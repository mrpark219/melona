package com.park.melona.domain.arrivalInfomation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArrivalInformationListApiResponse {

	@JsonProperty("beginRow")
	private Long beginRow;

	@JsonProperty("endRow")
	private Long endRow;

	@JsonProperty("curPage")
	private Long curPage;

	@JsonProperty("pageRow")
	private Long pageRow;

	@JsonProperty("totalCount")
	private Long totalCount;

	@JsonProperty("rowNum")
	private Long rowNum;

	@JsonProperty("selectedCount")
	private Long selectedCount;

	@JsonProperty("subwayId")
	private Long subwayId;

	@JsonProperty("subwayNm")
	private String subwayNm;

	@JsonProperty("updnLine")
	private String updnLine;

	@JsonProperty("trainLineNm")
	private String trainLineNm;

	@JsonProperty("subwayHeading")
	private String subwayHeading;

	@JsonProperty("statnFid")
	private String statnFid;

	@JsonProperty("statnTid")
	private String statnTid;

	@JsonProperty("statnId")
	private String statnId;

	@JsonProperty("statnNm")
	private String statnNm;

	@JsonProperty("trainCo")
	private String trainCo;

	@JsonProperty("trnsitCo")
	private String trnsitCo;

	@JsonProperty("ordkey")
	private String ordkey;

	@JsonProperty("subwayList")
	private String subwayList;

	@JsonProperty("statnList")
	private String statnList;

	@JsonProperty("btrainSttus")
	private String btrainSttus;

	@JsonProperty("barvlDt")
	private Long barvlDt;

	@JsonProperty("btrainNo")
	private String btrainNo;

	@JsonProperty("bstatnId")
	private String bstatnId;

	@JsonProperty("bstatnNm")
	private String bstatnNm;

	@JsonProperty("recptnDt")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime recptnDt;

	@JsonProperty("arvlMsg2")
	private String arvlMsg2;

	@JsonProperty("arvlMsg3")
	private String arvlMsg3;

	@JsonProperty("arvlCd")
	private String arvlCd;

}
