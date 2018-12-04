import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import java.sql.*;

public class Data {


	static Connection c = new Connection(
			"jdbc:mysql://localhost:3306/hrm_base", "root", "");


	public static boolean logIn(String pass, String username) {
		return c.validateLogIn(pass, username);
	}

	
	public static List<Shift> shifts(){
		return c.getShifts();
	}


	public static List<Worker> workers() {
		return c.getWorkers();
	}
	
	public static List<Branch> branches(){
		return c.getBranches();
	}


}
