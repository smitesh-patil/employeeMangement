package com.smitesh.empmanage.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.smitesh.empmanage.pojos.EmpType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GetAllEmps {
	
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate joinDate;
	private EmpType type;
	private double salary;
}
