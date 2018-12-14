package com.mether.call;
import java.util.*;
import java.time.*;

public class MethodCommon {

	
//	파라미터 : set
//	리턴 :  합
//	메서드 : add
	
	public int add(HashSet sett) {
		int hap = 0;
		
		Iterator it = sett.iterator();
		
		while(it.hasNext()) {
			int i = (int)it.next();
			System.out.print(i);
			hap += i;
		
		 if(it.hasNext() == false) break;
		 else System.out.print(" + ");
		}
		
		return hap;
		
	}

//	파라미터 : ArrayList
//	리턴 :  홀수합
//	메서드 : oddAdd
	
	public int oddAdd(ArrayList arr) {
		int hap = 0;
		for(int i=0;i<arr.size();i++) {
			if((int)arr.get(i)%2 == 1) {
				hap += (int)arr.get(i);
				System.out.print(arr.get(i));
				if(i<arr.size()-2) //고칠것
				System.out.print(" + ");
			}
		}
		
		return hap;
	}

//	파라미터 : ArrayList<ReplyVO>
//	리턴 :  ArrayList<BoardVO>
//	메서드 : boardList
//	조건 : BoardVO : bseq title content + ???
//		 ReplyVO : bseq rseq reply
//
//		       BoardVO 에 ReplyVO 담아서.
	
	
	public ArrayList<BoardVO> boardList(ArrayList<ReplyVO> reply){
		ArrayList<BoardVO> board = new ArrayList<BoardVO>();
		
		
		
		BoardVO bdvo = new BoardVO();
		bdvo.setBseq(0);
		bdvo.setTitle("너무 덥다");
		bdvo.setContent("너무 더워서 죽겠다 어떡하냐");
		
		ArrayList<ReplyVO> rep = new ArrayList<ReplyVO>();
		for(int i = 0 ; i < reply.size(); i++) {
			if(reply.get(i).getBseq() == 0) {
				rep.add(reply.get(i));
			}
		}
		bdvo.setReply(rep);
		board.add(bdvo);
		
		BoardVO bdvo2 = new BoardVO();
		bdvo2.setBseq(1);
		bdvo2.setTitle("너무 춥다");
		bdvo2.setContent("너무 추워서 죽겠다 어떡하냐");
		
		ArrayList<ReplyVO> rep2 = new ArrayList<ReplyVO>();
		for(int i = 0 ; i < reply.size(); i++) {
			if(reply.get(i).getBseq() == 1) {
				rep2.add(reply.get(i));
			}
		}
		bdvo2.setReply(rep2);
		board.add(bdvo2);
		
//		bdvo.setBseq(1);
//		bdvo.setTitle("너무 덥다아");
//		bdvo.setContent("너무 더워서 죽겠다 어떡하지");
//		board.add(bdvo);
//		bdvo.setBseq(2);
//		bdvo.setTitle("너무 덥다야");
//		bdvo.setContent("너무 더워서 죽겠다 어떡해");
//		board.add(bdvo);
		
		return  board;
	}
	
	

//	파라미터 : 주민번호 901130-1234567
//	리턴 :  나이, 성별
//	메서드 : getAge
	
	public ArrayList getAge(String jumin) {
		ArrayList arr = new ArrayList();
		
		
		int jnai = 1900+Integer.parseInt(jumin.substring(0, 2));
		int nyear = LocalDate.now().getYear();
		int nai = nyear - jnai;
		
		int sung1 = Integer.parseInt(jumin.substring(7, 8));
		String sung = "";
		if(sung1%2 == 1)
			sung = "남성";
		else
			sung = "여성";
		
		arr.add(nai);
		arr.add(sung);
			
		return arr;
	}

//	파라미터 : 아이디 
//	리턴 :  (kim360!@) kim****@
//	        (namu04) nam**4
//	메서드 : getConvertId
	
	public String[] getConvertId(String id,String pw) {
		String[] strr = new String[2];
		
		StringBuffer buf = new StringBuffer();
		//id
		buf.append(id.substring(0, 3));	
		
		for(int i = 3; i<id.length()-1; i++) {
			buf.append("*");
		}
		buf.append(id.substring(id.length()-1, id.length()));
		
		strr[0] = buf.toString();
		
		buf.delete(0, buf.length());
		
		//pw
		buf.append(pw.substring(0, 3));	
		
		for(int i = 3; i<pw.length()-1; i++) {
			buf.append("*");
		}
		buf.append(pw.substring(pw.length()-1, pw.length()));
		
		strr[1] = buf.toString();
		
		return strr;
		
	}

//	파라미터 : 파일경로+파일명
//	리턴 :  (c:\etc\aa.jpg)  확장자 jpg
//	메서드 : getFileExt
	
	public String getFileExt(String file) {
		
		String ext = file.substring(file.lastIndexOf("."), file.length());
		
		
		return ext;
	}
	
}
