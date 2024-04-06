package com.sathya.rest.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDetails {
	
	@NotBlank(message = "Hospital name is required")
	private String name;
	
	@NotBlank(message = "Location is required")
	private String location;
	
	private double rating;
	
	@Email(message = "Invalid email address")
	@NotBlank(message = "email is required")
	private String email;
	
	@Pattern(regexp = "[0-9]{10}", message = "invalid mobile number")
	@NotBlank(message = "Mobile number is required")
	private String mobile;

}
