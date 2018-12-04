public class Data {

	static Connection c = new Connection(
			"jdbc:mysql://localhost:3306/xml_students", "root", "");

	
	public static boolean logIn(String pass, String username) {		
		return c.validateLogIn(pass, username);	
	}
}
