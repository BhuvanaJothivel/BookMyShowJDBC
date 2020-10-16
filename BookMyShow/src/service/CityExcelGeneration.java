package service;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import model.CityDetails;

public class CityExcelGeneration {
	String filename = "F:\\New folder\\cities.xls";
	int i=1;
	FileOutputStream fileOutput;
	public void generate(List<CityDetails> cityList) {
		try {
			Workbook wb = new HSSFWorkbook();
			Sheet sheet = wb.createSheet("City Details");
			Row row = sheet.createRow(0);
			
			row.createCell(0).setCellValue("City Id");
			row.createCell(1).setCellValue("City Name");
			
			for(CityDetails c: cityList) {
				Row nextRow = sheet.createRow(i);
				
				nextRow.createCell(0).setCellValue(c.getCityId());
				nextRow.createCell(1).setCellValue(c.getCityName());
				i++;
				
			}
			 fileOutput = new FileOutputStream(filename);
			 wb.write(fileOutput);
			 System.out.println("Excel generated");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
