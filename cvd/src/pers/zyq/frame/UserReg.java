package pers.zyq.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import pers.zyq.factory.BasicFactory;
import pers.zyq.service.UserService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserReg extends JInternalFrame {
	private JTextField nameTxt;
	private JTextField idcardTxt;
	private JTextField phoneTxt;
	private JRadioButton malebtn;
	private JRadioButton famalebtn;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Create the frame.
	 */
	public UserReg() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setClosable(true);
		setBounds(100, 100, 525, 360);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		
		nameTxt = new JTextField();
		nameTxt.setColumns(15);
		
		JLabel label_2 = new JLabel("\u6027  \u522B\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		malebtn = new JRadioButton("\u7537");
		buttonGroup.add(malebtn);
		malebtn.setFont(new Font("宋体", Font.PLAIN, 14));
		
		famalebtn = new JRadioButton("\u5973");
		buttonGroup.add(famalebtn);
		famalebtn.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		idcardTxt = new JTextField();
		idcardTxt.setColumns(15);
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(15);
		
		JButton regbtn = new JButton("\u6CE8  \u518C");
		regbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService service=BasicFactory.getFactory().getInstance(UserService.class);
				String name=nameTxt.getText();
				String sex="";
				if(malebtn.isSelected()){
					sex="男";
				}
				if(famalebtn.isSelected()){
					sex="女";
				}
			}
		});
		regbtn.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(nameTxt, 157, 157, 157))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, Alignment.TRAILING)
								.addComponent(label_3, Alignment.TRAILING)
								.addComponent(label_4, Alignment.TRAILING))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(phoneTxt, Alignment.LEADING)
										.addComponent(idcardTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
										.addComponent(regbtn, Alignment.LEADING)))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(29)
									.addComponent(malebtn)
									.addGap(26)
									.addComponent(famalebtn)))))
					.addGap(140))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(malebtn)
						.addComponent(famalebtn))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idcardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(18)
					.addComponent(regbtn)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
