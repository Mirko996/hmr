import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "branches")
public class Branch {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "address")
	private String addres;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "active")
	private int active;
	
	
	
	public Branch() {
		super();
	}
	public Branch(int id, String addres, String city, String email, String name, String password, int active) {
		super();
		this.id = id;
		this.addres = addres;
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
		this.city = city;
	}
	public Branch(int id, String addres, String city, String email, String name, String password) {
		super();
		this.id = id;
		this.addres = addres;
		this.email = email;
		this.name = name;
		this.password = password;
		this.city = city;
	}
	public Branch( String addres, String city, String email, String name, String password) {
		super();
		this.addres = addres;
		this.email = email;
		this.name = name;
		this.password = password;
		this.city = city;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return id + ": " + name + ", " + email + ", " + addres + ", " + city + ", password: " + password;
 	}
	
}
