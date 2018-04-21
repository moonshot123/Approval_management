package com.approval.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.approval.dao.approvalDao;
import com.approval.vo.Document;
import com.approval.vo.DocEmpLine;
import com.approval.vo.Employee;

@Service("approvalService")
public class approvalServiceImpl implements approvalService{

	@Resource(name="approvalDao")
	private approvalDao approvalDao;

	@Override
	public Employee logincheck(String EMPID) {
		// TODO Auto-generated method stub
		
		Employee cnt = approvalDao.logincheck(EMPID);
		
		return cnt;
	}


	@Override
	public Document detail(int dOMSEQ) {
		// TODO Auto-generated method stub
		Document detail = approvalDao.detail(dOMSEQ);	
		return detail;
	}

	@Override
	public int write(Document document) {
		// TODO Auto-generated method stub
		
		int cnt = approvalDao.write(document);
		return cnt;
	}

	@Override
	public List<DocEmpLine> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<DocEmpLine> list= approvalDao.list(map);
		return list;
	}

	@Override
	public int appline(Document document) {
		// TODO Auto-generated method stub
		int cnt = approvalDao.update(document);		
		return cnt;
	}


	@Override
	public int Lineselect(Document document) {
		// TODO Auto-generated method stub
		int cnt = approvalDao.Lineselect(document);
		return cnt;
	}


	@Override
<<<<<<< HEAD
	public List<Employee> milist() {
		// TODO Auto-generated method stub
		List<Employee> list= approvalDao.milist();
		return list;
	}


	@Override
	public int setlistmi(Employee list) {
		// TODO Auto-generated method stub
		int cnt = approvalDao.setlistmi(list);
		return cnt;
	}


=======
	public int banline(Document document) {
		// TODO Auto-generated method stub
		int cnt = approvalDao.updateban(document);
		return cnt;
	}

>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	
	
}
