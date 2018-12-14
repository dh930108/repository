package com.kosmo.ch15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.net.Socket;

public class WriteThread implements Runnable{
	Socket sk;
	String nickname;
	
	public WriteThread(Socket sk, String nickname) {
		this.sk = sk;
		this.nickname = nickname;
	}
	@Override
	public void run() {
		
		
		
		PrintStream out = null;
		OutputStream os = null;
		try {
		os = sk.getOutputStream();
		out = new PrintStream(os);
		
		if(nickname != null) {
			out.println(nickname); //닉네임을 서버로
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(true)	{
		String msg = sc.nextLine();
		out.println(nickname +":"+msg);
		//String[] msg1 = msg.split(":");
		if(msg.equals("exit")) {
			System.out.println("서버에서 퇴장");
			break;
		}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
