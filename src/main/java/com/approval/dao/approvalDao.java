package com.approval.dao;

import java.util.List;
import java.util.Map;

import com.approval.vo.Document;
import com.approval.vo.DocEmpLine;
import com.approval.vo.Employee;

public interface approvalDao {
<<<<<<< HEAD
	
	Employee logincheck(String EMPID);
	
	Document detail(int dOMSEQ);
	
	int write(Document document);
	
	List<DocEmpLine> list(Map<String, Object> map);
	
	int update(Document document);
	
	int Lineselect(Document document);
	
	List<Employee> milist();
	
	int setlistmi(Employee list);
	
	
=======

	Employee logincheck(String EMPID);

	Document detail(int dOMSEQ);

	int write(Document document);

	List<DocEmpLine> list(Map<String, Object> map);

	int update(Document document);

	int Lineselect(Document document);
	
	int updateban(Document document);
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
}
