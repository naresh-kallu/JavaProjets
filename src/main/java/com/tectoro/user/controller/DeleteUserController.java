package com.tectoro.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/delete")
public class DeleteUserController extends HttpServlet {
	@SuppressWarnings("unused")
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
		default : try {
				deleteUser(request,response);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		}
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		System.out.println("Hello");
		PrintWriter out = response.getWriter(); 
		
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		//response.sendRedirect("list");
		UserModel model=new UserModel();
		out.print("Delete successfull::");
		out.print("Delete successfull::"+id+" "+model.getFname()+" "+model.getLname()+" "+model.getEmail()+" "+model.getContact());
		
	}

}
