package com.careerit.wiki.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_Write_Utils {

	public static String readTestDataFromExcel(String filePath, int rowNumber, int columnNumber) {
		String data = null;
		try {
			FileInputStream inputFile = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			XSSFSheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormat = new DataFormatter();
			data = dataFormat.formatCellValue(sheet.getRow(rowNumber).getCell(columnNumber));
			workbook.close();
			inputFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@SuppressWarnings("unused")
	public static void writeDataBackToExcel(String filePath, int rowNumber, int columnNumber, String data) {
		try {
			File file = new File(filePath);
			FileInputStream inputFile = new FileInputStream(file);

			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			XSSFSheet sheet = workbook.getSheetAt(0);

			XSSFRow row = sheet.getRow(rowNumber);
			XSSFCell cell = null;
			if (cell == null) {
				cell = row.createCell(columnNumber);
				cell.setCellValue(data);
			} else {
				cell.setCellValue(data);
			}
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);

			workbook.close();
			inputFile.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
