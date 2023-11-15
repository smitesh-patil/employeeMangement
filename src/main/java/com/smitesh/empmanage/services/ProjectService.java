package com.smitesh.empmanage.services;


import java.util.List;

import com.smitesh.empmanage.dtos.AddProjectRequest;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.GetAllProjects;

public interface ProjectService {
ApiResponse launchNewProject(AddProjectRequest pr);
List<GetAllProjects> getAllProjects();
String assignEmpToProject(Long projectId,Long empId);
}
