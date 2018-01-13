package pers.zyq.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import pers.zyq.domain.Record;
import pers.zyq.domain.User;
import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;
import pers.zyq.factory.BasicFactory;
import pers.zyq.service.UserService;
import pers.zyq.service.VcdService;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RentFrame extends JInternalFrame {
	private JTextField conTxt;
	private JTable table;
	private JFrame f;
	private JFileChooser fileChooser;
	private JTextField usernameTxt;
	private JTextField vcdidTxt;
	private JTextField rentdateTxt;
	private JTextField returndateTxt;
	private JTextField rentpriceTxt;
	private JTextField depositpriceTxt;

	/**
	 * Create the frame.
	 */
	public RentFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5F71\u789F\u7EF4\u62A4");
		setBounds(100, 100, 602, 605);
		
		conTxt = new JTextField();
		conTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		conTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryVcd();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button_1 = new JButton("\u501F\u9605");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=usernameTxt.getText();
				int userid=findName();
				String vcdidstr=vcdidTxt.getText();
				if("".equals(vcdidstr)||vcdidstr.isEmpty()){
					JOptionPane.showMessageDialog(null, "请选择影碟！");
					return;
				}
				if("".equals(name)||name.isEmpty()){
					JOptionPane.showMessageDialog(null, "用户名不可为空");
					return;
				}
				int vcdid=Integer.parseInt(vcdidstr);
				String rentdatestr=rentdateTxt.getText();
				String returndatestr=returndateTxt.getText();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date rentdateu = sdf.parse(rentdatestr);
					java.sql.Date rentdate= new java.sql.Date(rentdateu.getTime());
					Date returndateu = sdf.parse(returndatestr);
					java.sql.Date returndate= new java.sql.Date(returndateu.getTime());
					//System.out.println(new java.sql.Date());
					float rentprice=Float.parseFloat( rentpriceTxt.getText());
					float depositprice=Float.parseFloat(depositpriceTxt.getText());
					VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
					Record record=new Record(userid, vcdid, rentdate, returndate, depositprice, depositprice);
					if(service.addRecord(record)>0){
						resetValue();
						queryVcd();
					}
				} catch (ParseException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		usernameTxt = new JTextField();
		usernameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				findName();
				
			}

		});
		usernameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		usernameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5F71\u789F\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		vcdidTxt = new JTextField();
		vcdidTxt.setEditable(false);
		vcdidTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		vcdidTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u79DF\u65E5\u671F\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		rentdateTxt = new JTextField();
		rentdateTxt.setEditable(false);
		rentdateTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		rentdateTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5F52\u8FD8\u65E5\u671F\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		returndateTxt = new JTextField();
		returndateTxt.setEditable(false);
		returndateTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		returndateTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u79DF\u91D1\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		rentpriceTxt = new JTextField();
		rentpriceTxt.setEditable(false);
		rentpriceTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		rentpriceTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u62BC\u91D1\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		depositpriceTxt = new JTextField();
		depositpriceTxt.setEditable(false);
		depositpriceTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		depositpriceTxt.setColumns(10);
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
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(rentdateTxt)
										.addComponent(usernameTxt, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
									.addGap(144)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label_3)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rentpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_5)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(depositpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(returndateTxt)
									.addComponent(vcdidTxt))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(241)
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
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(vcdidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(rentdateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(returndateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(rentpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(depositpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(button_1)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				vcdidTxt.setText(table.getValueAt(row, 0).toString());
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String datestr=sdf.format(d);
				rentdateTxt.setText(datestr);
				d.setMonth(d.getMonth()+1);
				String datestr1=sdf.format(d);
				returndateTxt.setText(datestr1);
				rentpriceTxt.setText("5");
				depositpriceTxt.setText(table.getValueAt(row, 5).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5F71\u789F\u7F16\u53F7", "\u5F71\u789F\u540D", "\u5F71\u789F\u7C7B\u522B", "\u73B0\u5B58\u6570\u91CF", "\u4E3B\u6F14", "\u5355\u4EF7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
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
		usernameTxt.setText("");
		vcdidTxt.setText("");
		rentdateTxt.setText("");
		returndateTxt.setText("");
		rentpriceTxt.setText("");
		depositpriceTxt.setText("");
	}


	protected void queryVcd() {
		// TODO 自动生成的方法存根
		VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
		String con=conTxt.getText();
		List<Vcd> list=service.queryVcd(con);
		fillTable(list);
	}


	protected void fillTable(List<Vcd> list) {
		// TODO 自动生成的方法存根
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		Iterator<Vcd> it = list.iterator();
		dtm.setRowCount(0);
		while(it.hasNext()){
			Vector v=new Vector();
			Vcd vcd=it.next();
			v.add(vcd.getId());
			v.add(vcd.getName());
			v.add(getType(vcd.getTypeid()));
			v.add(vcd.getNownum());
			v.add(vcd.getStar());
			v.add(vcd.getPrice());
			v.add(vcd.getUrl());
			v.add(vcd.getImageurl());
			dtm.addRow(v);
		}
	}


	protected VcdType getType(int typeid) {
		// TODO 自动生成的方法存根
		VcdService service =BasicFactory.getFactory().getInstance(VcdService.class);
		return service.getType(typeid);
	}
	
	
	protected int findName() {
		UserService service=BasicFactory.getFactory().getInstance(UserService.class);
		User user=new User();
		user.setName(usernameTxt.getText());
		int n=service.findUser(user);
		if(n==0){
			resetValue();			
		}
		return n;
	}
}
