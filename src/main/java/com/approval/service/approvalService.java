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

	

	

}
