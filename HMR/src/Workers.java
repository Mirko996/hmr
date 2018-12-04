import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.SystemColor;

public class Workers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Object[][] objects = null;

	private String[] columnName = { "Name", "Last name", "Email", "Password" };

	public Workers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTable());
		Object[][] objcts = new Object[Data.workers().size()][4];
		int c = 0;
		List<Worker> wrk = Data.workers();
		if (wrk != null) {
			for (Worker w : wrk) {
				Object[] oo = { w.getName(), w.getLast_name(), w.getEmail(), w.getPassword() };
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
			table.setBounds(0, 134, 884, 377);
		}
		return table;
	}
}
