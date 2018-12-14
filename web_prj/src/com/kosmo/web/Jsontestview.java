package com.kosmo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Jsontestview
 */
@WebServlet("/view")
public class Jsontestview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html; charset=UTF-8");
		
		String val = request.getParameter("searchval");
		System.out.println(val);
		//String str2 = (String)request; //전달값은 JSON문만 있는게 아니다.
		
		Gson gson = new Gson();
		ArrayList<EmpVO> list = empsearch(val);
		
		
//		String cols = request.getParameter("searchcol"); //구분
//		String vals = request.getParameter("searchval"); //검색
//		System.out.println(cols + vals);
//		
//		ArrayList<EmpVO> list = empsearch(cols, vals);
		//ArrayList<EmpVO> list = empsearch();
		//System.out.println(list.size());
		//request.setAttribute("KEY_LIST", list);
		
		//request.getRequestDispatcher("/emp_result.jsp").forward(request, response);
		//request.getRequestDispatcher("/emp_result.jsp").forward(request, response);
		//Gson gson = new Gson();
		
		
		response.setContentType("application/json; encoding=UTF-8"); // 받는쪽에서 JSON으로 변환
		String gsonStr = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		out.println(gsonStr);
	}
	
	
	
	public ArrayList<EmpVO> empsearch(Object vals){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			
			String sql = "select empno, ename, job, sal, deptno, to_char(hiredate, 'YYYY-MM-DD') hiredate from emp where empno like ?";
			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setObject(1, "%" + vals + "%");
			
		
			rs =pstmt.executeQuery();
		while(rs.next()) {
			EmpVO evo = new EmpVO();
			evo.setEmpno(rs.getInt("empno"));
			evo.setHiredate(rs.getString("hiredate"));
			evo.setEname(rs.getString("ename"));
			evo.setJob(rs.getString("job"));
			evo.setSal(rs.getInt("sal"));
			evo.setDeptno(rs.getInt("deptno"));

			list.add(evo);
			
//			int no = rs.getInt("empno");
//			String name = rs.getString("ename");
//			System.out.println("사번 : " + no + "  이름 : " + name);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(rs,pstmt,conn );
		}
		
		System.out.println(list.size());
	return list;
		
		
	}

}
