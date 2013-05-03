<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title><fmt:message key="fck.editor.compatibleBrowser.no"/></title>
</head>
<body>
<div class="container">  
	<h1>
		<fmt:message key="fck.editor.compatibleBrowser.no"/>
	</h1>
	<p>
		Locale = ${pageContext.response.locale}
	</p>
	<hr>
</div>
</body>
</html>