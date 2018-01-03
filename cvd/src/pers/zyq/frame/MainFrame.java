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
		
		JMenu menu_1 = new JMenu("\u7C7B\u522B\u7EF4\u62A4");
		menu.add(menu_1);
		
		JMenuItem typemodify = new JMenuItem("\u7C7B\u522B\u4FEE\u6539");
		menu_1.add(typemodify);
		
		JMenuItem typedel = new JMenuItem("\u7C7B\u522B\u5220\u9664");
		menu_1.add(typedel);
		
		JMenu cdmenu = new JMenu("\u5F71\u789F\u7BA1\u7406");
		menuBar.add(cdmenu);
		
		JMenuItem addItem = new JMenuItem("\u5F71\u789F\u5165\u5E93");
		cdmenu.add(addItem);
		
		JMenu menu_2 = new JMenu("\u5F71\u789F\u7EF4\u62A4");
		cdmenu.add(menu_2);
		
		JMenuItem vcdmodify = new JMenuItem("\u5F71\u789F\u4FE1\u606F\u4FEE\u6539");
		menu_2.add(vcdmodify);
		
		JMenuItem vcddel = new JMenuItem("\u5F71\u789F\u5220\u9664");
		menu_2.add(vcddel);
		
		JMenu cdbrmenu = new JMenu("\u5F71\u789F\u501F\u9605\u4E0E\u5F52\u8FD8");
		menuBar.add(cdbrmenu);
		
		JMenuItem cdBoItem = new JMenuItem("\u5F71\u789F\u501F\u9605");
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
