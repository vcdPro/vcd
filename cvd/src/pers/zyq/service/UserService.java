package pers.zyq.service;

import java.util.List;

import pers.zyq.domain.Admin;
import pers.zyq.domain.User;

public interface UserService {
	/**
	 * 查询管理员用户名密码
	 * @param Name
	 * @return 
	 */
	public Admin findAdmin( String name);

	public int UserReg(User user);

	public List<User> query(String condition);

	public int update(User user);

	public int delUser(int id);


}
