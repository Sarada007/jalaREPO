package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DataProviderExcelTest {
	@Test
	public Object[][] readMultipleDataFromExcel() throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Olympic Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		System.out.println(lastRow);
		System.out.println(lastCell);
		Object[][] multi = new Object[lastRow][lastCell];
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				multi[i][j] = df.formatCellValue(cell);
			}
		}
		return multi;
	}
}
