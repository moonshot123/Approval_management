package com.board.controller;
	
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
	
import com.board.service.boardService;
import com.board.util.paging;
import com.board.vo.boardVO;
	
@Controller
public class boardController {
	
	@Resource(name="boardservice")
	private boardService boardservice;
	
	
	@RequestMapping(value="/boardlist")
	public ModelAndView boardlist(
								/*
								@RequestParam(required=false) String serch,
								@RequestParam(required=false) String sel,
								@RequestParam(required=false) String sdate,
								@RequestParam(required=false) String ndate,
								*/
								HttpServletRequest request,
						        @RequestParam(defaultValue="1") int curPage
								){
								
		//String pageNoStr = request.getParameter("pageNo")==null?"1":request.getParameter("pageNo");
		//int pageNo = Integer.parseInt(pageNoStr);
		
		String sel = request.getParameter("sel");
		String serch = request.getParameter("serch");
		String sdate = request.getParameter("sdate");
		String ndate = request.getParameter("ndate");
				
		
		ModelAndView mv = new ModelAndView();
		Map<String, Object> mapSearch = new HashMap<String, Object>();
		
		
		mapSearch.put("sel",sel);
		mapSearch.put("serch",serch);
		mapSearch.put("sdate",sdate);
		mapSearch.put("ndate",ndate);			
		mapSearch.put("pageNo",curPage);
		mapSearch.put("listSize",5);
		
		List<boardVO> list = boardservice.getboardlist(mapSearch);
		int countlist = boardservice.listcount(mapSearch);
		
		// 페이지 나누기 관련 처리
	    paging paging = new paging(countlist, curPage);
	    //int start = boardPager.getPageBegin();
	    //int end = boardPager.getPageEnd();
		
		
		mv.addObject("list",list);
		mv.addObject("mapvalue",mapSearch);
		mv.addObject("countlist", countlist);
		mv.addObject("paging", paging);
		mv.setViewName("board/boardlist");
		
		/*for(boardVO e : list){
			System.out.println(e.getMem_id());	
		}
		*/		
		return mv;		
	}
	
	
	//ajax
	@RequestMapping(value="/boardlist.ajax")
	public String ajax(
						HttpServletRequest request,
						Model model, 
						@RequestParam(defaultValue="1") int curPage){
		
		String sel = request.getParameter("sel");
		String serch = request.getParameter("serch");
		String sdate = request.getParameter("sdate");
		String ndate = request.getParameter("ndate");
						
		ModelAndView mv = new ModelAndView();
		Map<String, Object> mapSearch = new HashMap<String, Object>();
		
		
		mapSearch.put("sel",sel);
		mapSearch.put("serch",serch);
		mapSearch.put("sdate",sdate);
		mapSearch.put("ndate",ndate);			
		mapSearch.put("pageNo",curPage);
		mapSearch.put("listSize",5);
		
		List<boardVO> list = boardservice.getboardlist(mapSearch);
		int countlist = boardservice.listcount(mapSearch);
		
		// 페이지 나누기 관련 처리
	    paging paging = new paging(countlist, curPage);
	    //int start = boardPager.getPageBegin();
	    //int end = boardPager.getPageEnd();
		
		
		mv.addObject("list",list);
		mv.addObject("mapvalue",mapSearch);
		mv.addObject("countlist", countlist);
		mv.addObject("paging", paging);
			
		return "board/ajax" ;
	}
	
	
	
	
	/*
	@RequestMapping(value="/boardlist")
	public String boardlist(Model model){
		List<boardVO> list = boardservice.getboardlist();
		model.addAttribute("list",list);
		return "board/boardlist";
	}
	*/
	
	@RequestMapping(value="/writeform")
	public String gowrite(){
		return "board/writeform";
	}
	
	
	@RequestMapping(value="/boardwrite")
	public ModelAndView boardwrite(boardVO vo){
			
		// request.getParameter("name");
		
		System.out.println("==============================");
		System.out.println(vo.getMem_id());
		System.out.println(vo.getMem_name());
		System.out.println(vo.getBoard_subject());
		System.out.println(vo.getBoard_content());
		System.out.println("=======================");
		
		vo.setView_cnt(0);
		
		ModelAndView mv = new ModelAndView();
		
		int cnt = boardservice.insertboard(vo);
		
		//List<boardVO> list = new ArrayList<boardVO>();
	
						
		if(cnt == 1){
			System.out.println("입력성공:"+cnt);
			//list = boardservice.getboardlist();
						
		}else{
			System.out.println("입력실패:"+cnt);
		}
									
		//mv.addObject("list",list);
		mv.setViewName("redirect:board/boardlist");
		//mv.setViewName("redirect:/boardlist");
		return mv;
	}
	
	
	
