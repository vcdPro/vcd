package pers.zyq.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import pers.zyq.domain.User;
import pers.zyq.factory.BasicFactory;
import pers.zyq.service.UserService;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private static Login frame;
	private JPanel contentPane;
	private JTextField userName;
	private JLabel label_2;
	private JPasswordField userPwd;
	private JButton loginbtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame=new Login();
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
	public Login() {
		setTitle("\u767B\u5F55");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/pers/zyq/frame/vcdmana.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5F71\u789F\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		userName = new JTextField();
		userName.setColumns(10);
		label_2 = new JLabel("\u5BC6    \u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		userPwd = new JPasswordField();
		userPwd.setColumns(10);
		loginbtn = new JButton("\u767B\u5F55");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService service=BasicFactory.getFactory().getInstance(UserService.class);
				String nameTxt=userName.getText();
				if("".equals(nameTxt)||nameTxt.isEmpty()){
					JOptionPane.showMessageDialog(null, "用户名不可为空");
					userName.requestFocus();
					return;
				}
				String pwdTxt=String.valueOf(userPwd.getPassword());
				if("".equals(pwdTxt)||pwdTxt.isEmpty()){
					JOptionPane.showMessageDialog(null, "密码不可为空");
					userPwd.requestFocus();
					return;
				}
				User user=service.findUser(nameTxt);
				if( user!= null){
					if(!user.getPassword().equals(pwdTxt)){
						JOptionPane.showMessageDialog(null, "密码错误");
						userPwd.requestFocus();
					}
					else{
						MainFrame mainFrame=new MainFrame();
						mainFrame.setVisible(true);
						frame.dispose();
					}		
				}
				else{
					JOptionPane.showMessageDialog(null, "不存在该用户");
				}
			}
		});
		loginbtn.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(164, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(148))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(174)
					.addComponent(loginbtn, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addComponent(loginbtn)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
