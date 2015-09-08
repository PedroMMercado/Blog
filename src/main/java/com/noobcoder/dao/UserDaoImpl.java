package com.noobcoder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.noobcoder.model.Blog;
import com.noobcoder.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private DataSource dataSource;
		
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	public void createUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(user.getPassword());
		String createQuery = "insert into users (username,password,enabled,blogdomain) values (?,?,?,?)";
		String roleQuery = "insert into authorities(username,authority) values(?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			//create
			ps = con.prepareStatement(createQuery);
			ps.setString(1,user.getUserName());
			ps.setString(2, password);
			ps.setBoolean(3, true);
			ps.setString(4, user.getUserDomain());
			ps.executeUpdate();
			
			//Upon account creation users default is of type User_Role
			ps = con.prepareStatement(roleQuery);
			ps.setString(1, user.getUserName());
			ps.setString(2, "ROLE_USER");
			ps.executeUpdate();			
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
				ps.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public List<User> getAll() {
		String query = "select * from users";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserName(rs.getString("username"));
				user.setUserDomain(rs.getString("blogdomain"));
				user.setEnabled(rs.getBoolean("enabled"));
				userList.add(user);
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return userList;
	}

	public void delete(User user) {
		String query = "delete users where username = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

}
