package com.kosmo.test2222;

public class Ch07Child extends Ch07Parent{
			static int pnum = 99;
	  public       int cpoint = 1000;
	    
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//public :: 공공, 제한없음
		//protected : 같은 패키지, 다른패키지라면 자손까지 허용
		//( default ) : 같은 패키지
		//private : 같은 클래스
		
		
		//다형성  : 메서드 : 오버라이딩된 자식 메서드만 호출
		// 변 수 : 부모꺼만 호출 가능
		//부모 타입의 변수에 자식 인스턴스(주소)를 할당
		//Parent p = new Child();
		System.out.println(pnum);
		
		Ch07Child2 c2 = new Ch07Child2();
		int res = c2.add();
		System.out.println(res); 
		
		MyClass t = new MyClass();  
		
		t.method(5);
		
		
		
		
		

	}

}
