package com.kosmo.test2222;

import java.io.*;

public class Ch15FileIOTest {
	
	public static void main(String[] args) {
		//InputStream is = new InputStream();
		// 역슬러시(\) 1개쓰면 예약어로 인식.  2개써야 경로명
		String source = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\aaa.txt";
		String dest = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\cp.txt";
		
		File sfile = new File(source);
		File dfile = new File(dest);
		if(sfile.isDirectory() || dfile.isDirectory()) 
			System.exit(0);
		
		
		//상대경로는 일반 슬러시 사용
		//String name = "./aaa.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		
		
		
		try {
//			while(true) {
//				int res = fis.read();
//				System.out.println((char)res);
//				if(res == -1) {	break;
//				}
//			}
			fis = new FileInputStream(sfile);
			//fos = new FileOutputStream(dest);
			fos = new FileOutputStream(dfile,true);
			
//			bis = new BufferedInputStream(fis);
//			bos = new BufferedOutputStream(fos);
			
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);
			int num = 0;
			while(dis.available() > 0) {
				num = dis.readInt();
				System.out.println(num);
				fos.write(num);
			}
			
			
//			int res = 0;
//			while((res = dis.read()) != -1) {
//				System.out.println((char)res);
//				dos.write(res);
//				
//			}
			
//			dos.flush(); // 버퍼를 비우다
			
			
			
			System.out.println("--done--");
			
			
//			byte[] b = {65,66,67,68,69};
//			fos = new FileOutputStream(dest);
//			fos.write(b);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			source = "C:\\default.txt";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {try {
			fis.close();
			fos.close();
			dis.close();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}}
		
		
		
		
		
		
		
		
	}

}
