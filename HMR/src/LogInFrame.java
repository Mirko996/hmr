import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static SessionFactory factory;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					LogInFrame frame = new LogInFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try{
					
					factory = new Configuration().configure().
							addAnnotatedClass(Branch.class).
							addAnnotatedClass(Worker.class).
							buildSessionFactory();
					
					
				}catch(HibernateException ex) {
					ex.printStackTrace();
				}
			}
		});
	}

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

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(82, 92, 86, 29);
		contentPane.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(82, 127, 86, 29);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(180, 97, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10); 

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Data.logIn(passwordField.getText().toString(), textField.getText().toString())) {
					dispose();
					ManagerFrame mf = new ManagerFrame(textField.getText().toString());
					mf.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(contentPane, "Username or password are invalid:");
					passwordField.setText("");
				}
			}
		});
		btnLogIn.setBounds(130, 210, 116, 38);
		contentPane.add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 132, 116, 22);
		contentPane.add(passwordField);
	}
}
