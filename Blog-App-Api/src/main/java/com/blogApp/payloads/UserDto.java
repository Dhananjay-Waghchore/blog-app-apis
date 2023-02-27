package com.blogApp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private int userId;
	
	@NotNull
	@Size(min = 4, message = "FirstName must be of minimum 4 charecters")
	private String firstName;
	
	@NotNull
	@Size(min = 4, message = "LastName must be of minimum 4 charecters")
	private String lastName;
	
	@Email(message = "Email address is not valid")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
			message = "Invalid Password pattern. Password must contain 8 to 20 characters at least one digit, lower case, upper case and one special character."
			)
	private String password;
	
	@NotEmpty
	private String about;
	
}
