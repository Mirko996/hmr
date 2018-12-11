import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//not implemented yet
@Entity
@Table(name = "worker_shift")
public class Worker_shift {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "clock_in")
	private Date clock_in;
	@Column(name = "clock_out")
	private Date clock_out;
	@Column(name = "worker_id")
	private int worker_id;
	@Column(name = "shift_id")
	private int shift_id;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "branch_id")
	private int branchId;

	public Worker_shift() {
		super();
	}

	public Worker_shift(int id, Date clock_in, Date clock_out, int worker_id, int shift_id) {
		super();
		this.id = id;
		this.clock_in = clock_in;
		this.clock_out = clock_out;
		this.worker_id = worker_id;
		this.shift_id = shift_id;
		this.date = date;
	}
	
	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Worker_shift(LocalDate date,  int worker_id, int shift_id) {
		super();
		this.worker_id = worker_id;
		this.shift_id = shift_id;
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getClock_in() {
		return clock_in;
	}

	public void setClock_in(Date clock_in) {
		this.clock_in = clock_in;
	}

	public Date getClock_out() {
		return clock_out;
	}

	public void setClock_out(Date clock_out) {
		this.clock_out = clock_out;
	}

	public int getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}

	public int getShift_id() {
		return shift_id;
	}

	public void setShift_id(int shift_id) {
		this.shift_id = shift_id;
	}

	@Override
	public String toString() {
		return "Worker_shift [id=" + id + ", clock_in=" + clock_in + ", clock_out=" + clock_out + ", worker_id="
				+ worker_id + ", shift_id=" + shift_id + ", date=" + date + "]";
	}

}
