package com.park.melona.domain.arrivalInfomation;

import com.park.melona.domain.subwayStation.SubwayStationLineRepository;
import com.park.melona.global.util.ObjectUtil;
import com.park.melona.global.util.StringUtil;
import jooq.gernated.tables.pojos.SubwayStation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class ArrivalInformationService {

	private final SubwayStationLineRepository subwayStationLineRepository;

	private final ArrivalInformationApiService arrivalInformationApiService;

	public ArrivalInformationService(SubwayStationLineRepository subwayStationLineRepository, ArrivalInformationApiService arrivalInformationApiService) {
		this.subwayStationLineRepository = subwayStationLineRepository;
		this.arrivalInformationApiService = arrivalInformationApiService;
	}


	public ArrivalInformationResponse selectArrivalInformation(String subwayId, Integer stationId) {

		// 현재역 정보 가져오기
		SubwayStation subwayStation = subwayStationLineRepository.selectSubwayStationByStationId(stationId);

		// 이전역 정보 가져오기
		List<SubwayStation> previousStationInformationList = subwayStationLineRepository.selectPreviousSubwayStation(stationId);

		// 다음역 정보 가져오기
		List<SubwayStation> netxStationInformationList = subwayStationLineRepository.selectNextSubwayStation(stationId);

		// 상행선 도착정보
		List<ArrivalInformation> upLineArrivalInformationList = getUpLineArrivalInformationList(subwayId, subwayStation.getStationName());

		// 하행선 도착정보
		List<ArrivalInformation> downLineArrivalInformationList = getDownLineArrivalInformationList(subwayId, subwayStation.getStationName());

		return ArrivalInformationResponse.builder()
				.currentStationInformation(subwayStation)
				.previousStationInformationList(previousStationInformationList)
				.nextStationInformationList(netxStationInformationList)
				.upLineArrivalInformationList(upLineArrivalInformationList)
				.downLineArrivalInformationList(downLineArrivalInformationList)
				.build();
	}

	public List<ArrivalInformation> getUpLineArrivalInformationList(String subwayId, String stationName) {
		ArrivalInformationApiResponse arrivalInformationApiResponse = arrivalInformationApiService.getArrivalInformationApiCache(stationName);

		if(ObjectUtil.isEmpty(arrivalInformationApiResponse)) {
			return null;
		}

		return arrivalInformationApiResponse.getRealtimeArrivalList().stream()
				.filter(arrivalInformationListApiResponse -> arrivalInformationListApiResponse.getSubwayId().equals(Long.parseLong(subwayId.replace("LINE_", ""))))
				.filter(arrivalInformationListApiResponse -> arrivalInformationListApiResponse.getUpdnLine().equals("상행")
						|| arrivalInformationListApiResponse.getUpdnLine().equals("내선"))
				.filter(arrivalInformationListApiResponse -> !arrivalInformationListApiResponse.getArvlCd().equals("2"))
				.sorted(this::compareArrivalInformationList)
				.map(this::setArrivalInformation)
				.collect(Collectors.toList());
	}

	public List<ArrivalInformation> getDownLineArrivalInformationList(String subwayId, String stationName) {
		ArrivalInformationApiResponse arrivalInformationApiResponse = arrivalInformationApiService.getArrivalInformationApiCache(stationName);

		if(ObjectUtil.isEmpty(arrivalInformationApiResponse)) {
			return null;
		}

		return arrivalInformationApiResponse.getRealtimeArrivalList().stream()
				.filter(arrivalInformationListApiResponse -> arrivalInformationListApiResponse.getSubwayId().equals(Long.parseLong(subwayId.replace("LINE_", ""))))
				.filter(arrivalInformationListApiResponse -> arrivalInformationListApiResponse.getUpdnLine().equals("하행")
						|| arrivalInformationListApiResponse.getUpdnLine().equals("외선"))
				.filter(arrivalInformationListApiResponse -> !arrivalInformationListApiResponse.getArvlCd().equals("2"))
				.sorted(this::compareArrivalInformationList)
				.map(this::setArrivalInformation)
				.collect(Collectors.toList());
	}

	public ArrivalInformation setArrivalInformation(ArrivalInformationListApiResponse arrivalInformationListApiResponse) {

		long eta;
		String etaString;

		// 도착예정시간이 0인 경우에는 arvlMsg2 표출
		if(arrivalInformationListApiResponse.getBarvlDt().equals(0L)) {
			eta = arrivalInformationListApiResponse.getBarvlDt();
			etaString = arrivalInformationListApiResponse.getArvlMsg2();
		}
		else {
			long between = ChronoUnit.SECONDS.between(arrivalInformationListApiResponse.getRecptnDt(), LocalDateTime.now());
			eta = arrivalInformationListApiResponse.getBarvlDt() - between;
			etaString = StringUtil.convertSecondsToTimeString(eta);
		}

		return ArrivalInformation.builder()
				.terminusStationName(arrivalInformationListApiResponse.getBstatnNm())
				.trainNo(arrivalInformationListApiResponse.getBtrainNo())
				.currentStationName(arrivalInformationListApiResponse.getArvlMsg3())
				.eta(eta)
				.etaString(etaString)
				.build();
	}

	public int compareArrivalInformationList(ArrivalInformationListApiResponse o1, ArrivalInformationListApiResponse o2) {
		// 도착 예상 시간 정보가 없는 경우
		if(o1.getBarvlDt().equals(0L) || o2.getBarvlDt().equals(0L)) {
			if(o1.getBarvlDt().equals(0L) && !o2.getBarvlDt().equals(0L)) {
				return 1;
			}
			else if(o2.getBarvlDt().equals(0L) && !o1.getBarvlDt().equals(0L)) {
				return -1;
			}

			// arvlCd로 정렬
			if(o1.getArvlCd().equals("99") && o2.getArvlCd().equals("99")) {

				Pattern pattern = Pattern.compile("\\[(\\d+)]");

				Matcher o1Match = pattern.matcher(o1.getArvlMsg2());
				Matcher o2Match = pattern.matcher(o2.getArvlMsg2());

				if(o1Match.find() && o2Match.find()) {
					return Long.valueOf(o1Match.group(1))
							.compareTo(Long.valueOf(o2Match.group(1)));
				}
				else {
					return 0;
				}
			}
			else {

				// (0:진입, 1:도착, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중)

				int o1Priority = getArrivalCodePriority(o1.getArvlCd());
				int o2Priority = getArrivalCodePriority(o2.getArvlCd());

				return Long.compare(o1Priority, o2Priority);
			}
		}
		else {
			return Long.compare(o1.getBarvlDt(), o2.getBarvlDt());
		}
	}

	public int getArrivalCodePriority(String arrivalCode) {
		return switch(arrivalCode) {
			case "0" -> 2;
			case "1" -> 1;
			case "5" -> 3;
			case "4" -> 4;
			case "3" -> 5;
			case "99" -> 99;
			default -> -1;
		};

	}
}
