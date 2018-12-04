import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class Workers extends JFrame {

	private JPanel contentPane;
	private JTable table;

		
	public Workers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTable());
		
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(0, 134, 884, 377);
		}
		return table;
	}
}
