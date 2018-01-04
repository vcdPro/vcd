package pers.zyq.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;
import pers.zyq.util.DbUtil;

public class VcdDaoImp implements VcdDao {

	@Override
	public VcdType findType(VcdType type) {
		// TODO 自动生成的方法存根
		String sql="select * from Type_t where id !=? and name=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler <VcdType>(VcdType.class),type.getId(),type.getName());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addType(VcdType type) {
		// TODO 自动生成的方法存根
		String sql="insert into Type_t (name,description) values (?,?)";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql, type.getName(),type.getDescription());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<VcdType> query(String condition) {
		// TODO 自动生成的方法存根
		String sql="select * from Type_t where id like '%"+condition+"%'"+"or name like '%"+condition+"%'"+"or description like '%"+condition+"%'";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanListHandler<VcdType>(VcdType.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateType(VcdType type) {
		// TODO 自动生成的方法存根
		String sql="update Type_t set name=? , description=? where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql, type.getName(),type.getDescription(),type.getId());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public List<Vcd> findVcd(int typeid) {
		// TODO 自动生成的方法存根
		String sql="select * from VCD_t where id =?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanListHandler<Vcd>(Vcd.class),typeid);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}

	@Override
	public int delType(int id) {
		// TODO 自动生成的方法存根
		String sql="delete from Type_t where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql, id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
