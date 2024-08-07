package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	String excelPath ="./ExcelData/restAssuredData.xlsx";
	
	public String getDataFromExcel(String sheetName, int row, int cell ) throws Throwable, IOException {
		FileInputStream fis  = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(book.getSheet(sheetName).getRow(row).getCell(cell));
		book.close();
		return data;
	}

	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(fis);
		int rowNum = book.getSheet(sheetName).getLastRowNum();
		book.close();
		return rowNum;
	}

}
