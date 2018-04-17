package com.springboard.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springboard.service.SpBoardService;
import com.springboard.vo.SpBoardMemVo;
import com.springboard.vo.SpBoardVo;


@Controller
public class SpBoardController {
	
	@Resource(name="spboardservice")
	SpBoardService spboardservice;
		
	/**
	  메인으로 가기
	 * */
	@RequestMapping(value="main.sp")
	public String main(HttpServletRequest request,Model model){	
		return"/spboard/login";
	}
	
	
	
	/**
	  회원가입폼으로 가기
	 * */
	@RequestMapping(value="gotojoinform.sp")
	public String gotojoinform(HttpServletRequest request,Model model){	
		return"/spboard/joinform";
	}
	
	
	
	/**
	  아이디체크 ajax
	  @ResponseBody를 써줘야 ajax경로가 설정된다. 이유도 모르고 404당함 꼭 빼먹지 말고 쓰자.........
	 * */
	@RequestMapping(value="checkid.sp")
	public @ResponseBody String checkid(HttpServletRequest request,Model model){
		
		String id = request.getParameter("mem_id");
		int cnt = spboardservice.getcountid(id);
			
		return String.valueOf(cnt);
	}
	
	
	
	/**
	  회원가입
	 **/
	@RequestMapping(value="joinmember.sp")
	public String joinmember(HttpServletRequest request,Model model,SpBoardMemVo vo){
				
		int cnt = spboardservice.joinmem(vo);
		
		if(cnt == 1){
			System.out.println("가입성공");
			model.addAttribute("flag", cnt);
		}else{
			System.out.println("가입실패");
		}			
		return "/spboard/login";
	}
	
	
	
	/**
	  로그인
	 **/
	@RequestMapping(value="login.sp")
	public String login(HttpServletRequest request,Model model,HttpSession session,SpBoardMemVo mem){
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		
		SpBoardMemVo vo = spboardservice.login(mem_id);
		
		if(vo == null){
			System.out.println("아이디틀림");
			model.addAttribute("logincheck", 1);
			
			return "redirect:/main.sp";
		}else{
			if(vo.getMem_pw().equals(mem_pw)){
				System.out.println("로그인성공");
				session.setAttribute("sessionVO", vo);				
				List<SpBoardVo> list= spboardservice.getlist();				
				
				model.addAttribute("list",list);
				model.addAttribute("mem_id", mem_id);
				model.addAttribute("mem_pw", mem_pw);
				
				return "/spboard/boardlist";
			}else{
				System.out.println("비밀번호 틀림");
				model.addAttribute("logincheck", 2);
				
				return "redirect:/main.sp";
			}
		}
						
	}
	
	
	
	/**
	 * 리스트    >>> 입력 다하고 추가로 수정해야됨 지금안됨
	*/	
	@RequestMapping(value="list.sp")
	public String list(HttpServletRequest request,Model model,SpBoardMemVo vo){
				
		List<SpBoardVo> list= spboardservice.getlist();				
		
		model.addAttribute("list",list);
		
		return "/spboard/boardlist";
	}
	
	
	
	/**
	  입력폼으로 이동
	 **/
	@RequestMapping(value="gowrform.sp")
	public String gowrform(HttpServletRequest request, Model model){
		return "/spboard/write";
	}
	
	
	
	/**
	  글저장
	 **/
	@RequestMapping(value="write.sp")
	public String write(HttpServletRequest request,Model model,SpBoardVo vo,
						MultipartHttpServletRequest multirequest,MultipartFile fileName){
		
		
		String path = "C:\\temp\\";
        String file_name = "";
        
        OutputStream out = null;
        PrintWriter printWriter = null;
        
        try {
        	file_name = fileName.getOriginalFilename();
            byte[] bytes = fileName.getBytes();
            
            System.out.println("UtilFile fileUpload fileName : " + file_name);
            System.out.println("UtilFile fileUpload uploadPath : " + path);
            
            File file = new File(path);
            
//          파일명이 중복으로 존재할 경우
            if (file_name != null && !file_name.equals("")) {
                if (file.exists()) {
//                    파일명 앞에 업로드 시간 초단위로 붙여 파일명 중복을 방지
                	file_name = System.currentTimeMillis() + "_" + file_name;
                    
                    file = new File(path + file_name);
                }
            }
            
            System.out.println("UtilFile fileUpload final fileName : " + file_name);
            System.out.println("UtilFile fileUpload file : " + file);
            
            out = new FileOutputStream(file);
            
            System.out.println("UtilFile fileUpload out : " + out);
            
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        vo.setFile_name(file_name);
		vo.setFile_path(path);
		
		System.out.println("");
		
		int cnt = spboardservice.writebo(vo);
		
		if(cnt == 1){
			System.out.println("입력성공");
		}else{
			System.out.println("입력실패");
		}
		
			
		return "redirect:/list.sp";
	}
	
	

	/**
	  상세화면 이동
	 **/
	@RequestMapping(value="upform.sp")
	public String upform(HttpServletRequest request, Model model){
		
		String seq = request.getParameter("SEQ");
		
		SpBoardVo vo = spboardservice.getboard(seq);
		
		
		model.addAttribute("list", vo);
		
		return "/spboard/update";
	}
	
	
	
	/**
	  로그아웃
	 **/
	@RequestMapping(value="logout.sp")
	public String logout(HttpServletRequest request,HttpSession session){
		
		session.invalidate();
		
		return "redirect:/main.sp";
	}
	
	
	/**
	  회원탈퇴
	 **/
	@RequestMapping(value="withdraw.sp")
	public String withdraw(HttpServletRequest request){
		
		String id = request.getParameter("mem_id");
		
		int cnt = spboardservice.withdraw(id);
		
		
		
		
		return "redirect:/main.sp";
	}
}
