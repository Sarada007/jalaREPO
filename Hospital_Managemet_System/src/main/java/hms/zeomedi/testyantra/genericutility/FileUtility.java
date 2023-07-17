package hms.zeomedi.testyantra.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is used to read common data from the property file.
 * @author Piyush
 */
public class FileUtility {
	/**
	 * This method is used to read the common data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis = new FileInputStream(Constants.propertyFile);
	Properties prop = new Properties();
	prop.load(fis);
	String value =prop.getProperty(key);
	return value;
}
}
