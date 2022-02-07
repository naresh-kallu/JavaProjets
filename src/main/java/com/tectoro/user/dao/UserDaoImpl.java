package com.tectoro.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tectoro.user.config.*;
import com.tectoro.user.model.UserModel;

@Service
public class UserDaoImpl implements UserDao {
	
	PreparedStatement preparedStatement=null;
	private static final String INSERT_USERS_SQL = "INSERT INTO user_model" + "  (fname,lname, email,contact,username,password) VALUES " + " (?, ?,?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id,fname,lname,email,contact,username,password from user_model where id =?";
	private static final String SELECT_ALL_USERS = "select * from user_model";
	private static final String DELETE_USERS_SQL = "delete from user_model where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user_model set fname = ?,lname = ?,email= ?,contact=?, username=? , password =? where id = ?;";

	public UserDaoImpl(){
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void insertUser(UserModel userModel){
		try {
			UserDb db=new UserDb();
			preparedStatement=db.userDb().prepareStatement(INSERT_USERS_SQL);
			//preparedStatement.setLong(1, userModel.getUid());
			preparedStatement.setString(1, userModel.getFname());
			preparedStatement.setString(2, userModel.getLname());
			preparedStatement.setString(3, userModel.getEmail());
			preparedStatement.setString(4, userModel.getContact());
			preparedStatement.setString(5, userModel.getUsername());
			preparedStatement.setString(6, userModel.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	@SuppressWarnings("static-access")
	@Override
	public UserModel selectUser(int id) {
		UserModel userModel=null;
		try {
			UserDb userdb=new UserDb();
			preparedStatement=userdb.userDb().prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
			
				// int id1=rs.getInt("id");  
				// long uid=rs.getLong("uid");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");
				String contact = rs.getString("contact");
				String username = rs.getString("username");
				String password = rs.getString("password");
				userModel = new UserModel(id, fname,lname, email, contact,username,password);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return userModel;
	}

	@SuppressWarnings("static-access")
	@Override
	public List<UserModel> selectAllUsers() {
		List<UserModel> userModels=new ArrayList<>();
		try {
			UserDb userdb=new UserDb();
			preparedStatement=userdb.userDb().prepareStatement(SELECT_ALL_USERS);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				//long uid=rs.getLong("uid");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");
				String contact = rs.getString("contact");
				String username = rs.getString("username");
				String password = rs.getString("password");
				userModels.add(new UserModel(id, fname,lname, email, contact,username,password));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return userModels;
	}

	@Override
	public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		UserDb userdb=new UserDb();
		try (@SuppressWarnings("static-access")
		Connection connection =userdb.userDb();
		PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		
		}
			
			
		
		return rowDeleted;
	}

	@Override
	public boolean updateUser(UserModel userModel) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		UserDb userdb=new UserDb();
		try (@SuppressWarnings("static-access")
		Connection connection =userdb.userDb();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			//statement.setLong(1, userModel.getUid());
			statement.setString(1, userModel.getFname());
			statement.setString(2, userModel.getLname());	
			statement.setString(3, userModel.getEmail());
			statement.setString(4, userModel.getContact());
			statement.setString(5, userModel.getUsername());
			statement.setString(6, userModel.getPassword());
			statement.setInt(7, userModel.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
		
		//return false;
	}
	
	
	
	
	
}
