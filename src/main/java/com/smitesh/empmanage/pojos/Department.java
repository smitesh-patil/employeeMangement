package com.smitesh.empmanage.pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="departments")
@Getter
@Setter

@NoArgsConstructor
public class Department extends BaseEntity {
@Column(length=30)
private String location;
@Column(name = "dept_name", length = 40, unique = true)
private String deptName;
@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL,
orphanRemoval = true , fetch = FetchType.LAZY  )
private List<Employee> emps=new ArrayList<Employee>();



public void addEmployee(Employee e) {
	emps.add(e);// dept --> emp
	e.setDept(this);// emp --> dept
}

public void removeEmployee(Employee e) {
	emps.remove(e);
	e.setDept(null);
}

public Department(String location, String deptName) {
	super();
	this.location = location;
	this.deptName = deptName;
}

@Override
public String toString() {
	return "Department [location=" + location + ", deptName=" + deptName + ", getId()=" + getId() + "]";
}


}
