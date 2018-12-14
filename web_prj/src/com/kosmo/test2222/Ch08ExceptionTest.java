package com.kosmo.test2222;


//예외처리란 코드를 끝까지 수행학디 위해서 코드의 예외부를 처리하는것
//try{} XXXX
//try{} catch{}
//try{} cat{}finally{}
//try{} finally{} : 가능은 한데 의미는 없다
public class Ch08ExceptionTest {
	
	public static void main(String[] args) {
	
		int[] arr = new int[2];
		System.out.println("1");
		
		
		try {
			//ArrayIndexOutOfBoundsException 가 아니여도 try로 묶어도 된다
		System.out.println(arr[2]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("catch : 잡았다");
			e.printStackTrace();
		}finally {//예외발생여부와 관계없이 무조건 실행하라
			System.out.println("finally : 크아앙");
		}
		
		
		System.out.println("2");
		
		try {
			System.out.println(arr[6]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("catch : 잡았다22");
				try {
					System.out.println(arr[8]);
					}catch(ArrayIndexOutOfBoundsException ee) {
						System.out.println("catch : 잡았다33");
					}
			}
		
		System.out.println("3");
		
		try {
			int res = 10/0;
		}catch(Exception aaa) {
			System.out.println("산술적 예외 발생");
		}
	}


}
