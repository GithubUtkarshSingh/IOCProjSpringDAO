package com.nt.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.nt.Services.DBOPreprationServices;
public class CientApp
{
	public static void main(String[] args) throws Exception
	{
		ApplicationContext ctx=null;
		DBOPreprationServices services=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/ApplicationContext.xml");
		services=(DBOPreprationServices) ctx.getBean("DBOService");
		System.out.println("7499 Emp Details"+services.getEmpDetails(7499));
		System.out.println("All Emp Details"+services.getAllEmpDetails());
		System.out.println("7499 Emp Salary(Before hike)"+services.showSalary(7499));
		System.out.println("7499 Emp Salary hiking......"+services.hikeSalary(7499));
		System.out.println("7499 Emp Salary (after hiking)"+services.showSalary(7499));
		System.out.println(services.registerEmp(9902,"Utkarsh","Programmer",10005));
		

	}

}
