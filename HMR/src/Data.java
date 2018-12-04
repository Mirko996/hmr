import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import java.sql.*;

public class Data {

	public static Connection c = new Connection("jdbc:mysql://localhost:3306/hrm_base", "root", "");

	public static boolean logIn(String pass, String username) {
		return c.validateLogIn(pass, username);
	}

	public static List<Worker> workers() {
		return c.getWorkers();
	}

}
