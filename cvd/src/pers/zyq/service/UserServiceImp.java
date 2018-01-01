package pers.zyq.service;

import javax.swing.JOptionPane;

import pers.zyq.dao.UserDao;
import pers.zyq.domain.Admin;
import pers.zyq.domain.User;
import pers.zyq.factory.BasicFactory;

public class UserServiceImp implements UserService {

	public Admin findAdmin(String name) {
		// TODO �Զ����ɵķ������
		UserDao dao=BasicFactory.getFactory().getInstance(UserDao.class);
		Admin admin=dao.findAdmin(name);
		if(admin.getName().equals(name)){
			return admin;
		}
		return null;
		
	}

	/**
	 * �û�ע��
	 */
	public int UserReg(User user) {
		// TODO �Զ����ɵķ������
		UserDao dao=BasicFactory.getFactory().getInstance(UserDao.class);
		User user1=dao.findUser();
		if(!user.getName().equals(user1.getName())&&!user.getIdcard().equals(user1.getIdcard())){
		System.out.println(user.getName()+" "+user1.getName());
			return dao.UserReg(user);
		}
		if(user.getName().equals(user1.getName())){
			JOptionPane.showMessageDialog(null, "���û���ע��");
			return -1;
		}
		if(user.getIdcard().equals(user1.getIdcard())){
			JOptionPane.showMessageDialog(null, "�����֤����ע��");
			return -1;
		}
		return 0;
	}

}
