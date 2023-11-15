package com.smitesh.empmanage.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smitesh.empmanage.custom_exception.ResourceNotFoundException;
import com.smitesh.empmanage.daos.EmployeeRepository;
import com.smitesh.empmanage.daos.ProjectRepository;
import com.smitesh.empmanage.dtos.AddProjectRequest;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.GetAllProjects;
import com.smitesh.empmanage.pojos.Employee;
import com.smitesh.empmanage.pojos.Project;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProjectserviceImpl implements ProjectService {

	@Autowired
	ProjectRepository prRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	EmployeeRepository emRepo;
	
	@Override
	public ApiResponse launchNewProject(AddProjectRequest pr) {
		// TODO Auto-generated method stub
		Project pro=prRepo.save(mapper.map(pr, Project.class));
		return new ApiResponse(pro.getTitle()+"launced successfully");
	}
	@Override
	public List<GetAllProjects> getAllProjects() {
		// TODO Auto-generated method stub
		List<GetAllProjects> li1=new ArrayList<GetAllProjects>();
		List<Project> li2=new ArrayList<Project>();
		li2=prRepo.findAll();
		GetAllProjects obj;
		for(Project p:li2)
		{
			obj=myMapper(p);
			li1.add(obj);
		}
		return li1;
	}
	public GetAllProjects myMapper(Project p)
	{
		GetAllProjects pr=new GetAllProjects();
		pr.setTitle(p.getTitle());
		pr.setStartDate(p.getStartDate());
		pr.setEndDate(p.getEndDate());
		pr.setStatus(p.getStatus());
		return pr;
	}
	@Override
	public String assignEmpToProject(Long projectId, Long empId) {
		// TODO Auto-generated method stub
		Project pr=prRepo.findById(projectId).orElseThrow(()->new ResourceNotFoundException("invalid project id"));
		Employee emp=emRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("invalid emp id"));
		pr.addEmp(emp);
		return "Emp "+emp.getFirstName()+" added to Project : "+pr.getTitle();
	}

}
