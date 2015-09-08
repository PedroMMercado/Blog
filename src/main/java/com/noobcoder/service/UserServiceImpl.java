package com.noobcoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noobcoder.dao.UserDao;
import com.noobcoder.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	@Transactional
	public void create(User user) {
		userDao.createUser(user);
	}
	public List<User> getAll() {
		return userDao.getAll();
	}
	@Transactional
	public void delete(User user) {
		userDao.delete(user);
		
	}
}

/*
@Override
public List<Employee> getAll() {
   String query = "select id, name, role from Employee";
   List<Employee> empList = new ArrayList<Employee>();
   Connection con = null;
   PreparedStatement ps = null;
   ResultSet rs = null;
   try{
       con = dataSource.getConnection();
       ps = con.prepareStatement(query);
       rs = ps.executeQuery();
       while(rs.next()){
           Employee emp = new Employee();
           emp.setId(rs.getInt("id"));
           emp.setName(rs.getString("name"));
           emp.setRole(rs.getString("role"));
           empList.add(emp);
       }
   }catch(SQLException e){
       e.printStackTrace();
   }finally{
       try {
           rs.close();
           ps.close();
           con.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   return empList;
}
*/
