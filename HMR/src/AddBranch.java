import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBranch extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textName;
	private JLabel label;
	private JLabel lblCity;
	private JTextField textCity;
	private JLabel label_2;
	private JTextField textEmail;
	private JLabel label_3;
	private JPasswordField passwordField;
	private JLabel label_4;
	private JPasswordField passwordField_1;
	private JButton button;
	private JTextField textAdress;
	private JLabel lblAddress;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBranch frame = new AddBranch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddBranch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 352);
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
			panel.add(getTextName());
			panel.add(getLabel());
			panel.add(getLblCity());
			panel.add(getTextCity());
			panel.add(getLabel_2());
			panel.add(getTextEmail());
			panel.add(getLabel_3());
			panel.add(getPasswordField());
			panel.add(getLabel_4());
			panel.add(getPasswordField_1());
			panel.add(getButton());
			panel.add(getTextAdress());
			panel.add(getLblAddress());
		}
		return panel;
	}
	private JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setColumns(10);
			textName.setBounds(158, 57, 203, 20);
		}
		return textName;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Name:");
			label.setBounds(34, 60, 112, 14);
		}
		return label;
	}
	private JLabel getLblCity() {
		if (lblCity == null) {
			lblCity = new JLabel("City:");
			lblCity.setBounds(34, 93, 112, 14);
		}
		return lblCity;
	}
	private JTextField getTextCity() {
		if (textCity == null) {
			textCity = new JTextField();
			textCity.setColumns(10);
			textCity.setBounds(158, 90, 203, 20);
		}
		return textCity;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Email:");
			label_2.setBounds(34, 126, 112, 14);
		}
		return label_2;
	}
	private JTextField getTextEmail() {
		if (textEmail == null) {
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(158, 123, 203, 20);
		}
		return textEmail;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Password:");
			label_3.setBounds(34, 159, 112, 14);
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
			label_4.setBounds(34, 194, 112, 14);
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
	
	private boolean validation() {
	
			if (textName.getText().trim().equals("")){
				JOptionPane.showMessageDialog(frame, "Field Name can't be empty!", "WARNIRG",
						JOptionPane.WARNING_MESSAGE);
				return false;
			} else if (getTextCity().getText().trim().equals("")) {
				JOptionPane.showMessageDialog(frame, "Field City name can't be empty!", "WARNIRG",
						JOptionPane.WARNING_MESSAGE);
				return false;
			} else if (getTextEmail().getText().trim().equals("")) {
				
				JOptionPane.showMessageDialog(frame, "Field Email can't be empty!", "WARNIRG",
						JOptionPane.WARNING_MESSAGE);
				return false;
			} else if (getTextAdress().getText().trim().equals("")) {
				
				JOptionPane.showMessageDialog(frame, "Field Addres can't be empty!", "WARNIRG",
						JOptionPane.WARNING_MESSAGE);
				return false;
			} else if (getPasswordField().getText().trim().equals("")) {
				JOptionPane.showMessageDialog(frame, "Field Password can't be empty!", "WARNIRG",
						JOptionPane.WARNING_MESSAGE);
				return false;
			} else if (!(getPasswordField().getText().trim().equals(getPasswordField_1().getText().trim()))) {
				JOptionPane.showMessageDialog(frame, "Password doesn't match!", "WARNIRG",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}else {
				return true;
			
		}
		
	
	}
	
	private JButton getButton() {
		if (button == null) {
			button = new JButton("ADD");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validation()) {
						Branch b = new Branch(getTextAdress().getText(), getTextCity().getText(),getTextEmail().getText(), getTextName().getText(), getPasswordField().getText());
						if(Data.InsertBranch(b)) {
							JOptionPane.showMessageDialog(frame, "Success!", "DONE",
									JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(frame, "Something went wrong!", "WARNIRG",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			});
			button.setBounds(145, 241, 147, 49);
		}
		return button;
	}
	private JTextField getTextAdress() {
		if (textAdress == null) {
			textAdress = new JTextField();
			textAdress.setColumns(10);
			textAdress.setBounds(158, 24, 203, 20);
		}
		return textAdress;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setBounds(34, 27, 112, 14);
		}
		return lblAddress;
	}
}
