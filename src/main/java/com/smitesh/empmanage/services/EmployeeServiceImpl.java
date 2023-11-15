package com.smitesh.empmanage.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smitesh.empmanage.custom_exception.ResourceNotFoundException;
import com.smitesh.empmanage.daos.AddressRepository;
import com.smitesh.empmanage.daos.DepartmentRepository;
import com.smitesh.empmanage.daos.EmployeeRepository;
import com.smitesh.empmanage.dtos.AddEmployeeRequest;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.AuthRequestDto;
import com.smitesh.empmanage.dtos.AuthResponseDto;
import com.smitesh.empmanage.dtos.GetAllEmps;
import com.smitesh.empmanage.pojos.Address;
import com.smitesh.empmanage.pojos.Department;
import com.smitesh.empmanage.pojos.Employee;
import com.smitesh.empmanage.pojos.Project;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeRepository empRepo;

@Autowired
DepartmentRepository deptRepo;

@Autowired
AddressRepository addRepo;

@Autowired
private ModelMapper mapper;
	@Override
	public ApiResponse addNewEmp(Long deptID, AddEmployeeRequest emp) {
		// TODO Auto-generated method stub
		Department dept =deptRepo.findById(deptID).orElseThrow(()->new ResourceNotFoundException("Invalid"));
//		Department dept=deptRepo.getReferenceById(deptID);
		Employee perEmp=empRepo.save(mapper.map(emp, Employee.class));
		dept.addEmployee(perEmp);
		return new ApiResponse(perEmp.getFirstName()+" "+perEmp.getLastName()+"added successfully");
	}
	@Override
	public List<GetAllEmps> getAllEmps() {
		// TODO Auto-generated method stub
		List<GetAllEmps> li1= new ArrayList<GetAllEmps>();
		List<Employee> li2=new ArrayList<Employee>();
		GetAllEmps e;
		li2=empRepo.findAll();
		for(Employee em:li2)
		{
			e=myMapper(em);
			li1.add(e);
		}
		return li1;
	}
	public GetAllEmps myMapper(Employee emp)
	{
		GetAllEmps e=new GetAllEmps();
		e.setFirstName(emp.getFirstName());
		e.setLastName(emp.getLastName());
		e.setEmail(emp.getEmail());
		e.setType(emp.getType());
		e.setSalary(emp.getSalary());
		e.setJoinDate(emp.getJoinDate());
		return e;
	}
	
	
	@Override
	public String deleteEmpDetails(Long empId) {
		// TODO Auto-generated method stub
		Optional<Address> optAdr=addRepo.findById(empId);
		if(optAdr.isPresent())
		{
		addRepo.delete(optAdr.get());	
		}
		
		Employee emp=empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Invalid"));
		Iterator<Project> prs=emp.getProjects().iterator();
		while(prs.hasNext())
		{
			prs.next().getEmps().remove(emp);
		}
		empRepo.delete(emp);
		return "Emp Details deleted....";
	}
	@Override
	public AuthResponseDto signIn(AuthRequestDto request) {
		// TODO Auto-generated method stub
		Employee emp=empRepo.findByEmailAndPassword(request.getEmail(),request.getPassword()).orElseThrow(()->new ResourceNotFoundException("invalid email or password "));
		return mapper.map(emp,AuthResponseDto.class);
	}
	
	 

}
