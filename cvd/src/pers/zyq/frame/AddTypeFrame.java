package pers.zyq.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import pers.zyq.factory.BasicFactory;
import pers.zyq.service.VcdService;

public class AddTypeFrame extends JInternalFrame {
	private JTextField typeTxt;
	private 	JTextArea descTxt ;
	private Connection con;
	
	public AddTypeFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel booktypelab = new JLabel("\u5F71\u789F\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		typeTxt = new JTextField();
		typeTxt.setColumns(10);
		
		JLabel label = new JLabel("\u5F71\u789F\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		descTxt = new JTextArea();
		descTxt.setLineWrap(true);
		descTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		JButton addbtn = new JButton("\u6DFB\u52A0");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				String typename=typeTxt.getText();
				String desc=descTxt.getText();
				if("".equals(typename)||typename.isEmpty()){
					JOptionPane.showMessageDialog(null, "类别名不可为空");
					typeTxt.requestFocus(true);
					return;
				}else{
					if(service.addType( typename,desc) >0){
						JOptionPane.showMessageDialog(null, "添加成功");
						resetvalue();
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(booktypelab, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(typeTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(addbtn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(descTxt, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(booktypelab, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(typeTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(descTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(addbtn)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetvalue() {
		// TODO 自动生成的方法存根
		typeTxt.setText("");
		descTxt.setText("");
	}
}
