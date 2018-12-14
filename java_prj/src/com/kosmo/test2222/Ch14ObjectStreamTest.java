package com.kosmo.test2222;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ch14ObjectStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\object.txt";
		String dest = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\cp.txt";
		
        File sfile = new File(source);
//		File dfile = new File(dest);
//		FileInputStream fis = new FileInputStream(Sfile);
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		
		
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(source);
			ois = new ObjectInputStream(fis);
			oos = new ObjectOutputStream(fos);
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("aaa");
			list.add("bbb");
			list.add("ccc");
			
			MemberVO vo = new MemberVO();
			vo.setMid("lee");
			vo.setMpw("9999");
			
			
			oos.writeObject(list);
			oos.writeObject(vo);
			
			System.out.println("-------------------------done-------------------------");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ois != null) ois.close();
					if(oos != null) oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
