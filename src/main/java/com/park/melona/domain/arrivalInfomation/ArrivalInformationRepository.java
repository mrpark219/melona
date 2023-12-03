package com.park.melona.domain.arrivalInfomation;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class ArrivalInformationRepository {

	private final DSLContext dslContext;

	public ArrivalInformationRepository(DSLContext dslContext) {
		this.dslContext = dslContext;
	}
}
