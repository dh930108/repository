package com.kosmo.test0903;

import java.util.ArrayList;
import java.util.HashMap;

import com.kosmo.test2222.Ch99JDBCImpl;
import com.kosmo.test2222.EmpVO;

public class BoradCallTest {
	public static void main(String[] args) {
	BoardServiceImpl t = new BoardServiceImpl();
	

	
	
//	BoardVO bvoi = new BoardVO();
//	bvoi.setTitle("닭고기");
//	bvoi.setRegid("kim");
//	
//	int resvi = t.boardInsert(bvoi);
//	System.out.println(resvi + " 건 글 입력");
//	
//	BoardReplyVO brvoi = new BoardReplyVO();
//	brvoi.setBseq(5);
//	brvoi.setReply("치킨");
//	brvoi.setRegid("lee");
//	int resri = t.replyInsert(brvoi);
//	brvoi.setBseq(5);
//	brvoi.setReply("양념치킨");
//	brvoi.setRegid("park");
//	resri += t.replyInsert(brvoi);
//	System.out.println(resri + " 건 댓글 입력");
	
	ArrayList<BoardVO> list = t.boardList();
	
	System.out.println(list.size());
	
	
//	for(int i=0; i<list.size(); i++) {
//		EmpVO evo =list.get(i);
//		System.out.println(evo.getEname());
//	}
	
	// 위for문과 아래 for문과 같다
	for(BoardVO bvo : list) {//list 전체 출력
		System.out.println(bvo.getBseq() + "\t" + bvo.getTitle() + "\t" + 
					       bvo.getRegid() + "\t" + bvo.getRegdate());
	}
	
	System.out.println("=====================boardView===================");
	
	HashMap<String, Object> bmap = t.boardView(4);
	
	ArrayList<BoardVO> bvo = (ArrayList<BoardVO>) bmap.get("key_view");
	
	System.out.println(bvo.get(0).getBseq() + "\t" + bvo.get(0).getTitle() + "\t" + 
			  		   bvo.get(0).getRegid() + "\t" + bvo.get(0).getRegdate());
	
	System.out.println("==댓글==");
	
	ArrayList<BoardReplyVO> rvoar = (ArrayList<BoardReplyVO>)bmap.get("key_rlist");
	
	for(BoardReplyVO rvo : rvoar) {//list 전체 출력
		System.out.println(rvo.getReply() + "\t" + rvo.getRegid() + "\t" + rvo.getRegdate()
		+ "\t" + rvo.getRseq() );
	}
	
System.out.println("=====================boardView===================");
	
	bmap = t.boardView(5);
	
	bvo = (ArrayList<BoardVO>) bmap.get("key_view");
	
	System.out.println(bvo.get(0).getBseq() + "\t" + bvo.get(0).getTitle() + "\t" + 
			  		   bvo.get(0).getRegid() + "\t" + bvo.get(0).getRegdate());
	
	System.out.println("==댓글==");
	
	rvoar = (ArrayList<BoardReplyVO>)bmap.get("key_rlist");
	
	for(BoardReplyVO rvo : rvoar) {//list 전체 출력
		System.out.println(rvo.getReply() + "\t" + rvo.getRegid() + "\t" + rvo.getRegdate() 
							+ "\t" + rvo.getRseq() );
	}
	
}
}
