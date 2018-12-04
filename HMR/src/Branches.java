import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

public class Branches extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Object[][] objects = null;
	private String[] columnName = { "ID", "Address", "City", "Name", "Email", "Password", "Active" };

	/**
	 * Create the frame.
	 */
	public Branches() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTable());

		Object[][] objects = new Object[Data.branches().size()][7];

		List<Branch> branches = Data.branches();
		int num = 0;
		if (branches != null) {
			for (Branch b : branches) {
				Object[] branch = {b.getId(), b.getAddres(), b.getEmail(), b.getName(), b.getPassword(),
						b.isActive()};
				objects[num] = branch;
				num++;
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(objects,columnName);
		table.setModel(dtm);
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(0, 126, 884, 377);
		}
		return table;
	}
}
