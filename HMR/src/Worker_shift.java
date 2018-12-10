import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

//	private List<Worker> workers;
//
//	
//	private List<Shift> shifts;

	public Worker_shift() {
		super();
	}
	
	public Worker_shift(int worker_id, int shift_id) {
		super();
		this.worker_id = worker_id;
		this.shift_id = shift_id;
	}
	
	public Worker_shift(Date clock_out, int worker_id, int shift_id) {
		super();
		this.clock_out = clock_out;
		this.worker_id = worker_id;
		this.shift_id = shift_id;
	}

	public Worker_shift(Date clock_in, Date clock_out, int worker_id, int shift_id) {
		super();
		this.clock_in = clock_in;
		this.clock_out = clock_out;
		this.worker_id = worker_id;
		this.shift_id = shift_id;
	}

	public Worker_shift(int id, Date clock_in, Date clock_out, int worker_id, int shift_id) {
		super();
		this.id = id;
		this.clock_in = clock_in;
		this.clock_out = clock_out;
//		workers = new ArrayList<Worker>();
//		shifts = new ArrayList<Shift>();

		this.worker_id = worker_id;
		this.shift_id = shift_id;
	}

//	private boolean addWorker(Worker w) {
//		if (find(w)) {
//			if (workers.add(w)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private boolean addShift(Shift s) {
//		if (find(s)) {
//			if (shifts.add(s)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public <T> boolean find(T a) {
//		if (a instanceof Worker) {
//			Worker worker = (Worker) a;
//			for (Worker w : workers) {
//				if (worker.getId() == w.getId()) {
//					return true;
//				}
//			}
//		} else if (a instanceof Shift) {
//			Shift shift = (Shift) a;
//			for (Shift s : shifts) {
//				if (shift.getId() == s.getId()) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

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
}
