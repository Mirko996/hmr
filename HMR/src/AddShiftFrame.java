import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;

public class AddShiftFrame extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JCalendar calendar;
	private JLabel lblChooseADate;
	private Label label;
	private JComboBox comboBox;
	private Label label_1;
	private JComboBox comboBox_1;
	private JButton btnInsert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddShiftFrame frame = new AddShiftFrame();
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
	public AddShiftFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 512, 620);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getCalendar());
		contentPane.add(getLblChooseADate());
		contentPane.add(getLabel());
		contentPane.add(getComboBox());
		contentPane.add(getLabel_1());
		contentPane.add(getComboBox_1());
		contentPane.add(getBtnInsert());
	}

	private JDateChooser getDateChooserPocetak() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("yyyy-MM-dd");
			dateChooser.getCalendarButton().setEnabled(false);
			dateChooser.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			dateChooser.setBounds(304, 40, 113, 20);
		}
		return dateChooser;
	}

	private JCalendar getCalendar() {
		if (calendar == null) {
			calendar = new JCalendar();
			calendar.setBounds(76, 79, 337, 241);
		}
		return calendar;
	}

	private JLabel getLblChooseADate() {
		if (lblChooseADate == null) {
			lblChooseADate = new JLabel("Choose a date:");
			lblChooseADate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblChooseADate.setBounds(12, 38, 121, 28);
		}
		return lblChooseADate;
	}

	private Label getLabel() {
		if (label == null) {
			label = new Label("Choose employee:");
			label.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label.setBounds(12, 348, 150, 24);
		}
		return label;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(181, 350, 181, 22);
			comboBox.addItem("Choose");
			List<Worker> workers = Data.workers();
			if (workers != null) {
				for (Worker w : workers) {
					comboBox.addItem(w.getName() + " " + w.getLast_name());
				}
			}

		}
		return comboBox;
	}

	private Label getLabel_1() {
		if (label_1 == null) {
			label_1 = new Label("Choose branch:");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_1.setBounds(12, 414, 150, 24);
		}
		return label_1;
	}

	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(181, 416, 181, 22);
			comboBox_1.addItem("Choose");
			List<Branch> branches = Data.branches();
			if (branches != null) {
				for (Branch branch : branches) {
					comboBox_1.addItem(branch.getName() + "");
				}
			}
		}
		return comboBox_1;
	}

	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("Add shift");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dateChooser.setCalendar(Calendar.getInstance());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = null;
					String worker = null;
					String branch =  null;
					if (dateChooser.getDate() != null) {
						date = sdf.format(dateChooser.getDate());
					}
					worker = comboBox.getSelectedItem().toString();
					branch = comboBox_1.getSelectedItem().toString();
					System.out.println(worker);
					if(!worker.equalsIgnoreCase("Choose") && branch.equalsIgnoreCase("Choose")) {
					}
					
				}
			});
			btnInsert.setBounds(181, 488, 138, 53);
		}
		return btnInsert;
	}
}
