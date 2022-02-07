package com.tectoro.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tectoro.user.dao.UserDao;
import com.tectoro.user.dao.UserDaoImpl;
import com.tectoro.user.model.UserModel;
@WebServlet("/update")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDao userDao;
    
	public void init(ServletConfig config) throws ServletException {
		userDao = new UserDaoImpl();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Hello");
		
		String action=request.getServletPath();
		switch(action) {
		default :try {
				updateUser(request,response);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		}
		
	}

	
	
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//long uid=Integer.parseInt("uid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserModel user = new UserModel(id, fname,lname, email,  contact, username,password);
		userDao.updateUser(user);
		response.sendRedirect("list");
		
		
	}

}
