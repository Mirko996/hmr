import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Workers extends JFrame {

	private JPanel contentPane;
	static JTable table;
	Object[][] objects = null;
	private static String[] columnNameAdmin = { "ID", "Branch", "Name", "Last name", "Email", "Password", "Active" };
	private static String[] columnName = { "ID", "Name", "Last name", "Email", "Password", "Active" };
	private JScrollPane scrollPane;
	private JButton btnAddEmployee;
	private JButton btnRemoveEmployee;
	private JButton btnUpdateEmployee;
	private static String username;
	private JButton btnReturnEmployee;

	public Workers(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnAddEmployee());
		contentPane.add(getBtnRemoveEmployee());
		contentPane.add(getBtnUpdateEmployee());
		contentPane.add(getBtnReturnEmployee());
		if (isAdmin(username)) {
			updateTableAadmin();
			btnAddEmployee.setVisible(false);
		} else {
			updateTable();
		}
	}

	public static boolean isAdmin(String username) {
		if (username.equalsIgnoreCase("admin")) {
			return true;
		}
		return false;
	}

	public static void updateTableAadmin() {
		Object[][] objcts = new Object[Data.workers().size()][7];
		int c = 0;
		List<Worker> wrk = Data.workers();
		if (wrk != null) {
			for (Worker w : wrk) {
				Object[] oo = { w.getId(), w.getBranchName(), w.getName(), w.getLast_name(), w.getEmail(),
						w.getPassword(), w.isActive() };
				objcts[c] = oo;
				c++;
			}
		}
		DefaultTableModel dtm;
		if (isAdmin(username)) {
			dtm = new DefaultTableModel(objcts, columnNameAdmin);
		} else {
			dtm = new DefaultTableModel(objcts, columnName);
		}
		table.setModel(dtm);

	}

	public static void updateTable() {
		Object[][] objcts = new Object[Data.workersByBranch(Data.getIdBranchData(username)).size()][6];
		int c = 0;
		int id = Data.getIdBranchData(username);
		List<Worker> wrk = Data.workersByBranch(id);
		if (wrk != null) {
			for (Worker w : wrk) {
				Object[] oo = { w.getId(), w.getName(), w.getLast_name(), w.getEmail(), w.getPassword(), w.isActive() };
				objcts[c] = oo;
				c++;
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(objcts, columnName);
		table.setModel(dtm);
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(0, 338, 884, 173);
			table.setRowHeight(50);
		}
		return table;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 181, 884, 319);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JButton getBtnAddEmployee() {
		if (btnAddEmployee == null) {
			btnAddEmployee = new JButton("ADD EMPLOYEE");
			btnAddEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					AddEmployee ae = new AddEmployee(username);
					ae.setVisible(true);
				}
			});
			btnAddEmployee.setBounds(219, 108, 132, 42);
		}
		return btnAddEmployee;
	}

	private Worker tableWorker() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
			return null;
		}
		boolean active = false;
		int id;
		String name;
		String last_name;
		String email;
		String password;
		if (isAdmin(username)) {
			id = (int) table.getModel().getValueAt(row, 0);
			name = table.getModel().getValueAt(row, 2).toString();
			last_name = table.getModel().getValueAt(row, 3).toString();
			email = table.getModel().getValueAt(row, 4).toString();
			password = table.getModel().getValueAt(row, 5).toString();
		} else {
			id = (int) table.getModel().getValueAt(row, 0);
			name = table.getModel().getValueAt(row, 1).toString();
			last_name = table.getModel().getValueAt(row, 2).toString();
			email = table.getModel().getValueAt(row, 3).toString();
			password = table.getModel().getValueAt(row, 4).toString();

		}
		if (table.getModel().getValueAt(row, 5).toString().equalsIgnoreCase("true")) {
			active = false;
		}

		Worker w = new Worker(id, name, last_name, email, password, active);
		return w;
	}

	private JButton getBtnRemoveEmployee() {
		if (btnRemoveEmployee == null) {
			btnRemoveEmployee = new JButton("REMOVE EMPOLOYEE");
			btnRemoveEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					if (row != -1) {
						Data.removeWorker((int) table.getModel().getValueAt(row, 0));
						if (isAdmin(username)) {
							updateTableAadmin();
						} else {
							updateTable();
						}
						JOptionPane.showMessageDialog(contentPane, "Success!");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Success!");

					}
				}
			});
			btnRemoveEmployee.setBounds(530, 108, 155, 42);
		}
		return btnRemoveEmployee;
	}

	private JButton getBtnUpdateEmployee() {
		if (btnUpdateEmployee == null) {
			btnUpdateEmployee = new JButton("UPDATE EMPLOYEE");
			btnUpdateEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Worker w = tableWorker();
					if (w != null) {
						EditWorker ew = new EditWorker(w, username);
						ew.setVisible(true);
					}
				}
			});
			btnUpdateEmployee.setBounds(697, 108, 155, 42);
		}
		return btnUpdateEmployee;
	}

	private JButton getBtnReturnEmployee() {
		if (btnReturnEmployee == null) {
			btnReturnEmployee = new JButton("RESTORE EMPLOYEE");
			btnReturnEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
						return;
					}
					Data.restoreWorker((int) table.getModel().getValueAt(row, 0));
					if (isAdmin(username)) {
						updateTableAadmin();
					} else {
						updateTable();
					}
					JOptionPane.showMessageDialog(contentPane, "Success!");
				}
			});
			btnReturnEmployee.setBounds(363, 108, 155, 42);
		}
		return btnReturnEmployee;
	}
}
