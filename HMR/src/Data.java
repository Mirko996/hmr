import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import java.sql.*;

public class Data {


	public static Connection c = new Connection(
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
<<<<<<< HEAD
	public static boolean insertEmloyeeData(Worker w, String branchId) {
		return c.insertEmployee(w, branchId);
=======
	
	public static boolean InsertBranch(Branch b) {
		return c.insertBranch(b);
>>>>>>> a3dce5b044f7f41ccb3f98e7195b8f8b1612c850
	}

	public static String getIdBranchData(String username) {
		return c.getBranchId(username);
	}

}
