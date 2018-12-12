import java.time.LocalDate;
import java.util.List;

public class Data {
	// not using connections.class instead
//	public static Connection c = new Connection("jdbc:mysql://localhost:3306/hrm_base", "root", "");
	public static Connections connH = new Connections();

	public static boolean logIn(String pass, String username) {
		return connH.validateLogIn(pass, username);
	}

	public static boolean logInManager(String email, String pass, String emailBranch) {
		return connH.validateLoginManager(email, pass, emailBranch);
	}
	
	public static boolean logInAdmin(String email, String pass) {
		return connH.validateLoginAdmin(email, pass);
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

	public static boolean insetrtToWorker_shift(List<Worker_shift> ws, List<String> nonWorkingDays, int numDays,
			int branchId) {
		return connH.insertWorker_shift(ws, nonWorkingDays, numDays, branchId);
	}

	// not tested // not done yet
	public static boolean insertWorker_shift(Worker_shift ws) {
		return connH.insertWokrerShift(ws);
	}

	public static int getShiftIdByWorker(int worker_id) {
		return connH.getShiftIdByWorkerId(worker_id);
	}

	public static int getIdBranchDataByName(String branchName) {
		return connH.getIdBranchDataByName(branchName);
	}

	public static List<Worker> ActiveworkersByBranch(int idBranchData) {
		return connH.ActiveworkersByBranch(idBranchData);
	}
	
	public static boolean isAdmin(String email) {
		return connH.isAdmin(email);
	}

	public static boolean duplicateEntryWorker_shift(List<Worker_shift> worker_shift, LocalDate date) {
		return connH.duplicateEntryWorker_shift(worker_shift, date);
	}
}