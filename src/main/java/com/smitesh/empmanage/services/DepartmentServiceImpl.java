package com.smitesh.empmanage.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smitesh.empmanage.custom_exception.ResourceNotFoundException;
import com.smitesh.empmanage.daos.DepartmentRepository;
import com.smitesh.empmanage.dtos.AddDeptRequest;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.GetAllDeptResponse;
import com.smitesh.empmanage.pojos.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
@Autowired
private DepartmentRepository deptDao;
@Autowired
private ModelMapper mapper;

@PersistenceContext
private EntityManager entityManager;
	@Override
	public ApiResponse addDepartment(AddDeptRequest dept) {
		// TODO Auto-generated method stub
		System.out.println("dept"+dept);
		Department perDept=deptDao.save(mapper.map(dept, Department.class));
		return new ApiResponse(perDept.getDeptName()+"added successfully");
	}
	@Override
	public List<GetAllDeptResponse> getAllDepartments() {
		List<GetAllDeptResponse> li=new ArrayList<>();
		List<Department> li2=new ArrayList<>();
		li2=deptDao.findAll();
		GetAllDeptResponse obj;
		for(Department c:li2)
		{
			obj=myMapper(c);
			li.add(obj);
			
		}
	return li;
	}
	public GetAllDeptResponse myMapper(Department c) {
	GetAllDeptResponse d=new GetAllDeptResponse();
		d.setId(c.getId());
		d.setDeptName(c.getDeptName());
		d.setLocation(c.getLocation());
		return d;
	}
	@Override
	public GetAllDeptResponse getDepartmentDetails(Long deptId) {
		// TODO Auto-generated method stub
		Department d= deptDao.findById(deptId).orElseThrow(()->new ResourceNotFoundException("invalid dept id"));
	     GetAllDeptResponse obj;
	     obj=myMapper(d);
		return obj;
	}
	
	
	
	

}
