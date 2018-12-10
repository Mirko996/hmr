import java.util.List;

public class Data {
	//not using connections.class instead
//	public static Connection c = new Connection("jdbc:mysql://localhost:3306/hrm_base", "root", "");
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
		return connH.getWorkersByBranch(id);
	}

	public static List<Branch> branches() {
		return connH.getBranches();
	}



	public static boolean insertEmployeeDataNew(Worker w) {
		return connH.insertEmployee(w);
	}

	public static boolean insertBranchNew(Branch b) {
		return connH.insertBranch(b);
	}

	public static int getIdBranchData(String email) {
			return connH.getBranchId(email);
	}


	public static boolean removeWorkerNew(int id) {
		return connH.removeWorker(id);
	}
	
	public static boolean editWorkerNew(Worker w) {
		return connH.editWorker(w);
	}
	
	
	public static boolean restoreWorkerNew(int id) {
		return connH.restoreWorker(id);
	}
	
	public static boolean removeBranchNew(int id) {
		return connH.removeBranch(id);
	}

	public static boolean restoreBranchNew(int id) {
		return connH.restoreBranch(id);
	}

	public static boolean editBranchNew(Branch b) {
		return connH.editBranch(b);
	}
	

	public static boolean updateWorkersBranchNew(int id, int branchIdNew) {
		return connH.updateWorkersBranch(id, branchIdNew);
	}
	
	public static boolean duplicateEntryBranch(String email) {
		return connH.duplicateEntryBranch(email);
	}
	
	
	
	//test
	public static boolean insertWorker_shift(Worker_shift ws) {
		return connH.insertWokrerShift(ws);
	}
	
}
