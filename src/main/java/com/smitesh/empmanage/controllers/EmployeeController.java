package com.smitesh.empmanage.controllers;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smitesh.empmanage.dtos.AddEmployeeRequest;
import com.smitesh.empmanage.dtos.AuthRequestDto;
import com.smitesh.empmanage.dtos.AuthResponseDto;
import com.smitesh.empmanage.dtos.GetAllEmps;
import com.smitesh.empmanage.services.EmployeeService;
import com.smitesh.empmanage.services.ImageHandlingService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
@Autowired
EmployeeService empService;

@Autowired
ImageHandlingService imageService;

@PostMapping("/add")
public ResponseEntity<?>addNewEmp(@RequestParam Long id,@RequestBody AddEmployeeRequest emp)
{
	System.out.println("inside addemp controller");
	return ResponseEntity.status(HttpStatus.OK).body(empService.addNewEmp(id, emp));
}

@GetMapping("/showall")
public List<GetAllEmps> getAllEmps()
{
	return empService.getAllEmps();
}

@DeleteMapping("/delete/{empId}")
public String deleteEmpDetails(@PathVariable  Long empId)
{
	return empService.deleteEmpDetails(empId);
}

@PostMapping("/signIn")
public ResponseEntity<?> signIn(@RequestBody AuthRequestDto request)
{
	AuthResponseDto resp=empService.signIn(request);
	return ResponseEntity.ok(resp);
}

@PostMapping(value="/uploadimage/{empId}",consumes = "multipart/form-data")
public ResponseEntity<?> uploadEmpImage(@PathVariable Long empId,@RequestParam MultipartFile imageFile) throws IOException
{
	System.out.println("in img upload "+empId);
	//invoke image service method
	return ResponseEntity.status(HttpStatus.OK).body(imageService.uploadImage(empId, imageFile));
}

@GetMapping(value = "/{empId}",produces = {IMAGE_GIF_VALUE,IMAGE_JPEG_VALUE,IMAGE_PNG_VALUE})
public ResponseEntity<?> downloadImage(@PathVariable Long empId) throws IOException
{
	return ResponseEntity.ok(imageService.downloadIamge(empId));
}

}
