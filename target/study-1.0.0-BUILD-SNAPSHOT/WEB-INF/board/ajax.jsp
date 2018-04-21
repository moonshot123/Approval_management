<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="row" items="${list}">
 		<tr> 
 			<td> <input type="checkbox"  name="check" onclick="checkboard(this)" value="${row.seq}">  </td>	
 			<td>${row.seq}</td>
 			<td>${row.mem_id}(${row.mem_name})</td>
 			<td><a href="boarddatail?num=<c:out value="${row.seq}"/>"> ${row.board_subject}</a></td>
 			<td><fmt:formatDate value="${row.reg_date}" pattern="yyyy.MM.dd"/></td>
 			<td><fmt:formatDate value="${row.upt_date}" pattern="yyyy.MM.dd"/></td>
 			<td>${row.view_cnt}</td>	
 		</tr>	
 	</c:forEach>
	 <!-- **처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
             <c:if test="${paging.curBlock > 1}">
                  <a href="javascript:list('1')">[처음]</a>
              </c:if>
                
              <!-- **이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
              <c:if test="${paging.curBlock > 1}">
                  <a href="javascript:list('${paging.prevPage}')">[이전]</a>
              </c:if>
                
              <!-- **하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 -->
              <c:forEach var="num" begin="${paging.blockBegin}" end="${paging.blockEnd}">
                  <!-- **현재페이지이면 하이퍼링크 제거 -->
                  <c:choose>
                      <c:when test="${num == paging.curPage}">
                          <span style="color: red">${num}</span>&nbsp;
                      </c:when>
                      <c:otherwise>
                          <a href="javascript:list('${num}')">${num}</a>&nbsp;
                      </c:otherwise>
                  </c:choose>
              </c:forEach>
                
              <!-- **다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
              <c:if test="${paging.curBlock <= paging.totBlock}">
                  <a href="javascript:list('${paging.nextPage}')">[다음]</a>
              </c:if>
               
              <!-- **끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
              <c:if test="${paging.curPage <= paging.totPage}">
                  <a href="javascript:list('${paging.totPage}')">[끝]</a>
              </c:if>
	
	
	
</body>
</html>