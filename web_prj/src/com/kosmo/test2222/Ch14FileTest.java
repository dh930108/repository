package com.kosmo.test2222;

import java.io.*;
import java.util.ArrayList;


public class Ch14FileTest {
	static int totalFiles = 0;
	static int totalDirs = 0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String source = "C:\\jpeworkspace_java\\java_prj\\src\\com\\kosmo\\test2222\\aaa.txt";
//		
//		File f = new File(source);
//		System.out.println(f.getPath());
//		System.out.println(f.getAbsolutePath());
		
		
		
		String path = "C:\\jpeworkspace_java\\java_prj\\src";
//		File f1 = new File(path);
//		File[] farr = f1.listFiles();
//		for(int i=0;farr.length > i; i++) {
//		if(farr[i].exists() == true) {
//			System.out.println(farr[i].getName());
//		}
//		}
//		
//		f1.delete();
		
		if(path.length() == 1) {
			System.out.println("USAGE : java FileEx3 DIRECTORY");
			System.exit(0);
		}
		//path의 유무검사
		File dir = new File(path);
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		//유효한 경로인지 검사하고 아니라면 프로그램 종료
		printFileList(dir);
		
		System.out.println();
		System.out.println("총  " + totalFiles + "개의 파일");
		System.out.println("총  " + totalDirs + "개의 디렉토리");
	}
	
	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath()+"  디렉토리");
		File[] files = dir.listFiles();
		
		ArrayList subDir = new ArrayList();
		
//		for(File getifile : files)
//			=
//		for(int i=0; i < files.length; i++) {
//			getifile = files[i];
//		}
		
		for(int i=0; i < files.length; i++) {
			String filename = files[i].getName();
			
			if(files[i].isDirectory()) {
				filename = "[" + filename + "]";
				subDir.add(i+"");//subDir의 갯수로 디렉토리 갯수 카운트
			}//폴더라면 대괄호 쳐서 출력
			System.out.println(filename);
			//파일이면 그냥 출력
		}
		
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;//files.length는 디렉토리를 포함한 모든 파일의 갯수이므로...
		
		totalFiles += fileNum;
		totalDirs += dirNum;
		
		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();
		
		for(int i=0;i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]); //재귀호출을 통하여 조회한 디렉토리내 디렉토리를 다 조회하고 나옴, 반복
		}
	}
}
