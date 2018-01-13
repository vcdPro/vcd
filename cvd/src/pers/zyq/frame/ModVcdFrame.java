package pers.zyq.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;
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

import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;
import pers.zyq.factory.BasicFactory;
import pers.zyq.service.VcdService;

public class ModVcdFrame extends JInternalFrame {
	private JTextField conTxt;
	private JTable table;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField nownumTxt;
	private JTextField starTxt;
	private JTextField priceTxt;
	private JTextField urlTxt;
	private JTextField imageurlTxt;
	private JComboBox typeCbox;
	private JFrame f;
	private JFileChooser fileChooser;

	/**
	 * Create the frame.
	 */
	public ModVcdFrame() {
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
		
		JLabel label = new JLabel("\u5F71\u789F\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		idTxt.setColumns(10);
		
		JButton button_1 = new JButton("\u7F16\u8F91");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				int id=Integer.parseInt(idTxt.getText());
				String name=nameTxt.getText();
				int typeid=((VcdType)typeCbox.getSelectedItem()).getId();
				int nownum=Integer.parseInt(nownumTxt.getText()); 
				String star=starTxt.getText();
				float price=Float.parseFloat(priceTxt.getText());
				String url=urlTxt.getText();
				String imageurl=imageurlTxt.getText();
				Vcd vcd=new Vcd(id, name, typeid, nownum, star, price, url, imageurl);
				if(service.updateVcd(vcd)>0){
					JOptionPane.showMessageDialog(null, "修改完成！");
					queryVcd();
					resetValue();
				}
				else{
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				int vcdid=Integer.parseInt(idTxt.getText());
				if(service.delVcd(vcdid)>0){
					JOptionPane.showMessageDialog(null, "删除成功！");
					queryVcd();
					resetValue();
				}else{
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("\u5F71\u789F\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5F71\u789F\u7C7B\u522B\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		typeCbox = new JComboBox();
		
		JLabel label_3 = new JLabel("\u73B0\u5B58\u6570\u91CF\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		nownumTxt = new JTextField();
		nownumTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nownumTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4E3B    \u6F14\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		starTxt = new JTextField();
		starTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		starTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5355    \u4EF7\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JButton urlBtn = new JButton("\u5F71\u789F\u9884\u89C8");
		urlBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				f = new JFrame("选择文件");
		        fileChooser = new JFileChooser("D:\\");//建立一个FileChooser对象,并指定D:的目录为默认文件对话框路径.
		        f.pack();
		        f.setVisible(true);

				 File file = null;
			     int result;
				 fileChooser.setApproveButtonText("确定");
		            fileChooser.setDialogTitle("打开文件");
		            result = fileChooser.showOpenDialog(f);
		            /*当用户按下打开文件对话框的"确定"钮后,我们就可以利用getSelectedFile()方法取得文件对象.若是用户按下打开文件对话框的"Cancel"钮,则将在label上显示"你没有选择任何文件"字样.*/
		            if (result == JFileChooser.APPROVE_OPTION)
		            {
		                file = fileChooser.getSelectedFile();
		                FileFilter ff = new FileFilter() {
			                
			                @Override
			                public boolean accept(File file) {
			                    // TODO Auto-generated method stub
			                    String s = file.getName().toLowerCase();			                    
			                    if(s.endsWith(".mp4")||s.endsWith(".mkv")||s.endsWith(".avi")||s.endsWith(".wmv")||s.endsWith(".rmvb")){
			                        return true;
			                    }			                    
			                    return false;
			                }
			            };
			            if(ff.accept(file)){
			              	urlTxt.setText("../upload/MV/"+file.getName());
							 f.dispose();  
						}
			            else{
			            	f.dispose();
			            	JOptionPane.showMessageDialog(null, "文件格式不正确！");
			            }
		            }
		            else if(result == JFileChooser.CANCEL_OPTION)
		            {
		                f.dispose();  
		            }
		     
				
			
			}
		});
		urlBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		
		urlTxt = new JTextField();
		urlTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		urlTxt.setColumns(10);
		
		JButton imageBtn = new JButton("\u5F71\u789F\u9884\u89C8");
		imageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				f = new JFrame("选择文件");
		        fileChooser = new JFileChooser("D:\\");//建立一个FileChooser对象,并指定D:的目录为默认文件对话框路径.
		        f.pack();
		        f.setVisible(true);

				 File file = null;
			     int result;
				 fileChooser.setApproveButtonText("确定");
		            fileChooser.setDialogTitle("打开文件");
		            result = fileChooser.showOpenDialog(f);
		            /*当用户按下打开文件对话框的"确定"钮后,我们就可以利用getSelectedFile()方法取得文件对象.若是用户按下打开文件对话框的"Cancel"钮,则将在label上显示"你没有选择任何文件"字样.*/
		            if (result == JFileChooser.APPROVE_OPTION)
		            {
		                file = fileChooser.getSelectedFile();
		                FileFilter ff = new FileFilter() {
			                
			                @Override
			                public boolean accept(File file) {
			                    // TODO Auto-generated method stub
			                    String s = file.getName().toLowerCase();			                    
			                    if(s.endsWith(".png")||s.endsWith(".jpg")||s.endsWith(".bmp")||s.endsWith(".gif")||s.endsWith(".wmf")){
			                        return true;
			                    }			                    
			                    return false;
			                }
			            };
			            if(ff.accept(file)){
			            	imageurlTxt.setText("upload/pic/"+file.getName());
							 f.dispose();  
						}
			            else{
			            	f.dispose();
			            	JOptionPane.showMessageDialog(null, "文件格式不正确！");
			            }
		            }
		            else if(result == JFileChooser.CANCEL_OPTION)
		            {
		                f.dispose();  
		            }
		     
				
			
			
			}
		});
		imageBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		
		imageurlTxt = new JTextField();
		imageurlTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		imageurlTxt.setColumns(10);
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
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(157)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(29)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(label_4)
											.addComponent(label_2))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(typeCbox, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addComponent(starTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(urlTxt, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(urlBtn)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(label_5)
											.addComponent(label_3)))
									.addGap(41)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(priceTxt, Alignment.LEADING)
											.addComponent(nownumTxt, Alignment.LEADING)))
									.addGap(71))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(imageBtn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(imageurlTxt, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(58))))
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
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(typeCbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(nownumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_4)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(starTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_5)
							.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(urlBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(urlTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(imageurlTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(imageBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(22))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				idTxt.setText(table.getValueAt(row, 0).toString());
				nameTxt.setText(table.getValueAt(row, 1).toString());
				VcdType t=(VcdType) table.getValueAt(row, 2);		
				int n=typeCbox.getItemCount();
				for(int i=0;i<n;i++){					
					if(t.getName().equals(((VcdType)typeCbox.getItemAt(i)).getName())){
							typeCbox.setSelectedIndex(i);
					}
				}
				nownumTxt.setText(table.getValueAt(row, 3).toString());
				starTxt.setText(table.getValueAt(row, 4).toString());
				priceTxt.setText(table.getValueAt(row, 5).toString());
				urlTxt.setText(table.getValueAt(row, 6).toString());
				imageurlTxt.setText(table.getValueAt(row, 7).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5F71\u789F\u7F16\u53F7", "\u5F71\u789F\u540D", "\u5F71\u789F\u7C7B\u522B", "\u73B0\u5B58\u6570\u91CF", "\u4E3B\u6F14", "\u5355\u4EF7", "\u5F71\u789F\u9884\u89C8", "\u5F71\u789F\u5C01\u9762"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillType();
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
	protected void fillType(){
		VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
		List<VcdType> list=service.query("");
		Iterator<VcdType> it=list.iterator();
		while(it.hasNext()){
			VcdType type=it.next();			
			typeCbox.addItem(type);

		}
	
	}
	protected void resetValue() {
		// TODO 自动生成的方法存根
		idTxt.setText("");
		nameTxt.setText("");
		typeCbox.setSelectedIndex(0);
		nownumTxt.setText("");
		starTxt.setText("");
		priceTxt.setText("");
		urlTxt.setText("");
		imageurlTxt.setText("");
	}
}
