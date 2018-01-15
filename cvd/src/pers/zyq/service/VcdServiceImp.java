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
		List<Vcd> list=dao.findVcdByTypeId(typeid);
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
	@Override
	public int addVcd(Vcd vcd) {
		// TODO �Զ����ɵķ������
		return dao.addVcd(vcd);
	}
	@Override
	public int findVcd(Vcd vcd) {
		// TODO �Զ����ɵķ������
		vcd=dao.findVcd(vcd);
		if(vcd!=null)
			return vcd.getNownum();
		else return 0;
	}
	@Override
	public List queryVcd(String con) {
		// TODO �Զ����ɵķ������
		List<Vcd> list=dao.queryVcd(con);
		if(list.size()==0){
			JOptionPane.showMessageDialog(null,"�ò�ѯ������������");
			return list;
		}else{
			return list;
		}
	}
	@Override
	public VcdType getType(int id) {
		// TODO �Զ����ɵķ������
		return dao.getType(id);
	}
	@Override
	public int updateVcd(Vcd vcd) {
		// TODO �Զ����ɵķ������
		if(dao.findVcdByState(vcd.getId()).size()>0){
			JOptionPane.showMessageDialog(null, "Ӱ���ѽ���������޸ģ�");
			return 0;
		}
		return dao.updateVcd(vcd);
	}
	@Override
	public int delVcd(int vcdid) {
		// TODO �Զ����ɵķ������
		if(dao.findVcdByState(vcdid).size()>0){
			JOptionPane.showMessageDialog(null, "Ӱ���ѽ��������ɾ����");
			return 0;
		}
		return dao.delVcd(vcdid);		
	}
	@Override
	public int addRecord(Record record) {
		// TODO �Զ����ɵķ������
		int num=dao.getNumById(record.getVcdid());
		if(num>0){
			dao.updateVcdNum(record);
			JOptionPane.showMessageDialog(null, "���ĳɹ���");
			return 1;
		}else{
			JOptionPane.showMessageDialog(null, "��Ӱ����ȫ�������");
			return 0;
		}
	}
	@Override
	public List queryRecord(int id) {
		// TODO �Զ����ɵķ������
		Record record=dao.queryVcd(id);
		UserDao udao=BasicFactory.getFactory().getInstance(UserDao.class);
		if(record==null){
			JOptionPane.showMessageDialog(null, "��Ʊ�Ŵ���");
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
		// TODO �Զ����ɵķ������
		dao.updateRecord(id,name);
		
	}
}
