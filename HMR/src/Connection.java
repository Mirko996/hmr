import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		if (conn != null) {
			return true;
		}
		return false;
	}

	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public boolean validateLogIn(String pass, String username) {
		String sql = "SELECT * FROM branches";

		if (open()) {
			try {
				Statement s = conn.createStatement();
				ResultSet set = s.executeQuery(sql);

				while (set.next()) {
					if (pass.equalsIgnoreCase(set.getString("password"))
							&& username.equalsIgnoreCase(set.getString("name"))) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		}
		return false;
	}

	public List<Worker> getWorkers() {
		String sql = "SELECT * FROM workers";
		if (open()) {
			try {
				List<Worker> workers = new ArrayList<Worker>();
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					Worker w =  new Worker(rs.getString("name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"));
					workers.add(w);
				}
				close();
				return workers;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

}
