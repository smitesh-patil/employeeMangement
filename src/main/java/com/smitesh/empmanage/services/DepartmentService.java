package com.smitesh.empmanage.services;

import java.util.List;

import com.smitesh.empmanage.dtos.AddDeptRequest;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.GetAllDeptResponse;
import com.smitesh.empmanage.pojos.Department;

public interface DepartmentService {
List<GetAllDeptResponse> getAllDepartments();
public ApiResponse addDepartment(AddDeptRequest dept);
GetAllDeptResponse getDepartmentDetails(Long deptId);
}
