package hms.zeomedi.testyantra.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * This class is used for connecting to database , performing CRUD operations
 * and disconnecting from data base
 * 
 * @author Piyush
 *
 */
public class DataBaseUtility {
	static Driver driv;
	static Connection conn;
	static ResultSet result;

	/**
	 * This method is used to connect to data base.
	 * 
	 * @author Piyush
	 */
	public void connectToDB() {
		try {
			driv = new Driver();
			DriverManager.registerDriver(driv);
			conn = DriverManager.getConnection(Constants.mySQLUrl, Constants.mySQLUsername, Constants.mySQLPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to execute the passed query.
	 * 
	 * @author Piyush
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws Throwable {
		result = conn.createStatement().executeQuery(query);
		return result;
	}

	/**
	 * This method is used to execute update to passed query.
	 * 
	 * @author Piyush
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdate(String query) throws Throwable {
		int result = conn.createStatement().executeUpdate(query);
		return result;
	}

	/**
	 * This method is used to execute the query and verify whether it is present in
	 * data base or not.
	 * 
	 * @param query
	 * @param columnIndex
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQueryAndVerify(String query, int columnIndex, String expectedData) throws Throwable {
		boolean flag = false;
		result = conn.createStatement().executeQuery(query);
		while (result.next()) {
			if (result.getString(columnIndex).equals(expectedData)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(expectedData + " Data is verified in the data base table");
			return flag;
		} else {
			System.out.println(expectedData + " Data is not verified in the data base table");
			return flag;
		}
	}

	/**
	 * This method is used to close the data base connection.
	 * 
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		conn.close();
	}
}
