package com.pos.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.pos.vo.menuVO;
import com.pos.vo.sellVO;

@Repository("posdao")
public class posDaoImpl implements posDao{
	
	@Inject
	private SqlSessionTemplate sqlsessiontemplate;
	
	@Override
	public List<menuVO> list() {
		// TODO Auto-generated method stub
		List<menuVO> list= sqlsessiontemplate.selectList("pos.menuList");
		return list;
	}
	
	@Override
	public List<sellVO> selllist() {
		// TODO Auto-generated method stub
		List<sellVO> list= sqlsessiontemplate.selectList("pos.sellList");
		return list;
	}
	
	
	
	
}
