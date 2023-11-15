package com.smitesh.empmanage.dtos;

import java.time.LocalDate;

import com.smitesh.empmanage.pojos.Department;
import com.smitesh.empmanage.pojos.EmpType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddEmployeeRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate joinDate;
	private EmpType type;
	//private String imagePath;
	private double salary;
	//private Long deptId;
}
