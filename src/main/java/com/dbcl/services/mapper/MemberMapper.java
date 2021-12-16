package com.dbcl.services.mapper;

import com.dbcl.services.entity.Member;
import com.dbcl.services.model.Membership;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
	public Member map(final Membership membership) {
		return map(membership, new Member());
	}

	public Member map(final Membership membership, final Member member) {
		if (member == null) {
			throw new IllegalArgumentException("Member not found.");
		}
		member.setFirstName(membership.getFirstName());
		member.setLastName(membership.getLastName());
		member.setAddressLine1(membership.getAddressLine1());
		member.setAddressLine2(membership.getAddressLine2());
		member.setCity(membership.getCity());
		member.setState(membership.getState());
		member.setZip(membership.getZip());
		member.setEmail(membership.getEmail());
		member.setPhone(membership.getPhone());
		member.setPhoneExtension(membership.getPhoneExtension());
		member.setMobile(membership.getMobile());
		member.setActive(membership.getActive());
		member.setMemberSince(membership.getMemberSince());
		member.setUsername(membership.getUsername().toUpperCase());
		return member;
	}

	public Membership map(final Member member) {
		Membership membership = new Membership();
		membership.setId(member.getId());
		membership.setFirstName(member.getFirstName());
		membership.setLastName(member.getLastName());
		membership.setAddressLine1(member.getAddressLine1());
		membership.setAddressLine2(member.getAddressLine2());
		membership.setCity(member.getCity());
		membership.setState(member.getState());
		membership.setZip(member.getZip());
		membership.setEmail(member.getEmail());
		membership.setPhone(member.getPhone());
		membership.setPhoneExtension(member.getPhoneExtension());
		membership.setMobile(member.getMobile());
		membership.setActive(member.getActive());
		membership.setMemberSince(member.getMemberSince());
		membership.setUsername(member.getUsername());
		return membership;
	}
}
