import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import java.sql.*;

public class Data {

	public static Connection c = new Connection("jdbc:mysql://localhost:3306/hrm_base", "root", "");

	public static boolean logIn(String pass, String username) {
		return c.validateLogIn(pass, username);
	}

	public static List<Shift> shifts() {
		return c.getShifts();
	}

	public static List<Worker> workers() {
		return c.getWorkers();
	}

public static List<Worker> workersByBranch(int id) {
	return c.getWorkersByBranch(id);
}
	public static List<Branch> branches(){

		return c.getBranches();
	}

	public static boolean insertEmloyeeData(Worker w, String branchId) {
		return c.insertEmployee(w, branchId);
	}

	public static boolean InsertBranch(Branch b) {
		return c.insertBranch(b);

	}

	public static String getIdBranchData(String username) {
		if (c.open()) {
			return c.getBranchId(username);
		} else {
			System.out.println("Konekcija je zatvorena");
			return null;
		}
	}


	public static boolean removeWorker(int id) {
		if(c.removeWorker(id)) {
			return true;
		}
		return false;
		
	}


	public static boolean editWorker(Worker w) {
		return c.editWorker(w);
		
	}

}
