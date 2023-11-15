package com.smitesh.empmanage.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smitesh.empmanage.dtos.AddDeptRequest;
import com.smitesh.empmanage.dtos.GetAllDeptResponse;
import com.smitesh.empmanage.pojos.Department;
import com.smitesh.empmanage.services.DepartmentService;
@RestController
@RequestMapping("/dept")
public class DeptController {
@Autowired
private DepartmentService deptService;

public DeptController() {
	System.out.println("inside the dept controller");	
}
@PostMapping("/add")
public ResponseEntity<?>addDept(@RequestBody AddDeptRequest dept)
{
	System.out.println("inside addDept controller");
	return ResponseEntity.status(HttpStatus.OK).body(deptService.addDepartment(dept));
}

@GetMapping("/showall")
public List<GetAllDeptResponse> getDepts()
{
	System.out.println("inside dept get controller");
	
	return deptService.getAllDepartments();
}

@GetMapping("/{deptId}")
public GetAllDeptResponse getDepartmentDetails(@PathVariable Long deptId)
{
	System.out.println("inside dept find by id");
	return deptService.getDepartmentDetails(deptId);
}
}
