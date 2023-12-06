package com.park.melona.domain.report;

import com.park.melona.global.util.ObjectUtil;
import jooq.gernated.tables.pojos.Report;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;

import static jooq.gernated.Tables.REPORT;

@Repository
public class ReportRepository {

	private final DSLContext dslContext;

	public ReportRepository(DSLContext dslContext) {
		this.dslContext = dslContext;
	}

	public Integer insertReport(Report report) {


		Record1<Integer> reportIdRecord = dslContext.insertInto(REPORT, REPORT.TITLE, REPORT.CONTENT, REPORT.IP, REPORT.REGISTRATION_DATE)
				.values(report.getTitle(), report.getContent(), report.getIp(), report.getRegistrationDate())
				.returningResult(REPORT.ID)
				.fetchOne();

		if(ObjectUtil.isEmpty(reportIdRecord)) {
			return null;
		}
		else {
			return reportIdRecord.get(REPORT.ID);
		}
	}
}
