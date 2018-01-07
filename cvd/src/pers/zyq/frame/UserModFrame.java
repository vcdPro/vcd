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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;

import pers.zyq.domain.User;
import pers.zyq.factory.BasicFactory;
import pers.zyq.service.UserService;

public class UserModFrame extends JInternalFrame {
	private JTextField conTxt;
	private JTable table;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField pwdTxt;
	private JRadioButton maleBtn;
	private JRadioButton famaleBtn;
	private JTextField idcardTxt;
	private JTextField phoneTxt;
	private JTextField regdateTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public UserModFrame() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 15));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u7528\u6237\u4FE1\u606F\u7EF4\u62A4");
		setBounds(100, 100, 618, 605);
		
		conTxt = new JTextField();
		conTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		conTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			query();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		idTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		nameTxt = new JTextField();
		nameTxt.setEditable(false);
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setColumns(10);
		
		JButton modBtn = new JButton("\u7F16\u8F91");
		modBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idTxt.getText());
				String password=pwdTxt.getText();
				String phone=phoneTxt.getText();
				User user=new User(id,password,phone);
				UserService service=BasicFactory.getFactory().getInstance(UserService.class);
				if(service.update(user)>0){
					JOptionPane.showMessageDialog(null, "用户修改成功！");
					resetValue();
					query();
				}
			}
		});
		modBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton delBtn = new JButton("\u5220\u9664");
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "是否确认删除该用户？");
				int id=Integer.parseInt(idTxt.getText());
				UserService service=BasicFactory.getFactory().getInstance(UserService.class);
				if(n==0){
					if(service.delUser(id)>0){
					JOptionPane.showMessageDialog(null, "用户删除成功！");
					resetValue();
					query();
					}
				}
			}
		});
		delBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("\u6027    \u522B\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		maleBtn = new JRadioButton("\u7537");
		buttonGroup.add(maleBtn);
		maleBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		
		famaleBtn = new JRadioButton("\u5973");
		buttonGroup.add(famaleBtn);
		famaleBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("\u5BC6    \u7801\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		pwdTxt = new JTextField();
		pwdTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		pwdTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idcardTxt = new JTextField();
		idcardTxt.setEditable(false);
		idcardTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		phoneTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u6CE8\u518C\u65E5\u671F\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		
		regdateTxt = new JTextField();
		regdateTxt.setEditable(false);
		regdateTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(conTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(phoneTxt)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(maleBtn)
												.addGap(18)
												.addComponent(famaleBtn))
											.addComponent(label, Alignment.TRAILING)))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(label_4)
											.addComponent(label_3)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(idcardTxt, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(regdateTxt, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
							.addGap(114))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(179)
									.addComponent(delBtn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addComponent(modBtn, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(conTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(label_1)
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(maleBtn)
								.addComponent(famaleBtn)
								.addComponent(label_4)
								.addComponent(idcardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(regdateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(delBtn)
						.addComponent(modBtn))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				idTxt.setText(table.getValueAt(row, 0).toString());
				nameTxt.setText(table.getValueAt(row, 1).toString());
				pwdTxt.setText(table.getValueAt(row, 2).toString());
				String sex=table.getValueAt(row, 3).toString();
				if(maleBtn.getText().equals(sex)){
					maleBtn.setSelected(true);
					maleBtn.setEnabled(false);
					famaleBtn.setEnabled(false);
				}
				if(famaleBtn.getText().equals(sex)){
					famaleBtn.setSelected(true);
					maleBtn.setEnabled(false);
					famaleBtn.setEnabled(false);
				}
				idcardTxt.setText(table.getValueAt(row, 4).toString());
				phoneTxt.setText(table.getValueAt(row, 5).toString());
				regdateTxt.setText(table.getValueAt(row, 6).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u7F16\u53F7", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1", "\u624B\u673A\u53F7", "\u6CE8\u518C\u65E5\u671F"
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


	protected void resetValue() {
		// TODO 自动生成的方法存根
		idTxt.setText("");
		nameTxt.setText("");
		pwdTxt.setText("");
		idcardTxt.setText("");
		famaleBtn.setSelected(false);
		maleBtn.setSelected(false);
		phoneTxt.setText("");
		regdateTxt.setText("");
	}


	protected void query() {
		// TODO 自动生成的方法存根
		UserService service=BasicFactory.getFactory().getInstance(UserService.class);
		String condition=conTxt.getText();
		List<User> list=service.query(condition);
		filltable(list);
	}


	private void filltable(List<User> list) {
		// TODO 自动生成的方法存根
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Iterator<User> it = list.iterator();
		while(it.hasNext()){
			Vector v=new Vector();
			User user=it.next();
			v.add(user.getId());
			v.add(user.getName());
			v.add(user.getPassword());
			v.add(user.getSex());
			v.add(user.getIdcard());
			v.add(user.getPhone());
			v.add(user.getRegdate());
			dtm.addRow(v);
		}
	}
}