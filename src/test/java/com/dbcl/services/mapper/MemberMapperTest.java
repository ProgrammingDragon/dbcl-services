package com.dbcl.services.mapper;

import com.dbcl.services.fixture.MemberFixture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class MemberMapperTest {
	@Test
	void buildMembership() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(MemberFixture.testMembership()));
	}
}
