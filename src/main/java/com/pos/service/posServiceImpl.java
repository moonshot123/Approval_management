package com.pos.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pos.dao.posDao;
import com.pos.vo.menuVO;
import com.pos.vo.sellVO;

@Service("posService")
public class posServiceImpl implements posService{
	
	@Resource(name="posdao")
	private posDao posdao;

	@Override
	public List<menuVO> list() {
		// TODO Auto-generated method stub
		List<menuVO> list= posdao.list();
		
		return list;
	}

	@Override
	public List<sellVO> selllist() {
		// TODO Auto-generated method stub
		List<sellVO> list= posdao.selllist();
		return list;
	}
	
	
	
	
}
