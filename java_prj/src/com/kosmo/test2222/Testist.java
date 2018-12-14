package com.kosmo.test2222;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Testist {
	public static void main(String[] args) {
		
		String name = "kim";
		int age = 10;
		System.out.printf("my name is %s, age is %d",name,age);
		
		InputStreamReader isr =
				new InputStreamReader(System.in);
		System.out.println();
		try {
			System.out.println("1byte : " + isr.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		Scanner s = new Scanner(System.in);
		//String scStr = s.nextLine();
		int scStr = s.nextInt();
		System.err.println(scStr + 5);
	}

}
