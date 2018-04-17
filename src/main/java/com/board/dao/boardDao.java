package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.vo.boardVO;

public interface boardDao {
	
	List<boardVO> getlist(Map<String, Object> mapSearch);
	
	int insertlist(boardVO vo);

	boardVO serchboard(int seq);

	int updateboard(boardVO vo);

	int delboard(String vo);

	int getcount(Map<String, Object> mapSearch);

}
