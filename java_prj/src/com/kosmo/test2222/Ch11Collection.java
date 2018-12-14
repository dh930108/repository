package com.kosmo.test2222;

import java.util.*;

import org.xml.sax.HandlerBase;

public class Ch11Collection {
	
	public static void main(String[] args) {
		int[] numarr = {1,2,3};
		Ch02Var chVar = new Ch02Var();
		ArrayList list = new ArrayList();
		list.add("aa");
		list.add("bb");
		list.add(69);
		list.add(numarr);
		list.add(chVar);
		
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
			
		}
		
		int[] arr = (int[]) list.get(3);
		System.out.println(arr.length);
		
		Ch02Var var = (Ch02Var)list.get(4);
		
		System.out.println(var);
		
		
		System.out.println(var.point);
		
		String st1 = (String)list.get(1);
		System.out.println(st1);
		
		int su = (int)list.get(2);
		
		
		
		
		
		///--------------------------
		System.out.println("========HashSet===========");
		HashSet set = new HashSet();
		set.add("1");
		set.add("1");
		set.add("3");
		System.out.println(set);
		System.out.println(set.iterator().hasNext());
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		
		 if(it.hasNext() == false) break;
		}
			
		///---------------------------
		System.out.println("=====HashMap======");
		
		HashMap map = new HashMap();
		map.put("name", "kdh");
		map.put("age", 20);
		map.put("arr",numarr);
		map.put("cls", chVar);
		
//		for(int i=0; i<map.size(); i++) {
//			System.out.println(map.get(key));
//		}
		
		String mres1 = (String)map.get("name");
		int mres2 = (int)map.get("age");
		int[] mres3 = (int[])map.get("arr");
		Ch02Var mres4 = (Ch02Var)map.get("cls");
		System.out.println(mres1);
		System.out.println(mres2);
		System.out.println(mres3);
		System.out.println(mres4);
			
		
		
		///---------------------------
		System.out.println("======Collection in Collection======");
		
		ArrayList<HashMap<String,Object>> mlist = new ArrayList<HashMap<String,Object>>();
		
		
		for(int i=0;i<2;i++) {
		HashMap<String,Object> map1 = new HashMap<String,Object>(); // List에 들어가서 구분이 생겼으므로 map이름은 중복가능
		map1.put("name", "lee"+i);
		map1.put("age", i+10);
		mlist.add(map1);
		}
		
		System.out.println("총회원수 : " + mlist.size());
		
		//같은거 3개
		HashMap<String,Object> hm = (HashMap<String,Object>)mlist.get(0);
		System.out.println(hm.get("name"));
		
		System.out.println(((HashMap<String,Object>)mlist.get(0)).get("name"));
		
		//==================
		
		for(int i=0;i<mlist.size();i++) {
			System.out.println(((HashMap<String,Object>)mlist.get(i)).get("name"));
		}
		for(int i=0;i<mlist.size();i++) {
			System.out.println(mlist.get(i));
		}
		
		
		
		
	}

}
