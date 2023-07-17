package hms.zeomedi.testyantra.genericutility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
/**
 * This method is used to return any random number.
 * @author Piyush
 * @return
 */
	public int getRandomNumber() {
		Random radNum = new Random();
		int ranNum = radNum.nextInt(1000);
		return ranNum;
	}
	
	public String getCurrentDate() {
		Date dat = new Date();
		String date = dat.toString();
		return date;
	}
	
	public String getCurrentDateFormatted() {
		Date dat = new Date();
		String date = dat.toString();
		String [] currentDate= date.split(" ");
		String day = currentDate[0];
		String month = currentDate[1];
		String todayDate = currentDate[2];
		String year = currentDate[5];
		return day+" "+todayDate+" "+month+" "+year;
	}
}

