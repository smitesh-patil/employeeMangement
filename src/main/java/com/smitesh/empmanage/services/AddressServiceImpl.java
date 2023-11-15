package com.smitesh.empmanage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smitesh.empmanage.custom_exception.ResourceNotFoundException;
import com.smitesh.empmanage.daos.AddressRepository;
import com.smitesh.empmanage.daos.EmployeeRepository;
import com.smitesh.empmanage.dtos.AddAddressDto;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.dtos.GetAddressDto;
import com.smitesh.empmanage.pojos.Address;
import com.smitesh.empmanage.pojos.Employee;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	EmployeeRepository empRep;
	@Autowired
	AddressRepository addRep;
	@Override
	public ApiResponse addAddress(Long id, AddAddressDto ad) {
		Employee emp = empRep.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid Id"));
		Address address = myMapper(emp, ad);
		Address perAddress = addRep.save(address); 
		return new ApiResponse(perAddress.getOwner().getFirstName()+" "+"Address Added");
	}

	public Address myMapper(Employee emp,AddAddressDto ad) {
		Address address = new Address();
		address.setAdrLine1(ad.getAdrLine1());
		address.setAdrLine2(ad.getAdrLine2());
		address.setCity(ad.getCity());
		address.setCountry(ad.getCountry());
		address.setState(ad.getState());
		address.setZipCode(ad.getZipCode());
		if(emp!=null) {
		address.setOwner(emp);
		}
		return address;
	}
	public Address myMapper(Address add,AddAddressDto ad) {
		
		add.setAdrLine1(ad.getAdrLine1());
		add.setAdrLine2(ad.getAdrLine2());
		add.setCity(ad.getCity());
		add.setCountry(ad.getCountry());
		add.setState(ad.getState());
		add.setZipCode(ad.getZipCode());
		
		return add;
	}
	
	@Override
	public ApiResponse updateAddress(Long id, AddAddressDto ad) {
		Address address = addRep.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid Id"));
		Address updateAdd = myMapper(address, ad);
		Address perAdd = addRep.save(updateAdd);
		return new ApiResponse("Address updated Succesfully");
	}

	@Override
	public GetAddressDto getAddress(Long id) {
		// TODO Auto-generated method stub
		Address ad=addRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Address Id or address not yet assigned!!!!"));
       GetAddressDto obj;
       obj=myAdMapper(ad);
       return obj;
	}
	
	public GetAddressDto myAdMapper(Address a)
	{
		GetAddressDto g=new GetAddressDto();
		g.setAdrLine1(a.getAdrLine1());
		g.setAdrLine2(a.getAdrLine2());
		g.setCity(a.getCity());
		g.setCountry(a.getCountry());
		g.setState(a.getState());
		g.setZipCode(a.getZipCode());
		return g;
	}
	
	
}
