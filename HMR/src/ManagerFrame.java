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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAddShifts;
	private JButton btnChangeShft;
	private JButton btnWorkers;
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
		
		
		textField = new JTextField();
		textField.setBounds(105, 21, 156, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(getBtnAddShifts());
		contentPane.add(getBtnChangeShft());
		contentPane.add(getBtnWorkers());
	}
	
	public void dataImport() {
		
	}
	private JButton getBtnAddShifts() {
		if (btnAddShifts == null) {
			btnAddShifts = new JButton("Add shifts");
			btnAddShifts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddShiftFrame a = new AddShiftFrame();
					a.setVisible(true);
				}
			});
			btnAddShifts.setBounds(440, 14, 111, 38);
		}
		return btnAddShifts;
	}
	private JButton getBtnChangeShft() {
		if (btnChangeShft == null) {
			btnChangeShft = new JButton("Change Shift");
			btnChangeShft.setBounds(561, 13, 111, 38);
		}
		return btnChangeShft;
	}
	private JButton getBtnWorkers() {
		if (btnWorkers == null) {
			btnWorkers = new JButton("Workers");
			btnWorkers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Workers wr = new Workers();
					wr.setVisible(true);
				}
			});
			btnWorkers.setBounds(693, 14, 111, 38);
		}
		return btnWorkers;
	}
}
