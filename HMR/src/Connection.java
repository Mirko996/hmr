import java.sql.*;
public class Connection {

	String path;
	String password;
	String user;
	
	private java.sql.Connection conn = null;
	
	public Connection(String path, String user, String password) {
		super();
		
		this.path = path;
		this.user = user;
		this.password = password;
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
