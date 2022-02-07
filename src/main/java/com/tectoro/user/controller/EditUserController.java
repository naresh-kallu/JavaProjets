package com.tectoro.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/edit")
public class EditUserController extends HttpServlet{
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
		default :editUser(request,response);
		break;
		}
		
	}
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt("id");
		UserModel user=userDao.selectUser(id);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		
	}

}
