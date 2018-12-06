
public class Worker {
	private String name;
	private String last_name;
	private String branchName;
	private String email;
	private String password;
	private boolean active;
	private int id;
	private int frBranch;
	
	public Worker( int id, String branchName, String name, String last_name, String email, String password, boolean active) {
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
	public Worker( int id,int frBranch,  String name, String last_name, String email, String password, boolean active) {
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
	
	public Worker(int id, String name, String last_name, String email, String password, boolean active) {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return name + " " + last_name + ", email: " + email + ", " + ", password: " + password + ", active: " + active;
	}
}
