package com.springboard.dao;

import java.util.List;
import java.util.Map;

import com.springboard.vo.SpBoardMemVo;
import com.springboard.vo.SpBoardVo;

public interface SpBoardDao {

	int getcountid(String id);

	int joinmem(SpBoardMemVo vo);

	SpBoardMemVo login(String mem_id);

	List<SpBoardVo> getlist();

	int writebo(SpBoardVo vo);

	SpBoardVo getlist(String seq);

	int getwithdraw(String id);
	
}
