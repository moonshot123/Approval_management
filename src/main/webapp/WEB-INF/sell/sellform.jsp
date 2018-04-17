<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="/resources/jquery-ui-1.12.1/jquery-ui.css">
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>

<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">
	$(function(){
		
		$("#listBtn").click(function(){
			location.href="list.se";
		});
				
	})
	
function cancel(chk){		
	location.href="cancel.se?orderseq="+chk;	
}	
</script>

</head>
<body>

<h2>주문화면입니다.</h2>

	<table>
		<c:set value="" var="temp"></c:set>
		<c:forEach items="${orderlist}" var="list" varStatus="status">		
			
			<tr>
				<td>										       		         										
					<c:if test="${list.orderseq ne temp }">
						 
					   	<div class="card-header">주문번호: ${list.orderseq}
					   		<input type="button" id="cancelBtn" name="cancelBtn" value="주문취소하기" class="btn btn-primary" onclick="cancel('${list.orderseq}')">
					   	</div>
					   		<div class="card-body">
					   		<h4 class="card-title">상품이름: ${list.name} <fmt:formatNumber value="${list.price }" pattern="#,###" />원</h4>
					   	 	<div class="card-text">
					   	 		<div class="col-lg-4">
					   	 			<img alt="${list.name}" src="/resources/img/${list.imgpath}" width="100px">
					   	 		</div>
					   	 		<div class="col-lg-8">
					   	 			${list.story}
					   	 		</div>			   	 	  
					   	 	</div>
					  		</div>
					</c:if>
																				
				    <c:if test="${list.orderseq eq temp }">
						
					   	<div class="card-body">
					   		<h4 class="card-title">상품이름: ${list.name} <fmt:formatNumber value="${list.price }" pattern="#,###" />원</h4>
					   	<div class="card-text">
					   	 	<div class="col-lg-4">
					   	 		<img alt="${list.name}" src="/resources/img/${list.imgpath}" width="100px">
					   	 	</div>
					   	 	<div class="col-lg-8">
					   			${list.story}
					   	 	</div>			   	 	  
					   	 </div>
					  	</div>
						
					</c:if> 	
				    					
					<c:set value="${list.orderseq}" var="temp"/>
					<br>        						         				         			     						
											
				</td>						
			</tr>		
		</c:forEach>
	</table>
	<input type="button" id="listBtn" name="listBtn" value="상품화면으로이동" class="btn btn-primary btn-lg btn-block">
		
</body>
</html>