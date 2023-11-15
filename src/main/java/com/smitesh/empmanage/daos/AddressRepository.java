package com.smitesh.empmanage.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smitesh.empmanage.pojos.Address;
import com.smitesh.empmanage.pojos.Employee;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
