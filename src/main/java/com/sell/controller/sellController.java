package com.sell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sell.service.sellService;
import com.sell.vo.orderProduct;
import com.sell.vo.orderlistVO;
import com.sell.vo.product;

@Controller
public class sellController {
	
	@Resource(name="sellservice")
	private sellService sellservice;
	
	/**
		리스트
	*/
	@RequestMapping(value="list.se")
	public String list(Model model){
		
		List<product> list= sellservice.list();
		
		model.addAttribute("list", list);			
		
		for(product a : list){
			System.out.println(a.toString());
		}
		return"sell/selllist";
	}
	
	
	/**
		주문리스트
	*/
	@RequestMapping(value="orderlist.se")
	public String orderlist(Model model){
		
		List<orderlistVO> orderlist= sellservice.orderlist();
		
		for(orderlistVO or : orderlist){
			System.out.println(or.toString());
		}
					
		model.addAttribute("orderlist", orderlist);
		return"sell/sellform";
	}
	
		
	
	/**
		주문리스트입력
	 */
	@RequestMapping(value="order.se")
	public String order(Model model,HttpServletRequest request){
		System.out.println("오더");
	
		String[] list= request.getParameterValues("checkProduct");
		int cnt=0;
		orderProduct op = new orderProduct(); 
		String num ="";
		long random= System.currentTimeMillis ();
		num = "co"+random;	
		
		if(list != null){		
			for(String seq : list){			
											
				op.setOrderseq(num);
				op.setSellseq(Integer.parseInt(seq));
				
				cnt = sellservice.order(op);						
			}						
		}
								
		if(cnt == 1){
			System.out.println("입력성공");
		}else{
			System.out.println("입력실패");
		}		
		return"redirect:/orderlist.se";
	}
	
	
	/**
		주문취소
	*/
	@RequestMapping(value="cancel.se")
	public String cancel(Model model,HttpServletRequest request){
		
		String orderseq = request.getParameter("orderseq");
		
		int cnt = sellservice.cancel(orderseq);
		
		if(cnt == 1){
			System.out.println("취소성공");
		}else{
			System.out.println("취소실패");
		}		
		return"redirect:/order.se";
	}

	
	
}
