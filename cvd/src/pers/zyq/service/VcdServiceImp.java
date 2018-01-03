package pers.zyq.service;

import javax.swing.JOptionPane;

import pers.zyq.dao.VcdDao;
import pers.zyq.factory.BasicFactory;

public class VcdServiceImp implements VcdService {
	private VcdDao dao=BasicFactory.getFactory().getInstance(VcdDao.class);
	public int addType(String typename, String desc) {
		if(dao.findType(typename) != null){
			JOptionPane.showMessageDialog(null,"该类已存在");
		}else{
			return dao.addType(typename,desc);
		}
		return 0;
		
	}
}
