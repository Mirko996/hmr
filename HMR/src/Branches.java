import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JFrame;
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

public class Branches extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public void setTable(JTable table) {
		this.table = table;
	}
	Object[][] objects = null;
	private String[] columnName = { "ID", "Address", "City", "Name", "Email", "Password", "Active" };
	private JScrollPane scrollPane;
	private JButton btnAddBranch;
	private JButton btnRemoveBranch;
	private JButton btnUpdateBranch;

	/**
	 * Create the frame.
	 */
	public Branches() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());

		fillWithBranches();
		
		contentPane.add(getBtnAddBranch());
		contentPane.add(getBtnRemoveBranch());
		contentPane.add(getBtnUpdateBranch());
	}
	
	public void fillWithBranches() {
		Object[][] objects = new Object[Data.branches().size()][7];

		List<Branch> branches = Data.branches();
		int num = 0;
		if (branches != null) {
			for (Branch b : branches) {
				Object[] branch = {b.getId(), b.getAddres(), b.getCity(), b.getEmail(), b.getName(), b.getPassword(),
						b.isActive()};
				objects[num] = branch;
				num++;
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(objects,columnName);
		table.setModel(dtm);
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
			btnRemoveBranch.setBounds(594, 72, 132, 42);
		}
		return btnRemoveBranch;
	}
	private JButton getBtnUpdateBranch() {
		if (btnUpdateBranch == null) {
			btnUpdateBranch = new JButton("UPDATE BRANCH");
			btnUpdateBranch.setBounds(738, 72, 132, 42);
		}
		return btnUpdateBranch;
	}
}
