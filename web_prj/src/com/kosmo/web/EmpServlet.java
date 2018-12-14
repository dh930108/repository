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


@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		//String cols = request.getParameter("searchcol");
		//String vals = request.getParameter("searchval");
		
		//ArrayList<EmpVO> list = empsearch(cols, vals);
		ArrayList<EmpVO> list = empsearch();
//		System.out.println(list.size());
		request.setAttribute("KEY_LIST", list);
		
		//request.getRequestDispatcher("/emp_result.jsp").forward(request, response);
		request.getRequestDispatcher("/style_test.jsp").forward(request, response);
		
		//response.getWriter().append("Served at: " + cols + vals);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String str = request.getParameter("key");
		//String str2 = (String)request; //전달값은 JSON문만 있는게 아니다.
		
		Gson gson = new Gson();
		SearchVO svo = gson.fromJson(str, SearchVO.class);
		System.out.println(svo.getSearchval());
		ArrayList<EmpVO> list = empsearch(svo.getSearchcol(),svo.getSearchval());
		
		
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
	
	
	
	
	
	
	public ArrayList<EmpVO> empsearch(String cols, Object vals){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			
			String sql = "select empno, ename, job, sal, deptno, to_char(hiredate, 'YYYY-MM-DD') hiredate from emp where "
					    +  cols + " like ?";
			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			System.out.println(cols +" = "+ vals);
			
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

	
	public ArrayList<EmpVO> empsearch(){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "select empno, ename, job, sal, deptno, to_char(hiredate, 'YYYY-MM-DD') hiredate from emp";
			pstmt = conn.prepareStatement(sql);
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
