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
@WebServlet("/input_tag")
public class inputTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public inputTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String uid;
		String upw;
		String habit;
		String gen;
		String ucid;
		String ufile;
		String tel;
		String content;
		System.out.println("post call..");
		uid = request.getParameter("uid");
		upw = request.getParameter("upw");
		habit = request.getParameter("habit");
		gen = request.getParameter("gen");
		ucid = request.getParameter("ucid");
		ufile = request.getParameter("ufile");
		tel = request.getParameter("tel");
		content = request.getParameter("content");
		response.getWriter().append("uid : " + uid + "<br>");
		response.getWriter().append("upw : " + upw +"<br>");
		response.getWriter().append("habit : " + habit +"<br>");
		response.getWriter().append("gen : " + gen +"<br>");
		response.getWriter().append("ucid : " + ucid +"<br>");
		response.getWriter().append("ufile : " + ufile +"<br>");
		response.getWriter().append("tel : " + tel +"<br>");
		response.getWriter().append("content : " + content);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String uid;
		String upw;
		String[] habit;
		String gen;
		String ucid;
		String ufile;
		String tel;
		String content;
		System.out.println("post call..");
		uid = request.getParameter("uid");
		upw = request.getParameter("upw");
		habit = request.getParameterValues("habit");
		gen = request.getParameter("gen");
		ucid = request.getParameter("ucid");
		ufile = request.getParameter("ufile");
		tel = request.getParameter("tel");
		content = request.getParameter("content");
		
//		File file = new File(request.getParameter("ufile"));
//		BufferedImage image = ImageIO.read(file);
//		ImageIO.write(image, "PNG", response.getOutputStream());
		
		response.getWriter().append("uid : " + uid + "<br>");
		response.getWriter().append("upw : " + upw +"<br>");
		response.getWriter().append("habit : " + habit +"<br>");
		response.getWriter().append("gen : " + gen +"<br>");
		response.getWriter().append("ucid : " + ucid +"<br>");
		response.getWriter().append("ufile : " + ufile +"<br>");
		response.getWriter().append("tel : " + tel +"<br>");
		response.getWriter().append("content : " + content);
		
		//PrintWriter out = response.getWriter();
		//out.write("<font>dbdbdbdb");
		
		ArrayList<String> mlist = new ArrayList<String>();
		mlist.add("아무개");
		mlist.add("홍길동");
		ArrayList<String> clist = new ArrayList<String>();
		clist.add("김두한");
		clist.add("상하이조");
		
		request.setAttribute("KEY_STRING", "나이름");
		request.setAttribute("KEY_MLIST", mlist);
		request.setAttribute("KEY_CLIST", clist);
		request.getRequestDispatcher("/input_tag_result.jsp").forward(request, response);
		
		//response.sendRedirect("/input_tag_result.jsp?uid="+uid+"&upw="+upw);
	}

}
