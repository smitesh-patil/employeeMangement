package com.smitesh.empmanage.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.smitesh.empmanage.pojos.ProjectStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddProjectRequest {
	private String title;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	private ProjectStatus status;
}
