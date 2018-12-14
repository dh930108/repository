package com.kosmo.ch15;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class NetClassTest {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		InetAddress net;
//		try {
//			net = InetAddress.getLocalHost();
//			String addr = net.getHostAddress();
//			String host = net.getHostName();
//			System.out.println(addr + "\t" + host);
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			URL url = new URL("http://www.google.com");
			//InputStream is = url.openStream();
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			while( (line=br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
