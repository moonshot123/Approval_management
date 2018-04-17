package com.sell.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sell.dao.sellDao;
import com.sell.vo.orderProduct;
import com.sell.vo.orderlistVO;
import com.sell.vo.product;

@Service("sellservice")
public class sellServiceImpl implements sellService{
	
	@Resource(name="selldao")
	private sellDao selldao;

	@Override
	public List<product> list() {
		// TODO Auto-generated method stub
		List<product> list= selldao.list();
		
		return list;
	}

	@Override
	public int order(orderProduct op) {
		// TODO Auto-generated method stub
		int cnt = selldao.order(op);
		return cnt;
	}

	@Override
	public List<orderlistVO> orderlist() {
		// TODO Auto-generated method stub
		List<orderlistVO> orderlist= selldao.orderlist();
		return orderlist;
	}

	@Override
	public int cancel(String orderseq) {
		// TODO Auto-generated method stub
		
		int cnt = selldao.cancel(orderseq);
		return cnt;
	}

	
}
