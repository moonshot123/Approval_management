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
<<<<<<< HEAD
=======
		System.out.println("============================================empid" + empid);
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
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
<<<<<<< HEAD
		List<DocEmpLine> list = sqlsession.selectList("approval.list", map);
=======
		System.out.println("sssssasdkjalksdjlasjdlssss"+map.get("EMPID"));
		System.out.println("sssssasdkjalksdjlasjdlssss"+map.get("EMPGRADE"));
		
		List<DocEmpLine> list = sqlsession.selectList("approval.list", map);
		/*
		for(DocEmpLine e :list){
			System.out.println("sssssasdkjalksdjlasjdlssss"+e.getEMPGRADE());
			System.out.println("sssssasdkjalksdjlasjdlssss"+e.getEMPGRADE());
		}
		*/
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
		
		return list;
	}

	/**
	 * 문서 결재라인(결재)
	*/
	@Override
	public int update(Document document) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		int cnt = sqlsession.update("approval.update", document);
		return cnt;
	}
	
	
=======
		System.out.println("상태 확인++++++++++++++++++++++++++++++++"+document.getAPPROVALSTATUS());
		int cnt = sqlsession.update("approval.update", document);
		return cnt;
	}

>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	@Override
	public int Lineselect(Document document) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.insert("approval.Lineselect", document);		
		return cnt;
	}
<<<<<<< HEAD

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
	
	
	
=======
	
	
	/**
	 * 문서 결재라인(반려)
	*/
	@Override
	public int updateban(Document document) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.update("approval.updateban", document);
		return cnt;
	}
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad

	
	
	
	
	
}
