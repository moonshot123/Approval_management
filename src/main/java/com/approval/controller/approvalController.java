package com.approval.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.approval.service.approvalService;
import com.approval.vo.Document;
import com.approval.vo.DocEmpLine;
import com.approval.vo.Employee;

//map 으로 세션을 넣으면 여러개 가지고 다닌다.

@Controller
public class approvalController {
	
	@Resource(name="approvalService")
	private approvalService approvalService; 
	
	/**
		로그인페이지로 이동
	*/	
	@RequestMapping(value="main.ap")
	public String start(){		
		return "approval/login";
	}
	
	
	/**
		로그인 확인 
	*/
	@RequestMapping(value="login.ap")
	public String login(Model model,Employee e, HttpSession session,HttpServletRequest request){
		
		System.out.println("=====e.getEMPID()======"+e.getEMPID());
		String EMPID = request.getParameter("EMPID");
		String EMPPW = request.getParameter("EMPPW");
		List<DocEmpLine> list;
		
		Employee check = approvalService.logincheck(EMPID);
				
		if(check==null){
			System.out.println("아이디가 잘못되었습니다.");
			model.addAttribute("ID", "fail");			
			return "approval/login";
		}else{			
			if(EMPPW.equals(check.getEMPPW())){
			System.out.println("로그인되었습니다.");
			session.setAttribute("sessionEMPNAME",check.getEMPNAME());
			session.setAttribute("sessionEMPGRADE",check.getEMPGRADE());
			
			Map<String, Object> map = new HashMap<String, Object>(); 
			
			map.put("EMPID", EMPID);
			
			
			list = approvalService.list(map);				
						
			model.addAttribute("ID", EMPID);
			model.addAttribute("EMPPW", EMPPW);
			model.addAttribute("list", list);
			
			return "approval/list";
			
			}else{			
				System.out.println("비밀번호가 잘못되었습니다.");
				model.addAttribute("PW", "fail");
				return "approval/login";
			}
		}	
	}
	
	
	/**
		리스트, 검색
	 */
	@RequestMapping(value="list.ap")
	public String list(Model model,Employee e, HttpSession session,HttpServletRequest request){
		
		String EMPID = request.getParameter("EMPID");		
		String serchtype= request.getParameter("serchtype");
		String serchtext= request.getParameter("serchtext");
		String stdate= request.getParameter("stdate");
		String endate= request.getParameter("endate");
		
		System.out.println("stdate+++++++++++++++++++++"+stdate);
		System.out.println("endate+++++++++++++++++++++"+endate);
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("EMPID", EMPID);
		map.put("serchtype", serchtype);
		map.put("serchtext", serchtext);
		map.put("stdate", stdate);
		map.put("endate", endate);
		
		List<DocEmpLine> list = approvalService.list(map);
		
		model.addAttribute("ID", EMPID);
		model.addAttribute("list",list);
		
		return "approval/list";
	}
	
		
	/**
		로그아웃
	*/
	@RequestMapping(value="logout.ap")
	public String logout(HttpSession session){
				
		session.invalidate();
		System.out.println("로그아웃성공");
		return "redirect:/main.ap";
	}
	
	
	/**
		글쓰기
	*/
	@RequestMapping(value="writeform.ap")
	public String goform(HttpServletRequest request, Model model,HttpSession session){
		String EMPID= request.getParameter("EMPID");
		System.out.println("글쓰기 사원정보"+EMPID);
		
		Employee check = approvalService.logincheck(EMPID);
		model.addAttribute("Employee", check);
		System.out.println("aaaaaaaaaaaa======"+check.getEMPID());		
		return "approval/writeform";
				
	} 
	
	
	/**
		글쓰기정보저장
	*/
	@RequestMapping(value="writedo.ap")
	public String goWRITE(HttpServletRequest request, Model model, Document document){
		
		int cnt = approvalService.write(document);
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("EMPID", document.getEMPID());
		
		List<DocEmpLine> list = approvalService.list(map);				
		
		model.addAttribute("ID", document.getEMPID());	
		model.addAttribute("list", list);
		
		
		if(cnt == 1){
			System.out.println("입력저장");
			//return "redirect:/login.ap";
		}else{
			System.out.println("입력실패");
			//return "redirect:/writeform.ap";
		}
				
		return "approval/list";
				
	} 
	
	
	/**
		상세
	 */
	@RequestMapping(value="detailform.ap")
	public String detailform(HttpServletRequest request, Model model){
		int DOMSEQ= Integer.parseInt(request.getParameter("DOMSEQ"));
		System.out.println("상세정보======"+DOMSEQ);
				
		Document ddetail = approvalService.detail(DOMSEQ);
		
		model.addAttribute("detail", ddetail);
		
		return "approval/detailform";				
	} 
	
	
	/**
		문서 결재라인
	 */
	@RequestMapping(value="approve.ap")
	public String appline(HttpServletRequest request, Model model, Document document,HttpSession session){
		
		int cnt = approvalService.appline(document);
		model.addAttribute("EMPID", document.getEMPID());	
		
		if(cnt == 1){
			System.out.println("결재성공");				
		}else{
			System.out.println("결재실패");			
		}
		return "redirect:/list.ap";	
					
}
		
	
	
}
