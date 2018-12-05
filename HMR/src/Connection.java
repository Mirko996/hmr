import java.awt.Frame;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Connection {

	private String path;
	private String password;
	private String user;

	private java.sql.Connection conn = null;

	public Connection(String path, String user, String password) {
		super();

		this.path = path;
		this.user = user;
		this.password = password;
	}

	// empty constructor
	public Connection() {
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
					Worker w = new Worker(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getString("email"),
							rs.getString("password"), rs.getString("active"));
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

	public List<Shift> getShifts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Branch> getBranches() {
		List<Branch> branches = new ArrayList<>();
		if (open()) {
			String sql = "SELECT * FROM branches";
			try {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				boolean boo;
				while (rs.next()) {
					if (rs.getInt("active") == 1) {
						boo = true;
					} else {
						boo = false;
					}
					Branch b = new Branch(rs.getInt("id"), rs.getString("address"), rs.getString("city"),
							rs.getString("email"), rs.getString("name"), rs.getString("password"), boo);
					branches.add(b);
				}
				close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return branches;
	}

	public boolean insertBranch(Branch b) {
		if (open()) {

			String sql = "INSERT INTO branches(address,city,email,name,password) VALUES ('" + b.getAddres() + "','"
					+ b.getCity() + "','" + b.getEmail() + "','" + b.getName() + "', '" + b.getPassword() + "' )";
			try {

				Statement s = conn.createStatement();
				s.executeUpdate(sql);
				close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;

	}

	public boolean insertEmployee(Worker w, String branchId) {
		System.out.println(branchId);

		String sql = "INSERT INTO workers(fk_branc_id, name, last_name, email, password) VALUES ('" + branchId + "','"
				+ w.getName() + "','" + w.getLast_name() + "', '" + w.getEmail() + "','" + w.getPassword() + "')";
//		String sqlCheck = "select * from workers where email like '" + w.getEmail() + "'";
		Statement s;
		try {
			if (open()) {
////				s = conn.createStatement();
//				ResultSet rs = s.executeQuery(sqlCheck);
//				if (!rs.next()) {
				s = conn.createStatement();
				s.executeUpdate(sql);
				close();
				return true;
//				}else {
//					return false;
//				}	
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			return false;
		}
		return false;
	}

	public String getBranchId(String username) {
		if (open()) {
			String sql = "select id from `branches` WHERE name = '" + username + "'";
			try {
				String ss = "";
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					ss = rs.getString("id");
				}
				return ss;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}

		}
		return null;
	}

	public boolean removeWorker(int id) {

		if (open()) {
			String sql = "UPDATE workers SET active = " + "'0'" + " where id = " + "'" + id + "'";
			try {

				Statement s = conn.createStatement();
				s.executeUpdate(sql);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
