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
	private JButton btnBranches;

	private JLabel lblSearch;
	public String username;

	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 972, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLblSearch());

		contentPane.add(getTextField());
		contentPane.add(getBtnAddShifts());
		contentPane.add(getBtnChangeShft());
		contentPane.add(getBtnWorkers());
		contentPane.add(getBtnBranches());
	}
	public ManagerFrame(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 972, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLblSearch());

		contentPane.add(getTextField());
		contentPane.add(getBtnAddShifts());
		contentPane.add(getBtnChangeShft());
		contentPane.add(getBtnWorkers());
		contentPane.add(getBtnBranches());
	}

	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("Search:");
			lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSearch.setBounds(37, 23, 56, 16);
		}
		return lblSearch;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(105, 21, 156, 22);
		}

		return textField;
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
			btnAddShifts.setBounds(410, 13, 111, 38);
		}
		return btnAddShifts;
	}

	private JButton getBtnChangeShft() {
		if (btnChangeShft == null) {
			btnChangeShft = new JButton("Change Shift");
			btnChangeShft.setBounds(533, 13, 111, 38);
		}
		return btnChangeShft;
	}

	private JButton getBtnWorkers() {
		if (btnWorkers == null) {
			btnWorkers = new JButton("Workers");
			btnWorkers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Workers wr = new Workers(username);
					wr.setVisible(true);
				}
			});
			btnWorkers.setBounds(656, 13, 111, 38);
		}
		return btnWorkers;
	}

	private JButton getBtnBranches() {
		if (btnBranches == null) {
			btnBranches = new JButton("Branches");
			btnBranches.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Branches b = new Branches();
					b.setVisible(true);
				}
			});
			btnBranches.setBounds(779, 13, 111, 38);
		}
		return btnBranches;
	}
}
