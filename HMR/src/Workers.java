import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
<<<<<<< HEAD
import javax.swing.JScrollPane;
=======
import java.awt.SystemColor;
>>>>>>> ac111e989c6d644e253ebb6a303d1160bdc2562f

public class Workers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Object[][] objects = null;

	private String[] columnName = { "Name", "Last name", "Email", "Password" };
	private JScrollPane scrollPane;

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
}
