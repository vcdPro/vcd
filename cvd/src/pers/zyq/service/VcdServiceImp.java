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
			JOptionPane.showMessageDialog(null,"�����Ѵ���");
		}else{
			return dao.addType(type);
		}
		return 0;
		
	}
	@Override
	public List<VcdType> query(String condition) {
		List<VcdType> list=dao.query(condition);
		if(list.size()==0){
			JOptionPane.showMessageDialog(null,"�ò�ѯ������������");
			return list;
		}else{
			return list;
		}
	}
	@Override
	public int updateType(VcdType type) {
		// TODO �Զ����ɵķ������
		if(dao.findType(type) != null){
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ������Ѵ���");
			return 0;
		}

		if(dao.updateType(type)==1){
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			return 1;
		}
		return 0;
			
	}
	@Override
	public int delType(int typeid) {
		// TODO �Զ����ɵķ������
		List<Vcd> list=dao.findVcd(typeid);
		if(list.size()!=0){
			JOptionPane.showMessageDialog(null, "����������Ӱ��������ɾ����");
			return 0;
		}else{
			int n=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ����");
			if(n==0){
			if(dao.delType(typeid)==1){
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				return 1;
			}
			}
		}
		return 0;
	}
}
