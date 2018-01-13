package pers.zyq.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane = new JDesktopPane();
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("\u5F71\u789F\u7BA1\u7406\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/pers/zyq/frame/vcdmana.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 549);
		setExtendedState(MAXIMIZED_BOTH);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu usermenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(usermenu);
		
		JMenuItem userAddItem = new JMenuItem("\u7528\u6237\u6CE8\u518C");
		userAddItem.addActionListener(new ActionListener() {//”√ªß◊¢≤·œÏ”¶
			public void actionPerformed(ActionEvent e) {
				UserRegFrame reg=new UserRegFrame();
				reg.setVisible(true);
				desktopPane.add(reg);
			}
		});
		usermenu.add(userAddItem);
		
		JMenuItem menuItem_2 = new JMenuItem("\u7528\u6237\u7EF4\u62A4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserModFrame umf=new UserModFrame();
				umf.setVisible(true);
				desktopPane.add(umf);
			}
		});
		usermenu.add(menuItem_2);
		
		JMenu menu = new JMenu("\u5F71\u789F\u7C7B\u522B\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem addTypeItem = new JMenuItem("\u7C7B\u522B\u6DFB\u52A0");
		addTypeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTypeFrame atf=new AddTypeFrame();
				atf.setVisible(true);
				desktopPane.add(atf);
			}
		});
		menu.add(addTypeItem);
		
		JMenuItem modTypeItem = new JMenuItem("\u7C7B\u522B\u7EF4\u62A4");
		modTypeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModTypeFrame modTF=new ModTypeFrame();
				modTF.setVisible(true);
				desktopPane.add(modTF);
			}
		});
		menu.add(modTypeItem);
		
		JMenu cdmenu = new JMenu("\u5F71\u789F\u7BA1\u7406");
		menuBar.add(cdmenu);
		
		JMenuItem addItem = new JMenuItem("\u5F71\u789F\u5165\u5E93");
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVcdFrame avf=new AddVcdFrame();
				avf.setVisible(true);
				desktopPane.add(avf);
			}
		});
		cdmenu.add(addItem);
		
		JMenuItem menuItem = new JMenuItem("\u5F71\u789F\u7EF4\u62A4");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModVcdFrame mvf=new ModVcdFrame();
				mvf.setVisible(true);
				desktopPane.add(mvf);
			}
		});
		cdmenu.add(menuItem);
		
		JMenu cdbrmenu = new JMenu("\u5F71\u789F\u501F\u9605\u4E0E\u5F52\u8FD8");
		menuBar.add(cdbrmenu);
		
		JMenuItem cdBoItem = new JMenuItem("\u5F71\u789F\u501F\u9605");
		cdBoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentFrame rf=new RentFrame();
				rf.setVisible(true);
				desktopPane.add(rf);
			}
		});
		cdbrmenu.add(cdBoItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5F71\u789F\u5F52\u8FD8");
		cdbrmenu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane.setBackground(Color.BLUE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
