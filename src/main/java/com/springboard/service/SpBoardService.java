package com.springboard.service;

import java.util.List;
import java.util.Map;

import com.springboard.vo.SpBoardMemVo;
import com.springboard.vo.SpBoardVo;

public interface SpBoardService {

	int getcountid(String id);

	int joinmem(SpBoardMemVo vo);

	SpBoardMemVo login(String mem_id);

	List<SpBoardVo> getlist();

	int writebo(SpBoardVo vo);

	SpBoardVo getboard(String seq);

	int withdraw(String id);

}
