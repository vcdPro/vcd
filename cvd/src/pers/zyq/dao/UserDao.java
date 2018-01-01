package pers.zyq.dao;

import pers.zyq.domain.Admin;
import pers.zyq.domain.User;

public interface UserDao {

	public Admin findAdmin(String name);

	public int UserReg(User user);
	public User findUser();
}
