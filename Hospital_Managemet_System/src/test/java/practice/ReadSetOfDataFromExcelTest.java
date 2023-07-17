package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.zeomedi.testyantra.genericutility.ExcelUtility;

public class ReadSetOfDataFromExcelTest {
	@Test(dataProvider = "retrieve")
public void readMultipleDataTest(String name, String gold, String silver, String bronze, String total) throws Throwable {
		System.out
		.println("Country Name====" + name + "     " + "Gold Medals====" + gold + "     " + "Silver Medals===="
				+ silver + "     " + "Bronze Medals====" + bronze + "     " + "Total Medals====" + total);
}
@DataProvider
public Object[][] retrieve() throws Throwable{
	ExcelUtility excel = new ExcelUtility();
	Object[][] obj =excel.readSetOfData("DataProvider");
	return obj;
}
}
