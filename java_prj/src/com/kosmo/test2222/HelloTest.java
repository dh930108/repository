package com.kosmo.test2222;

// 7월 26일

public class HelloTest { //
	 static int allnum = 1000;

	//	주석 : 메서드  : main
	//__0___   main(__1_ _2_)
	//	(  ) : 파라미터 parameter // 매개변수, 인자
	//  0 : 리턴타입 int String void(리턴이없다 = 줄값이 없다)
	//	1 : 파라미터 타입
	//	2 : 파라미터명 = 변수명(사용자 리네임)


	public static void main(String[] args) {
		System.out.println(allnum);
		
		System.out.println("안녕");
	


		//add  메서드를 호출한다
		// res : add 메서드를 호출한 겱과값
		int res = add(4, 6); 
		System.out.println(res);  
		
		
		//+++++++++++++++++++++++++++++++++++++++++++
		//메모리에 올리는 방법
		// 1. static
		// 2. new
		//+++++++++++++++++++++++++++++++++++++++++++
		HelloTest aaa = new HelloTest();
		System.out.println(aaa.allnum);
		int res22 = aaa.add(55, 10);
		System.out.println(res22);
	}


	// 접근제어자 리턴타입 메서드명(파라미터타입 파라미터명)

	public static int add(int a, int b) {
		System.out.println("-----" + allnum);
		return a + b;
		
	}

	public void myprint() {
		System.out.println("호출되었다합니다");
		
	}
}
