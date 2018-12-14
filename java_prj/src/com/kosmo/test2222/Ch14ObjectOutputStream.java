package com.kosmo.test2222;

import java.io.*;
import java.util.ArrayList;

public class Ch14ObjectOutputStream {
	
	public static void main(String[] args) {
		String source = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\object.txt";
		FileOutputStream fos = null;
		ObjectOutputStream oos  = null;
		try {
			fos = new FileOutputStream(source);
			oos  = new ObjectOutputStream(fos);
			
			
			
//			ArrayList<String> list = new ArrayList<String>();
//			list.add("aaa");
//			list.add("bbb");
//			list.add("ccc");
			
			Ch99JDBCImpl t = new Ch99JDBCImpl();
			ArrayList<EmpVO> list = t.empList();
			
			MemberVO vo = new MemberVO();
			vo.setMid("lee");
			vo.setMpw("9999");
			
			oos.writeObject(list);
			oos.writeObject(vo);
			
		
			System.out.println("====write done====");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
