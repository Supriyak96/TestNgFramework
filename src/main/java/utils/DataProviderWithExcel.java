package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Listner.ReportLogger;

public class DataProviderWithExcel {
	
	
	
	@DataProvider
	public Object[][] getData(Method method) throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Excel/TestData1.xlsx");
		String sheetName = method.getName();
		try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			int rownum = sheet.getLastRowNum();
			System.out.println(rownum);
			int columnnum = sheet.getRow(0).getLastCellNum();
			
			System.out.println(columnnum);
			Object[][] data = new Object[rownum][columnnum];
			for(int i=1; i<=rownum; i++) {
				for (int j=0; j<columnnum;j++) {
					data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return data;
		}
	}
	
	
	@DataProvider
	public Object[] getData1(Method method) throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Excel/TestData1.xlsx");
		String sheetName = method.getName();
		try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			int rownum = sheet.getLastRowNum();
			System.out.println(rownum);
			int columnnum = sheet.getRow(0).getLastCellNum();
			
			System.out.println(columnnum);
			Object[] data = new Object[rownum];
			Map<String, String> map;
			
			for(int i=1; i<=rownum; i++) {
				map = new HashMap<>();
				for (int j=0; j<columnnum;j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
					
					data[i-1]= map;
				}
			}
			return data;
		}
	}
}
