package com.selenium.automationpractice.excelManage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelManage {

	public String[][] excelRead(String excelName, String sheetName) throws IOException{
		
		File file= new File(System.getProperty("user.dir")+"/testData/"+excelName+".xlsx");
		FileInputStream fis= new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sheet= wb.getSheet(sheetName);
		//XSSFRow row= sheet.getRow(0);
		//XSSFCell cell=row.getCell(0);
		//String data= cell.getStringCellValue();
		//System.out.println(data);
		
		int rowNum= sheet.getLastRowNum();
		int cellNum= sheet.getRow(0).getLastCellNum();
		
		String[][] dataSet=new String[rowNum][cellNum];
		Iterator<Row> rowIterator = sheet.iterator();
		
		int i=0;
		int t=0;
		
		while(rowIterator.hasNext())
		{			
			Row row = rowIterator.next();
			if (i++ != 0) 
			{
				int j = t;
				t++;
				
				Iterator<Cell> cellIterator = row.cellIterator();
				int k = 0;
				
				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					dataSet[j][k++] = cell.getStringCellValue();
					
				}
			
			}
		
		
		}
		
		return dataSet;
		
	}
	
	
	
	@Test
	public void test() throws IOException{
		ExcelManage obj= new ExcelManage();
		String[][] dataSet = obj.excelRead("TestData","Sheet1");
		
		 for (String[] row : dataSet){
			    System.out.println(Arrays.toString(row));
			   }
		
	}
	
}
