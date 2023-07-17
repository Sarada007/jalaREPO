package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "dataSet1")
	public void travelDetails(String src, String dest, int price) {
		System.out.println("From====" + src + "     " + "To====" + dest + "     " + "Fare====" + price);
	}

	@Test(dataProvider = "dataSet2")
	public void employeeDetails(String name, String address, int weight, int height) {
		System.out.println("Name====" + name + "     " + "Address====" + address + "     " + "Weight====" + weight
				+ "     " + "Height====" + height + "     ");
	}

	@Test(dataProvider = "dataSet3")
	public void medalDetails(String name, int gold, int silver, int bronze, int total) {
		System.out
				.println("Country Name====" + name + "     " + "Gold Medals====" + gold + "     " + "Silver Medals===="
						+ silver + "     " + "Bronze Medals====" + bronze + "     " + "Total Medals====" + total);
	}

	@DataProvider
	public Object[][] dataSet1() {
		Object[][] arr = new Object[3][3];
		arr[0][0] = "New Delhi";
		arr[0][1] = "Mumbai";
		arr[0][2] = 7000;
		arr[1][0] = "Shimla";
		arr[1][1] = "Gangtok";
		arr[1][2] = 4000;
		arr[2][0] = "Chennai";
		arr[2][1] = "Calcutta";
		arr[2][2] = 6000;
		return arr;
	}

	@DataProvider
	public Object[][] dataSet2() {
		Object[][] arr = new Object[4][4];
		arr[0][0] = "Rahul";
		arr[0][1] = "Mumbai";
		arr[0][2] = 65;
		arr[0][3] = 170;
		arr[1][0] = "Preetam";
		arr[1][1] = "Gangtok";
		arr[1][2] = 80;
		arr[1][3] = 175;
		arr[2][0] = "Lisa";
		arr[2][1] = "Calcutta";
		arr[2][2] = 50;
		arr[2][3] = 160;
		arr[3][0] = "Aisha";
		arr[3][1] = "New Delhi";
		arr[3][2] = 55;
		arr[3][3] = 165;
		return arr;
	}

	@DataProvider
	public Object[][] dataSet3() {
		Object[][] arr = new Object[4][5];
		arr[0][0] = "India";
		arr[0][1] = 1;
		arr[0][2] = 2;
		arr[0][3] = 4;
		arr[0][4] = 7;
		arr[1][0] = "USA";
		arr[1][1] = 39;
		arr[1][2] = 41;
		arr[1][3] = 33;
		arr[1][4] = 113;
		arr[2][0] = "Australia";
		arr[2][1] = 17;
		arr[2][2] = 7;
		arr[2][3] = 22;
		arr[2][4] = 46;
		arr[3][0] = "Brazil";
		arr[3][1] = 7;
		arr[3][2] = 6;
		arr[3][3] = 8;
		arr[3][4] = 21;
		return arr;
	}
}
