package pers.zyq.service;

import pers.zyq.domain.Admin;

public interface UserService {
	/**
	 * ��ѯ����Ա�û�������
	 * @param Name
	 * @return 
	 */
	public Admin findAdmin( String name);
}
