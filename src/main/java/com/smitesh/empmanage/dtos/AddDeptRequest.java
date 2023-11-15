package com.smitesh.empmanage.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class AddDeptRequest {

	private String location;
	
	private String deptName;
}
