<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("result")%>입니다. <-코드블럭
	${result} <-EL 표기법<br>
	${names[0]}<br>
	${notice.title}<br>
	${param.n} <-쿼리스트링으로 넘어가는 파라미터값
	${empty param.n?'값이 비어있습니다':param.n};
</body>
</html>