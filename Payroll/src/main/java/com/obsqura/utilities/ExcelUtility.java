package com.obsqura.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtility {
	XSSFSheet sh;
	public String readData(int i,int j){
		Row r=sh.getRow(i);
		Cell c=r.getCell(j);
		int celltype=c.getCellType();
		switch(celltype) {//0
			case Cell.CELL_TYPE_NUMERIC:
			{
					double a=c.getNumericCellValue();
					return String.valueOf(a);
			}
			case Cell.CELL_TYPE_STRING://1
			{
					return c.getStringCellValue();
			}
		}
		return null;
	}
	public ExcelUtility() throws IOException {
		FileInputStream f=new FileInputStream("C:\\excel read nd write\\Book1.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		sh=w.getSheet("Sheet1");
	}
}


