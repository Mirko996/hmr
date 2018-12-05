import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmployeeName;
	private JLabel lblEmployeeName;
	private JLabel lblEmployeeSurname;
	private JTextField txtEmployeeSurname;
	private JLabel lblEmail;
	private JTextField txtEmployeeEmail;
	private JLabel lblPassword;
	private JPasswordField txtEmployeePassword;
	private JLabel lblConfirmPassword;
	private JPasswordField txtEmployeeConfirmPassword;
	private JButton btnEmployeeAdd;
	private JFrame frame;
	public String username;

	/**
	 * Create the frame.
	 */
	public AddEmployee(String username) {
		this.username = username;
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 496, 350);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame = this;
		contentPane.add(getTxtEmployeeName());
		contentPane.add(getLblEmployeeName());
		contentPane.add(getLblEmployeeSurname());
		contentPane.add(getTxtEmployeeSurname());
		contentPane.add(getLblEmail());
		contentPane.add(getTxtEmployeeEmail());
		contentPane.add(getLblPassword());
		contentPane.add(getTxtEmployeePassword());
		contentPane.add(getLblConfirmPassword());
		contentPane.add(getTxtEmployeeConfirmPassword());
		contentPane.add(getBtnEmployeeAdd());
	}
	

	private JTextField getTxtEmployeeName() {
		if (txtEmployeeName == null) {
			txtEmployeeName = new JTextField();
			txtEmployeeName.setBounds(158, 38, 203, 20);
			txtEmployeeName.setColumns(10);
		}
		return txtEmployeeName;
	}

	private JLabel getLblEmployeeName() {
		if (lblEmployeeName == null) {
			lblEmployeeName = new JLabel("Name:");
			lblEmployeeName.setBounds(36, 41, 112, 14);
		}
		return lblEmployeeName;
	}

	private JLabel getLblEmployeeSurname() {
		if (lblEmployeeSurname == null) {
			lblEmployeeSurname = new JLabel("Last name");
			lblEmployeeSurname.setBounds(36, 79, 112, 14);
		}
		return lblEmployeeSurname;
	}

	private JTextField getTxtEmployeeSurname() {
		if (txtEmployeeSurname == null) {
			txtEmployeeSurname = new JTextField();
			txtEmployeeSurname.setColumns(10);
			txtEmployeeSurname.setBounds(158, 76, 203, 20);
		}
		return txtEmployeeSurname;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(36, 117, 112, 14);
		}
		return lblEmail;
	}

	private JTextField getTxtEmployeeEmail() {
		if (txtEmployeeEmail == null) {
			txtEmployeeEmail = new JTextField();
			txtEmployeeEmail.setColumns(10);
			txtEmployeeEmail.setBounds(158, 114, 203, 20);
		}
		return txtEmployeeEmail;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(36, 159, 112, 14);
		}
		return lblPassword;
	}

	private JPasswordField getTxtEmployeePassword() {
		if (txtEmployeePassword == null) {
			txtEmployeePassword = new JPasswordField();
			txtEmployeePassword.setBounds(158, 156, 203, 20);
		}
		return txtEmployeePassword;
	}

	private JLabel getLblConfirmPassword() {
		if (lblConfirmPassword == null) {
			lblConfirmPassword = new JLabel("Password:");
			lblConfirmPassword.setBounds(36, 194, 112, 14);
		}
		return lblConfirmPassword;
	}

	private JPasswordField getTxtEmployeeConfirmPassword() {
		if (txtEmployeeConfirmPassword == null) {
			txtEmployeeConfirmPassword = new JPasswordField();
			txtEmployeeConfirmPassword.setBounds(158, 191, 203, 20);
		}
		return txtEmployeeConfirmPassword;
	}
	
	public boolean validateAdding() {
		if (getTxtEmployeeName().getText().trim().equals("")){
			JOptionPane.showMessageDialog(frame, "Field Name can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTxtEmployeeSurname().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(frame, "Field Last name can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTxtEmployeeEmail().getText().trim().equals("")) {
			
			JOptionPane.showMessageDialog(frame, "Field Email can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTxtEmployeePassword().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(frame, "Field Password can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (!(getTxtEmployeeConfirmPassword().getText().trim().equals(getTxtEmployeePassword().getText().trim()))) {
			JOptionPane.showMessageDialog(frame, "Password doesn't match!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
	
	public void clearForm() {
		getTxtEmployeeName().setText("");
		getTxtEmployeeSurname().setText("");
		getTxtEmployeeEmail().setText("");
		getTxtEmployeePassword().setText("");
		getTxtEmployeeConfirmPassword().setText("");
	}
	private JButton getBtnEmployeeAdd() {
		if (btnEmployeeAdd == null) {
			btnEmployeeAdd = new JButton("ADD");
			btnEmployeeAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(validateAdding()) {
						Worker w  = new Worker(txtEmployeeName.getText().trim(), txtEmployeeSurname.getText().trim(),txtEmployeeEmail.getText().trim(),txtEmployeePassword.getText().trim());
						String branchId = Data.getIdBranchData(username);
						
						if(Data.insertEmloyeeData(w, branchId)) {
							JOptionPane.showMessageDialog(frame, "Successfully added", "Success", JOptionPane.OK_OPTION);
							clearForm();
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(frame, "Didn't insert", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
//						JOptionPane.showMessageDialog(frame, "Sucessfully added", "Success", JOptionPane.YES_OPTION);
					}
				}

			});
			btnEmployeeAdd.setBounds(179, 251, 147, 49);
		}
		return btnEmployeeAdd;
	}
}
