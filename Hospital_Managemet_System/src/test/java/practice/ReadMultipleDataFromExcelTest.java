package practice;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {
	public static void main(String[] args) throws Throwable {
		readMultipleDataFromExcel("Sheet1",1);
	}
public static void readMultipleDataFromExcel(String sheet,int rowNum) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/Olympic Data.xlsx");
	ArrayList<String> arr = new ArrayList<String>();
	Workbook wb = WorkbookFactory.create(fis);
	Sheet shee = wb.getSheet(sheet);
	Row row = shee.getRow(rowNum);
	int firstRow = shee.getFirstRowNum();
	short lastCell = row.getLastCellNum();
	System.out.println(firstRow);
	System.out.println(lastCell);
	DataFormatter df = new DataFormatter();
	for (int i = firstRow; i < lastCell; i++) {
		Cell cell = row.getCell(i);
		String cellValue=df.formatCellValue(cell);
		arr.add(cellValue);
	}
	System.out.println(arr);
}
}
