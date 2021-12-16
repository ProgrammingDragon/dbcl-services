package com.dbcl.services.controller;

/*
@RestController
@RequestMapping(value = "/member")
@CrossOrigin(origins = "*")
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping(value = "/{memberId}")
	public ResponseEntity<Membership> retrieveMember(@AuthenticationPrincipal final User user,
	                                                 @PathVariable(value = "memberId") final Long memberId) {
		if (user != null) {
			Membership membership = service.getMember(memberId);
			if (membership != null) {
				return new ResponseEntity<>(membership, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/last/{lastName}")
	public ResponseEntity<List<Membership>> retrieveMembers(@AuthenticationPrincipal final User user,
	                                                        @PathVariable(value = "lastName") final String last) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Membership> addMember(@AuthenticationPrincipal final User user,
	                                            @RequestBody final Membership request) {
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(service.addMember(user.getUsername(), request), HttpStatus.ACCEPTED);
	}

	@PatchMapping(value = "/{memberId}")
	public ResponseEntity<Membership> updateMember(@AuthenticationPrincipal final User user,
	                                               @PathVariable(value = "memberId") Long memberId,
	                                               @RequestBody final Membership request) {
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(service.updateMember(memberId, user.getUsername(), request), HttpStatus.ACCEPTED);
	}
}
*/
