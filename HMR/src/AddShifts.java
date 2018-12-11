import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Label;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ItemEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.event.AncestorEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextField;

public class AddShifts extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JLabel label_2;
	private JCheckBox mon;
	private JCheckBox tues;
	private JCheckBox wed;
	private JCheckBox thurs;
	private JCheckBox fri;
	private JCheckBox sat;
	private JCheckBox sun;
	private JButton button;
	private Label label_1;
	private JComboBox comboBox1;
	private Label label_3;
	private JComboBox comboBox2;
	private Label label_4;
	private JComboBox comboBox3;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private JLabel label_5;
	private JDateChooser dateChooser;
	private JLabel label_6;
	private JComboBox comboBox;
	private int NumberOfShifts = 1;
	private List<String> shift1;
	private List<String> shift2;
	private List<String> shift3;
	private String username;
	private JTextField numOfDays;
	private JLabel lblForHowMany;
	private String[] columnName = { "ID", "Name" };
	private DefaultTableModel dtm;
	private DefaultTableModel dtm1;
	private DefaultTableModel dtm2;
	private JButton r1;
	private JButton r2;
	private JButton r3;
	private DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public AddShifts(String username) {
		shift1 = new ArrayList<String>();
		shift2 = new ArrayList<String>();
		shift3 = new ArrayList<String>();
		this.username = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 885);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getLabel_2());
		contentPane.add(getMon());
		contentPane.add(getTues());
		contentPane.add(getWed());
		contentPane.add(getThurs());
		contentPane.add(getFri());
		contentPane.add(getSat());
		contentPane.add(getSun());
		contentPane.add(getButton());
		contentPane.add(getLabel_1());
		contentPane.add(getComboBox_1());
		contentPane.add(getLabel_3());
		contentPane.add(getComboBox_1_1());
		contentPane.add(getLabel_4());
		contentPane.add(getComboBox3());
		contentPane.add(getTable1());
		contentPane.add(getTable2());
		contentPane.add(getTable3());
		contentPane.add(getLabel_5());
		contentPane.add(getDateChooser());
		contentPane.add(getLabel_6());
		contentPane.add(getNumOfDays());
		contentPane.add(getLblForHowMany());
		contentPane.add(getR1());
		contentPane.add(getR2());
		contentPane.add(getR3());
		contentPane.add(getComboBox());
		updateTable();
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox.getSelectedItem().equals("1")) {
						comboBox2.setVisible(false);
						table2.setVisible(false);
						label_3.setVisible(false);
						label_4.setVisible(false);
						r3.setVisible(false);
						r2.setVisible(false);
						table3.setVisible(false);
						comboBox3.setVisible(false);
						contentPane.repaint();
					} else if (comboBox.getSelectedItem().equals("2")) {
						NumberOfShifts = 2;
						comboBox2.setVisible(true);
						table2.setVisible(true);
						label_3.setVisible(true);
						r2.setVisible(true);
						r3.setVisible(false);
						label_4.setVisible(false);
						table3.setVisible(false);
						comboBox3.setVisible(false);
						contentPane.repaint();
					} else if (comboBox.getSelectedItem().equals("3")) {
						NumberOfShifts = 3;
						label_4.setVisible(true);
						table3.setVisible(true);
						comboBox3.setVisible(true);
						r2.setVisible(true);
						r3.setVisible(true);
						comboBox2.setVisible(true);
						table2.setVisible(true);
						label_3.setVisible(true);
						contentPane.repaint();
					}
				}
			});
			comboBox.setBounds(789, 70, 113, 22);
			comboBox.addItem("1");
			comboBox.addItem("2");
			comboBox.addItem("3");

		}
		return comboBox;
	}

	public void updateTable() {
		Object[][] objcts = new Object[0][2];
		dtm = new DefaultTableModel(objcts, columnName);
		dtm1 = new DefaultTableModel(objcts, columnName);
		dtm2 = new DefaultTableModel(objcts, columnName);
		table1.setModel(dtm);
		table2.setModel(dtm1);
		table3.setModel(dtm2);

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Non-working days:");
			label.setBounds(191, 705, 150, 28);
			label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return label;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Non-working days:");
			label_2.setBounds(-261, 467, 150, 28);
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return label_2;
	}

	private JCheckBox getMon() {
		if (mon == null) {
			mon = new JCheckBox("Mon");
			mon.setBounds(73, 742, 57, 25);
		}
		return mon;
	}

	private JCheckBox getTues() {
		if (tues == null) {
			tues = new JCheckBox("Tues");
			tues.setBounds(130, 742, 62, 25);
		}
		return tues;
	}

	private JCheckBox getWed() {
		if (wed == null) {
			wed = new JCheckBox("Wed");
			wed.setBounds(191, 742, 59, 25);
		}
		return wed;
	}

	private JCheckBox getThurs() {
		if (thurs == null) {
			thurs = new JCheckBox("Thurs");
			thurs.setBounds(250, 742, 70, 25);
		}
		return thurs;
	}

	private JCheckBox getFri() {
		if (fri == null) {
			fri = new JCheckBox("Fri");
			fri.setBounds(317, 742, 57, 25);
		}
		return fri;
	}

	private JCheckBox getSat() {
		if (sat == null) {
			sat = new JCheckBox("Sat");
			sat.setBounds(371, 742, 47, 25);
		}
		return sat;
	}

	private JCheckBox getSun() {
		if (sun == null) {
			sun = new JCheckBox("Sun");
			sun.setBounds(418, 742, 53, 25);
		}
		return sun;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("Add shifts");
			button.setBounds(749, 760, 138, 53);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int branchId = Data.getIdBranchData(username);
					String numDays = "1";
					Date d = null;
					LocalDate date = null;
					List<Integer> nonWorkingDays = new ArrayList<>();
					List<Worker_shift> worker_shift = new ArrayList<>();
					if (dateChooser.getDate() != null) {
						d = dateChooser.getDate();
						date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					} else {
						JOptionPane.showMessageDialog(contentPane, "You have to choose date first!");
						return;
					}
					for (int i = 0; i < table1.getRowCount(); i++) {
						Worker_shift ws = new Worker_shift(date, Integer.parseInt(table1.getValueAt(i, 0).toString().trim()),1);
						worker_shift.add(ws);
					}
					if (comboBox.getSelectedIndex() == 1) {
						for (int i = 0; i < table2.getRowCount(); i++) {
							Worker_shift ws = new Worker_shift(date, Integer.parseInt(table2.getValueAt(i, 0).toString().trim()),2);
							worker_shift.add(ws);
							}
					} else if (comboBox.getSelectedIndex() == 2) {
						for (int i = 0; i < table2.getRowCount(); i++) {
							Worker_shift ws = new Worker_shift(date, Integer.parseInt(table2.getValueAt(i, 0).toString().trim()),2);
							worker_shift.add(ws);
							}
						for (int i = 0; i < table3.getRowCount(); i++) {
							Worker_shift ws = new Worker_shift(date, Integer.parseInt(table3.getValueAt(i, 0).toString().trim()),3);
							worker_shift.add(ws);
							}
					}
					
					if (!numOfDays.toString().equals("")) {
						try {
							int i = Integer.parseInt(numOfDays.getText().toString());
							numDays = numOfDays.getText().toString().trim();
						} catch (Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Number of days must be number!");
						}
					}else{
						numDays = "1";
					}

					if (nonWorkingDays != null) {
						if (mon.isSelected()) {
							nonWorkingDays.add(1);
						} else if (tues.isSelected()) {
							nonWorkingDays.add(2);
						} else if (wed.isSelected()) {
							nonWorkingDays.add(3);
						} else if (thurs.isSelected()) {
							nonWorkingDays.add(4);
						} else if (fri.isSelected()) {
							nonWorkingDays.add(5);
						} else if (sat.isSelected()) {
							nonWorkingDays.add(6);
						} else if (sun.isSelected()) {
							nonWorkingDays.add(7);
						}
					}

//					for (int i = 0; i < table1.getRowCount(); i++) {
//						Worker_shift ws = new Worker_shift(date, Integer.parseInt(table1.getValueAt(i, 0).toString().trim()),1, branchId);
//						Data.insetrtToWorker_shift(ws, nonWorkingDays, numDays);
//					}
//					if (comboBox.getSelectedIndex() == 1) {
//						for (int i = 0; i < table2.getRowCount(); i++) {
//							Worker_shift ws = new Worker_shift(date, Integer.parseInt(table2.getValueAt(i, 0).toString().trim()),2, branchId);
//							Data.insetrtToWorker_shift(ws, nonWorkingDays, numDays);
//							}
//					} else if (comboBox.getSelectedIndex() == 2) {
//						for (int i = 0; i < table2.getRowCount(); i++) {
//							Worker_shift ws = new Worker_shift(date, Integer.parseInt(table2.getValueAt(i, 0).toString().trim()),2, branchId);
//							Data.insetrtToWorker_shift(ws, nonWorkingDays, numDays);
//							}
//						for (int i = 0; i < table3.getRowCount(); i++) {
//							Worker_shift ws = new Worker_shift(date, Integer.parseInt(table3.getValueAt(i, 0).toString().trim()),3, branchId);
//							Data.insetrtToWorker_shift(ws, nonWorkingDays, numDays);
//							}
//					}
					Data.insetrtToWorker_shift(worker_shift, nonWorkingDays, numDays, branchId);
					

				}
			});
		}
		return button;
	}

	private Label getLabel_1() {
		if (label_1 == null) {
			label_1 = new Label("Shift 1");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
			label_1.setBounds(122, 178, 70, 24);
		}
		return label_1;
	}

	private JComboBox getComboBox_1() {
		if (comboBox1 == null) {
			comboBox1 = new JComboBox();
			comboBox1.setBounds(63, 208, 187, 28);
			List<Worker> workers = Data.workersByBranch(Data.getIdBranchData(username));
			if (workers != null) {
				for (Worker w : workers) {
					String s = w.getId() + " - " + w.getName() + " " + w.getLast_name();
					comboBox1.addItem(s);
				}

			}
			comboBox1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] row = comboBox1.getSelectedItem().toString().split("-");
					dtm.addRow(row);
					comboBox1.removeItem(comboBox1.getSelectedItem());

				}
			});

		}
		return comboBox1;
	}

	private Label getLabel_3() {
		if (label_3 == null) {
			label_3 = new Label("Shift 2");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
			label_3.setBounds(485, 178, 70, 24);
		}
		return label_3;
	}

	private JComboBox getComboBox_1_1() {
		if (comboBox2 == null) {
			comboBox2 = new JComboBox();
			comboBox2.setBounds(426, 208, 187, 28);
			List<Worker> workers = Data.workersByBranch(Data.getIdBranchData(username));
			if (workers != null) {
				for (Worker w : workers) {
					String s = w.getId() + " - " + w.getName() + " " + w.getLast_name();
					comboBox2.addItem(s);
				}

			}
			comboBox2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] row = comboBox2.getSelectedItem().toString().split("-");
					dtm1.addRow(row);
					comboBox2.removeItem(comboBox2.getSelectedItem());

				}
			});
		}
		return comboBox2;
	}

	private Label getLabel_4() {
		if (label_4 == null) {
			label_4 = new Label("Shift 3");
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
			label_4.setBounds(848, 178, 70, 24);
		}
		return label_4;
	}

	private JComboBox getComboBox3() {
		if (comboBox3 == null) {
			comboBox3 = new JComboBox();
			comboBox3.setBounds(789, 208, 187, 28);
			List<Worker> workers = Data.workersByBranch(Data.getIdBranchData(username));
			if (workers != null) {
				for (Worker w : workers) {
					String s = w.getId() + " - " + w.getName() + " " + w.getLast_name();
					comboBox3.addItem(s);
				}

			}
			comboBox3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] row = comboBox3.getSelectedItem().toString().split("-");
					dtm2.addRow(row);
					comboBox3.removeItem(comboBox3.getSelectedItem());

				}
			});
		}
		return comboBox3;
	}

	private JTable getTable1() {
		if (table1 == null) {
			table1 = new JTable();
			table1.setBounds(63, 249, 190, 447);
		}
		return table1;
	}

	private JTable getTable2() {
		if (table2 == null) {
			table2 = new JTable();
			table2.setBounds(426, 249, 190, 447);
		}
		return table2;
	}

	private JTable getTable3() {
		if (table3 == null) {
			table3 = new JTable();
			table3.setBounds(789, 249, 190, 447);
		}
		return table3;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("Choose starting date:");
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_5.setBounds(63, 65, 169, 28);
		}
		return label_5;
	}

	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.getCalendarButton().setEnabled(false);
			dateChooser.setEnabled(true);
			dateChooser.setDateFormatString("yyyy-MM-dd");
			dateChooser.setBounds(268, 65, 150, 28);
		}
		return dateChooser;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("Choose number of shifts:");
			label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_6.setBounds(546, 65, 237, 28);
		}
		return label_6;
	}

	private JTextField getNumOfDays() {
		if (numOfDays == null) {
			numOfDays = new JTextField();
			numOfDays.setText("1");
			numOfDays.setBounds(522, 791, 116, 22);
			numOfDays.setColumns(10);
		}
		return numOfDays;
	}

	private JLabel getLblForHowMany() {
		if (lblForHowMany == null) {
			lblForHowMany = new JLabel("For how many days do you want to follow this pattern:");
			lblForHowMany.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblForHowMany.setBounds(67, 786, 443, 28);
		}
		return lblForHowMany;
	}

	private JButton getR1() {
		if (r1 == null) {
			r1 = new JButton("R");
			r1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table1.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
						return;
					}

					table1.remove(row);
					contentPane.removeAll();
				}
			});
			r1.setBounds(12, 249, 47, 34);
		}
		return r1;
	}

	private JButton getR2() {
		if (r2 == null) {
			r2 = new JButton("R");
			r2.setBounds(377, 249, 47, 34);
			r2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table1.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
						return;
					}

					table1.remove(row);
					contentPane.removeAll();
				}
			});
		}
		return r2;
	}

	private JButton getR3() {
		if (r3 == null) {
			r3 = new JButton("R");
			r3.setBounds(736, 249, 47, 34);
			r3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table1.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
						return;
					}

					table1.remove(row);
					contentPane.removeAll();
				}
			});
		}
		return r3;
	}
}
