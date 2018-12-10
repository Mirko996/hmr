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
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class WorkersFrame extends JFrame {

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
	private JButton btnChangeEmployeesBranch;
	private JPanel panel;
	private JButton btnChange;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JLabel label;
	private String idChange;
	private String branchC;

	public WorkersFrame(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 706);
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
		contentPane.add(getBtnChangeEmployeesBranch());
		contentPane.add(getPanel());
		if (isAdmin(username)) {
			contentPane.add(getPanel());
			panel.setVisible(false);
			updateTableAadmin();
			btnAddEmployee.setVisible(false);
		} else {
			btnChangeEmployeesBranch.setVisible(false);
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
		List<Worker> wrk = (List<Worker>)Data.workers();
		if (wrk != null) {
			for (Worker w : wrk) {
				Object[] oo = { w.getId(), w.getBranchName(), w.getName(), w.getLast_name(), w.getEmail(),
						w.getPassword(), w.getActive() };
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
				Object[] oo = { w.getId(), w.getName(), w.getLast_name(), w.getEmail(), w.getPassword(), w.getActive() };
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
			scrollPane.setBounds(0, 340, 882, 319);
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
			btnAddEmployee.setBounds(12, 285, 132, 42);
		}
		return btnAddEmployee;
	}

	private Worker tableWorker() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
			return null;
		}
		int id;
		String name;
		String last_name;
		String email;
		String password;
		int active;
		if (isAdmin(username)) {
			id = (int) table.getModel().getValueAt(row, 0);
			name = table.getModel().getValueAt(row, 2).toString();
			last_name = table.getModel().getValueAt(row, 3).toString();
			email = table.getModel().getValueAt(row, 4).toString();
			password = table.getModel().getValueAt(row, 5).toString();
			active = (int) table.getModel().getValueAt(row, 6);
		} else {
			id = (int) table.getModel().getValueAt(row, 0);
			name = table.getModel().getValueAt(row, 1).toString();
			last_name = table.getModel().getValueAt(row, 2).toString();
			email = table.getModel().getValueAt(row, 3).toString();
			password = table.getModel().getValueAt(row, 4).toString();
			 active = (int) table.getModel().getValueAt(row, 5);


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
						Data.removeWorkerNew((int) table.getModel().getValueAt(row, 0));
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
			btnRemoveEmployee.setBounds(490, 285, 155, 42);
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
			btnUpdateEmployee.setBounds(156, 283, 155, 42);
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
					Data.restoreWorkerNew((int) table.getModel().getValueAt(row, 0));
					if (isAdmin(username)) {
						updateTableAadmin();
					} else {
						updateTable();
					}
					JOptionPane.showMessageDialog(contentPane, "Success!");
				}
			});
			btnReturnEmployee.setBounds(323, 285, 155, 42);
		}
		return btnReturnEmployee;
	}

	private JButton getBtnChangeEmployeesBranch() {
		if (btnChangeEmployeesBranch == null) {
			btnChangeEmployeesBranch = new JButton("CHANGE EMPLOYEES BRANCH");
			btnChangeEmployeesBranch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int row = table.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
						return;
					}

					String nameB = table.getModel().getValueAt(row, 1) + "";
					idChange = table.getModel().getValueAt(row, 0) + "";
					label.setText(nameB);
					branchC = (table.getModel().getValueAt(row, 2) + " " + table.getModel().getValueAt(row, 3));
					lblNewLabel.setText(branchC);
					panel.setVisible(true);
					List<Branch> branchChange = Data.branches();
					int i = 0;
					for (Branch branch : branchChange) {
						if (!branch.getName().equals(nameB)) {
							comboBox.insertItemAt(branch.getId() + "-" + branch.getName(), i);
							i++;
						}
					}

				}
			});
			btnChangeEmployeesBranch.setBounds(657, 285, 215, 42);
		}
		return btnChangeEmployeesBranch;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBackground(SystemColor.activeCaption);
			panel.setBounds(550, 13, 320, 248);
			panel.setLayout(null);
			panel.add(getBtnChange());
			panel.add(getComboBox());
			panel.add(getLblNewLabel());
			panel.add(getLabel());
		}
		return panel;
	}

	private JButton getBtnChange() {
		if (btnChange == null) {
			btnChange = new JButton("CHANGE");
			btnChange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if(comboBox.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(contentPane, "You have to choose branch first!");
						return;
					}
					String branch = comboBox.getSelectedItem() + "";
					int branchId = Integer.parseInt(comboBox.getSelectedItem().toString().split("-")[0]);
					
					if(Data.updateWorkersBranchNew(Integer.parseInt(idChange), branchId)) {
						JOptionPane.showMessageDialog(contentPane, "Success!");
						updateTableAadmin();
						return;
					}
					JOptionPane.showMessageDialog(contentPane, "Something went wrong!");

				}
			});
			btnChange.setBounds(111, 189, 127, 46);
		}
		return btnChange;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(52, 116, 212, 22);
		}
		return comboBox;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel.setBounds(52, 57, 230, 46);
		}
		return lblNewLabel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("New label");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.PLAIN, 17));
			label.setBounds(52, 13, 230, 46);
		}
		return label;
	}
}
