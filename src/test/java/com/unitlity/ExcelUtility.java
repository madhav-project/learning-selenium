package com.unitlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static String getTestData(int rowNumber, int cellNumber) throws InvalidFormatException, IOException {

		// Create File object
		File file = new File("D:\\Java\\seleniumtest\\src\\test\\resources\\testData.xlsx");
		FileInputStream fileStream = new FileInputStream(file);
		// Create workbook object
		XSSFWorkbook workBook = new XSSFWorkbook(fileStream);
		// Create sheet object
		XSSFSheet sheet = workBook.getSheetAt(0);
		// close the workbook
		workBook.close();
		// specify the row and cell number
		return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	}
}
