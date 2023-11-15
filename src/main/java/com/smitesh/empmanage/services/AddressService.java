package com.smitesh.empmanage.services;

import com.smitesh.empmanage.dtos.AddAddressDto;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.GetAddressDto;
import com.smitesh.empmanage.pojos.Address;

public interface AddressService {
	
	public ApiResponse addAddress(Long id,AddAddressDto ad);
	
	public ApiResponse updateAddress(Long id,AddAddressDto ad);

	public GetAddressDto getAddress(Long id);
}
