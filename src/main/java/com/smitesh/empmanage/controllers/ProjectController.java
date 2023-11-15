package com.smitesh.empmanage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smitesh.empmanage.dtos.AddProjectRequest;
import com.smitesh.empmanage.dtos.GetAllProjects;
import com.smitesh.empmanage.services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
@Autowired
ProjectService prSer;

@PostMapping("/add")
public ResponseEntity<?> lauchProject(@RequestBody AddProjectRequest pr)
{
	return ResponseEntity.status(HttpStatus.OK).body(prSer.launchNewProject(pr));
}
@GetMapping("/list")
public List<GetAllProjects> getAllProjects()
{
	return prSer.getAllProjects();
}

@PostMapping("/assign_emp")
public String assignEmpToProject(@RequestParam Long projectId,@RequestParam Long empId)
{
	return prSer.assignEmpToProject(projectId, empId);
}
}
