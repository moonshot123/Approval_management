package com.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.dao.boardDao;
import com.board.vo.boardVO;

@Service("boardservice")
public class boardServiceImpl implements boardService {
	
	@Resource(name="boarddao")
	private boardDao boarddao;
	
	
	public List<boardVO> getboardlist(Map<String, Object> mapSearch) {
		
		List<boardVO> list = boarddao.getlist(mapSearch);
		
		return list;
	}
	
	
		
	public int insertboard(boardVO vo) {
		
		int cnt= boarddao.insertlist(vo);
		
		return cnt;
	}


	@Override
	public boardVO serboard(int seq) {
		
		boardVO board = boarddao.serchboard(seq);
		
		return board;
	}



	@Override
	public int updateboard(boardVO vo) {
		// TODO Auto-generated method stub
		
		int cnt = boarddao.updateboard(vo);
		return cnt;
	}



	@Override
	public int delboard(String vo) {
		// TODO Auto-generated method stub
		int cnt = boarddao.delboard(vo);		
		return cnt;
	}
	
	
	
	@Override
	public int listcount(Map<String, Object> mapSearch) {
		int count = boarddao.getcount(mapSearch);
		return count;
	}



}
