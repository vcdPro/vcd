package pers.zyq.service;

import java.util.List;

import javax.swing.JOptionPane;

import pers.zyq.dao.VcdDao;
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
		List<Vcd> list=dao.findVcdById(typeid);
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
		Vcd vcd1=dao.findVcd(vcd);
		if(vcd1!=null){
			int n=JOptionPane.showConfirmDialog(null, "该影碟已存在，是否确认修改信息？");
			if(n==0){
				vcd.setId(vcd1.getId());
			return dao.updateVcd(vcd);
			}
		}
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
}
