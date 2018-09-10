package com.nt.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOPreprationDAO implements DBOPreprations
{
	private static final String INSERT_QRY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL)values(?,?,?,?)";
	private static final String GET_EMP_SALARY="SELECT SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS_BY_NO="select sal,job,ename from emp where empno=?";
	private static final String GET_ALL_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	private static final String UPDATE_EMP_SALARY="UPDATE EMP SET SAL=? WHERE EMPNO=?";
	private static final String DELETE_EMP="DELETE FROM EMP WHERE EMPNO=?";
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt)
	{
		this.jt = jt;
	}
public int insert(int no, String name, String job, long sal)
{
	int result=jt.update(INSERT_QRY,no,name,job,sal);
		return result;
	}
     public int getSalary(int no) 
     {
    	 int salary=jt.queryForInt(GET_EMP_SALARY,no);
		return salary;
	}
     
	public Map<String, Object> listEmpDetails(int no)
	{
	 Map<String,Object>map=jt.queryForMap(GET_EMP_DETAILS_BY_NO,no);	
	return map;
	}
	public List<Map<String, Object>> listAllEmpDetails() 
	{
		List<Map<String, Object>> list=jt.queryForList(GET_ALL_EMP_DETAILS);
		return list;
	}
	public int UpdateEmpSalary(int no, int newsal)
	{
		int result=jt.update(UPDATE_EMP_SALARY,newsal, no);
	   return result;
	}
	public int deleteEmp(int no) 
	{
		int result=jt.update(DELETE_EMP,no);
			return result;
	}
}