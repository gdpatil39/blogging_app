package com.blogger.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotBlank
	@Size(min=3 ,message="min size of tital is 3")
	private String categoryTitle;
	@NotBlank
	@Size(min=3 ,message="min size of description is 3")
	private String categoryDescription;
	
}
