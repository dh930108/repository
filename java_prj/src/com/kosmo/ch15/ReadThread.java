package com.kosmo.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ReadThread implements Runnable{
	Socket sk;
	
	public ReadThread(Socket sk) {
		this.sk = sk;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		InputStream is = null;
		InputStreamReader isr = null;
		try {
		is = sk.getInputStream();
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String line = "";
		while( (line = br.readLine()) != null) {
			System.out.println(line);
		}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("클라이언트 퇴장");
			try {
				br.close();
				sk.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
