package com.smitesh.empmanage.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GetAddressDto {

	private String adrLine1;
	private String adrLine2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
}
