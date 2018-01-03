package pers.zyq.dao;

import java.lang.reflect.Type;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.zyq.util.DbUtil;

public class VcdDaoImp implements VcdDao {

	@Override
	public Type findType(String typename) {
		// TODO 自动生成的方法存根
		String sql="select * from Type_t where name=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler <Type>(Type.class),typename);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addType(String name, String description) {
		// TODO 自动生成的方法存根
		String sql="insert into Type_t values (?,?)";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql, name,description);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
