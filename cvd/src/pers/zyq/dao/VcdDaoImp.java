package pers.zyq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pers.zyq.domain.Record;
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


	public List<Vcd> findVcdByTypeId(int typeid) {
		// TODO 自动生成的方法存根
		String sql="select * from VCD_t where typeid =?";
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

	@Override
	public Vcd findVcd(Vcd vcd) {
		// TODO 自动生成的方法存根
		String sql="select * from Vcd_t where name=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler<Vcd>(Vcd.class),vcd.getName());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int updateVcd(Vcd vcd) {
		// TODO 自动生成的方法存根
		String sql="update VCD_t set name=? , typeid=? , nownum=? , star=? , price=? , url=? , imageurl=? where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql, vcd.getName(),vcd.getTypeid(),vcd.getNownum(),vcd.getStar(),vcd.getPrice(),vcd.getUrl(),vcd.getImageurl(),vcd.getId());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int addVcd(Vcd vcd) {
		// TODO 自动生成的方法存根
		String sql="insert into Vcd_t (name, typeid, nownum, star, price, url, imageurl) values (?,?,?,?,?,?,?)";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.update(sql, vcd.getName(),vcd.getTypeid(),vcd.getNownum(),vcd.getStar(),vcd.getPrice(),vcd.getUrl(),vcd.getImageurl());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Vcd> queryVcd(String con) {
		// TODO 自动生成的方法存根
		String sql="select * from VCD_t where name like '%"+con+"%'"+" or star like '%"+con+"%'";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanListHandler<Vcd>(Vcd.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public VcdType getType(int id) {
		// TODO 自动生成的方法存根
		String sql="select * from Type_t where id =? ";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler <VcdType>(VcdType.class),id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Record> findVcdByState(int id) {
		// TODO 自动生成的方法存根
		String sql="select * from Record_t where vcdid=? and state=1";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanListHandler<Record>(Record.class),id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int delVcd(int id) {
		// TODO 自动生成的方法存根
		String sql="delete from VCD_t where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
	 	try {
			return runner.update(sql,id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int getNumById(int vcdid) {
		// TODO 自动生成的方法存根
		String sql="select nownum from VCD_t where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return (Integer) runner.query(sql, new ScalarHandler(),vcdid);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void updateVcdNum(Record record) {
		// TODO 自动生成的方法存根
		String sql="update VCD_t set nownum=nownum-1 where id=?";
		//数据库设置state默认值为1
		String sql1="insert into Record_t (userid, vcdid, rentdate, returndate, rentprice, depositprice) values (?,?,?,?,?,?)";
		Connection conn=DbUtil.getConn();
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			conn.setAutoCommit(false);
			runner.update(conn, sql, record.getVcdid());
			runner.update(conn, sql1, record.getUserid(),record.getVcdid(),record.getRentdate(),record.getReturndate(),record.getRentprice(),record.getDepositprice());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			if(conn!=null){
				try {
					conn.rollback();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.commit();
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
		
	}

	@Override
	public Record queryVcd(int id) {
		// TODO 自动生成的方法存根
		String sql="select * from Record_t where id=? and state=1";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return runner.query(sql, new BeanHandler<Record>(Record.class),id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public String getVcdName(int vcdid) {
		// TODO 自动生成的方法存根
		String sql="select name from VCD_t where id=?";
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			return (String) runner.query(sql, new ScalarHandler(),vcdid);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void updateRecord(int id, String name) {
		// TODO 自动生成的方法存根
		String sql="update Record_t set state=0 ,rentprice=0,depositprice=0,returndate=GETDATE() where id=?";
		String sql1="update VCD_t set nownum=nownum+1 where name=?";
		Connection conn=DbUtil.getConn();
		QueryRunner runner=new QueryRunner(DbUtil.getSource());
		try {
			conn.setAutoCommit(false);
			runner.update(conn, sql, id);
			runner.update(conn, sql1, name);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		}finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