	@RequestMapping(value="/boarddatail")
	public ModelAndView boarddetail(HttpServletRequest request){
		
		ModelAndView mv =new ModelAndView();
		
		int seq = Integer.parseInt(request.getParameter("num"));
		
		boardVO board = boardservice.serboard(seq);
		
		System.out.println("상세글정보"+board.getMem_name());
		System.out.println("상세글정보"+board.getMem_id());
		System.out.println("상세글정보"+board.getBoard_subject());
		System.out.println("상세글정보"+board.getBoard_content());
				
		mv.addObject("board", board);
		mv.setViewName("board/writeform");
		return mv;
	}
	
	
	
	@RequestMapping(value="/boardupdate")
	public ModelAndView boardupdate(boardVO vo){
		
		/*
			vo(dto) - 변수를 먼저 지정해두고 게터세터를이용해서 사용  >> 먼저 공간이 할당되어서 아무래도 조금더 성능을 차지함
			map - (key(column),value(data)) 변수를 먼저 지정해두지 않을때 맵은 필요할떄 바로 만들어서 사용하기 때문에 성능이 vo보다는 빠르다.
						
			redirect : attribute를 공유 (컨트롤러에서 값을 넘겨줄때 사용,),url변경(이동할때 이동한 주소로 url주소가 바뀜) 
			: 화면이동하면서 값도 같이 가져가고 싶을떄 사용  
			
			forward : attribute를 공유하지않음, url 변경되지않음(페이지가 넘어가도 바뀐주소로 주소가 바뀌지 않음) 
			: 화면만 이동시키고 싶을떄				
		*/
		
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println("seq"+vo.getSeq());
		System.out.println("아이디"+vo.getMem_id());
		System.out.println("제목"+vo.getBoard_subject());
		
		ModelAndView mv =new ModelAndView();
		
		int cnt = boardservice.updateboard(vo);
		
		if(cnt == 1){
			System.out.println("수정이 완료되었습니다.");
		}else{
			System.out.println("수정이 실패했습니다.");
		}
		
		/* 
		mapper에서 사용하는 표시
		  
		${} == statement  >>>>>>  sql = "select * from dept where no=1";  정적인 데이터 
		
		#{} == preparestatement   >>>>>  sql ="select * from dept where no=?"  동적인데이터를
						
		jdbc
		
		
		동기 비동기
		
		비동기: ajax처럼 부분만 바뀌는것(서버에서 정보를 받아와서 쓰기위해서..)
		
		동기(리로드,리플레쉬): 전체 페이지가 로딩하는것(jsp에서 다른페이지로 이동하는것같은거)
		
		ajax는 두가지방법이 있음 
		1. 데이터를 가져와서 넘기는 방법 
		2. 파일을 통으로 불러오는 방법
		
		*/
				
		mv.setViewName("redirect:/boardlist");		
		return mv;
	}
	
	@RequestMapping(value="/boarddel")
	public ModelAndView boarddel(boardVO vo, HttpServletRequest request){
		/*request 대신에 @RequestParam,@ModelAttribute,@PathVariable 이거써서할수 있음  int[] chk */
		
		int cnt = 0;		
		ModelAndView mv =new ModelAndView();
		System.out.println("삭제컨트롤러옴");
		
		for(String seq :request.getParameterValues("check")){
			System.out.println("=========삭제========="+seq);
			cnt = boardservice.delboard(seq);
		}
				
		if(cnt == 1){
			System.out.println("삭제가 완료되었습니다.");
		}else{
			System.out.println("삭제가 실패했습니다.");
		}
		
		mv.setViewName("redirect:/boardlist");		
		return mv;
	}	
	
			
}
