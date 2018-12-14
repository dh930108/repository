package com.kosmo.test2222;

import java.util.ArrayList;

public interface Ch99JDBC {
	public abstract ArrayList<EmpVO> empList(String gubun ,Object oval );
	public abstract ArrayList<EmpVO> empList(int empno);
	public abstract ArrayList<EmpVO> empList();
	public abstract int empInsert(int prmEmpno, String prmEname);
	public abstract int empUpdate(int prmSal, int prmEmpno);
	public abstract int empDelete(int prmEmpno);
}
