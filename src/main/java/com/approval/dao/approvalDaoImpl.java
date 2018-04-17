package com.approval.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.approval.vo.Document;
import com.approval.vo.DocEmpLine;
import com.approval.vo.Employee;

@Repository("approvalDao")
public class approvalDaoImpl implements approvalDao{
	
	@Inject
	SqlSessionTemplate sqlsession;
	
	/**
	 * 로그인 확인
	*/
	@Override
	public Employee logincheck(String empid) {
		// TODO Auto-generated method stub		
		Employee cnt = sqlsession.selectOne("approval.logincheck", empid);
		return cnt;
	}
	
	/**
	 * 상세글보기
	*/
	@Override
	public Document detail(int dOMSEQ) {
		// TODO Auto-generated method stub
		Document detail = sqlsession.selectOne("approval.getdetail", dOMSEQ);
		return detail;
	}
	
	/**
	 * 임시저장하기
	*/
	@Override
	public int write(Document document) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.insert("approval.write", document);		
		return cnt;
	}
	
	/**
	 * 리스트
	*/
	@Override
	public List<DocEmpLine> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<DocEmpLine> list = sqlsession.selectList("approval.list", map);
		
		return list;
	}

	/**
	 * 문서 결재라인(결재)
	*/
	@Override
	public int update(Document document) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.update("approval.update", document);
		return cnt;
	}
	
	
	@Override
	public int Lineselect(Document document) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.insert("approval.Lineselect", document);		
		return cnt;
	}

	@Override
	public List<Employee> milist() {
		// TODO Auto-generated method stub
		List<Employee> list= sqlsession.selectList("approval.milist");
		return list;
	}

	@Override
	public int setlistmi(Employee list) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.insert("approval.setmilist", list);
		return cnt;
	}
	
	
	

	
	
	
	
	
}
