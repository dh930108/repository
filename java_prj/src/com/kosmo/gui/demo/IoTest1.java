package com.kosmo.gui.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IoTest1 {
	public static void main(String[] args ) {
		File f = new File("C:\\down\\map.jpg");
		FileOutputStream fos = null;
		InputStream is = null;
		String urlstr = "https://maps.googleapis.com/maps/api/staticmap?center=쌍문1동&zoom=16&size=800x600&maptype=roadmap" ;
				   //  "&key=AIzaSyCuNEZy0_FkEG11zaMzQS02JYxYDpV_i54";
		try {
			fos = new FileOutputStream(f);
		
		URL url = new URL(urlstr);
		//InputStream is = url.openStream();
		URLConnection conn = url.openConnection();
		is = conn.getInputStream();
		int data = 0;
		while((data=is.read()) != -1) {
			fos.write(data);
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
