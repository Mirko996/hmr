import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

//not implemented yet
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnClockIn;
	private JButton btnClockOut;
	static SessionFactory factory;
	private JTextField txtIdWorker;
	private JLabel lblNewLabel;
	private JFrame frame;
	private String email;

	
	public MainFrame(String email) {
		frame = this;
		this.email = email;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 337, 243);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLogIn = new JButton("Administration");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginManagers lm = new LoginManagers(email);
				lm.setVisible(true);
			}
		});
		btnLogIn.setBounds(207, 158, 108, 35);
		contentPane.add(btnLogIn);
		contentPane.add(getBtnClockIn());
		contentPane.add(getBtnClockOut());
		contentPane.add(getTxtIdWorker());
		contentPane.add(getLblNewLabel());
	}

	private JButton getBtnClockIn() {
		if (btnClockIn == null) {
			btnClockIn = new JButton("Clock in");
			btnClockIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnClockIn.setBackground(new Color(0, 255, 0));
			btnClockIn.setBounds(63, 79, 88, 35);
		}
		return btnClockIn;
	}

	private JButton getBtnClockOut() {
		if (btnClockOut == null) {
			btnClockOut = new JButton("Clock out");
			btnClockOut.setBackground(new Color(255, 0, 0));
			btnClockOut.setBounds(161, 79, 88, 35);
		}
		return btnClockOut;
	}

	private JTextField getTxtIdWorker() {
		if (txtIdWorker == null) {
			txtIdWorker = new JTextField();
			txtIdWorker.setBounds(115, 38, 86, 20);
			txtIdWorker.setColumns(10);
			txtIdWorker.setToolTipText("Enter ID");
		}
		return txtIdWorker;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID for Clock in/Clock out");
			lblNewLabel.setBounds(105, 11, 129, 14);
		}
		return lblNewLabel;
	}
}
