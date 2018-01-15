package pers.zyq.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pers.zyq.domain.Admin;
import pers.zyq.domain.User;
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

	public User findUser(User user) {
		String sql="select * from User_t where name=? or idcard=? ";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler<User>(User.class),user.getName(),user.getIdcard());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@Override
	public int UserReg(User user) {
		// TODO 自动生成的方法存根
		String sql="insert into User_t (name,sex,idcard,phone) values (?,?,?,?)";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql,user.getName(),user.getSex(),user.getIdcard(),user.getPhone());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> query(String condition) {
		// TODO 自动生成的方法存根
		String sql="select * from User_t where name like '%"+condition+"%' or idcard like '%"+condition+"%' or phone like'%"+condition+"%'";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int update(User user) {
		// TODO 自动生成的方法存根
		String sql="update User_t set password=? , phone=? where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql,user.getPassword(),user.getPhone(),user.getId());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int delUser(int id) {
		// TODO 自动生成的方法存根
		String sql="delete  from User_t where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql, id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public String getUserName(int userid) {
		// TODO 自动生成的方法存根
		String sql="select name from User_t where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return (String) runner.query(sql, new ScalarHandler(),userid);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	

}
