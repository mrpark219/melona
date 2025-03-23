package com.park.melona.domain.report.repository;

import com.park.melona.domain.report.Report;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import static jooq.gernated.Tables.REPORT;


@Repository
public class ReportRepository {

	private final DSLContext dslContext;

	public ReportRepository(DSLContext dslContext) {
		this.dslContext = dslContext;
	}

	public Report insertReport(Report report) {

		Record reportRecord = dslContext.insertInto(REPORT, REPORT.TITLE, REPORT.CONTENT, REPORT.IP, REPORT.REGISTRATION_DATE)
			.values(report.getTitle(), report.getContent(), report.getIp(), report.getRegistrationDate())
			.returningResult(REPORT.ID)
			.fetchOne();

		if(reportRecord == null) {
			return null;
		}
		else {
			report.setId(reportRecord.get(REPORT.ID).longValue());
			return report;

		}
	}
}
