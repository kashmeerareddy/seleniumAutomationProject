package app.seleniumautomation.utilities;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelSheet {
	public static XSSFWorkbook getExcelWorkBook(String path) throws IOException {
		FileInputStream fs = new FileInputStream(new File(path));
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		return wb;
	}
		
	public static XSSFSheet getExcelWorkSheet(String path,String Sheetname) throws IOException {
		FileInputStream fs = new FileInputStream(new File(path));
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet ws = wb.getSheet(Sheetname);
		return ws;
	}
}
