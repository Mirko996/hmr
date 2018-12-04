import java.sql.*;
public class Connection {

	String path;
	String password;
	String user;
	
	private java.sql.Connection conn = null;
	
	public Connection(String path, String password, String user) {
		super();
		
		this.path = path;
		this.password = password;
		this.user = user;
		
	}
	
	public boolean open() {
		try {
			conn = DriverManager.getConnection(path, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(conn != null) {
			return true;
		}
		return false;
	}
	
	public void close() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
}
