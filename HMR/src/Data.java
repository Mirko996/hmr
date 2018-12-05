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

	public static boolean insertEmloyeeData(Worker w, int branchId) {
		return c.insertEmployee(w, branchId);
	}

	public static boolean InsertBranch(Branch b) {
		return c.insertBranch(b);

	}

	public static int getIdBranchData(String username) {
		if (c.open()) {
			return c.getBranchId(username);
		} else {
			return -1;
		}
	}

	public static boolean removeWorker(int id) {
		return c.removeWorker(id);
		}


	public static boolean editWorker(Worker w) {
		return c.editWorker(w);
	}

	public static boolean restoreWorker(int id) {
		return c.restoreWorker(id);	
	}

	public static boolean editBranch(Branch b) {
		return c.editBranch(b);
	}

	public static boolean removeBranch(int id) {
		return c.removeBranch(id);
		
	}

	public static boolean restoreBranch(int id) {
		return c.restoreBranch(id);
		
	}

	///not working
	public static boolean editBranch(Branch b) {
		return c.editBranch(b);
	}

}
