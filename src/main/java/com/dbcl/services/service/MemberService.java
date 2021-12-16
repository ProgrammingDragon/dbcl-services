package com.dbcl.services.service;

import com.dbcl.services.model.Membership;

public interface MemberService {
	Membership getMember(final Long memberId);
	Membership addMember(final String personUsername, final Membership membership);
	Membership updateMember(final Long memberId, final String personUsername, final Membership membership);
}
