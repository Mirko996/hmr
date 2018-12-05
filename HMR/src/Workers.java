import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
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

	private String[] columnName = { "Name", "Last name", "Email", "Password", "Active" };
	private JScrollPane scrollPane;
	private JButton btnAddEmployee;
	private JButton btnRemoveEmployee;
	private JButton btnUpdateEmployee;

	public Workers() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.add(getTable());
		contentPane.add(getScrollPane());
		Object[][] objcts = new Object[Data.workers().size()][5];
		int c = 0;
		List<Worker> wrk = Data.workers();
		if (wrk != null) {
			for (Worker w : wrk) {
				Object[] oo = { w.getName(), w.getLast_name(), w.getEmail(), w.getPassword() ,w.getActive()};
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
				}
			});
			btnAddEmployee.setBounds(418, 108, 132, 42);
		}
		return btnAddEmployee;
	}
	private JButton getBtnRemoveEmployee() {
		if (btnRemoveEmployee == null) {
			btnRemoveEmployee = new JButton("REMOVE EMPOLOYEE");
			btnRemoveEmployee.setBounds(567, 108, 135, 42);
		}
		return btnRemoveEmployee;
	}
	private JButton getBtnUpdateEmployee() {
		if (btnUpdateEmployee == null) {
			btnUpdateEmployee = new JButton("UPDATE EMPLOYEE");
			btnUpdateEmployee.setBounds(722, 108, 135, 42);
		}
		return btnUpdateEmployee;
	}
}
