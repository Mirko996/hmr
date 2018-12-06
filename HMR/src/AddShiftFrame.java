import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AddShiftFrame extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JLabel lblChooseADate;
	private Label label;
	private JComboBox comboBox;
	private Label label_1;
	private JComboBox comboBox_1;
	private JButton btnInsert;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JLabel lblChoosePattern;
	private JLabel lblChooseNumberOf;
	private JLabel lblNon;
	private JCheckBox chckbxMon;
	private JCheckBox chckbxTues;
	private JCheckBox chckbxWed;
	private JCheckBox chckbxThurs;
	private JCheckBox chckbxFri;
	private JCheckBox chckbxSat;
	private JCheckBox chckbxSun;
	private JLabel lblChooseNumberOf_1;
	private JComboBox comboBox_4;

	
	/**
	 * Create the frame.
	 */
	public AddShiftFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 444, 499);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblChooseADate());
		contentPane.add(getBtnInsert());
		contentPane.add(getDateChooser());
		dateChooser.setEnabled(true);
		contentPane.add(getComboBox_2());
		contentPane.add(getComboBox_3());
		contentPane.add(getLblChoosePattern());
		contentPane.add(getLblChooseNumberOf());
		contentPane.add(getLblNon());
		contentPane.add(getChckbxMon());
		contentPane.add(getChckbxTues());
		contentPane.add(getChckbxWed());
		contentPane.add(getChckbxThurs());
		contentPane.add(getChckbxFri());
		contentPane.add(getChckbxSat());
		contentPane.add(getChckbxSun());
		contentPane.add(getLblChooseNumberOf_1());
		contentPane.add(getComboBox_4());
	}

	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("yyyy-MM-dd");
			dateChooser.getCalendarButton().setEnabled(false);
			dateChooser.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			dateChooser.setBounds(259, 38, 113, 20);
		}
		return dateChooser;
	}

	private JLabel getLblChooseADate() {
		if (lblChooseADate == null) {
			lblChooseADate = new JLabel("Choose starting date:");
			lblChooseADate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblChooseADate.setBounds(12, 38, 169, 28);
		}
		return lblChooseADate;
	}

//	private JComboBox getComboBox() {
//		if (comboBox == null) {
//			comboBox = new JComboBox();
//			comboBox.setBounds(191, 453, 181, 22);
//			comboBox.addItem("Choose");
//			List<Worker> workers = Data.workers();
//			if (workers != null) {
//				for (Worker w : workers) {
//					comboBox.addItem(w.getName() + " " + w.getLast_name());
//				}
//			}
//
//		}
//		return comboBox;
//	}


//	private JComboBox getComboBox_1() {
//		if (comboBox_1 == null) {
//			comboBox_1 = new JComboBox();
//			comboBox_1.setBounds(191, 414, 181, 22);
//			comboBox_1.addItem("Choose");
//			List<Branch> branches = Data.branches();
//			if (branches != null) {
//				for (Branch branch : branches) {
//					comboBox_1.addItem(branch.getName() + "");
//				}
//			}
//		}
//		return comboBox_1;
//	}

	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("Add shift");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = null;
					if (dateChooser.getDate() != null) {
						date = sdf.format(dateChooser.getDate());
					}
				}
			});
			btnInsert.setBounds(138, 354, 138, 53);
		}
		return btnInsert;
	}
	private JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setBounds(259, 149, 113, 22);
			comboBox_2.addItem("Choose");
			comboBox_2.addItem("Day pattern");
			comboBox_2.addItem("Week pattern");
		}
		return comboBox_2;
	}
	private JComboBox getComboBox_3() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox();
			comboBox_3.setBounds(259, 184, 113, 22);
			comboBox_3.addItem("Choose");
			comboBox_3.addItem("1");
			comboBox_3.addItem("2");
			comboBox_3.addItem("3");
			comboBox_3.addItem("4");
			comboBox_3.addItem("5");
			comboBox_3.addItem("6");
			comboBox_3.addItem("7");
			comboBox_3.addItem("8");
			comboBox_3.addItem("9");
			comboBox_3.addItem("10");
		}
		return comboBox_3;
	}
	private JLabel getLblChoosePattern() {
		if (lblChoosePattern == null) {
			lblChoosePattern = new JLabel("Choose pattern:");
			lblChoosePattern.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblChoosePattern.setBounds(12, 144, 169, 28);
		}
		return lblChoosePattern;
	}
	private JLabel getLblChooseNumberOf() {
		if (lblChooseNumberOf == null) {
			lblChooseNumberOf = new JLabel("Choose number of workers:");
			lblChooseNumberOf.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblChooseNumberOf.setBounds(12, 179, 237, 28);
		}
		return lblChooseNumberOf;
	}
	private JLabel getLblNon() {
		if (lblNon == null) {
			lblNon = new JLabel("Non-working days:");
			lblNon.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNon.setBounds(146, 245, 150, 28);
		}
		return lblNon;
	}
	private JCheckBox getChckbxMon() {
		if (chckbxMon == null) {
			chckbxMon = new JCheckBox("Mon");
			chckbxMon.setBounds(8, 282, 53, 25);
		}
		return chckbxMon;
	}
	private JCheckBox getChckbxTues() {
		if (chckbxTues == null) {
			chckbxTues = new JCheckBox("Tues");
			chckbxTues.setBounds(65, 282, 57, 25);
		}
		return chckbxTues;
	}
	private JCheckBox getChckbxWed() {
		if (chckbxWed == null) {
			chckbxWed = new JCheckBox("Wed");
			chckbxWed.setBounds(126, 282, 55, 25);
		}
		return chckbxWed;
	}
	private JCheckBox getChckbxThurs() {
		if (chckbxThurs == null) {
			chckbxThurs = new JCheckBox("Thurs");
			chckbxThurs.setBounds(185, 282, 66, 25);
		}
		return chckbxThurs;
	}
	private JCheckBox getChckbxFri() {
		if (chckbxFri == null) {
			chckbxFri = new JCheckBox("Fri");
			chckbxFri.setBounds(255, 282, 53, 25);
		}
		return chckbxFri;
	}
	private JCheckBox getChckbxSat() {
		if (chckbxSat == null) {
			chckbxSat = new JCheckBox("Sat");
			chckbxSat.setBounds(312, 282, 47, 25);
		}
		return chckbxSat;
	}
	private JCheckBox getChckbxSun() {
		if (chckbxSun == null) {
			chckbxSun = new JCheckBox("Sun");
			chckbxSun.setBounds(363, 282, 53, 25);
		}
		return chckbxSun;
	}
	private JLabel getLblChooseNumberOf_1() {
		if (lblChooseNumberOf_1 == null) {
			lblChooseNumberOf_1 = new JLabel("Choose number of shifts:");
			lblChooseNumberOf_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblChooseNumberOf_1.setBounds(12, 112, 237, 28);
		}
		return lblChooseNumberOf_1;
	}
	private JComboBox getComboBox_4() {
		if (comboBox_4 == null) {
			comboBox_4 = new JComboBox();
			comboBox_4.setBounds(259, 114, 113, 22);
			comboBox_4.addItem("Choose");
			comboBox_4.addItem("1");
			comboBox_4.addItem("2");
			comboBox_4.addItem("3");
		}
		return comboBox_4;
	}
}
