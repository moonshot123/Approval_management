package com.sell.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sell.vo.orderProduct;
import com.sell.vo.orderlistVO;
import com.sell.vo.product;

@Repository("selldao")
public class sellDaoImpl implements sellDao{

	@Inject
	SqlSessionTemplate SqlSessionTemplate;

	@Override
	public List<product> list() {
		// TODO Auto-generated method stub
		List<product>list = SqlSessionTemplate.selectList("sell.list");
		return list;
	}

	@Override
	public int order(orderProduct op) {
		// TODO Auto-generated method stub
		int cnt = SqlSessionTemplate.insert("sell.order", op);
		return cnt;
	}

	@Override
	public List<orderlistVO> orderlist() {
		// TODO Auto-generated method stub
		List<orderlistVO> orderlist = SqlSessionTemplate.selectList("sell.orderlist");
		return orderlist;
	}

	@Override
	public int cancel(String orderseq) {
		// TODO Auto-generated method stub
		
		int cnt = SqlSessionTemplate.update("sell.cancel", orderseq);
		
		return cnt;
	}

	
	
	
}
