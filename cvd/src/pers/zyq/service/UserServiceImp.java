package pers.zyq.service;

import pers.zyq.dao.UserDao;
import pers.zyq.domain.User;
import pers.zyq.factory.BasicFactory;

public class UserServiceImp implements UserService {

	public User findUser(String name) {
		// TODO 自动生成的方法存根
		UserDao dao=BasicFactory.getFactory().getInstance(UserDao.class);
		return dao.findUser(name);
		
	}

}
