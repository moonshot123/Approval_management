package com.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.board.vo.boardVO;

@Repository("boarddao")
public class boardDaoImpl implements boardDao{
	
	@Inject
	SqlSessionTemplate sqlsession;
			
	public List<boardVO> getlist(Map<String, Object> mapSearch) {
		List<boardVO> list=sqlsession.selectList("mapper.boardlistmap",mapSearch);
		return list;
	}
	
	
	
	@Override
	public int insertlist(boardVO vo) {
		int cnt = sqlsession.insert("mapper.boardinsert", vo);
		return cnt;
	}
	
	
	@Override
	public boardVO serchboard(int seq) {		
		boardVO board = sqlsession.selectOne("mapper.boardddetail", seq);
		return board;
	}
	
	
	@Override
	public int updateboard(boardVO vo) {		
		int cnt = sqlsession.update("mapper.boardupdate", vo);
		return cnt;
	}
	
	
	@Override
	public int delboard(String vo) {
		// TODO Auto-generated method stub
		int cnt = sqlsession.delete("mapper.delboard", vo);
		return cnt;
	}



	@Override
	public int getcount(Map<String, Object> mapSearch) {
		int cnt = sqlsession.selectOne("mapper.countboard",mapSearch);
		return cnt;
	}
	
}
