package com.approval.service;


import java.util.List;
import java.util.Map;

import com.approval.vo.Document;
import com.approval.vo.DocEmpLine;
import com.approval.vo.Employee;

public interface approvalService {

	Employee logincheck(String EMPID);

	Document detail(int dOMSEQ);

	int write(Document document);

	List<DocEmpLine> list(Map<String, Object> map);

	int appline(Document document);

	int Lineselect(Document document);
<<<<<<< HEAD

	List<Employee> milist();

	int setlistmi(Employee list);
	
=======
	
	int banline(Document document);
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad

}
