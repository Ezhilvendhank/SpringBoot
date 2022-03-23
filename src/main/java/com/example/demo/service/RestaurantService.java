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
				Cell cell = row.getCell(0);
		       String cellValue = null;
		        switch ( cell.getCellType()) {
				 case STRING:
		                cellValue = cell.getStringCellValue();
		                break;
		            case NUMERIC:
		                String[] values = String.valueOf(cell.getNumericCellValue()).split("\\.");
		                if (values != null && values.length > 0) {
		                    cellValue = values[0];
		                } else {
		                    cellValue = String.valueOf(cell.getNumericCellValue());
		                }
		                break;
		            case BOOLEAN:
		                cellValue = String.valueOf(cell.getBooleanCellValue());
		                break;
		            default:
		        }
		        String cellValue1 = null;
		        Cell cell1 = row.getCell(1);
		        switch ( cell1.getCellType()) {
				 case STRING:
		                cellValue1 = cell1.getStringCellValue();
		                break;
		            case NUMERIC:
		                String[] values = String.valueOf(cell1.getNumericCellValue()).split("\\.");
		                if (values != null && values.length > 0) {
		                    cellValue1 = values[0];
		                } else {
		                    cellValue1 = String.valueOf(cell1.getNumericCellValue());
		                }
		                break;
		            case BOOLEAN:
		                cellValue1 = String.valueOf(cell1.getBooleanCellValue());
		                break;
		            default:
		        }
		        String cellValue2 = null;
		        Cell cell11 = row.getCell(3);
		        switch ( cell11.getCellType()) {
				 case STRING:
		                cellValue2 = cell11.getStringCellValue();
		                break;
		            case NUMERIC:
		                String[] values = String.valueOf(cell11.getNumericCellValue()).split("\\.");
		                if (values != null && values.length > 0) {
		                    cellValue2 = values[0];
		                } else {
		                    cellValue2 = String.valueOf(cell11.getNumericCellValue());
		                }
		                break;
		            case BOOLEAN:
		                cellValue2 = String.valueOf(cell11.getBooleanCellValue());
		                break;
		            default:
		        }
		        String cellValue3 = null;
		        Cell cell111 = row.getCell(4);
		        switch ( cell111.getCellType()) {
				 case STRING:
		                cellValue3 = cell111.getStringCellValue();
		                break;
		            case NUMERIC:
		                String[] values = String.valueOf(cell111.getNumericCellValue()).split("\\.");
		                if (values != null && values.length > 0) {
		                    cellValue3 = values[0];
		                } else {
		                    cellValue3 = String.valueOf(cell111.getNumericCellValue());
		                }
		                break;
		            case BOOLEAN:
		                cellValue3 = String.valueOf(cell111.getBooleanCellValue());
		                break;
		            default:
		        }
		
				restaurantEntity.setRestuarantCode(cellValue);
				restaurantEntity.setRestaurantName(cellValue1);
				restaurantEntity.setCity(cellValue2);
				restaurantEntity.setAddress(cellValue3);
			}
			restaurantEntities.add(restaurantEntity);
		}
		restaurantRepo.saveAll(restaurantEntities);
	}
}
