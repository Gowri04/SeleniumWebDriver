package selenium.webdriver.datadriventesting;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities 
{

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow r;
	public static XSSFCell c;
	
	public static int getRowCount(String excelFile, String excelSheet)
	{
		int rowCount=0;
		try
		{
			
			fis=new FileInputStream(excelFile);
			wb=new XSSFWorkbook(fis);
			ws=wb.getSheet(excelSheet);
			rowCount=ws.getLastRowNum();
			System.out.println(rowCount);
			wb.close();
			fis.close();
			
		}
		catch(Exception e)
		{
			
			System.out.println("FileNotFound/Unable to Read the File");
			
		}
		System.out.println(rowCount);
		return rowCount;
	}
	
	public static int getCellCount(String excelFile, String excelSheet, int rowNum)
	{
		int colCount=0;
		try
		{
			
			fis=new FileInputStream(excelFile);
			wb=new XSSFWorkbook(fis);
			ws=wb.getSheet(excelSheet);
			r=ws.getRow(rowNum);
			colCount=r.getLastCellNum();
			System.out.println(colCount);
			wb.close();
			fis.close();
		
		}
		catch(Exception e)
		{

			System.out.println("FileNotFound/Unable to Read the File");
			
		}
		System.out.println(colCount);
		return colCount;
		
	}
	
	public static String getCellData(String excelFile, String excelSheet, int rowNum, int colNum)
	{
		
		String cellData=null;
		try
		{
			
			fis=new FileInputStream(excelFile);
			wb=new XSSFWorkbook(fis);
			ws=wb.getSheet(excelSheet);
			r=ws.getRow(rowNum);
			c=r.getCell(colNum);
			try
			{
				DataFormatter formatter=new DataFormatter();
				String cellValue=formatter.formatCellValue(c);
				return cellValue;
			}
			catch(Exception e)
			{
				
				cellData="";
				
			}
			wb.close();
			fis.close();
		}
		catch(Exception e)
		{
		
			System.out.println("FileNotFound/Unable to Read the File");
			
		}
		
		return cellData;
		
	}
	
	public static void setCellData(String excelFile, String excelSheet, int rowNum ,int colNum, String data)
	{
		
		try
		{
			
			fis=new FileInputStream(excelFile);
			wb=new XSSFWorkbook(fis);
			ws=wb.getSheet(excelSheet);
			r=ws.getRow(rowNum);
			c=r.createCell(colNum);
			c.setCellValue(data);
			fos=new FileOutputStream(excelFile);
			wb.write(fos);
			wb.close();
			fis.close();
			fos.close();
			
		}
		catch(Exception e)
		{
			
			System.out.println("File cantbe Created/Unable to Write a data to Excel");
			
		}
		
	}
	
}
