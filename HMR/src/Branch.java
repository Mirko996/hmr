public class Branch {

	private int id;
	private String addres;
	private String email;
	private String name;
	private String password;
	private boolean active;
	
	public Branch(int id, String addres, String email, String name, String password, boolean active) {
		super();
		this.id = id;
		this.addres = addres;
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	
}
