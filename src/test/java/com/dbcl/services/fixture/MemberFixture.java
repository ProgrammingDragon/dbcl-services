package com.dbcl.services.fixture;

import com.dbcl.services.model.Membership;

public class MemberFixture {
	public static Membership testMembership() {
		Membership membership = new Membership();
		membership.setId(1L);
		membership.setFirstName("Test First");
		membership.setLastName("Test Last");
		membership.setAddressLine1("12345 S Sunnyside Street");
		membership.setAddressLine2(null);
		membership.setCity("Gunner City");
		membership.setState("WI");
		membership.setZip("51556");
		membership.setEmail("tester@gmail.com");
		membership.setPhone(null);
		membership.setPhoneExtension(null);
		membership.setMobile("9201234567");
		membership.setActive(true);
		membership.setMemberSince("112021");
		membership.setUsername("PDRAGON");
		return membership;
	}
}
