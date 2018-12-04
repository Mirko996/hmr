import java.sql.Date;

public class Shift {

	private int id;
	private Date date;
	private int worker_id;
	private int branch_id;
	
	public Shift(int id, Date date, int worker_id, int branch_id) {
		super();
		this.id = id;
		this.date = date;
		this.worker_id = worker_id;
		this.branch_id = branch_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	
}
