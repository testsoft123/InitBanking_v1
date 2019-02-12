package com.initBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException{
		System.out.println(xlfile);
		fi=new FileInputStream(xlfile);
		System.out.println(fi);
		wb=new XSSFWorkbook(fi); 
		ws=wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
		
	}
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
		
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum)throws IOException{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			 DataFormatter formatter = new DataFormatter();
			 String cellData = formatter.formatCellValue(cell);
			 return cellData;
		} catch (Exception e) {
			data="";// TODO: handle exception
		}
		wb.close();
		fi.close();
		
		return data;
		
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum,String data)throws IOException{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		
		return data;
		
	}
	

}
