import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.KeyStore.PasswordProtection;
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
	private JButton button;
	private Worker w;

	/**
	 * Launch the application.
	 */
	public EditWorker(Worker w) {
		this.w = w;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 495, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
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
			panel.add(getButton());
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
	private JButton getButton() {
		if (button == null) {
			button = new JButton("ADD");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			button.setBounds(179, 251, 147, 49);
		}
		return button;
	}
}