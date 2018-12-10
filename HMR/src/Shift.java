import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shifts")
public class Shift {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "date")
	private Date date;
	@Column(name = "branch_id")
	private int branch_id;
	@Column(name = "shift_type")
	private int shift_type;

	public Shift() {
		super();
	}

	public Shift(int id, Date date, int branch_id, int shift_type) {
		super();
		this.id = id;
		this.date = date;
		this.branch_id = branch_id;
		this.shift_type = shift_type;
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

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public int getShift_type() {
		return shift_type;
	}

	public void setShift_type(int shift_type) {
		this.shift_type = shift_type;
	}

	@Override
	public String toString() {
		return id + ": " + date.toString() + ", branch_id: " + branch_id + ", " + shift_type;
	}
}
