package com.mether.call;
import java.time.LocalDate;
import java.util.*;

public class MethodCall {
	
	public static void main(String[] args) {
		
		MethodCommon mc = new MethodCommon();
		
		//call add
		HashSet sett = new HashSet();
		sett.add(1);
		sett.add(2);sett.add(2);
		sett.add(3);sett.add(3);sett.add(3);
		int res1 = mc.add(sett);
		
		System.out.println(" = " + res1);
		
		
		//call oddAdd
		ArrayList arr = new ArrayList();
		arr.add(1);arr.add(2);arr.add(3);
		arr.add(4);arr.add(5);arr.add(6);
		arr.add(7);arr.add(8);arr.add(9);
		arr.add(10);arr.add(11);arr.add(12);
		
		int res2 = mc.oddAdd(arr);
		
		System.out.println(" = " + res2);
		
		//call getAge
		String jumin = "901130-1234567";
		ArrayList arr2 = mc.getAge(jumin);
		System.out.println("만"+arr2.get(0)+"세");
		System.out.println(arr2.get(1));
		
		//call getConvertId
		String id="kim360!@";
		String pw="namu04";
		String[] res3 = mc.getConvertId(id, pw);
		System.out.println(res3[0]);
		System.out.println(res3[1]);
		
		//call getFileExt
		String file = "c:\\etc\\aa.jpg";
		String ext = mc.getFileExt(file);
		System.out.println(ext);
		
		
		
		System.out.println("====================================");
		//call boardList
		
		ArrayList<ReplyVO> reply = new ArrayList<ReplyVO>();
		
	
		
		
		
		ReplyVO rep = new ReplyVO();
		
		rep.setBseq(0);
		rep.setReply("더워");
		rep.setRseq(0);
		reply.add(rep);
		ReplyVO rep1 = new ReplyVO();
		rep1.setBseq(0);
		rep1.setReply("더워더워");
		rep1.setRseq(1);
		reply.add(rep1);
		ReplyVO rep2 = new ReplyVO();
		rep2.setBseq(0);
		rep2.setReply("더워더워더워");
		rep2.setRseq(2);
		reply.add(rep2);
		ReplyVO rep3 = new ReplyVO();
		rep3.setBseq(1);
		rep3.setReply("추워");
		rep3.setRseq(0);
		reply.add(rep3);
		ReplyVO rep4 = new ReplyVO();
		rep4.setBseq(1);
		rep4.setReply("추워추워");
		rep4.setRseq(1);
		reply.add(rep4);
		ReplyVO rep5 = new ReplyVO();
		rep5.setBseq(1);
		rep5.setReply("추워추워추워");
		rep5.setRseq(2);
		reply.add(rep5);
		
		ArrayList<BoardVO> bord = mc.boardList(reply);
		
		for(int j = 0; j < bord.size(); j++) {
			System.out.println(bord.get(j).getBseq());
			System.out.println(bord.get(j).getTitle());
			System.out.println(bord.get(j).getContent());
			for(int i = 0; i < bord.get(j).getReply().size(); i++) {
			System.out.print(bord.get(j).getReply().get(i).getBseq() + "  ");
			System.out.print(bord.get(j).getReply().get(i).getRseq() + "  ");
			System.out.println(bord.get(j).getReply().get(i).getReply());
			}
			System.out.println("================다음글=================");
		}
		
		
		
	}

}
