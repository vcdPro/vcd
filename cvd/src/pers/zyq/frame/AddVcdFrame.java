package pers.zyq.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;
import pers.zyq.factory.BasicFactory;
import pers.zyq.service.VcdService;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddVcdFrame extends JInternalFrame {
	private JTextField nameTxt;
	private JComboBox typeCbox;
	private JTextField inNumTxt;
	private JTextField nowNumTxt;
	private JTextField starTxt;
	private JTextField priceTxt;
	private JTextField urlTxt;
	private JTextField imageurlTxt;
	private JFrame f;
	private JFileChooser fileChooser ;
	/**
	 * Create the frame.
	 */
	public AddVcdFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5F71\u789F\u5165\u5E93");
		setBounds(100, 100, 695, 408);
		
		JLabel label = new JLabel("\u5F71\u789F\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		nameTxt = new JTextField();
		nameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				String name=nameTxt.getText();
				Vcd vcd=new Vcd();
				vcd.setName(name);
				nowNumTxt.setText(String.valueOf(service.findVcd(vcd)));
				JOptionPane.showMessageDialog(null, "该影碟已存在，请前往更新！");
				resetValue();
			}
		});
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5F71\u789F\u7C7B\u522B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		typeCbox = new JComboBox();
		typeCbox.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("\u5165\u5E93\u6570\u91CF\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		inNumTxt = new JTextField();
		inNumTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		inNumTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u73B0\u5B58\u6570\u91CF\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		nowNumTxt = new JTextField();
		nowNumTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nowNumTxt.setColumns(10);
		nowNumTxt.setEditable(false);
		JLabel label_4 = new JLabel("\u4E3B\u6F14\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		starTxt = new JTextField();
		starTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4EF7\u683C\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JButton mvBtn = new JButton("\u89C6\u9891\u9884\u89C8\uFF1A");
		mvBtn.addActionListener(new ActionListener() {
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
		mvBtn.setBackground(Color.WHITE);
		mvBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		
		urlTxt = new JTextField();
		urlTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		urlTxt.setColumns(10);
		
		JButton imageBtn = new JButton("\u5C01\u9762\uFF1A");
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
			            	imageurlTxt.setText("../upload/pic/"+file.getName());
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
		imageurlTxt.setColumns(10);
		
		JButton addBtn = new JButton("\u6DFB\u52A0");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
				String name=nameTxt.getText();
				if(name.isEmpty()||"".equals(name)){
					JOptionPane.showMessageDialog(null, "影碟名不可为空！"); 
					nameTxt.requestFocus(true);
					return;
				}
				if(inNumTxt.getText().isEmpty()||"".equals(inNumTxt.getText())){
					JOptionPane.showMessageDialog(null, "进库数量不可为空！"); 
					inNumTxt.requestFocus(true);
					return;
				}
				if(priceTxt.getText().isEmpty()||"".equals(priceTxt.getText())){
					JOptionPane.showMessageDialog(null, "价格不可为空！"); 
					priceTxt.requestFocus(true);
					return;
				}
				VcdType type=(VcdType) typeCbox.getSelectedItem();
				int typeid=type.getId();
				int innum=Integer.parseInt(inNumTxt.getText());
				int nownum=Integer.parseInt(nowNumTxt.getText());
				String star=starTxt.getText();
				float price=Float.parseFloat(priceTxt.getText());
				String url=urlTxt.getText();
				String imageurl=imageurlTxt.getText();
				Vcd vcd=new Vcd( name, typeid, innum+nownum, star, price, url, imageurl);
				if(service.addVcd(vcd)>0){
					JOptionPane.showMessageDialog(null, "影碟已添加！");
					resetValue();
				}
				else{
					JOptionPane.showMessageDialog(null, "影碟添加失败！");
				}
			}
		});
		addBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, Alignment.TRAILING)
								.addComponent(label, Alignment.TRAILING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(inNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(label_4)
							.addGap(18)
							.addComponent(starTxt))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(mvBtn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(urlTxt, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(113)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(typeCbox, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(imageBtn)
										.addComponent(label_3))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(nowNumTxt)
										.addComponent(imageurlTxt)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(122)
							.addComponent(label_5)))
					.addContainerGap(90, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(312, Short.MAX_VALUE)
					.addComponent(addBtn)
					.addGap(304))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(typeCbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(inNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(nowNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(starTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mvBtn)
						.addComponent(urlTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(imageBtn)
						.addComponent(imageurlTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(addBtn)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillType();
	}

	protected void resetValue() {
		// TODO 自动生成的方法存根
		nameTxt.setText("");
		typeCbox.setSelectedIndex(0);
		inNumTxt.setText("");
		nowNumTxt.setText("");
		starTxt.setText("");
		priceTxt.setText("");
		urlTxt.setText("");
		imageurlTxt.setText("");
	}

	protected  void fillType(){
		VcdService service=BasicFactory.getFactory().getInstance(VcdService.class);
		List<VcdType> list=service.query("");
		Iterator<VcdType> it=list.iterator();
		while(it.hasNext()){
			VcdType type=it.next();
			typeCbox.addItem(type);

		}
	}
}
