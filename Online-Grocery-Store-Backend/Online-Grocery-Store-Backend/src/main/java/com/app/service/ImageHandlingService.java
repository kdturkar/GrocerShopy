package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ProductDto;



public interface ImageHandlingService {
	ProductDto saveImage(int id, MultipartFile imgFile) throws IOException;
}
