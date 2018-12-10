import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BranchesFrame extends JFrame {

	private JPanel contentPane;
	static JTable table;
	private static String EMAIL;

	Object[][] objects = null;
	private String[] columnName = { "ID", "Address", "City", "Email", "Name", "Password", "Active" };
	private JScrollPane scrollPane;
	private JButton btnAddBranch;
	private JButton btnRemoveBranch;
	private JButton btnUpdateBranch;
	private JButton btnRestoreBranch;

	public BranchesFrame(String email) {
		this.EMAIL = email;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());

		updateTable();

		contentPane.add(getBtnAddBranch());
		contentPane.add(getBtnRemoveBranch());
		contentPane.add(getBtnUpdateBranch());
		contentPane.add(getBtnRestoreBranch());
	}

	public void updateTable() {
		Object[][] objects = new Object[Data.branches().size()][7];

		List<Branch> branches = Data.branches();
		int num = 0;
		if (branches != null) {
			for (Branch b : branches) {
				Object[] branch = { b.getId(), b.getAddres(), b.getCity(), b.getEmail(), b.getName(), b.getPassword(),
						b.getActive() };
				objects[num] = branch;
				num++;
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(objects, columnName);
		table.setModel(dtm);
	}

	private Branch tableBranch() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(contentPane, "You have to choose branch first!");
			return null;
		}
		String id = table.getModel().getValueAt(row, 0).toString();
//		int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
		String address = table.getModel().getValueAt(row, 1).toString();
		String city = table.getModel().getValueAt(row, 2).toString();
		String email = table.getModel().getValueAt(row, 3).toString();
		String name = table.getModel().getValueAt(row, 4).toString();
		String password = table.getModel().getValueAt(row, 5).toString();
		int active = (int)table.getModel().getValueAt(row, 6);

		Branch b = new Branch(Integer.parseInt(id),address, city, email, name, password,active);
		return b;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setRowHeight(50);
			table.setBounds(-2, -218, 884, 377);
		}
		return table;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 137, 882, 366);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JButton getBtnAddBranch() {
		if (btnAddBranch == null) {
			btnAddBranch = new JButton("ADD BRANCH");
			btnAddBranch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddBranch ab = new AddBranch();
					ab.setVisible(true);
				}
			});
			btnAddBranch.setBounds(451, 72, 132, 42);
		}
		return btnAddBranch;
	}
	

	private JButton getBtnRemoveBranch() {
		if (btnRemoveBranch == null) {
			btnRemoveBranch = new JButton("REMOVE BRANCH");
			btnRemoveBranch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int row = table.getSelectedRow();
					if(row != -1) {
						
					Data.removeBranchNew((int) table.getModel().getValueAt(row, 0));
					updateTable();
					JOptionPane.showMessageDialog(contentPane, "Success!");
					}else {
						JOptionPane.showMessageDialog(contentPane, "Success!");

					}
				}
			});
			btnRemoveBranch.setBounds(594, 72, 132, 42);
		}
		return btnRemoveBranch;
	}

	private JButton getBtnUpdateBranch() {
		if (btnUpdateBranch == null) {
			btnUpdateBranch = new JButton("UPDATE BRANCH");
			btnUpdateBranch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Branch b = tableBranch();
					if (b != null) {
						EditBranch e = new EditBranch(b);
						e.setVisible(true);
					}
				}
			});
			btnUpdateBranch.setBounds(738, 72, 132, 42);
		}
		return btnUpdateBranch;
	}
	private JButton getBtnRestoreBranch() {
		if (btnRestoreBranch == null) {
			btnRestoreBranch = new JButton("RESTORE BRANCH");
			btnRestoreBranch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(contentPane, "You have to choose worker first!");
						return;
					}
					Data.restoreBranchNew((int) table.getModel().getValueAt(row, 0));
					updateTable();
					JOptionPane.showMessageDialog(contentPane, "Success!");	
				
				}
			});
			btnRestoreBranch.setBounds(300, 72, 139, 42);
		}
		return btnRestoreBranch;
	}
}