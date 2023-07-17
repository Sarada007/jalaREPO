package hms.zeomedi.testyantra.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to read data from excel, to get the row number and to insert data into excel.
 * @author Piyush
 */
public class ExcelUtility {
	/**
	 * This method is used to insert data into excel workbook.
	 * 
	 * @author Piyush
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	public void insertDataIntoExcel(String SheetName, int rowNum, int cellNum, String data)
			throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet(SheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(Constants.excelFile);
		workBook.write(fos);
		workBook.close();
	}

	/**
	 * This method is used to read data from excel workbook.
	 * 
	 * @author Piyush
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		workBook.close();
		return value;
	}

	/**
	 * This method is used to get the row number of the excel workbook.
	 * @author Piyush
	 * @param SheetName
	 * @return
	 * @throws IOException
	 */
	public int getRowNumber(String SheetName) throws IOException {
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet(SheetName);
		int rowNum = sheet.getLastRowNum();
		workBook.close();
		return rowNum;
	}

	/**
	 * This method is used to read all the cell string data present in a particular
	 * row
	 * 
	 * @author Piyush
	 * @param sheetName
	 * @param rowNum
	 * @return cellValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> readMultipleStringDataFromExcel(String sheetName, int rowNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		ArrayList<String> allCellValue = new ArrayList<String>();
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		int firstRowNum = sheet.getFirstRowNum();
		int lastCellNum = row.getLastCellNum();
		for (int i = ++firstRowNum; i < lastCellNum; i++) {
			String cellValue = row.getCell(i).getStringCellValue();
			allCellValue.add(cellValue);
		}
		workBook.close();
		return allCellValue;
	}
	public Object[][] readSetOfData(String sheetName) throws Throwable{
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum() +1;
		short lastCellNum = sheet.getRow(1).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][lastCellNum];
		DataFormatter df = new DataFormatter();
		for (int i = 1; i < lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				obj[i][j] = df.formatCellValue(cell);
			}
		}
		workbook.close();
		return obj;
	}
}
