package pers.zyq.service;

import pers.zyq.domain.User;

public interface UserService {
	/**
	 * 查询用户名密码
	 * @param userName
	 * @param password
	 * @return 
	 */
	public User findUser( String name);
}
