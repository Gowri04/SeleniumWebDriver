package selenium.webdriver.datadriventesting;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class ReadDataFromExcelFile 
{
	@Test
	public void read() throws Exception
	{
		FileInputStream fis=new FileInputStream("./TestData\\Login_TestData.xlsx");
		
		XSSFWorkbook w=new XSSFWorkbook(fis);
		
		XSSFSheet s=w.getSheetAt(0);
		
		int rowcount=s.getLastRowNum();
		System.out.println(rowcount);
		
		int column=s.getRow(0).getLastCellNum();
		System.out.println(column);
		
		for(int r=0;r<rowcount;r++)
		{
			XSSFRow row=s.getRow(r);
			for(int c=0;c<column;c++)
			{
				XSSFCell cellvalue=row.getCell(c);
				System.out.print(cellvalue+" ");
			}
			System.out.println();
		}
	}
}
/*

Data Driven Framework 
======================

Separate the test data and test scripts logic from each other.

Allows us to create test scripts by passing different sets of test data.

Test Data are kept in external files such as Excel, Text Files, CSV, Database, XML files.

Usage of Apache POI API
-----------------------

Why Data Driven Framework?
==========================

We can pass different set of data for test scripts to work properly

Reduces number of scripts

Advantages of a Data-Driven Framework
======================================

It supports multiple data sets

Modifying the test scripts won’t affect the test data

No need to hardcode test data

Saves time by executing more tests

Disadvantages of a Data-Driven Framework
=========================================

Require coding skills

Setting up the framework and test data takes more time

Need experienced automation testers to design framework

What is Apache POI
==================

	1. Apache POI is an open source library developed and distributed by Apache Software Foundation.
	
	2. To design or modify, read and write Microsoft Office files(Excel) using Java program.
	
	3. You’d use HSSF if you needed to read or write an Excel file using Java (XLS). 
	
	4. You’d use XSSF if you need to read or write an OOXML Excel file using Java (XLSX).

	5. It has many predefined methods, classes, and interfaces.

*/