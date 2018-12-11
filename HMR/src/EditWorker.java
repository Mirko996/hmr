import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.KeyStore.PasswordProtection;
import java.util.List;
import java.awt.event.ActionEvent;

public class EditWorker extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JLabel label_3;
	private JPasswordField passwordField;
	private JLabel label_4;
	private JPasswordField passwordField_1;
	private JButton btnUpdate;
	private Worker w;
	private static String EMAIL;
	private String[] columnName = { "ID", "Name", "Last name", "Email", "Password", "Active" };
	private String branchName;

	/**
	 * Launch the application.
	 */
	public EditWorker(Worker w, String email,String branchName) {
		this.branchName = branchName;
		this.EMAIL = email;
		this.w = w;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 495, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}

	public boolean validateAdding() {
		if (getTextField().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Field Name can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTextField_1().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Field Last name can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTextField_2().getText().trim().equals("")) {

			JOptionPane.showMessageDialog(contentPane, "Field Email can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getPasswordField().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Field Password can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (!(getPasswordField().getText().trim().equals(getPasswordField_1().getText().trim()))) {
			JOptionPane.showMessageDialog(contentPane, "Password doesn't match!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBackground(SystemColor.activeCaption);
			panel.setBounds(0, 0, 478, 303);
			panel.add(getTextField());
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getTextField_1());
			panel.add(getLabel_2());
			panel.add(getTextField_2());
			panel.add(getLabel_3());
			panel.add(getPasswordField());
			panel.add(getLabel_4());
			panel.add(getPasswordField_1());
			panel.add(getBtnUpdate());
			fill();
		}
		return panel;
	}

	private void fill() {
		textField.setText(w.getName());
		textField_1.setText(w.getLast_name());
		textField_2.setText(w.getEmail());
		passwordField.setText(w.getPassword());
		passwordField_1.setText(w.getPassword());
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(158, 38, 203, 20);
			textField.setEnabled(true);
		}
		return textField;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Name:");
			label.setBounds(36, 41, 112, 14);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Last name");
			label_1.setBounds(36, 79, 112, 14);
		}
		return label_1;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(158, 76, 203, 20);
		}
		return textField_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Email:");
			label_2.setBounds(36, 117, 112, 14);
		}
		return label_2;
	}

	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(158, 114, 203, 20);
		}
		return textField_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Password:");
			label_3.setBounds(36, 159, 112, 14);
		}
		return label_3;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(158, 156, 203, 20);
		}
		return passwordField;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Password:");
			label_4.setBounds(36, 194, 112, 14);
		}
		return label_4;
	}

	private JPasswordField getPasswordField_1() {
		if (passwordField_1 == null) {
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(158, 191, 203, 20);
		}
		return passwordField_1;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("UPDATE");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (validateAdding()) {
						int branchId = Data.getIdBranchDataByName(branchName);
						Worker w1 = new Worker(w.getId(),branchId, getTextField().getText().trim(),
								getTextField_1().getText().trim(), getTextField_2().getText().trim(),
								getPasswordField().getText().trim(), w.getActive());
							
						if (Data.editWorkerNew(w1)) {
							if (WorkersFrame.isAdmin(EMAIL)) {
								WorkersFrame.updateTableAadmin();
							} else {
								WorkersFrame.updateTable();
							}
							dispose();
							JOptionPane.showMessageDialog(contentPane, "Success!", "WARNIRG",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(contentPane, "Something went wrong!", "WARNIRG",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			});
			btnUpdate.setBounds(179, 243, 147, 49);
		}
		return btnUpdate;
	}


//	public void updateTable() {
//		Object[][] objcts = new Object[Data.workersByBranch(Data.getIdBranchData(username)).size()][6];
//		int c = 0;
//		int id = Data.getIdBranchData(username);
//		List<Worker> wrk = Data.workersByBranch(id);
//		if (wrk != null) {
//			for (Worker w : wrk) {
//				Object[] oo = { w.getId(), w.getName(), w.getLast_name(), w.getEmail(), w.getPassword(), w.isActive() };
//				objcts[c] = oo;
//				c++;
//			}
//		}
//		DefaultTableModel dtm = new DefaultTableModel(objcts, columnName);
//		Workers.table.setModel(dtm);
//	}
}
