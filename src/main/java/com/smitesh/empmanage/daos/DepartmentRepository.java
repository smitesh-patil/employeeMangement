package com.smitesh.empmanage.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smitesh.empmanage.pojos.Department;
import com.smitesh.empmanage.pojos.Employee;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
