<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>出错了</title>
<script language='javascript' type='text/javascript'>
	function show(trace,show) {
		if(trace.style.display=='none'){
			trace.style.display = '';
			show.innerHTML='收起';
		}else {
			trace.style.display = 'none';
			show.innerHTML='展开';
		}
	}
</script>
</head>
<!-- pre 元素可定义预格式化的文本。被包围在 pre 元素中的文本通常会保留空格和换行符。而文本也会呈现为等宽字体。-->
<!--<pre> 标签的一个常见应用就是用来表示计算机的源代码。-->
<body>
	<%Exception ex = (Exception) request.getAttribute("ex");%>
	<h3>系统出现异常:<c:out value="${ex.message}"></c:out> [<a href="#" onclick="show(trace,this);">展开</a>]</h3>
	<pre><span id="trace" style="display: none"><%ex.printStackTrace(new PrintWriter(out));%></span></pre>
</body>
</html>