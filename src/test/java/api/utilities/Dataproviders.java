package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {

	@DataProvider(name="data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\testData\\UserData.xlsx";
		ExcelRelated e=new ExcelRelated(path);
		
		int r=e.getRowCount("Sheet1");
		int c=e.getCellCount("Sheet1", 1);
		System.out.println(r+"   "+c);
		String[][] s=new String[r-1][c];
		
		
		for(int i=1;i<r;i++)//4
		{
			for(int j=0;j<c;j++)//6
			{
				
				s[i-1][j]=e.getCellData("Sheet1", i, j);
			}
		}
		
		return s;
	}
	
	
	@DataProvider(name="userName")
	public String[] getUserName() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\testData\\UserData.xlsx";
		ExcelRelated e=new ExcelRelated(path);
		
		int r=e.getRowCount("Sheet1");
		
		String[] s=new String[r-1];
		
		for(int i=1;i<r;i++)
		{
			s[i-1]=e.getCellData("Sheet1", i, 1);
		}
		
		return s;
	}
}
