package pers.zyq.service;

import pers.zyq.domain.Admin;
import pers.zyq.domain.User;

public interface UserService {
	/**
	 * ��ѯ����Ա�û�������
	 * @param Name
	 * @return 
	 */
	public Admin findAdmin( String name);

	public int UserReg(User user);
}
