package com.kosmo.test2222;

import java.util.Scanner;

public class Ch04For {
	public static void main (String[] args) {
		//for (_s_,조건,_e_) {...}
		//while(조건) {...}
		//do{...} while(조건)
		
//		for(int i=1; i<10; i=i+1) {
//			System.out.println(i);
//		}
		
		
		
//		for (int dan=2; dan<=9; dan++){
//			System.out.println(dan+"단");
//			 for (int gu=1; gu<=9;gu++) {
//				 System.out.print(dan+" X "+ gu +" = " + dan*gu+ "\t"); // \t : 탭  \n : 줄바꿈
//			 }
//			 System.out.println("");
//		}
		
		//디버깅  
		//라인번호 옆에 브레이크포인트설정하면 그곳까지 실행
		//F6 : 다음줄까지 실행 
		//F7 : 이전줄까지 실행
		//F8 : 디버그종료
	//	for(int i=10;i>0;i=i-1) {
	//		System.out.println(i);
	//	}
		
	
		
				
//		
		
	System.out.println("-------------------------------");
	
	
//	for(int i=0; i<=20; i++) {
//		 for(int h=20; h>=i; h--) {
//			 System.out.print(" ");
//			 }
//			for(int j=0; j<=i; j++) {
//				
//				if(i==0) {
//					System.out.println("@");
//				}
//				else System.out.print("**");
//			}
//			System.out.println("");
//		}
//	for(int i=0;i<=5;i++) {
//		System.out.println("                     ||");
//	}
	
	
	for(int i=0; i<=5; i++) {
		for(int j=0; j<=i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	
	
//		for(int i=9; i>=1; i--) {
//			for(int j=0; j<i; j++) {
//			System.out.print("*");
//			}
//			System.out.println("");
//		}
		
	
/*	for(int i=10;i>0;i--) {
		System.out.println(i);
		myprint();
		System.out.println("a"+i);
	}*/
	
/*	String job = "SALES";
	int num = 3;
	while(job == "SALES") {
		System.out.println("true");
		num--;
		if(num == 0) break;
	}
	System.out.println("===done==="); */
	
	
	
	
/*	int dan = 2;
	while(dan<10) {
		int gu = 1;
		System.out.println(dan + "단");
		while(gu<10) {
			System.out.print(dan + " X " + gu + " = " + dan*gu + "\t");
			gu++;
			if(gu == 10) break;
		}
		System.out.println();
		dan++;
		if(dan == 10) break;
	} */
	
	
//	int gob2 = 0;
//	int z = 0;
//	while (gob2<10) {
//		int dan2 = 2;
//		while(dan2<11) {
//			if(z<9) {
//			System.out.print(dan2+"단" + "\t\t");
//			} else {
//			System.out.print(dan2+" X " + gob2 + " = " + dan2*gob2 + "\t");
//			}
//			z++;
//			dan2++;
//			if(dan2>10)break;
//		}
//		System.out.println();
//		gob2++;
//		if(gob2>10)break;
//	}
	
	
	
	
	System.out.println("======dotodoto======");
	
	
//	System.out.println("for문 으로 ");
//	int hap = 0;
//	for(int i=1; i<11; i++) {
//		hap = hap + i;
//		System.out.println(" 1부터"+i+"의 합 = " + hap);
//	}
//	
//	
//	System.out.println("모지용");
//	String str = "";
//	int sum =0;
//	for(int i=1; i<=10; i++) {
////		if(i==1) str = str + "+"+i;
////		else str = str + i;
//		if(i==10) {str += + i; }
//		else str += (i + "+");
//		sum = sum + i;
//	}
//	System.out.println(str);
//	System.out.println("합은 "+sum);
//	
//	
//	
//	System.out.println();
//	System.out.println("while문 으로 ");
//	hap = 0;
//	int i = 1;
//	while(i < 11) {
//		hap = hap + i;
//		System.out.println(" 1부터"+i+"의 합 = " + hap);
//		i++;
//		if(i>11)break;
//	}
//	
//	
//	
//	System.out.println();
//	System.out.println("dowhile문 으로 ");
//	hap = 0;
//	i = 1;
//	do {
//		hap = hap + i;
//		System.out.println(" 1부터"+i+"의 합 = " + hap);
//		i++;
//		if(i>11)break;
//	}while(i < 11);
		
		
		
		
	}

	
	
	
/*	String line = null;
	do{
		System.out.println("메세지:");
		Scanner s = new Scanner(System.in);
		line = s.nextLine();
		//if(line.equals("q"))break;
	}while(!line.equals("q")); */
	
	
	public static void myprint() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
	}

}
