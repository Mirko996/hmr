import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

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

	/**
	 * Create the frame.
	 */
	public EditBranch(Branch b) {
		this.b = b;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 495, 351);
		txt = new JPanel();
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
		fill();
	}

	private void fill() {
		txtName.setText(b.getName());
		txtEmail.setText(b.getEmail());
		txtAddress.setText(b.getAddres());
		txtCity.setText(b.getCity());
		txtPassword.setText(b.getPassword());
		txtPasswordConfirm .setText(b.getPassword());
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
			lblEmail.setBounds(35, 69, 46, 14);
		}
		return lblEmail;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setBounds(35, 105, 46, 14);
		}
		return lblAddress;
	}

	private JLabel getLblCity() {
		if (lblCity == null) {
			lblCity = new JLabel("City:");
			lblCity.setBounds(35, 144, 46, 14);
		}
		return lblCity;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(35, 186, 65, 14);
		}
		return lblPassword;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(95, 29, 170, 20);
			txtName.setColumns(10);
		}
		return txtName;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(91, 66, 170, 20);
		}
		return txtEmail;
	}

	private JTextField getTxtAddress() {
		if (txtAddress == null) {
			txtAddress = new JTextField();
			txtAddress.setColumns(10);
			txtAddress.setBounds(91, 102, 170, 20);
		}
		return txtAddress;
	}

	private JTextField getTxtCity() {
		if (txtCity == null) {
			txtCity = new JTextField();
			txtCity.setColumns(10);
			txtCity.setBounds(95, 141, 170, 20);
		}
		return txtCity;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(95, 183, 170, 20);
		}
		return txtPassword;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Password:");
			label.setBounds(35, 230, 65, 14);
		}
		return label;
	}

	private JPasswordField getTxtPasswordConfirm() {
		if (txtPasswordConfirm == null) {
			txtPasswordConfirm = new JPasswordField();
			txtPasswordConfirm.setBounds(95, 224, 170, 20);
		}
		return txtPasswordConfirm;
	}

	private JButton getBtEdit() {
		if (btEdit == null) {
			btEdit = new JButton("EDIT");
			btEdit.setBounds(199, 255, 89, 46);
		}
		return btEdit;
	}
}
