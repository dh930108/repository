package com.kosmo.test2222;

import java.util.*;

public class Ch11PropertyTest {
	public static void main(String[] args) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		MemberVO mvo = new MemberVO();
		mvo.setMseq(1);
		mvo.setMid("lee");
		mvo.setMpw("111");
		mvo.setMname("이씨");
		mvo.setMgubun("u");
		list.add(mvo);
		
		MemberVO mvo2 = new MemberVO();
		mvo2.setMseq(2);
		mvo2.setMid("kim");
		mvo2.setMpw("222");
		mvo2.setMname("김씨");
		mvo2.setMgubun("a");
		list.add(mvo2);
		
		for(int i=0;i<list.size();i++) {
			MemberVO mmvo = (MemberVO)list.get(i);
			System.out.print(mmvo.getMseq() + "\t");
			System.out.print(mmvo.getMid() + "\t");
			System.out.print(mmvo.getMpw() + "\t");
			System.out.print(mmvo.getMname() + "\t");
			System.out.println(mmvo.getMgubun());
		}
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(mvo);
		System.out.println(mvo2);
		System.out.println(list.get(0).getMid());
		MemberVO mmvo = (MemberVO)list.get(0);
		
	}

}
