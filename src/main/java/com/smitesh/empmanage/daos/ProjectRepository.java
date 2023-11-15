package com.smitesh.empmanage.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smitesh.empmanage.pojos.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
