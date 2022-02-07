package com.tectoro.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.tectoro.user.dao.UserDao;
import com.tectoro.user.dao.UserDaoImpl;
import com.tectoro.user.model.*;


//@WebServlet(name="Servlet",urlPatterns = "/UserController")
@WebServlet( urlPatterns = "/UserController")
public class UserController extends HttpServlet {
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
		try {
			switch(action) {
			case "/newUser" : showNewForm(request,response);
			break;
			case "/insertUser" :insertUser(request,response);	
			break;
			case "/editUser":editUser(request,response);
			break;
			case "/updateUser":try {
					updateUser(request,response);
				} catch (ClassNotFoundException | SQLException | IOException e) {
					
					e.printStackTrace();
				}
			break;
			case "/deleteUser":try {
					deleteUser(request,response);
				} catch (ClassNotFoundException | SQLException | IOException e) {
					
					e.printStackTrace();
				}
			break;
			default:listUsers(request,response);
			break;
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			     
		
		
	}
	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
       System.out.println("list user");
       PrintWriter out = response.getWriter(); 
       out.println("Hello");
       response.setContentType("text/html");
       
		
		List<UserModel> userslist=userDao.selectAllUsers();
		request.setAttribute("userslist", userslist);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Home.html");
		//dispatcher.forward(request, response);
		out.println("Data::::");
		for(UserModel list:userslist) {
			out.println(list.getId()+" "+list.getFname()+" "+list.getLname()+" "+list.getEmail()+" "+list.getContact());
			out.println("<br />");
			
		}
		out.println("<a href='/new'>New User</a>");
		
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
		
		
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
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt("id");
		UserModel user=userDao.selectUser(id);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		
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
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello new user");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.html");
		dispatcher.forward(request, response);
		
	}

}
