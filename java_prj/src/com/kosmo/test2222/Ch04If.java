package com.kosmo.test2222;

public class Ch04If {
	
	public static void main(String[] args) {
		
		
		int empno = 7733;
		int sal = 2000;
		if(empno==7733 || sal>2000){
			System.out.println("ture");
		} else {
			System.out.println("false");
		}
		
		
		
//		decode(10,'10번부서',20,'20번부서',30,'30번부서',40,"해당없음");
		int deptno = 20;
		if(deptno==10) {
			System.out.println("10번부서");
		} else if(deptno==20){
			System.out.println("20번부서");
		} else if(deptno==30){
			System.out.println("30번부서");
		} else {
			System.out.println("해당없음");
		};
		
		
		int comm = 100;
		if(comm>=90) {
			System.out.println("90");
		} else if(comm>=80){
			System.out.println("80");
		} else {
			System.out.println("해당없음");
		};
		
		System.out.println("======done======");
		
		
		switch(deptno) {
			case 90:
				System.out.println("10");
			case 80 :
				System.out.println("20");
			default :
				System.out.println("20");
			
		}
		
		System.out.println("===done===");
		
	}

}
