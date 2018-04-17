package com.pos.dao;

import java.util.List;

import com.pos.vo.menuVO;
import com.pos.vo.sellVO;

public interface posDao {

	List<menuVO> list();

	List<sellVO> selllist();

}
