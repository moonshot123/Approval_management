package com.springboard.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springboard.vo.SpBoardMemVo;
import com.springboard.vo.SpBoardVo;


@Repository("spboarddao")
public class SpBoardDaoImpl implements SpBoardDao{
	
	@Inject
	SqlSessionTemplate sqlsession;

	@Override
	public int getcountid(String id) {
		// TODO Auto-generated method stub	
		int cnt = sqlsession.selectOne("spmapper.checkid", id);
		return cnt;
	}

	@Override
	public int joinmem(SpBoardMemVo vo) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.insert("spmapper.insertmem", vo);
		return cnt;
	}

	@Override
	public SpBoardMemVo login(String id) {
		// TODO Auto-generated method stub
		SpBoardMemVo vo = sqlsession.selectOne("spmapper.loginmem", id);
		
		return vo;
	}

	@Override
	public List<SpBoardVo> getlist() {
		// TODO Auto-generated method stub		
		List<SpBoardVo> list= sqlsession.selectList("spmapper.getlist");
		return list;
	}

	@Override
	public int writebo(SpBoardVo vo) {
		// TODO Auto-generated method stub
		int cnt= sqlsession.insert("spmapper.write", vo);
		return cnt;
	}

	@Override
	public SpBoardVo getlist(String seq) {
		// TODO Auto-generated method stub
		SpBoardVo vo = sqlsession.selectOne("spmapper.getboard", seq);
		return vo;
	}

	@Override
	public int getwithdraw(String id) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.update("spmapper.withdraw", id);
		return cnt;
	}
	
	
	
	
	
}
