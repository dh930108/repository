package com.kosmo.ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.FieldPosition;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	
	private static int i;

	public static void main(String[] args) {
		
		String url = "http://www.ytn.co.kr/photo/sports_list_9901.html";
		String selector = "div#ytn_list_v2014 dl.photo_list";
	int i = ytnCrawling(url,selector );
		
		System.out.println("크롤링수 : " + i);
		
	}
//			Connection.Response response;
//			try {
//			response = Jsoup.connect("http://www.ytn.co.kr/photo/photo_list_1406.html")
//					.method(Connection.Method.GET)
//					.execute();
//			System.out.println(response.statusCode());
//			System.out.println(response.statusMessage());
//			
//			Document docc = response.parse();
//			System.out.println(docc.html());
//			
//			Elements elms = docc.select("div#ytn_list_v2014 dl.photo_list");
//			Elements elms1 = docc.select("div#ytn_list_v2014 dl.photo_list dt a");
//			Elements elms2 = docc.select("div#ytn_list_v2014 dl.photo_list dd.date ");
//			for(Element elm : elms) {
//				Elements elTitle = elm.select("dt a");
//				System.out.println("http://www.ytn.co.kr"+elm.attr("href"));
//				System.out.println(elTitle.text());
//				
//				Elements elmsContent = elm.select("dd.text");
//				for(Element elmCont : elmsContent) {
//					System.out.println(elmCont.text());
//				}
//				System.out.println();
//			}
//			
//			
//			
//			
//			//String source = "abcd";
//			String dest = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\ch15\\jsoup.txt";
//			
//			//Reader r = new Reader(); //추상클래스라서 직접 new 불가
//			
//			//FileReader fr = null;
//			//FileWriter fw = null;
//			//BufferedReader br = null;
//			//BufferedWriter bw = null;
//			
//			
//				//char[] carr = {'j','a','v','a'};
//				//fr = new FileReader(source);
//				//fw = new FileWriter(dest);
//				
//				//br = new BufferedReader(fr);
//				//bw = new BufferedWriter(fw);
//	//
////				int res = 0;
////				while((res=br.read()) != -1) {
////					System.out.println(res);
////					bw.write(res);
////				}
////				File f = new File();
////				FileOutputStream fos = new FileOutputStream(f);
////				PrintStream out = new PrintStream(fos); 
//				
//				
//			
////					System.out.println(docc.html());
////					bw.write(docc.html());
////				
////				
////				bw.flush();
//
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
		
		
		
		
	
	
	public static int ytnCrawling(String url, String selector){
		
		
		Connection.Response response;
		int res = 0;
		try {
			response = Jsoup.connect(url)
					.method(Connection.Method.GET)
					.execute();
	
		System.out.println(response.statusCode());
		System.out.println(response.statusMessage());
		
		Document docc = response.parse();
		System.out.println(docc.html());
		
		Elements elms = docc.select(selector);
		res = elms.size();
		for(Element elm : elms) {
			Elements elTitle = elm.select("dt a");
			System.out.println("http://www.ytn.co.kr"+elm.attr("href"));
			System.out.println(elTitle.text());
			System.out.println();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	
}
	
}
			
			


