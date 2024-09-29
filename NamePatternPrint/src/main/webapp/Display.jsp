<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

#patterns {
	display: flex;
	justify-content: space-around;
	color: #d0bdf4;
}

#container {

	height: 100vh;
	width:100%;
	background-color: #232F3E;
	text-align: center;
}
a{
    color: #747429;
    text-decoration: none;
}

a:hover{
    color: orange;
}


#pattern {
	margin: 50px 0 0 0;
}

h1 {
	text-align: center;
	color: #ffa8B6;
	background-color: #0f1111;
}
</style>
</head>
<body>

	<h1>Name Pattern</h1>
	<%
	List<StringBuilder> patterns = (List<StringBuilder>) request.getAttribute("list");
	%>
	<div id="container">
		<div id="patterns">
			<%
			for (StringBuilder pattern : patterns) {
			%>
			<div id="pattern">
				<pre><%=pattern%></pre>
			</div>
			<%
			}
			%>

		</div>
		<a href="index.jsp" style="text-align: center;">Return to Main
			Menu</a>
	</div>

</body>
</html>