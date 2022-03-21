package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.RestaurantService;

@RestController
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;

	@PostMapping("readAndSaveExcelData")
	public String readExcelAndSaveToDb(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		File file = convertMultiPartToFile(multipartFile);
		restaurantService.readExcelAndWriteToDatabase(file);
		return "Success";
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
