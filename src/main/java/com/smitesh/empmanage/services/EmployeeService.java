package com.smitesh.empmanage.services;

import java.util.List;

import com.smitesh.empmanage.dtos.AddEmployeeRequest;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.AuthRequestDto;
import com.smitesh.empmanage.dtos.AuthResponseDto;
import com.smitesh.empmanage.dtos.GetAllEmps;

public interface EmployeeService {
	ApiResponse addNewEmp(Long deptID, AddEmployeeRequest emp);
	List<GetAllEmps> getAllEmps();
	String deleteEmpDetails(Long empId);
	AuthResponseDto signIn(AuthRequestDto request);
}
