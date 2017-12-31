package pers.zyq.dao;

import pers.zyq.domain.Admin;

public interface UserDao {

	public Admin findAdmin(String name);
}
