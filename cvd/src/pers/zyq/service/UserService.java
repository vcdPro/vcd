package pers.zyq.service;

import pers.zyq.domain.User;

public interface UserService {
	/**
	 * ��ѯ�û�������
	 * @param userName
	 * @param password
	 * @return 
	 */
	public User findUser( String name);
}
