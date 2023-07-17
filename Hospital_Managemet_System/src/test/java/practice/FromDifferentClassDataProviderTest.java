package practice;

import org.testng.annotations.Test;

public class FromDifferentClassDataProviderTest {
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataSet1")
	public void travelDetails(String src, String dest, int price) {
		System.out.println("From====" + src + "     " + "To====" + dest + "     " + "Fare====" + price);
	}

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataSet2")
	public void employeeDetails(String name, String address, int weight, int height) {
		System.out.println("Name====" + name + "     " + "Address====" + address + "     " + "Weight====" + weight
				+ "     " + "Height====" + height + "     ");
	}

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataSet3")
	public void medalDetails(String name, int gold, int silver, int bronze, int total) {
		System.out
				.println("Country Name====" + name + "     " + "Gold Medals====" + gold + "     " + "Silver Medals===="
						+ silver + "     " + "Bronze Medals====" + bronze + "     " + "Total Medals====" + total);
	}
}
