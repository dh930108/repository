package com.kosmo.test2222;

public class Ch02LocalVar {
	
	int num; // 자동 초기화
	
	public static void main(String[] args) {
		int num = 555; //반드시 초기화
		Ch02LocalVar v = new Ch02LocalVar();
		v.myprint();
		System.out.println(v.num);
		System.out.println(num);
		//System.out.println(this.num);//언제new될지 모르므로...
		
		
	}
	public void myprint() {
		int num=999;
		System.out.println(num);//둘 다 같이 메모리에 올라가므로 에러X
		System.out.println(this.num);//this.매서드가 포함된 클래스
		System.out.println();
	}
}
