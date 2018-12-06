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
		String sql = "SELECT w.id, w.fk_branc_id, b.name, w.name, w.last_name, w.email, w.password, w.active FROM workers w, branches b where w.fk_branc_id = b.id";
		if (open()) {
			try {
				List<Worker> workers = new ArrayList<Worker>();
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					boolean active = false;
					if (rs.getString("w.active").equalsIgnoreCase("1")) {
						active = true;
					}
					Worker w = new Worker(rs.getInt("w.id"), rs.getString("b.name"), rs.getString("w.name"),
							rs.getString("w.last_name"), rs.getString("w.email"), rs.getString("w.password"), active);

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

	public boolean insertEmployee(Worker w, int branchId) {
		String sql = "INSERT INTO workers(fk_branc_id, name, last_name, email, password) VALUES ('" + branchId + "','"
				+ w.getName() + "','" + w.getLast_name() + "', '" + w.getEmail() + "','" + w.getPassword() + "')";
		Statement s;
		try {
			if (open()) {
				s = conn.createStatement();
				s.executeUpdate(sql);
				close();
				return true;
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			return false;
		}
		return false;
	}

	public int getBranchId(String username) {
		if (open()) {
			String sql = "select id from `branches` WHERE name = '" + username + "'";
			try {
				int ss = -1;
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					ss = rs.getInt("id");
				}
				close();
				return ss;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return -1;
			}
		}
		return -1;
	}

	public boolean removeWorker(int id) {

		if (open()) {
			String sql = "UPDATE workers SET active = " + "'0'" + " where id = " + "'" + id + "'";
			try {

				Statement s = conn.createStatement();
				s.executeUpdate(sql);
				close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public List<Worker> getWorkersByBranch(int id) {
		String sql = "SELECT * FROM workers WHERE fk_branc_id = '" + id + "'";
		if (open()) {
			try {
				List<Worker> workers = new ArrayList<Worker>();
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					boolean active = false;
					if (rs.getString("active").equalsIgnoreCase("1")) {
						active = true;
					}
					Worker w = new Worker(rs.getInt("id"), rs.getInt("fk_branc_id"), rs.getString("name"),
							rs.getString("last_name"), rs.getString("email"), rs.getString("password"), active);
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

	public boolean editWorker(Worker w) {

		// String sql = "UPDATE workers SET fk_branc_id = 1,name = 2,last_name = 3,email
		// = 4,password = 5,active = 1 WHERE id = '0'";
		if (open()) {
			String sql = "UPDATE workers SET name = '" + w.getName() + "',last_name = '" + w.getLast_name()
					+ "',email = '" + w.getEmail() + "',password = '" + w.getPassword() + "',active = 1 WHERE id = '"
					+ w.getId() + "'";
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

	public boolean restoreWorker(int id) {
		if (open()) {
			String sql = "UPDATE workers SET active = " + "'1'" + " where id = " + "'" + id + "'";
			try {

				Statement s = conn.createStatement();
				s.executeUpdate(sql);
				close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean editBranch(Branch b) {

		if (open()) {
			String sql = "UPDATE branches SET address = '" + b.getAddres() + "',name = '" + b.getName() + "',city = '"
					+ b.getCity() + "',email = '" + b.getEmail() + "',password = '" + b.getPassword()
					+ "',active = 1 WHERE id = '" + b.getId() + "'";
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

	public boolean removeBranch(int id) {
		if (open()) {
			String sql = "UPDATE branches SET active = " + "'0'" + " where id = " + "'" + id + "'";
			try {

				Statement s = conn.createStatement();
				s.executeUpdate(sql);
				close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;

	}

	public boolean restoreBranch(int id) {
		if (open()) {
			String sql = "UPDATE branches SET active = " + "'1'" + " where id = " + "'" + id + "'";
			try {

				Statement s = conn.createStatement();
				s.executeUpdate(sql);
				close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean updatWorkersBranch(String branch, String id) {
		if (open()) {
			String sql = "SELECT id FROM branches WHERE name = '" + branch + "'";
			try {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					String sql2 = "UPDATE workers SET fk_branc_id = " +  rs.getInt("id") + " where id = " + "'" + id + "'";
					Statement s2 = conn.createStatement();
					s2.executeUpdate(sql2);
				}
				close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}

}
