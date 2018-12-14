package com.kosmo.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inputTagServlet
 */
@WebServlet("/input_tag_2")
public class inputTagServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public inputTagServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		
		
		request.getRequestDispatcher("/input_tag_result2.jsp").forward(request, response);
		
		//response.sendRedirect("/input_tag_result.jsp?uid="+uid+"&upw="+upw);
	}

}
