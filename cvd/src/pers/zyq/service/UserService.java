package pers.zyq.service;

import pers.zyq.domain.Admin;

public interface UserService {
	/**
	 * 查询管理员用户名密码
	 * @param Name
	 * @return 
	 */
	public Admin findAdmin( String name);
}
