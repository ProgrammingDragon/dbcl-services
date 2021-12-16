package com.dbcl.services.service;

import com.dbcl.services.entity.Member;
import com.dbcl.services.mapper.MemberMapper;
import com.dbcl.services.model.Membership;
import com.dbcl.services.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberServiceImpl implements MemberService {
	private final MemberRepository repository;
	private final MemberMapper mapper;

	public MemberServiceImpl(final MemberRepository repository,
	                         final MemberMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Membership getMember(Long memberId) {
		Member member = repository.findById(memberId).orElse(null);
		if (member == null) {
			return null;
		}
		return mapper.map(member);
	}

	@Override
	public Membership addMember(String personUsername, Membership membership) {
		Member member = mapper.map(membership);
		LocalDateTime now = LocalDateTime.now();
		member.setId(null);
		member.setUsername(member.getUsername().toUpperCase());
		member.setCreated(now);
		member.setModified(now);
		member.setCreatedBy(personUsername);
		member.setModifiedBy(personUsername);
		return mapper.map(repository.save(member));
	}

	@Override
	public Membership updateMember(Long memberId, String personUsername, Membership membership) {
		Member member = mapper.map(membership, repository.findById(memberId).orElse(null));
		member.setModified(LocalDateTime.now());
		member.setModifiedBy(personUsername);
		member.setId(memberId);
		return mapper.map(repository.save(member));
	}
}
