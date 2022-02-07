package com.tectoro.user.dao;
import java.sql.SQLException;
import java.util.List;

import com.tectoro.user.model.*;

public interface UserDao {
	public void insertUser(UserModel userModel);
	public UserModel selectUser(int id);
	public List<UserModel> selectAllUsers();
	public boolean deleteUser(int id) throws SQLException, ClassNotFoundException;
	public boolean updateUser(UserModel userModel) throws SQLException, ClassNotFoundException;

}
