package com.tectoro.user.controller;

import java.io.IOException;

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

@WebServlet(urlPatterns="/insert")
public class InsertUserController extends HttpServlet {
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
			default:insertUser(request,response);
			break;
			}
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("insert data");
		
		//long uid=Long.parseLong(request.getParameter("uid"));	
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserModel userModel = new UserModel(fname,lname ,email, contact,username,password);
		userDao.insertUser(userModel);
		//response.sendRedirect("list");
		System.out.println("insert data");
		
		
	}
		
	

}
