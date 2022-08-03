package com.dan.myaccount;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

 

@WebServlet("/registration")
public class Registration extends HttpServlet {

 
              public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

                            ArrayList<String> resultSet = new ArrayList<>(); 
            	  			String userName = request.getParameter("username");
                             String gender = request.getParameter("gender");

                             String[] courses = request.getParameterValues("language");
                             String selCourse = "";
                             for (String course : courses) {
                                           selCourse = selCourse + course + " ";
                             }

                             resultSet.add(userName + " " + gender + " " + selCourse);
                             PrintWriter out = response.getWriter();
                             for (String student : resultSet) {
                            	 out.println(student);
                             }
                             

              }

}
