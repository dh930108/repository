package com.kosmo.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
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
			
				sendMsgToAll("RIGHT:::" + nickname + "입장");
				
				StringBuffer buffer = new StringBuffer();
				Set set = map.keySet();
				
				Iterator it = set.iterator();
				while(it.hasNext()) {
					buffer.append(it.next()+"@");
				}
				sendMsgToAll("LEFT:::" + buffer.toString());
				
			
				String msg = "";
				while((msg = br.readLine()) != null) {
					sendMsgToAll(msg);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					sendMsgToAll("RIGHT:::" + nickname + "퇴장");
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