package com.srvcode.springboot.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SupportForm {

	@NotNull
	@Min(value=10000, message="customer id should be >= 10000")
	private Long id;
	
	@NotNull
	@Size(min=5, max=50)
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String membership;

	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9 ]{3,255}", message="please enter only letters & numbers")
	private String content;
	
}
