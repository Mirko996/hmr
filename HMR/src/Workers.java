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
	private JTable table;
	Object[][] objects = null;

	private String[] columnName = { "ID", "Name", "Last name", "Email", "Password", "Active" };
	private JScrollPane scrollPane;
	private JButton btnAddEmployee;
	private JButton btnRemoveEmployee;
	private JButton btnUpdateEmployee;
	public String username;

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
		Object[][] objcts = new Object[Data.workersByBranch(Integer.parseInt(Data.getIdBranchData(username)).size()][6];
		int c = 0;
		int id = Integer.parseInt(Data.getIdBranchData(username));
		List<Worker> wrk = Data.workersByBranch(id);
		if (wrk != null) {
			for (Worker w : wrk) {
				Object[] oo = { w.getId(), w.getName(), w.getLast_name(), w.getEmail(), w.getPassword(),
						w.getActive() };
				objcts[c] = oo;
				c++;
			}
		}

		DefaultTableModel dtm = new DefaultTableModel(objcts, columnName);
		table.setModel(dtm);
		contentPane.add(getBtnAddEmployee());
		contentPane.add(getBtnRemoveEmployee());
		contentPane.add(getBtnUpdateEmployee());
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
			btnAddEmployee.setBounds(418, 108, 132, 42);
		}
		return btnAddEmployee;
	}

	private Worker tableWorker() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
			return null;
		}
		int id = (int) table.getModel().getValueAt(row, 0);
		String name = table.getModel().getValueAt(row, 1).toString();
		String last_name = table.getModel().getValueAt(row, 2).toString();
		String email = table.getModel().getValueAt(row, 3).toString();
		String password = table.getModel().getValueAt(row, 4).toString();
		String active = table.getModel().getValueAt(row, 5).toString();

		Worker w = new Worker(id, name, last_name, email, password, active);
		return w;
	}

	private JButton getBtnRemoveEmployee() {
		if (btnRemoveEmployee == null) {
			btnRemoveEmployee = new JButton("REMOVE EMPOLOYEE");
			btnRemoveEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					Data.removeWorker((int) table.getModel().getValueAt(row, 0));
				}
			});
			btnRemoveEmployee.setBounds(567, 108, 135, 42);
		}
		return btnRemoveEmployee;
	}

	private JButton getBtnUpdateEmployee() {
		if (btnUpdateEmployee == null) {
			btnUpdateEmployee = new JButton("UPDATE EMPLOYEE");
			btnUpdateEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Worker w = tableWorker();
					if(w != null) {
						EditWorker ew = new EditWorker(w);
						ew.setVisible(true);
					}
				}
			});
			btnUpdateEmployee.setBounds(722, 108, 135, 42);
		}
		return btnUpdateEmployee;
	}
}
