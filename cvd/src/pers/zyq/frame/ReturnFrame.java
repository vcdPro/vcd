package pers.zyq.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import pers.zyq.domain.Record;
import pers.zyq.factory.BasicFactory;
import pers.zyq.service.VcdService;

public class ReturnFrame extends JInternalFrame {
	private JTextField conTxt;
	private JTable table;
	private JFrame f;
	private JFileChooser fileChooser;

	/**
	 * Create the frame.
	 */
	public ReturnFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5F71\u789F\u7EF4\u62A4");
		setBounds(100, 100, 608, 397);
		
		conTxt = new JTextField();
		conTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		conTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryRecord();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button_1 = new JButton("\u5F52\u8FD8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				int row=table.getSelectedRow();			
				int id=(Integer) table.getValueAt(row, 0);
				String name= (String) table.getValueAt(row, 2);
				service.updateRecord(id,name);
				JOptionPane.showMessageDialog(null, "图书已归还！");
				conTxt.setText("");
				DefaultTableModel dtm=(DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(conTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(94)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(230)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(conTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(button_1)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u53D1\u7968\u53F7", "\u7528\u6237\u540D", "\u5F71\u789F\u540D", "\u79DF\u91D1", "\u62BC\u91D1", "\u51FA\u79DF\u65E5\u671F", "\u5F52\u8FD8\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}

	protected void queryRecord() {
		// TODO 自动生成的方法存根
		VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
		if(conTxt.getText()==null||"".equals(conTxt.getText())){
			JOptionPane.showMessageDialog(null, "发票号不可为空！");
			return;
		}
		int id=Integer.parseInt(conTxt.getText());
		List list=service.queryRecord(id);
		if(list==null){
			return;
		}
		filTable(list);
	}

	private void filTable(List list) {
		// TODO 自动生成的方法存根
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Vector v=new Vector();
		v.add(list.get(0));
		v.add(list.get(1));
		v.add(list.get(2));
		v.add(list.get(3));
		v.add(list.get(4));
		v.add(list.get(5));
		v.add(list.get(6));
		dtm.addRow(v);
	}
}
