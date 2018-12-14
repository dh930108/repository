package com.kosmo.test2222;
import java.util.*;

public class MethodCallTest {
	public static void main(String args) {
//		int sum = 0;
//		for(int i=0; i<args.length; i++) {
//			sum += Integer.parseInt(args[i]);
//			System.out.println(args[i]);
//		}
//		System.out.println(sum);
		System.out.println("OverLoading : " + args);
	}
	//오버로딩(OverLoading) : 하나의 클래스안에서 n개의 메서드 관계, 
	//이름이 같고, 매개변수의 타입이 다른것
	
	public static void main(String[] args) {
		//1. static static
		//대상 클래스이름, 메서드명
		//(내꺼면, 내 클래스명)메서드명
		//2. new
		
		MethodCommon mc = new MethodCommon();
		double c = 0;
		MethodCallTest.main("a");
		c = mc.add(5.7, 7.7);
		System.out.println(c);
		
		
		int[] irr = new int[]{4,3,8,6,5};
		int i = 0;
		i = mc.getItem(irr);
		System.out.println(i);
		
		
		HashMap mapp = new HashMap();
		mapp.put("key_name", "김동현씨");
		mapp.put("key_age", 26);
		String mapres = mc.getItembyMap(mapp);
		System.out.println(mapres);
		
		
		String[] strr = {"aa","bb","cc","dd","ee","ff"};
		ArrayList alres = mc.convertArrayToList(strr);
		for(int a=0;a<alres.size();a++) {
			System.out.print(alres.get(a) + "\t");
		}
		System.out.println();
	
		
		Object obres = mc.next(strr, 3);
		System.out.println(obres);
		
		int pres = mc.getPoint();
		String nres = mc.getNation();
		System.out.println(pres);
		System.out.println(nres);
		
		mc.setPoint(10000);
		mc.setNation("Japan");
		
		pres = mc.getPoint();
		nres = mc.getNation();
		System.out.println(pres + " : " + nres);
		mc.reSet();
		pres = mc.getPoint();
		nres = mc.getNation();
		System.out.println(pres + " :: " + nres);
		
		
		String lname = mc.login("iiiddd", "q1w2e3");
		System.out.println(lname);
		
		
		String mapres2 = mc.getValueByMap("key_name");
		System.out.println(mapres2);
		
		
	}
	


}
