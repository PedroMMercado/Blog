package com.noobcoder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noobcoder.model.Blog;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Blog blog) {
		String query = "insert into blog (blogname,username,title,content) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, blog.getBlogname());
			ps.setString(2, blog.getUsername());
			ps.setString(3, blog.getTitle());
			ps.setString(4, blog.getContent());
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

	public void update(Blog blog) {
		String query = "update blog set title = ?, content = ? where id = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, blog.getTitle());
			ps.setString(2, blog.getContent());
			ps.setInt(3, blog.getId());
			ps.executeUpdate();
		}catch(SQLException e){
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


	public void delete(Blog blog) {
		String query = "delete blog where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, blog.getId());
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

	public String getBlogName(String username) {
		String query = "SELECT blogdomain FROM users WHERE username = '" + username + "'"; 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery(query);
			if(rs.next())
				return rs.getString("blogdomain");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Blog> getAll(int pageNumber) {
		String id = "id";
		String query = "select * from blog order by " + id   + " desc limit 6 offset " + pageNumber;
		List<Blog> blogList = new ArrayList<Blog>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
            	Blog blog = new Blog();
            	blog.setId(rs.getInt("id"));
            	blog.setBlogname(rs.getString("blogname"));
                blog.setUsername(rs.getString("username"));
                blog.setTitle(rs.getString("title"));
                blog.setContent(rs.getString("content"));   	
                blogList.add(blog);
            }
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        finally{
        	try{
        		con.close();
        		rs.close();
        		ps.close();
        	}
        	catch(SQLException e){
        		e.printStackTrace();
        	}
        }
		return blogList;
	}

	public List<Blog> getAllUser(String blogname) {
		String query = "select * from blog where blogname = '" + blogname + "'";
		List<Blog> blogList = new ArrayList<Blog>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Blog blog = new Blog();
				blog.setBlogname(rs.getString("blogname"));
				blog.setUsername(rs.getString("username"));
				blog.setContent(rs.getString("content"));
				blog.setTitle(rs.getString("title"));
				blogList.add(blog);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
				rs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return blogList;
	}

	public List<Blog> getByID(int id) {
		String query = "select content, title from blog where id =" + id;
		List<Blog> blogList = new ArrayList<Blog>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Blog blog = new Blog();
				blog.setContent(rs.getString("content"));
				blog.setTitle(rs.getString("title"));
				blogList.add(blog);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
				rs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return blogList;
	}
}



