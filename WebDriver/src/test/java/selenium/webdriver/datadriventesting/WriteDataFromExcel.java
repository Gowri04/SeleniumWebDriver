package selenium.webdriver.datadriventesting;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class WriteDataFromExcel 
{
	@Test
	public void write() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("./TestData\\WriteData.xlsx");
	
		XSSFWorkbook w=new XSSFWorkbook();
		
		XSSFSheet s=w.createSheet("Sheet1");
		
		for(int r=0;r<=5;r++)
		{
			XSSFRow row=s.createRow(r);
			for(int c=0;c<=2;c++)
			{
				XSSFCell cellvalue=row.createCell(c);
				cellvalue.setCellValue("Excel");
			}
		}
		w.write(fos);
	}
}
