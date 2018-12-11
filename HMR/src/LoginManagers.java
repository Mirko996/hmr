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
import java.awt.event.ActionEvent;

public class LoginManagers extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JButton btnLogIn;
	private String emailBranch;
	private JFrame frame;

	public LoginManagers(String email) {
		frame = this;
		this.emailBranch = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTxtEmail());
		contentPane.add(getLblEmail());
		contentPane.add(getLblPassword());
		contentPane.add(getTxtPassword());
		contentPane.add(getBtnLogIn());
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setBounds(134, 50, 197, 20);
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(78, 53, 46, 14);
		}
		return lblEmail;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(75, 101, 62, 14);
		}
		return lblPassword;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(134, 98, 197, 20);
		}
		return txtPassword;
	}

	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log in");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Data.logInManager(txtEmail.getText(), txtPassword.getText(), emailBranch)) {
						ManagerFrame mf = new ManagerFrame(txtEmail.getText(), emailBranch);
						mf.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(frame, "Email or password invalid!", "Warning", JOptionPane.WARNING_MESSAGE);
						
					}

				}
			});
			btnLogIn.setBounds(168, 164, 124, 40);
		}
		return btnLogIn;
	}
}
