package com.kosmo.test2222;

import java.util.ArrayList;

public class Ch99JDBCCall {
	public static void main(String[] args) {
		Ch99JDBCImpl t = new Ch99JDBCImpl();
		//ArrayList<EmpVO> list = t.empList();
		
		//ArrayList<EmpVO> list = t.empList("job", "CLERK");
		//ArrayList<EmpVO> list = t.empList("empno", 7499);
		ArrayList<EmpVO> list = t.empList("deptno", 10);
		int resInsert = t.empInsert(9090, "PAPAGO");
		System.out.println(resInsert + "건 생성");
		//int resUpdate = t.empUpdate(1000, 9090);
		//System.out.println(resUpdate + "건 업데이트");
		//int resDelete = t.empDelete(9090);
		//System.out.println(resDelete + "건 삭제");
		
		System.out.println(list.size());
		
		
//		for(int i=0; i<list.size(); i++) {
//			EmpVO evo =list.get(i);
//			System.out.println(evo.getEname());
//		}
		
		// 위for문과 아래 for문과 같다
		for(EmpVO evo : list) {//list 전체 출력
			System.out.println(evo.getEname() + "\t" + evo.getEmpno());
		}
	}

}
