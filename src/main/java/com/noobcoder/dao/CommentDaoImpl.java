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

import com.noobcoder.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private DataSource dataSource;

	public List<Comment> getComments(int id) {
		String query = "select * from comments where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Comment> list = new ArrayList<Comment>();
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setUsername(rs.getString("username"));
				comment.setCid(rs.getInt("cid"));
				comment.setComment(rs.getString("comment"));
				comment.setDate(rs.getDate("date"));
				comment.setId(rs.getInt("id"));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void create(Comment comment) {
		String query = "insert into comments (comment,username,date,id) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, comment.getComment());
			ps.setString(2, comment.getUsername());
			ps.setDate(3, new java.sql.Date(comment.getDate().getTime()));
			ps.setInt(4, comment.getId());
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
