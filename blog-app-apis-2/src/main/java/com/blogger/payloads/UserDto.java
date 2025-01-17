package com.blogger.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Empty;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id ;
	@NotEmpty
	@Size(min= 4, message  ="Username must be of size min of 4 charcters")
	private String name;
	@Email(message ="Email address is not valid !")
	private String email;
	@NotEmpty
	@Size(min= 3,max=15, message  ="password must be of size min of 3 charcters and max 15 ")
	private String password;
	@NotEmpty
	private String about;
	
}
