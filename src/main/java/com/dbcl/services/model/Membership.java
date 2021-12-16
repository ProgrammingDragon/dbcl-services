package com.dbcl.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
	private Long id;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phone;
	private String phoneExtension;
	private String mobile;
	private String memberSince;
	private Boolean active;
	private String username;
}
