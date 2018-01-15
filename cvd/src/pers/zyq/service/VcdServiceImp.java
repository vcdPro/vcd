package pers.zyq.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import pers.zyq.dao.UserDao;
import pers.zyq.dao.VcdDao;
import pers.zyq.domain.Record;
import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;
import pers.zyq.factory.BasicFactory;

public class VcdServiceImp implements VcdService {
	private VcdDao dao=BasicFactory.getFactory().getInstance(VcdDao.class);
	public int addType(VcdType type) {
		if(dao.findType(type) != null){
			JOptionPane.showMessageDialog(null,"该类已存在");
		}else{
			return dao.addType(type);
		}
		return 0;
		
	}
	@Override
	public List<VcdType> query(String condition) {
		List<VcdType> list=dao.query(condition);
		if(list.size()==0){
			JOptionPane.showMessageDialog(null,"该查询条件下无内容");
			return list;
		}else{
			return list;
		}
	}
	@Override
	public int updateType(VcdType type) {
		// TODO 自动生成的方法存根
		if(dao.findType(type) != null){
			JOptionPane.showMessageDialog(null, "修改失败！该类已存在");
			return 0;
		}

		if(dao.updateType(type)==1){
			JOptionPane.showMessageDialog(null, "修改成功");
			return 1;
		}
		return 0;
			
	}
	@Override
	public int delType(int typeid) {
		// TODO 自动生成的方法存根
		List<Vcd> list=dao.findVcdByTypeId(typeid);
		if(list.size()!=0){
			JOptionPane.showMessageDialog(null, "该类下尚有影碟，不可删除！");
			return 0;
		}else{
			int n=JOptionPane.showConfirmDialog(null, "是否确认删除？");
			if(n==0){
			if(dao.delType(typeid)==1){
				JOptionPane.showMessageDialog(null, "删除成功！");
				return 1;
			}
			}
		}
		return 0;
	}
	@Override
	public int addVcd(Vcd vcd) {
		// TODO 自动生成的方法存根
		return dao.addVcd(vcd);
	}
	@Override
	public int findVcd(Vcd vcd) {
		// TODO 自动生成的方法存根
		vcd=dao.findVcd(vcd);
		if(vcd!=null)
			return vcd.getNownum();
		else return 0;
	}
	@Override
	public List queryVcd(String con) {
		// TODO 自动生成的方法存根
		List<Vcd> list=dao.queryVcd(con);
		if(list.size()==0){
			JOptionPane.showMessageDialog(null,"该查询条件下无内容");
			return list;
		}else{
			return list;
		}
	}
	@Override
	public VcdType getType(int id) {
		// TODO 自动生成的方法存根
		return dao.getType(id);
	}
	@Override
	public int updateVcd(Vcd vcd) {
		// TODO 自动生成的方法存根
		if(dao.findVcdByState(vcd.getId()).size()>0){
			JOptionPane.showMessageDialog(null, "影碟已借出，不可修改！");
			return 0;
		}
		return dao.updateVcd(vcd);
	}
	@Override
	public int delVcd(int vcdid) {
		// TODO 自动生成的方法存根
		if(dao.findVcdByState(vcdid).size()>0){
			JOptionPane.showMessageDialog(null, "影碟已借出，不可删除！");
			return 0;
		}
		return dao.delVcd(vcdid);		
	}
	@Override
	public int addRecord(Record record) {
		// TODO 自动生成的方法存根
		int num=dao.getNumById(record.getVcdid());
		if(num>0){
			dao.updateVcdNum(record);
			JOptionPane.showMessageDialog(null, "借阅成功！");
			return 1;
		}else{
			JOptionPane.showMessageDialog(null, "该影碟已全部借出！");
			return 0;
		}
	}
	@Override
	public List queryRecord(int id) {
		// TODO 自动生成的方法存根
		Record record=dao.queryVcd(id);
		UserDao udao=BasicFactory.getFactory().getInstance(UserDao.class);
		if(record==null){
			JOptionPane.showMessageDialog(null, "发票号错误！");
			return null;
		}
		String username=udao.getUserName(record.getUserid());
		String vcdname=dao.getVcdName(record.getVcdid());
		List list=new ArrayList();
		list.add(record.getId());
		list.add(username);
		list.add(vcdname);
		list.add(record.getRentprice());
		list.add(record.getDepositprice());
		list.add(record.getRentdate());
		list.add(record.getReturndate());
		return list;
	}
	@Override
	public void updateRecord(int id, String name) {
		// TODO 自动生成的方法存根
		dao.updateRecord(id,name);
		
	}
}
