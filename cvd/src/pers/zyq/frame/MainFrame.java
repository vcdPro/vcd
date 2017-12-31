package pers.zyq.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				UserReg reg=new UserReg();
				reg.setVisible(true);
				desktopPane.add(reg);
			}
		});
		usermenu.add(userAddItem);
		
		JMenuItem userModifyItem = new JMenuItem("\u7528\u6237\u7BA1\u7406");
		usermenu.add(userModifyItem);
		
		JMenu cdmenu = new JMenu("\u5F71\u789F\u7BA1\u7406");
		menuBar.add(cdmenu);
		
		JMenuItem addItem = new JMenuItem("\u5F71\u789F\u5165\u5E93");
		cdmenu.add(addItem);
		
		JMenuItem modifyItem = new JMenuItem("\u5F71\u789F\u7EF4\u62A4");
		cdmenu.add(modifyItem);
		
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
