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