package com.kosmo.test2222;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class Ch99JDBCImpl implements Ch99JDBC{
	//JDBC(Java DataBase Connectivity)
	// : Driver
	// : jar(java Archive) 클래스파일 닮은것.== zip파일
	// : openAPI(메서드 기능의 묶음) 

	
	//public static void main(String[] args) {
	
	//SWING JTABLE 용도
	
	
	public int empInsert(int prmSal, int prmEmpno) {
		int i = 0;
		i = prmSal + prmEmpno;
		return i;
	};
	
	public ArrayList<Vector> empListForSwing() {
//		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
//		
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Ch99DBManager dbm = new Ch99DBManager();
		ArrayList<Vector> list = new ArrayList<Vector>();
		try {
			conn = dbm.dbConn();
			String sql = "select empno, ename, job, deptno from emp ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			Vector<Object> vt = new Vector<Object>();
			vt.addElement(rs.getInt("empno"));
			vt.addElement(rs.getString("ename"));
			vt.addElement(rs.getString("job"));
			vt.addElement(rs.getInt("deptno"));
			list.add(vt);
			
//			EmpVO evo = new EmpVO();
//			evo.setEmpno(rs.getInt("empno"));
//			evo.setEname(rs.getString("ename"));
//			evo.setJob(rs.getString("job"));
//			list.add(evo);
			
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
	return list;
	
		
	}
	
	
	public ArrayList<EmpVO> empList(int empno) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
		
		if(conn != null)
			System.out.println("conn succ");
		else
			System.out.println("conn fail");
		
		
		String sql = "select empno, ename from emp where empno = ?";
		pstmt = conn.prepareStatement(sql);
		rs =pstmt.executeQuery();
		while(rs.next()) {
			EmpVO evo = new EmpVO();
			evo.setEmpno(rs.getInt("empno"));
			evo.setEname(rs.getString("ename"));
			list.add(evo);
			
//			int no = rs.getInt("empno");
//			String name = rs.getString("ename");
//			System.out.println("사번 : " + no + "  이름 : " + name);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	return list;
	
		
	}
	
	public ArrayList<EmpVO> empList() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
		
		if(conn != null)
			System.out.println("conn succ");
		else
			System.out.println("conn fail");
		
		
		String sql = "select empno, ename from emp";
		pstmt = conn.prepareStatement(sql);
		rs =pstmt.executeQuery();
		while(rs.next()) {
			EmpVO evo = new EmpVO();
			evo.setEmpno(rs.getInt("empno"));
			evo.setEname(rs.getString("ename"));
			list.add(evo);
			
//			int no = rs.getInt("empno");
//			String name = rs.getString("ename");
//			System.out.println("사번 : " + no + "  이름 : " + name);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	
	return list;
	
}
	
	public int empInsert(int prmEmpno, String prmEname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		Ch99DBManager dbm = new Ch99DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "insert into emp (empno, ename) values (?,?)";
			//Insert into ORDERS_GOODS (GOOD_SEQ,ORDER_AMOUNT,ORDER_PRICE,ORDER_CODE) 
			//values (1,1,1000,'n00001');
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, prmEmpno);//바인딩
			pstmt.setString(2, prmEname);
		
			rs =pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		
		
		return rs;
		}
	
	
	public int empInsert(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		Ch99DBManager dbm = new Ch99DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "insert into emp (empno, ename, job, deptno) values (?,?,?,?)";
			//Insert into ORDERS_GOODS (GOOD_SEQ,ORDER_AMOUNT,ORDER_PRICE,ORDER_CODE) 
			//values (1,1,1000,'n00001');
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, vo.getEmpno());//바인딩
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getDeptno());
			rs =pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		
		
		return rs;
		}
		
		
		
	public int empUpdate(int prmSal, int prmEmpno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		Ch99DBManager dbm = new Ch99DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "update emp set sal = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
		
		
			pstmt.setInt(1, prmSal);//바인딩
			pstmt.setInt(2, prmEmpno);//바인딩
		
			rs =pstmt.executeUpdate();
			
//			int no = rs.getInt("empno");
//			String name = rs.getString("ename");
//			System.out.println("사번 : " + no + "  이름 : " + name);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		return rs;
		
}
	
	public int empUpdate(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		Ch99DBManager dbm = new Ch99DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "update emp set ename = ?, job = ?, deptno = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
		
		
			pstmt.setString(1, vo.getEname());//바인딩
			pstmt.setString(2, vo.getJob());//바인딩
			pstmt.setInt(3, vo.getDeptno());
			pstmt.setInt(4, vo.getEmpno());
			
			
			rs =pstmt.executeUpdate();
			
//			int no = rs.getInt("empno");
//			String name = rs.getString("ename");
//			System.out.println("사번 : " + no + "  이름 : " + name);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		return rs;
		
}
		
		
		
	public int empDelete(int prmEmpno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		Ch99DBManager dbm = new Ch99DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
		
		
			pstmt.setInt(1, prmEmpno);//바인딩
		
			rs =pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		return rs;
		}
	
	public int empDeleteForSwing(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		Ch99DBManager dbm = new Ch99DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
		
		
			pstmt.setInt(1, vo.getEmpno());//바인딩
		
			rs =pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		return rs;
		}

	@Override
	public ArrayList<EmpVO> empList(String gubun, Object oval) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
