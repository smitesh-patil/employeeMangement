package com.smitesh.empmanage.dtos;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class GetAllDeptResponse {
	private Long id;
	private String location;
	
	private String deptName;
}
