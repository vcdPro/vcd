package pers.zyq.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.zyq.domain.Admin;
import pers.zyq.util.DbUtil;

public class UserDaoImp implements UserDao {

	/**
	 * 查找管理员的用户名密码
	 */
	public Admin findAdmin(String name) {

		String sql="select * from Admin_t where name=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler<Admin>(Admin.class),name);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
