package com.kosmo.test2222;

import java.io.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ch15FileRWTest {
	
	public static void main(String[] args) {
		String source = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\aaa.txt";
		String dest = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\cp.txt";
		
		//Reader r = new Reader(); //추상클래스라서 직접 new 불가
		
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			//char[] carr = {'j','a','v','a'};
			fr = new FileReader(source);
			fw = new FileWriter(dest);
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
//
//			int res = 0;
//			while((res=br.read()) != -1) {
//				System.out.println(res);
//				bw.write(res);
//			}
			
			String line = null;
			while((line=br.readLine()) != null) {
				System.out.println(line);
				bw.write(line);
			}
			
			bw.flush();
			
//			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
