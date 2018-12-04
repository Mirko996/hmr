
public class Worker {
	private String name;
	private String last_name;
	private String email;
	private String password;
	public Worker(String name, String last_name, String email, String password) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	@Override
	public String toString() {
		return name + " " + last_name  + ", email: " + email + ", " + ", password: " + password; 
	}
}
