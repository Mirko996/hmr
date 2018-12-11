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
import java.util.concurrent.BrokenBarrierException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAddShifts;
	private JButton btnChangeShft;
	private JButton btnWorkers;
	private JButton btnBranches;
	private JLabel lblSearch;
	public static String EMAIL;
	public static String ADMIN_EMAIL = "admin@synergysuite.com";
	private JButton btnLogout;
	private JPanel panel;
	private JTextField txtIdWorker;
	private JButton btnClockIn;
	private JButton btnClockOut;
	private JLabel lblNewLabel;

	public ManagerFrame(String email) {
		this.EMAIL = email;
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
		contentPane.add(getBtnLogout());
		contentPane.add(getPanel());
		if (!email.equals(ADMIN_EMAIL)) {
			btnBranches.setVisible(false);
		}
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
					AddShifts a = new AddShifts(EMAIL);
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
			btnChangeShft.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnChangeShft.setBounds(533, 13, 111, 38);
		}
		return btnChangeShft;
	}

	private JButton getBtnWorkers() {
		if (btnWorkers == null) {
			btnWorkers = new JButton("Workers");
			btnWorkers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					WorkersFrame wr = new WorkersFrame(EMAIL);
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
					BranchesFrame b = new BranchesFrame(EMAIL);
					b.setVisible(true);
				}
			});
			btnBranches.setBounds(779, 13, 111, 38);
		}
		return btnBranches;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					EMAIL = null;
					LogInFrame lf = new LogInFrame();
					lf.setVisible(true);
				}
			});
			btnLogout.setBounds(779, 86, 111, 38);
		}
		return btnLogout;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(SystemColor.activeCaption);
			panel.setBounds(73, 125, 294, 134);
			panel.setLayout(null);
			panel.add(getTxtIdWorker());
			panel.add(getBtnClockIn());
			panel.add(getBtnClockOut());
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JTextField getTxtIdWorker() {
		if (txtIdWorker == null) {
			txtIdWorker = new JTextField();
			txtIdWorker.setBounds(95, 48, 86, 20);
			txtIdWorker.setColumns(10);
		}
		return txtIdWorker;
	}
	private JButton getBtnClockIn() {
		if (btnClockIn == null) {
			btnClockIn = new JButton("Clock in");
			btnClockIn.setBackground(Color.GREEN);
			btnClockIn.setBounds(34, 79, 95, 30);
		}
		return btnClockIn;
	}
	private JButton getBtnClockOut() {
		if (btnClockOut == null) {
			btnClockOut = new JButton("Clock out");
			btnClockOut.setBackground(Color.RED);
			btnClockOut.setBounds(152, 79, 95, 30);
		}
		return btnClockOut;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID for Clock in/Clock out");
			lblNewLabel.setBounds(77, 23, 163, 14);
		}
		return lblNewLabel;
	}
}
