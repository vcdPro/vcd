package pers.zyq.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {

	private static DataSource source=new ComboPooledDataSource();
	private DbUtil(){
		
	}
	public static DataSource getSource(){
		return source;
	}
	public static Connection getConn(){
		try {
			return source.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
