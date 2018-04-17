package com.pos.service;

import java.util.List;

import com.pos.vo.menuVO;
import com.pos.vo.sellVO;

public interface posService {

	List<menuVO> list();

	List<sellVO> selllist();

}
