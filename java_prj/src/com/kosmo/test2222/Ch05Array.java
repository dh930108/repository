package com.kosmo.test2222;

public class Ch05Array {
	public static void main(String[] args) {
	//타입[] ____ = new 타입[크기];
	//Hello[] _____ = new Hello[];
		
	//선언 + new 생성 후 --> 사용
		int[] numArr = new int[5];
	//	numArr[0] ~ numArr[4]
		
		System.out.println(numArr[4]);
		
		
		int[] numArr2 = new int[5];
		
		//밑의 3개는 같은 문법
		int[] numArr3 = new int[] {10,30,50};
		int[] numArr4 = {10,30,50}; //new가 된것
		int[] numArr5 = new int[3];
		numArr5[0] = 10;
		numArr5[1] = 30;
		numArr5[2] = 50;
		int[] arr[] = new int[3][];
		arr[0] = new int[2];
		arr[0][1] = 5;
		
		arr[0][0] = 5;
		arr[0][1] = 5;
		arr[5][5] = 5;
		
//		int[][] arrr;
//		arrr = { {1,2}, {3,4}, {5,6}};
		
		//System.out.println("바보 + " + arrr[0][0]);
		
		Ch02Var c1 = new Ch02Var();
		Ch02Var c2 = new Ch02Var();
		Ch02Var c3 = new Ch02Var();
		//문법주의 () <==빼기
		//Ch02var[] carr = new Ch02Var()[3];
		
		
		
		System.out.println(c1.point);
		c1.point = 5000; // static 값이기 때문에 c2.point도 5000이 됨
		System.out.println(c2.point);
		//------------------------
		System.out.println(c1.point2);
		c1.point2 = 5000; // 서로 다른 new로 선언되서 c2는 값이 안변함
		System.out.println(c2.point2);
		
		
		//------------------------
		Ch02Var[] carr = new Ch02Var[3]; 
		
		carr[0] = new Ch02Var();
		carr[1] = new Ch02Var();
		carr[2] = new Ch02Var();
		
//		for(int i=0;i<3;i++) {
//			carr[i] = new Ch02Var();
//		} // 객체 배열은 실제 객체 생성이 아닌 주소값범위만 잡으므로 
//		  // 각 객체별로 new해줄 필요가 있다.
		

		System.out.println(carr[0].point2);
		carr[0].point2 = 3000;
		System.out.println(carr[1].point2);
		
		
		String[] strArr = {"aa","bb"};
		
		String[] strArr2 = new String[] {"aa","bb"};
		
		String[] strArr3 = new String[2];
		strArr3[0] = "aa";
		strArr3[1] = "bb";
		
		
		
		System.out.println(strArr[0]);
		System.out.println(strArr[1]);
		System.out.println(strArr2[0]);
		System.out.println(strArr2[1]);
		System.out.println(strArr3[0]);
		System.out.println(strArr3[1]);
		
		
		
		char[] cArr = {'a','b','c'};
		
		System.out.println(cArr[0]);
		System.out.println(cArr[1]);
		System.out.println(cArr[2]);
		
		
		//----------같은문법-----------------
		String str1 = new String("123");
		String str2 = "123";
		char[] str3 = new char[] {'1','2','3'};
		
		
		
		
		
		String name = "kdh";
		String name2 = new String("kdh");
		char[] name3 ={'k','d','h'};
		
		
//		int score[] = new int[3];
//		int score[] = new int[] {88,77,88};
		int score1[] = {88,77,88};
		int score2[] = {55,66,44};
		
		
		
//		for(int i=1; i<6; i++) {
//			System.out.println(i);
//		}
//		int[] numarr = new int[] {1,2,3,4,5,6,7,8,9};
//		int[] gob = new int[] {1,2,3,4,5,6,7,8,9};
//		for (int i=0; i<numarr.length; i++) {
//			System.out.println(numarr[i] + "단");
//				for(int g=0; g<gob.length;g++) {
//					System.out.println(gob[g]);
//
//			}
//		}
		
		int[] dan = new int[] {1,2,3,4,5};
		for(int i=0;i<3;i++)
		{
			System.out.println(dan[i+2]);
		}
		
		int[] stu = {100,80,90,100};
		int hap = 0;
		for(int i=0; i<stu.length;i++) {
			//hap = hap + stu[i];
			hap += stu[i];
		}
		double avg = (double)hap/stu.length;
		
		System.out.println("총합은 " + hap + " 평균은  " + avg);
		
		//String abc = {"ABCDE"};
		//abc[0] = {"ABCDE"}; <=  배열의 주소가 들어가므로 NEW가 필요
		
		String abc = "ABCDE";
		for(int i=0; i < abc.length(); i++) {
			char ch = abc.charAt(i);
			System.out.println("src.charAt("+i+") :"+ ch);
		}
		
		char[] chArr = abc.toCharArray();
		
		System.out.println(chArr);
		System.out.println(chArr.length);
		
		
		
		System.out.println("=========kongkong==========");
		
		int[][] jtScore = new int[][] { {100,90,80,1,50},
										{88,87,86,1,50},
										{44,47,49,1,50},	
										{78,77,76,1,50}};
										
		Integer results[] = {new Integer(3), new Integer(5)};
		
		System.out.println(5%10 +" 개  ");
	    System.out.println(jtScore[0].length);
		System.out.println(jtScore[1].length);
		System.out.println(jtScore.length);
		
		System.out.println(jtScore[0][0]);
		
		
		//for(int i=0;i<jtScore.length;i++)<=에러, [3]의 length를 조회해버림 
		
		//1. 각 학생별 평균점수
		for(int i=0;i<jtScore.length;i++) {
			int jthap = 0;
			for(int j=0;j<jtScore[i].length;j++) {
				jthap = jthap + jtScore[i][j];	
			}
		System.out.println("학생" + (i+1) + "번 평균은 " + jthap/jtScore[i].length);
		}
		
		
		
		
		System.out.println("======이건 회차별======");
		//2. 각 회차별 평균점수
		for(int i=0;i<jtScore[0].length;i++) {
			int jthap = 0;
			for(int j=0;j<jtScore.length;j++) {
				jthap = jthap + jtScore[j][i];	
			}
		System.out.println( (i+1) +"회차" + " 평균은 " + jthap/jtScore.length);
		}
		
		
		System.out.println("===============");
		
		int[] answer = {1,4,4,3,2,6,7};
		
		for(int i=0; i<answer.length;i++) {
			System.out.print(answer[i] + " : ");
			for(int j=0; j<answer[i];j++) {
			System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("===============");
		
	/*	int[][] jtScore = new int[][] { {100,90,80,1,50},
										{88,87,86,1,50},
										{44,47,49,1,50},	
										{78,77,76,1,50}};*/
		
		
		int[][] jtcp = new int[jtScore.length+1][jtScore[0].length+1];
		
		
		
		for(int i=0; i<jtcp.length;i++) {
			
			int hap1 = 0;
			int hap2 = 0;
			for(int j=0; j<jtcp[0].length-1;j++){
				if( i < jtScore.length) {
				jtcp[i][j] = jtScore[i][j];
				}
				hap1 += jtcp[i][j];
				if( i < jtScore.length) {
				System.out.print(jtcp[i][j] + "\t");
				}
			}
			if( i < jtScore.length) {
			jtcp[i][jtcp[0].length-1] = hap1;
			System.out.print(jtcp[i][jtcp[0].length-1]);
			}
			
			for(int j=0; j<jtcp.length-1;j++) {
				hap2 += jtScore[j][i] ;
			}
			jtcp[jtcp.length-1][i] = hap2;
			if( i < jtScore.length) {
			System.out.println();
			}
		}
		int hap3 = 0;
		for(int i=0; i<jtcp.length-1;i++) {
			hap3 += jtcp[i][jtcp[0].length-1];
		}
		jtcp[jtcp.length-1][jtcp[0].length-1] = hap3;
		
		for(int i=0; i<jtcp[0].length;i++) {
			System.out.print(jtcp[jtcp.length-1][i] + "\t");
		}
		
				
				
			}
			
			
	
		
		
		
		
		
		
}
	
