<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
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
		
		$("#deatailDIV").hide();
		
		$("#orderBtn").click(function() {
			
			if(!($('input:checkbox[name="checkProduct"]').is(":checked"))){
				alert("구입 할 회사를 체크하세요.");		
				return false;
			}else{				
				alert("주문완료");
				
				$("#orderfmt").attr("method","post");
				$("#orderfmt").attr("action","order.se");
				$("#orderfmt").submit();
			}			
		});
		
		$("#orderListBtn").click(function(){
			location.href="order.se";			
		});
		
	})
		
	
function doDisplay(chk){
	
    if($("#deatailDIV"+chk).hide()){       
        $("#deatailDIV"+chk).show();
        $("#firstDIV"+chk).hide();           
    }else{
    	$("#deatailDIV"+chk).hide();
        $("#firstDIV"+chk).show();      
    }
    
}	
	

</script>

</head>
<body>
<div class="col-md-12">
		
	<h2>회사를 구매하세요.</h2>
	<form id="orderfmt" name="orderfmt">
	<table class="table table-hover">
		<tr>
			<th>선택</th>
			<th>사진</th>
			<th>가격</th>
			<th>상품명</th>
			<th>상품소개</th>
		</tr>
				  
		<c:forEach var="list" items="${list}" varStatus="status">	
			<tr height="100px" >
				<th width="80px">
				<!-- 체크되면 value값이 넘어감 이거 해야하면 체크해서 넘기는거 쉽게 할수 있음 -->				
					<input type="checkbox" id="checkProduct" name="checkProduct" value="${list.sellseq}">														
				</th>
				<th width="120px"><img alt="${list.name}" src="/resources/img/${list.imgpath}" width="100px" ></th>
				<th width="100px"> <fmt:formatNumber value="${list.price }" pattern="#,###" />원</th>
				<th width="100px">${list.name}</th>
				<th>
				
				<div id="firstDIV${status.count}">				 
				  <c:out value="${fn:substring(list.story,0,13)}"/>....				  
				  <a href="javascript:doDisplay('${status.count}');" title="${status.count}"> 더보기</a><br/><br/>
				</div>
												
				<div id="deatailDIV${status.count}"  style="display:none">
				  <c:out value="${list.story}"/>
				</div>
					
				</th>
			</tr>
		</c:forEach>	
	</table>
	</form>	
	<input type="button" id="orderBtn" name="orderBtn" value="주문" class="btn btn-primary btn-lg btn-block">	
	<input type="button" id="orderListBtn" name="orderListBtn" value="주문화면보기" class="btn btn-primary btn-lg btn-block">	
</div>		
</body>

</html>