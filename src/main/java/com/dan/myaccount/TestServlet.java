package com.dan.myaccount;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/login")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 

    public void init() {

          System.out.println("from httpservlet init...");

    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          String userName = request.getParameter("username");

          String password = request.getParameter("password");
          
          PrintWriter out = response.getWriter();
          
          try {
        	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
        	  PreparedStatement pstmt = conn.prepareStatement("Select & from user where user_name = ? and password = ?");
        	  pstmt.setString(1, userName);
        	  pstmt.setString(2, password);
        	  ResultSet rs = pstmt.executeQuery();
        	  if (rs.next()) {
        		  out.println("Welcome!");
        	  } else {
        		  out.println("Account not found");
        	  }
    	  } catch (SQLException e){
    		  e.printStackTrace();
    	  }

          response.setContentType("text/html");

          

    }

}
