import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.JobAttributes;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.SystemColor;


public class EditBranch extends JFrame {

	private JPanel txt;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblPassword;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JPasswordField txtPassword;
	private JLabel label;
	private JPasswordField txtPasswordConfirm;
	private JButton btEdit;
	private Branch b;
	private JTextField txtIdNotVisible;
	private String[] columnName = { "ID", "Address", "City", "Email", "Name", "Password", "Active" };
	private JFrame frame;
	/**
	 * Create the frame.
	 */
	public EditBranch(Branch b) {
		this.b = b;
		frame = this;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 431, 363);
		txt = new JPanel();
		txt.setBackground(SystemColor.activeCaption);
		txt.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txt);
		txt.setLayout(null);
		txt.add(getLblName());
		txt.add(getLblEmail());
		txt.add(getLblAddress());
		txt.add(getLblCity());
		txt.add(getLblPassword());
		txt.add(getTxtName());
		txt.add(getTxtEmail());
		txt.add(getTxtAddress());
		txt.add(getTxtCity());
		txt.add(getTxtPassword());
		txt.add(getLabel());
		txt.add(getTxtPasswordConfirm());
		txt.add(getBtEdit());
		txt.add(getTxtIdNotVisible());
		fill();
	}

	public boolean validateAdding() {
		if (getTxtName().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Field Name can't be empty!", "WARNIRG", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTxtAddress().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Field Address name can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTxtCity().getText().trim().equals("")) {

			JOptionPane.showMessageDialog(this, "Field City can't be empty!", "WARNIRG", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTxtEmail().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Field Email can't be empty!", "WARNIRG", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (getTxtPassword().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Field Password can't be empty!", "WARNIRG",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (!(getTxtPassword().getText().trim().equals(getTxtPasswordConfirm().getText().trim()))) {
			JOptionPane.showMessageDialog(this, "Password doesn't match!", "WARNIRG", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private void fill() {
		txtIdNotVisible.setText(b.getId() + "");
		txtName.setText(b.getName());
		txtEmail.setText(b.getEmail());
		txtAddress.setText(b.getAddres());
		txtCity.setText(b.getCity());
		txtPassword.setText(b.getPassword());
		txtPasswordConfirm.setText(b.getPassword());

	}

	public void updateTable() {
		Object[][] objects = new Object[Data.branches().size()][7];

		List<Branch> branches = Data.branches();
		int num = 0;
		if (branches != null) {
			for (Branch b : branches) {
				Object[] branch = { b.getId(), b.getAddres(), b.getCity(), b.getEmail(), b.getName(), b.getPassword(),
						b.getActive() };
				objects[num] = branch;
				num++;
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(objects, columnName);
		BranchesFrame.table.setModel(dtm);
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name: ");
			lblName.setBounds(35, 32, 46, 14);
		}
		return lblName;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(35, 92, 46, 14);
		}
		return lblEmail;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setBounds(35, 129, 51, 14);
		}
		return lblAddress;
	}

	private JLabel getLblCity() {
		if (lblCity == null) {
			lblCity = new JLabel("City:");
			lblCity.setBounds(35, 65, 46, 14);
		}
		return lblCity;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(35, 163, 65, 14);
		}
		return lblPassword;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(127, 29, 170, 20);
			txtName.setColumns(10);
		}
		return txtName;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(127, 89, 170, 20);
		}
		return txtEmail;
	}

	private JTextField getTxtAddress() {
		if (txtAddress == null) {
			txtAddress = new JTextField();
			txtAddress.setColumns(10);
			txtAddress.setBounds(127, 126, 170, 20);
		}
		return txtAddress;
	}

	private JTextField getTxtCity() {
		if (txtCity == null) {
			txtCity = new JTextField();
			txtCity.setColumns(10);
			txtCity.setBounds(127, 62, 170, 20);
		}
		return txtCity;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(127, 160, 170, 20);
		}
		return txtPassword;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Password:");
			label.setBounds(35, 190, 65, 14);
		}
		return label;
	}

	private JPasswordField getTxtPasswordConfirm() {
		if (txtPasswordConfirm == null) {
			txtPasswordConfirm = new JPasswordField();
			txtPasswordConfirm.setBounds(127, 187, 170, 20);
		}
		return txtPasswordConfirm;
	}

	private JButton getBtEdit() {
		if (btEdit == null) {
			btEdit = new JButton("EDIT");
			btEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (validateAdding()) {				
							Branch b1 = new Branch(b.getId(), getTxtAddress().getText(), getTxtCity().getText(), getTxtEmail().getText(), getTxtName().getText(), getTxtPassword().getText(),1);
							if(Data.editBranchNew(b1)) {
								JOptionPane.showMessageDialog(frame, "Success!", "DONE",
										JOptionPane.INFORMATION_MESSAGE);
								updateTable();
								dispose();
							}else {
						
							JOptionPane.showMessageDialog(frame, "Something went wrong!", "WARNIRG",
									JOptionPane.WARNING_MESSAGE);		
							}
					}

				}
			});
			btEdit.setBounds(155, 242, 89, 46);
			}
		return btEdit;
	}

	private JTextField getTxtIdNotVisible() {
		if (txtIdNotVisible == null) {
			txtIdNotVisible = new JTextField();
			txtIdNotVisible.setVisible(false);
			txtIdNotVisible.setBounds(362, 29, 86, 20);
			txtIdNotVisible.setColumns(10);
		}
		return txtIdNotVisible;
	}
}
