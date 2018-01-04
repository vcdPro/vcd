package pers.zyq.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import pers.zyq.domain.VcdType;
import pers.zyq.factory.BasicFactory;
import pers.zyq.service.VcdService;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModTypeFrame extends JInternalFrame {
	private JTextField conTxt;
	private JTable table;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextArea descTxt ;


	/**
	 * Create the frame.
	 */
	public ModTypeFrame() {
		setClosable(true);
		setTitle("\u7C7B\u522B\u7EF4\u62A4");
		setBounds(100, 100, 526, 605);
		
		conTxt = new JTextField();
		conTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		conTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				String condition=conTxt.getText();
				List<VcdType> list=service.query(condition);
				fillTable(list);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u7C7B\u522B\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		idTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7C7B\u522B\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		descTxt = new JTextArea();
		descTxt.setBorder(new LineBorder(new Color(0, 0, 0)));
		descTxt.setLineWrap(true);
		
		JButton button_1 = new JButton("\u7F16\u8F91");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				VcdType type=new VcdType(Integer.parseInt(idTxt.getText()), nameTxt.getText(),descTxt.getText());
				int n=service.updateType(type);
				if(n==1){
					resetValue();
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				int id=Integer.parseInt(idTxt.getText());
				if(service.delType(id)==1){
					resetValue();
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
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
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(descTxt, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(label_1)
									.addGap(18)
									.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(130)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)))
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
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(descTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				idTxt.setText(table.getValueAt(row, 0).toString());
				nameTxt.setText(table.getValueAt(row, 1).toString());
				descTxt.setText(table.getValueAt(row, 2).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7C7B\u522B\u7F16\u53F7", "\u7C7B\u522B\u540D\u79F0", "\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue() {
		// TODO 自动生成的方法存根
		idTxt.setText("");
		nameTxt.setText("");
		descTxt.setText("");
		
	}

	protected void fillTable(List<VcdType> list) {
		// TODO 自动生成的方法存根
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Iterator<VcdType> it=list.iterator();
		while(it.hasNext()){
			Vector v=new Vector();
			VcdType vcdt=it.next();
			v.add(vcdt.getId());
			v.add(vcdt.getName());
			v.add(vcdt.getDescription());
			dtm.addRow(v);
		}
	}
}
