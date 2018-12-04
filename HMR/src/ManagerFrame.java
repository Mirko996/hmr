import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setBounds(37, 23, 56, 16);
		contentPane.add(lblSearch);
		
		table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 88, 954, 576);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("Add Shifts");
		btnNewButton_1.setBounds(443, 13, 111, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Shift");
		btnNewButton_2.setBounds(566, 13, 111, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnAddWorker = new JButton("Add worker");
		btnAddWorker.setBounds(689, 13, 111, 38);
		contentPane.add(btnAddWorker);
		
		JButton btnRemoveWorker = new JButton("Remove worker");
		btnRemoveWorker.setBounds(812, 13, 130, 38);
		contentPane.add(btnRemoveWorker);
		
		textField = new JTextField();
		textField.setBounds(105, 21, 156, 22);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	public void dataImport() {
		
	}

}
