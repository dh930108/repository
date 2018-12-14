package com.kosmo.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class ReadThread implements Runnable{
	Socket sk;
	ChatMain chatArea;
	BufferedReader br;
	InputStream is;
	InputStreamReader isr;
	
	
	public ReadThread(Socket sk, ChatMain aaa) {
		this.sk = sk;
		chatArea = aaa;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		is = sk.getInputStream();
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String line = "";
		while( (line = br.readLine()) != null) {
			//System.out.println(line);
			String[] arrStr = line.split(":::");
			
			if(arrStr[0].equals("RIGHT")) {
				chatArea.textArea_chat.append(arrStr[1] + "\n");
			}else if(arrStr[0].equals("LEFT")) {
				//닉네임
				//textArea_nick.append(nick + "\n");
				chatArea.textArea_nick.setText("");
				String[] nickArr = arrStr[1].split("@");
				for(int i=0; i<nickArr.length; i++) {
				chatArea.textArea_nick.append(nickArr[i] + "\n");
				}
			}else {}
			
			
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
