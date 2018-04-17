package com.sell.dao;

import java.util.List;

import com.sell.vo.orderProduct;
import com.sell.vo.orderlistVO;
import com.sell.vo.product;

public interface sellDao {

	List<product> list();

	int order(orderProduct op);

	List<orderlistVO> orderlist();

	int cancel(String orderseq);

	

}
