package pers.zyq.dao;

import pers.zyq.domain.User;

public interface UserDao {

	public User findUser(String name);
}
