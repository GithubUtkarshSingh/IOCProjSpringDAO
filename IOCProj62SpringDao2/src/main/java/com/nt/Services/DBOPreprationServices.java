package com.nt.Services;

import java.util.List;
import java.util.Map;

import com.nt.Dao.DBOPreprations;

public class DBOPreprationServices 
{
	private DBOPreprations dbo;

	public void setDbo(DBOPreprations dbo)
	{
		this.dbo = dbo;
	}
	public String registerEmp(int no,String name,String job,int sal)
	{
		int result=dbo.insert(no, name, job, sal);
		if(result==0)
			return no+"Emp is not registered";
		else
			return no+"Emp is registered";
	}
	public int showSalary(int no)
	{
		int salary=dbo.getSalary(no);
		return salary;
	}
	public String hikeSalary(int no)
	{
		int salary=showSalary(no);
		int newsal=0;
		if(salary>=50000)
			newsal=Math.round(salary+(salary*0.1f));
		else
			newsal=Math.round(salary+(salary*0.2f));
		int result=dbo.UpdateEmpSalary(no, newsal);
		if(result==0)
			return no+"Emp Salary not hiked";
		else
			return no+"Emp Salary hiked";
	}
	public Map<String,Object>getEmpDetails(int no)throws Exception
	{
		Map<String,Object>map=dbo.listEmpDetails(no);
		if(map!=null)
			return map;
		else
			throw new Exception(no+"Emp not found");
	}
	public List<Map<String,Object>>getAllEmpDetails()throws Exception
	{
	List<Map<String,Object>>list=dbo.listAllEmpDetails();
	if(list!=null)	
		return list;
	else
		throw new Exception("Employee not found");
}
	public String fireEmp(int eno)
	{
		int result=dbo.deleteEmp(eno);
		if(result==0)
			return eno+"Employee not found";
		else
			return "Employee deleted";
	}
}