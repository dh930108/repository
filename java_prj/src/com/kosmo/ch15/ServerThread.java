package com.kosmo.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.net.Socket;

public class ServerThread implements Runnable {
	Socket sk;
	HashMap map;

		public ServerThread(Socket ss, HashMap mm){
		this.sk = ss;
		this.map = mm;
		}
		
		public void run() {
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			PrintStream out = null;
			String nickname = "";
			try {
				is =sk.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
			
				nickname = br.readLine();
				map.put(nickname, sk);
				System.out.println("총 인원:" + map.size());
			
				sendMsgToAll(nickname + "입장");
			
				String msg = "";
				while((msg = br.readLine()) != null) {
					sendMsgToAll(msg);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					sendMsgToAll(nickname + "퇴장");
					map.remove(nickname);
					br.close();
					sk.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		public void sendMsgToAll(String msg) {
			try {
				Iterator it = map.keySet().iterator();
				while(it.hasNext()) {
					Socket usersk = (Socket)map.get(it.next());
					OutputStream uos = usersk.getOutputStream();
					new PrintStream(uos).println(msg);
					}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
}