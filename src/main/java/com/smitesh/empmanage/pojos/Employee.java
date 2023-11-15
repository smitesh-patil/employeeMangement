package com.smitesh.empmanage.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emps")
@NoArgsConstructor
@Getter
@Setter

public class Employee extends BaseEntity {
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 50,nullable = false)
	private String password;
	@Column(name = "join_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private EmpType type;
	@Column(length = 300, name = "image")
	private String imagePath;
	@Column(length = 30)
	private double salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
	private Department dept;
	
	@ManyToMany(mappedBy = "emps")
	private Set<Project> projects=new HashSet<>();
	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate, EmpType type,
			double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}
	
	public void addProject(Project p)
	{
		projects.add(p);
		p.getEmps().add(this);
	}
	public void removeProject(Project p)
	{
		projects.remove(p);
		p.getEmps().remove(this);
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", joinDate=" + joinDate + ", type=" + type + ", imagePath=" + imagePath + ", salary="
				+ salary + ", getId()=" + getId() + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
}
