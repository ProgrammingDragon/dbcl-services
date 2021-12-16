package com.dbcl.services.controller;

import com.dbcl.services.model.Membership;
import com.dbcl.services.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/member")
//@CrossOrigin(origins = "*")
public class MemberController {
	private final MemberService service;

	public MemberController(MemberService service) {
		this.service = service;
	}

	@GetMapping(value = "/{memberId}")
	public ResponseEntity<Membership> retrieveMember(@PathVariable(value = "memberId") final Long memberId) {
		Membership membership = service.getMember(memberId);
		if (membership != null) {
			return ResponseEntity.ok(membership);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/last/{lastName}")
	public ResponseEntity<List<Membership>> retrieveMembers(final Principal principal,
	                                                        @PathVariable(value = "lastName") final String last) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Membership> addMember(final Principal principal,
	                                            @RequestBody final Membership request) {
		return new ResponseEntity<>(service.addMember(principal.getName(), request), HttpStatus.ACCEPTED);
	}

	@PatchMapping(value = "/{memberId}")
	public ResponseEntity<Membership> updateMember(final Principal principal,
	                                               @PathVariable(value = "memberId") Long memberId,
	                                               @RequestBody final Membership request) {
		return new ResponseEntity<>(service.updateMember(memberId, principal.getName(), request), HttpStatus.ACCEPTED);
	}
}
