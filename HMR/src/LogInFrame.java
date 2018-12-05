import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public LogInFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 380, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(82, 92, 86, 29);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(82, 127, 86, 29);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(180, 97, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10); 

		textField_1 = new JTextField();
		textField_1.setBounds(180, 132, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Data.logIn(textField_1.getText().toString(), textField.getText().toString())) {
					dispose();
					ManagerFrame mf = new ManagerFrame(textField.getText().toString());
					mf.setVisible(true);
				}
			}
		});
		btnLogIn.setBounds(130, 210, 116, 38);
		contentPane.add(btnLogIn);
	}

}
