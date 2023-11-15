package com.smitesh.empmanage.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.smitesh.empmanage.dtos.ApiResponse;

public interface ImageHandlingService {
	ApiResponse uploadImage(Long id,MultipartFile image) throws IOException;
	byte[] downloadIamge(Long imageId) throws IOException;
}
