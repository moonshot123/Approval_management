<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
		
	<link rel="stylesheet" href="/resources/jquery-ui-1.12.1/jquery-ui.css">
	<script src="/resources/js/jquery-3.3.1.js"></script>
	<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
		
	<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
		
	<script type="text/javascript">
	
	$(function(){
		document.getElementById('selectmenu').innerHTML="";		
	})
	
	function selllist(){
		location.href = "sellist.po";
	}
	
	function order(){
		alert("응 결제");
	}
	
	
	
	function addmenu(chk){
		
		document.getElementById('selectmenu').innerHTML +=  
		"<input type='button' name="+chk.name+" id="+chk.id+" value="+chk.value+" onclick=deletmenu(this)>"
		
	}
	
	function deletmenu(chk){
	
		alert("삭제");		
		chk.remove();
	
	}
			
	</script>
</head>
<body>
	<h1>POS</h1>
	<table class="table"> 	
			
		<c:forEach items="${menulist}" var="list" varStatus="Status" > 
						
			<c:if test="${Status.count % 4 == 1}"> 				
			<tr>
				<td>				
					<input type="button" class="btn btn-primary btn-lg" name="${list.menuseq}" id="${list.menuseq}"
					 value="${list.name} ( ${list.price} 원 )" onclick="addmenu(this)">
				</td>
			</c:if>
			
		 	<c:if test="${Status.count % 4 != 0 && Status.count % 4 != 1 }"> 	
				<td> 					
				 	<input type="button" class="btn btn-primary btn-lg"  name="${list.menuseq}" id="${list.menuseq}" 
				 	 value="${list.name} ( ${list.price} 원 )" onclick="addmenu(this)"> 							
				</td>
		    </c:if>  		     			
		    		 	
			<c:if test="${Status.count % 4 == 0}"> 				
				<td> 					
				 	<input type="button" class="btn btn-primary btn-lg" name="${list.menuseq}" id="${list.menuseq}" 
				 	 value="${list.name} ( ${list.price} 원 )" onclick="addmenu(this)"> 							
				</td>			
		    </c:if> 		     					    
		</c:forEach> 	 
			
	</table>
	<br><br>
	
	<h1>선택메뉴 및 가격</h1>
	<table class="table">
		<tr>
			<td>
				<div id="selectmenu"></div>				
			</td>
		</tr>		
	</table>
	
	<input type="button" class="btn btn-success" name="sellBtn" id="sellBtn" value="결제하기" onclick="order()">				
	<br><br>
	<input type="button" class="btn btn-success" name="orderBtn" id="orderBtn" value="판매정보보기" onclick="selllist()">		
</body>
</html>
