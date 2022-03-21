package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RestaurantEntity;
import com.example.demo.repository.RestaurantRepo;

@Service
public class RestaurantService {
	@Autowired
	RestaurantRepo restaurantRepo;

	public void readExcelAndWriteToDatabase(File file) throws EncryptedDocumentException, IOException {
		InputStream inputStream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		List<RestaurantEntity> restaurantEntities = new ArrayList<>();
		for (int rowNum = 1; rowNum < sheet.getLastRowNum(); rowNum++) {
			RestaurantEntity restaurantEntity = new RestaurantEntity();
			Row row = sheet.getRow(rowNum);
			for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
				String restuarantCode = String.valueOf(row.getCell(0).getNumericCellValue()) ;
				String restuarantName = row.getCell(1).getStringCellValue();
				String restuarantCity = row.getCell(3).getStringCellValue();
				String restuarantAddress = row.getCell(4).getStringCellValue();
				restaurantEntity.setRestuarantCode(restuarantCode);
				restaurantEntity.setRestaurantName(restuarantName);
				restaurantEntity.setCity(restuarantCity);
				restaurantEntity.setAddress(restuarantAddress);
			}
			restaurantEntities.add(restaurantEntity);
		}
		restaurantRepo.saveAll(restaurantEntities);
	}
}
