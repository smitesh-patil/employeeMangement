package com.smitesh.empmanage.services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smitesh.empmanage.custom_exception.ResourceNotFoundException;
import com.smitesh.empmanage.daos.EmployeeRepository;
import com.smitesh.empmanage.dtos.ApiResponse;
import com.smitesh.empmanage.pojos.Employee;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	
	@Autowired
	EmployeeRepository emRepo;
	
	/*	@Value("${upload.location}")
	private String folderLocation;*/
	
	@Value("${upload.location}")
	private String folderLocation;
	
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init "+folderLocation);
		//chk if folder exists
		File folder=new File(folderLocation);
		if(folder.exists())
			System.out.println("folder alrdy exists !");
		else {
			folder.mkdir(); //creates a new folder 
			System.out.println("created a new folder...");
		}
		
	}

	@Override
	public ApiResponse uploadImage(Long id, MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		Employee emp=emRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!!!"));
		String path=folderLocation.concat(image.getOriginalFilename());
		FileUtils.writeByteArrayToFile(new File(path),image.getBytes());
		emp.setImagePath(path);
		return new ApiResponse("File uploaded n stored in server side folder");
	}

	@Override
	public byte[] downloadIamge(Long imageId) throws IOException {
		// TODO Auto-generated method stub
		Employee emp=emRepo.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!!!"));
	    if(emp.getImagePath()!=null)
	    {
	    	return FileUtils.readFileToByteArray(new File(emp.getImagePath()));
	    }
	    else
	    {
	    	throw new ResourceNotFoundException("Image not yet assigned!!!!");
	    }
	}

}
