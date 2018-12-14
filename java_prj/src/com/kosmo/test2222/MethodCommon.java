package com.kosmo.test2222;

import java.util.*;

public class MethodCommon {
	int point = 50000;
	String nation = "korea";
	HashMap map = new HashMap();
	
	
	
	//클래스명과같은 2단 메서드 : 생성자(함수) Constructor
	//초기화
	//컴파일러는 해당 클래스 컴파일 시 생성자가 단 한개도 없을 경우 
	//기본생성자( public Class(){} )를 만들어준다
	
	//기본생성자
	public MethodCommon() {
		map.put("key_id","lee");
		map.put("key_pw", "q1w2e3");
		map.put("key_name", "이씨");
	}
	
	
	//파라미터가 있는, 매개변수가 있는 생성자
	public MethodCommon(int poi ,String nat) {
		this.point = poi;
		this.nation = nat;
		
		map.put("key_id","hong");
		map.put("key_pw", "1234");
		map.put("key_name", "홍씨");
	}
	
	//전역변수값 리턴
	//get+변수명, getPoint getNation
	
	public int getPoint() {
		return this.point;
	}
	
	public String getNation() {
		return this.nation;
	}
	
	//입력받은 파라미터 값을 전역변수에 넣는
	//set+변수명, setPoint setNation
	
	public void setPoint(int i) {
		this.point = i;
	}
	
	public void setNation(String s) {
		this.nation= s;
	}
	
	public void reSet() {
		this.point = 50000;
		this.nation = "korea";
	}
	
	//double 타입 두개를 입력받아 더해서 합을 리턴하는
	//add매서드를 만드시오.
	public double add(double a, double b) {
		double hap = a + b;
		return hap;
	}
	
	//int[] 배열을 입력받아 3번쨰 값을 리턴하는
	//getItem이란 메서드 생성
	public int getItem(int[] iarr) {
		int res = 0;
		if(iarr.length >= 3) {
		 res = iarr[2];
		}
		return res;
	}
	
	
	//HashMap을 파라미터로 받아
	//키값이 name인 값을 리턴
	//getItembyMap 메서드 생성
	public String getItembyMap(HashMap mapp) {
		String res = "";
		res = (String)mapp.get("key_name");
		return res;
	}
	
	//문자열 배열을 파라미터로 받아
	//ArrayList로 변환해서 리턴
	//메서드명 : convertArrayToList
	
	public ArrayList convertArrayToList(String[] strr) {
		ArrayList al = new ArrayList();
		for(int i=0;i<strr.length;i++) {
			al.add(strr[i]);
		}
		return al;
		
	}
	
	//배열의 인덱스를 파라미터로 받아
	//그 인덱스의 다음 데이터를 리턴하는
	//next 메서드
	//다음 데이터 없으면 null
	public Object next(Object[] arr, int num) {
		Object a = null;
		if(num+1 < arr.length && num+1 >= 0) 
		a = arr[num+1];
		return a;
	}
	
	
	//아이디,비번을 입력 받아
	//이름을 리턴하는(하드코딩)
	//login 메서드 생성
	public String login(String lid, String lpw) {
		String name = "김동현님";
		return name;
	}
	
	
	//맵의 키를 파라미터로 받아
	//그 값을  리턴하면
	//getValueByMap 메서드 생성
	
	public String getValueByMap(String key) {
		String res;
		res = (String)this.map.get(key);
		if (res==null)
		 res = "key값 에러";
		return res;
	}
	

}
