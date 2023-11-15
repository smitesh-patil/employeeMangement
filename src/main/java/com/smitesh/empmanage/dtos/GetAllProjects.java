package com.smitesh.empmanage.dtos;

import java.time.LocalDate;

import com.smitesh.empmanage.pojos.ProjectStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GetAllProjects {
	private String title;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	private ProjectStatus status;

}
