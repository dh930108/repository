package com.kosmo.gui.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IOTest {

	public static void main(String[] args) {
		File f = new File("c:\\down\\map.jpg");
		FileOutputStream fos = null;
		InputStream is = null;
		String urlStr = "https://maps.googleapis.com/maps/api/staticmap?center=독산동&zoom=16&size=800x600&maptype=roadmap"; 
//				"&markers=color:blue%7Clabel:S%7C40.702147,-74.015794"
//				+ "&markers=color:green%7Clabel:G%7C40.711614,-74.012318\r\n" + 
//				"&markers=color:red%7Clabel:C%7C40.718217,-73.998284\r\n" + 
//				"&key=YOUR_API_KEY";
		try {
			fos = new FileOutputStream(f);
			URL url = new URL(urlStr);
//			InputStream is = url.openStream();
			URLConnection conn = url.openConnection();
			is = conn.getInputStream();
			
			int data = 0;
			while((data=is.read()) != -1) {
				fos.write(data);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} finally {
			try {
				fos.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("============done===============");
	}

}
