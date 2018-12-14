package com.kosmo.test2222;

import java.io.IOException;

public class Ch9Lang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Ch9Lang lang = new Ch9Lang();
		
		 
//		 int rea;
//		try {
//			rea = System.in.read();
//		    System.out.println(rea);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("에러에러");
//			e.printStackTrace();
//		}
//		
		
		//---------------------------
		
		String sss = " aA801190-1234556";
		System.out.println(sss.charAt(1));	
		System.out.println(sss.length());
		System.out.println(sss.substring(0, 6));
		System.out.println(sss.concat("333"));
		System.out.println(sss.indexOf("-"));
		System.out.println(sss.lastIndexOf("-"));
		System.out.println(sss.replace("-", "**"));
		String[] aa =sss.split("-");
		System.out.println(aa[1]);
		
		System.out.println(sss.toLowerCase());
		System.out.println(sss.toUpperCase());
		System.out.println(sss.trim());
		
		

	}

}
