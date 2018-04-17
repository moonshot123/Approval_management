package com.pos.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.service.posService;
import com.pos.vo.menuVO;
import com.pos.vo.sellVO;

@Controller
public class posController {

	@Resource(name="posService")
	private posService posService;
	
	/**
	 * 메인리스트
	 * */
	@RequestMapping(value="main.po")
	public String main(HttpServletRequest request, Model model){
		
		List<menuVO> list= posService.list();
		
		for(menuVO a :list){
			System.out.println(a.toString());
		}
		
		model.addAttribute("menulist", list);
		
		return "pos/mainpos";
	}
	
	
	/**
	 * 판매리스트이동
	 */
	@RequestMapping(value="sellist.po")
	public String selllist(HttpServletRequest request, Model model){
		
		List<sellVO> selllist = posService.selllist();
		
		model.addAttribute("selllist", selllist);
		
		return "pos/selllist";
	} 
	
	
	
	
}
