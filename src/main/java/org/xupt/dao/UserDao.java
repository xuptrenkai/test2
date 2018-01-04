package org.xupt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.xupt.bean.User;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDao {

	public String findpass(User user) throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		String sql = "select pass from user where name=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, user.getName());
		ResultSet resultSet = stat.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString(1);
		}
		ds.close();
		return password;
	}

	public void add(User user) throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		String sql = "insert into user values(?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, user.getName());
		stat.setString(2, user.getPass());
		stat.execute();
	}

}
