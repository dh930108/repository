package com.kosmo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/abc")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("get call..");
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		System.out.println(uid + "," + upw);
		response.getWriter().append("전송값:"+uid).append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("post call..");
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		System.out.println(uid + "," + upw);
		response.getWriter().append("전송값:"+uid).append(request.getContextPath());
		//doGet(request, response);
	}

}
