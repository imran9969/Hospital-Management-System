package com.hms.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Patient {

	
	private Integer id;
	@NotEmpty(message="Hey")
	@Length(min=1,max=3,message="between {min} AND {max}")
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String email;
	@NotEmpty
	private String mobileNo;
	@NotEmpty
	private String gender;
	
	
}
