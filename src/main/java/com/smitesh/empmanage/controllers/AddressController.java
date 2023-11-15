package com.smitesh.empmanage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smitesh.empmanage.dtos.AddAddressDto;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.GetAddressDto;
import com.smitesh.empmanage.pojos.Address;
import com.smitesh.empmanage.services.AddressService;

import lombok.Getter;



@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addSer;
	
	@PostMapping("/add")
	public ApiResponse addAddress(Long id,@RequestBody AddAddressDto ad) {
		
		return addSer.addAddress(id, ad);
	}
	
	@PutMapping("/update")
	public ApiResponse upAdateddress(Long id,@RequestBody AddAddressDto ad) {
		
		return addSer.updateAddress(id, ad);
	}
	
	@GetMapping("/{AdId}")
	public GetAddressDto getAddress(@PathVariable Long AdId)
	{
		return addSer.getAddress(AdId);
	}
	
}
