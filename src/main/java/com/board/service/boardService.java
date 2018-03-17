package com.board.service;

import java.util.List;
import java.util.Map;

import com.board.vo.boardVO;

public interface boardService {

	List<boardVO> getboardlist(Map<String, Object> mapSearch);
		
	int insertboard(boardVO vo);
	
	boardVO serboard(int seq);
	
	int updateboard(boardVO vo);
	
	int delboard(String a);
	
	int listcount(Map<String, Object> mapSearch);
	
	
}
