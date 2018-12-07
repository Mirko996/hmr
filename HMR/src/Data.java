import java.util.List;


public class Data {

	public static Connection c = new Connection("jdbc:mysql://localhost:3306/hrm_base", "root", "");
	public static Connections connH = new Connections();

	public static boolean logIn(String pass, String username) {
		return connH.validateLogIn(pass, username);
	}

	public static List<Shift> shifts() {
		return connH.getShifts();
	}

	public static List<Worker> workers() {
		return connH.getWorkers();
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
	
	public static boolean updateWorkersBranch(String s, String c1) {
		return c.updatWorkersBranch(s,c1);
	}

}
