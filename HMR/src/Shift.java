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
	@Column(name = "start_shift")
	private Date startShift;
	@Column(name = "end_shift")
	private Date endShift;
	public Shift() {
		super();
	}

	public Shift(int id, Date startShift, Date endShift) {
		super();
		this.id = id;
		this.startShift = startShift;
		this.endShift = endShift;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartShift() {
		return startShift;
	}

	public void setStartShift(Date startShift) {
		this.startShift = startShift;
	}

	public Date getEndShift() {
		return endShift;
	}

	public void setEndShift(Date endShift) {
		this.endShift = endShift;
	}

	@Override
	public String toString() {
		return id + ": " + startShift.toString() + ", end shift: " + endShift.toString();
	}
}
