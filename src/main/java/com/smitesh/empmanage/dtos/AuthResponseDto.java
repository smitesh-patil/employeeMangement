package com.smitesh.empmanage.dtos;

import com.smitesh.empmanage.pojos.EmpType;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthResponseDto {
	private String firstName;
	
	private String lastName;
	private EmpType type;
}
