package com.kosmo.test2222;



public class Ch02Var {
	//클래스 안에는 변수 또는 메소드 들이 올 수 있다.
	
	//메모리에 올리는 2가지 방법
	static int point; //전역변수는 초기화 안하면 기본값으로 초기화된다.
	       int point2;
	       
	static  final int NOT_EDIT_NUM = 500;
	
	public static void main(String[] args) {
		//static 선언 으로 메모리업로드(Static 변수, 클래스변수)
		System.out.println(point);
		//new로 메모리업로드 (인스턴스변수)
						//new로 만들어지는 변수
		Ch02Var v = new Ch02Var(); 
		//인스턴스 : 메모리에 올라가 주소를 갖는 변수, 메서드
		//인스턴스화 : 주소를 만드다(new등)
		System.out.println(v.point2);
		
		
		
		//변수 선언
		int a; //지역 변수는 반드시 초기화
		//초기화
		a = 0;
		//변수선언 + 초기화
		int b=0;
		
		System.out.println(b);
		
		b=7; //값을 재할당(값을 다시 넣는다)
		
		
		
		//기본(primitive)타입:8개
		//참조(reference)타입: 주소값 (4바이트)
		
		boolean bool = false; //ture
		char c = 'c';
		byte by = 127;//2^7-1;
		short s = 256;
		int i = 25000;
		long l = 52000;
		float f = 3.0f;
		double d = 3.0d;
		
		
		final int NOT_EDIT_NUM = 500;
		System.out.println(NOT_EDIT_NUM); 
		
		
		String str1 = null;
		String str2 = "";
		String str3 = "A";
		
		int h = 100;
		int z = 50;
		System.out.println(str3 + h +z);
		System.out.println(str3 + (h +z));
		
		char calph = 'A';
		System.out.println(calph+1);
		
		
		//캐스팅:형변환(바꾸고싶은타입)
		System.out.println((char)(calph+1));
		//기본타입8개중 boolean을 제외한 나머지는 형변환불가
		
		
		//참조타입 < == > 기본타입 XXXXX 캐스팅불가
		String numstr = "11";
		//System.out.println((int)numstr);
		
		Boolean bw;
		Character cw;
		Byte btw;
		Short sw;
		//Short sr = Short.parseShort("13");
		Integer it;
		Long lw;
		Float fw;
		Double dw;
		double dp = Double.parseDouble("3.41");
		
		
		//참조타입 < == > 기본타입 Wrapper 클래스를  사용해라
		
		int pint = Integer.parseInt(numstr);
		System.out.println(pint);
		
		byte b1 = 10;
		byte b2 = 20;
		byte b3 = (byte)(b1 + b2);
		
		System.out.println("합쳐서 " + b3);
		
		int n1 = 1000000;
		int n2 = 2000000;
		int nres = n1* n2;
		long l1 = (long)n1 * n2;
		System.out.println("합쳐서 " + nres);
		System.out.println("합쳐서 " + l1);
		
		int tot = 80;
		String totres = (tot>90)? "크다" : "작다";
		System.out.println(totres);
		
		int score = 80;
		
	}

}
