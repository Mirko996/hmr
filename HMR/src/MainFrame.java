import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 711);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(104, 36, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setBounds(36, 38, 56, 16);
		contentPane.add(lblSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 88, 954, 576);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(834, 13, 108, 35);
		contentPane.add(btnNewButton);
	}
}
