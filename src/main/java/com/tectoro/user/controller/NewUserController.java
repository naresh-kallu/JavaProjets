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

@WebServlet(urlPatterns="/new")
public class NewUserController extends HttpServlet{
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
			default: showNewForm(request,response);
			break;
			}
	
	
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello new user");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.html");
		dispatcher.forward(request, response);
		
	}

}
