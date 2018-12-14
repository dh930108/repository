package com.kosmo.ch15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.BufferOverflowException;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) {
		PrintStream out = null;
		Socket sk = null;
		try {
			sk = new Socket("192.168.0.111"
					+ "", 7777);
			System.out.println("[client] 서버연결성공");

			
			
			
//			OutputStreamWriter osw = new OutputStreamWriter();
//			BufferOverflowException b = BufferOverf

//			out = new PrintStream(os);
//			
//			Scanner sc = new Scanner(System.in);
//			
//			while(true)	{
//			String msg = sc.nextLine();
//			out.println(msg);
//			if(msg.equals("exit")) break;
//			}
			 
			Scanner sc = new Scanner(System.in);
			System.out.print("닉네임 : ");
			String nickname = sc.nextLine();
			 
			WriteThread wr = new WriteThread(sk,nickname);
			Thread th = new Thread(wr);
			th.start();
			
			ReadThread rt = new ReadThread(sk);
			 Thread t1 = new Thread(rt);
			 t1.start();
			
			System.out.println("===[client] done===");
		} catch (UnknownHostException e) {
			//e.printStackTrace();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}finally {
			try {
				out.close();
				sk.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
