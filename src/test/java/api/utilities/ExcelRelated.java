package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRelated {

	String path;
	public FileInputStream f;
	public XSSFWorkbook x;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;
	
	public ExcelRelated(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		f=new FileInputStream(path);
		x=new XSSFWorkbook(f);
		 s=x.getSheet(sheetName);
		int r= s.getLastRowNum();
		x.close();
		f.close();
		
		return r;
	}
	
	public int getCellCount(String sheetName,int rowNum) throws IOException
	{
		f=new FileInputStream(path);
		x=new XSSFWorkbook(f);
		 s=x.getSheet(sheetName);
		 row= s.getRow(rowNum);
		 int c=(int)row.getLastCellNum();
		 //System.out.println(c+" "+rowNum);
		x.close();
		f.close();
		
		return c;
	}
	
	public String getCellData(String sheetName,int rowNum,int comnNum) throws IOException
	{
		f=new FileInputStream(path);
		x=new XSSFWorkbook(f);
		 s=x.getSheet(sheetName);
		 row= s.getRow(rowNum);
		cell=row.getCell(comnNum);
		
		DataFormatter d=new DataFormatter();
		
		String data;
		try
		{
			data=d.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="the";
		}
		x.close();
		f.close();
		return data;
		
	}
}
