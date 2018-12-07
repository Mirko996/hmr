
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "workers")
public class Worker {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "branch_name")
	private String branchName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private int active;
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "fk_branc_id")
	private int frBranch;
	public Worker() {}
	public Worker( int id, String branchName, String name, String last_name, String email, String password, int active) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.branchName = branchName;
		this.password = password;
		this.active = active;
		this.id = id;
		this.frBranch = frBranch;
	}
	public Worker( int id,int frBranch,  String name, String last_name, String email, String password, int active) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.id = id;
		this.frBranch = frBranch;
	}
	// without active
	public Worker(String name, String last_name, String email, String password) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}
	
	public Worker(int id, String name, String last_name, String email, String password, int active) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.active = active;
	}
	
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getFrBranch() {
		return frBranch;
	}

	public void setFrBranch(int frBranch) {
		this.frBranch = frBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return name + " " + last_name + ", email: " + email + ", " + ", password: " + password + ", active: " + active;
	}
}
