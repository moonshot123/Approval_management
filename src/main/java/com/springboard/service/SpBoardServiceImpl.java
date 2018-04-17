package com.springboard.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboard.dao.SpBoardDao;
import com.springboard.vo.SpBoardMemVo;
import com.springboard.vo.SpBoardVo;

@Service("spboardservice")
public class SpBoardServiceImpl implements SpBoardService{
	
	@Resource(name="spboarddao")
	SpBoardDao spboarddao;

	@Override
	public int getcountid(String id) {
		// TODO Auto-generated method stub
		int cnt = spboarddao.getcountid(id);
		return cnt;
	}

	@Override
	public int joinmem(SpBoardMemVo vo) {
		// TODO Auto-generated method stub
		int cnt = spboarddao.joinmem(vo);
		
		return cnt;
	}

	@Override
	public SpBoardMemVo login(String mem_id) {
		// TODO Auto-generated method stub
		SpBoardMemVo vo =spboarddao.login(mem_id);
		return vo;
	}

	@Override
	public List<SpBoardVo> getlist() {
		// TODO Auto-generated method stub
		List<SpBoardVo> list = spboarddao.getlist();
		return list;
	}

	@Override
	public int writebo(SpBoardVo vo) {
		// TODO Auto-generated method stub
		int cnt = spboarddao.writebo(vo);
		return cnt;
	}

	@Override
	public SpBoardVo getboard(String seq) {
		// TODO Auto-generated method stub
		SpBoardVo vo = spboarddao.getlist(seq);
		return vo;
	}

	@Override
	public int withdraw(String id) {
		// TODO Auto-generated method stub
		int cnt = spboarddao.getwithdraw(id);
		return cnt;
	}	
	
}
