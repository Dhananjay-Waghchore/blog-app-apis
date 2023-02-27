package com.blogApp.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	private int categoryId;
	
	@NotEmpty
	@Size(min = 5, message = "Title must contain atleast four charecters")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 5, message = "Description must contain atleast four charecters")
	private String categoryDescription;

		
}
