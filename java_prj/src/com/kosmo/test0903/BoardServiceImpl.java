package com.kosmo.test0903;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class BoardServiceImpl implements BoardService{
	
	
	
	public ArrayList<BoardVO> boardList(){
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
		
			rs =pstmt.executeQuery();
		while(rs.next()) {
			BoardVO bvo = new BoardVO();
			bvo.setBseq(rs.getInt("bseq"));
			bvo.setRegid(rs.getString("regid"));
			bvo.setRegdate(rs.getString("regdate"));
			bvo.setTitle(rs.getString("title"));

			list.add(bvo);
			
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
		
		
	};
	
	
	
	
	public int boardInsert(BoardVO bvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "insert into board (bseq,title, regid) values (board_seq.nextval,?,?)";
			//Insert into ORDERS_GOODS (GOOD_SEQ,ORDER_AMOUNT,ORDER_PRICE,ORDER_CODE) 
			//values (1,1,1000,'n00001');
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, bvo.getTitle());//바인딩
			pstmt.setString(2, bvo.getRegid());
		
			rs =pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		
		
		return rs;
	};
	
	
	
	public int replyInsert(BoardReplyVO brvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "insert into board_reply (Rseq ,Bseq, Reply, Regid) values (board_reply_seq.nextval,?,?,?)";
			//Insert into ORDERS_GOODS (GOOD_SEQ,ORDER_AMOUNT,ORDER_PRICE,ORDER_CODE) 
			//values (1,1,1000,'n00001');
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, brvo.getBseq());//바인딩
			pstmt.setString(2, brvo.getReply());
			pstmt.setString(3, brvo.getRegid());
		
			rs =pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(pstmt,conn);
		}
		
		
		return rs;
		
	};
	
	
	
	
	public HashMap<String, Object> boardView(int bseq){
		HashMap<String, Object> bmap = new HashMap<String, Object>();
		ArrayList<BoardVO> bvoar = new ArrayList<BoardVO>();
		ArrayList<BoardReplyVO> rvoar = new ArrayList<BoardReplyVO>();
		


		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "select b.bseq, b.title, b.regid, b.regdate,\r\n" + 
					"       r.reply, r.regid as repid, r.regdate as regday, r.rseq\r\n" + 
					"from board b, board_reply r\r\n" + 
					"where b.bseq = r.bseq\r\n" + 
					"and b.bseq = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bseq);
		
			rs =pstmt.executeQuery();
			
		while(rs.next()) {
			BoardVO bvo = new BoardVO();
			bvo.setBseq(rs.getInt("bseq"));
			bvo.setRegid(rs.getString("regid"));
			bvo.setRegdate(rs.getString("regdate"));
			bvo.setTitle(rs.getString("title"));

			bvoar.add(bvo);
			
			BoardReplyVO rvo = new BoardReplyVO();
			rvo.setRseq(rs.getInt("rseq"));
			rvo.setReply(rs.getString("reply"));
			rvo.setRegid(rs.getString("repid"));
			rvo.setRegdate(rs.getString("regday"));
//			rvo.setRegid(rs.getString("r.regid"));
//			rvo.setRegdate(rs.getString("r.regdate"));
//			rvo.setRegid(rs.getString("board_reply.regid"));
//			rvo.setRegdate(rs.getString("board_reply.regdate"));
			
			rvoar.add(rvo);
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
		
//		key_view
//		key_rlist
		
		bmap.put("key_view", bvoar);
		bmap.put("key_rlist",rvoar);
		
		return bmap;
		
	};

}
