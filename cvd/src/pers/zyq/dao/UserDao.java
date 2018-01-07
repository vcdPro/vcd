package pers.zyq.dao;

import java.util.List;

import pers.zyq.domain.Admin;
import pers.zyq.domain.User;

public interface UserDao {

	public Admin findAdmin(String name);

	public int UserReg(User user);
	public User findUser(User user);

	public List<User> query(String condition);

	public int update(User user);

	public int delUser(int id);

}
