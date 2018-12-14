package com.mether.call;

public class CallTest {
	
//	add
//	sub
//	mul
//	div
	
	public static void main(String[] args) {
		int res = 0;
		double res2 = 0;
		
	     res = add(6,5);
	     System.out.println("더하기 : " + res);
	     res = sub(6,5);
	     System.out.println("빼기   : " + res);
	     res = mul(6,5);
	     System.out.println("곱하기 : " + res);
	     res2 = div(6,2);
	     System.out.println("나누기 : " + res2);
	 	
		
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public static int mul(int a, int b) {
		return a * b;
	}
	
	public static double div(int a, int b) {
		return a / b;
	}
	
	
	

}
