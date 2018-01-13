package pers.zyq.service;

import java.util.List;

import javax.swing.JOptionPane;

import pers.zyq.dao.UserDao;
import pers.zyq.domain.Admin;
import pers.zyq.domain.User;
import pers.zyq.factory.BasicFactory;

public class UserServiceImp implements UserService {
	private UserDao dao=BasicFactory.getFactory().getInstance(UserDao.class);
	public Admin findAdmin(String name) {
		// TODO 自动生成的方法存根
		Admin admin=dao.findAdmin(name);
		if(admin!=null&&admin.getName().equals(name)){
			return admin;
		}
		return null;
		
	}

	/**
	 * 用户注册
	 */
	public int UserReg(User user) {
		// TODO 自动生成的方法存根
		UserDao dao=BasicFactory.getFactory().getInstance(UserDao.class);
		User user1=dao.findUser(user);
		if(dao.findUser(user) != null){
			if(user.getName().equals(user1.getName())){
			JOptionPane.showMessageDialog(null, "该用户名已注册");
			return -1;
			}
			if(user.getIdcard().equals(user1.getIdcard())){
				JOptionPane.showMessageDialog(null, "该身份证号已注册");
				return -1;
			}
			
		}
		else return dao.UserReg(user);
		return 0;
		
	
	}

	@Override
	public List<User> query(String condition) {
		List<User> list=dao.query(condition);
		if(list.size()==0){
			JOptionPane.showMessageDialog(null, "该查询条件下无内容");
			return list;
		}
		return list;
	}

	@Override
	public int update(User user) {
		// TODO 自动生成的方法存根
		return dao.update(user);
	}

	@Override
	public int delUser(int id) {
		// TODO 自动生成的方法存根
			return dao.delUser(id);
	}

	@Override
	public int findUser(User user) {
		// TODO 自动生成的方法存根
		User user1=dao.findUser(user);
		if(user1 == null){
			JOptionPane.showMessageDialog(null, "该用户名尚未注册，请前往注册！");
			return 0;
			}
		return user1.getId();
	}


}
