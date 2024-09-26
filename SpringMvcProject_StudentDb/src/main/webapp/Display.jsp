<%@page import="com.jsp.spring_mvc.studentdb.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./Style.css">

<style type="text/css">
#table {
border:2px solid black;


	height: 100px;
}
section{
border: 2px solid blue;

align-items:center;
flex-direction:column;
justify-content: space-between;
display: flex;
}

h1 {

	color: #24a6a6;
}


tr,th {
	border-bottom: 2px solid grey;		
	
}

#index {
	text-decoration: none;
	color: red;
	border: none;

}

a {
	text-decoration: none;
}

a:visited {
	color: #33db1b;
}

a:link {
	color: #33db1b;
}
a:hover {
	color: orange;
}
</style>
</head>
<body>
     <section>
         	<h1>Display All Student Details</h1>
	<table id="table" >
		<tr>
			<th>StudentId</th>
			<th>StudentName</th>
			<th>StudentEmail</th>
			<th>Mobile</th>
			<th>StudentMarks</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<% List<Student> students=(List<Student>) request.getAttribute("students") ;
          for(Student student:students){
        	  
     %>
		<tr>
			<td><%=student.getStudentId() %></td>
			<td><%=student.getStudentName() %></td>
			<td><%=student.getStudentEmail() %></td>
			<td><%=student.getMobile() %></td>
			<td><%=student.getStudentMarks() %></td>
			<td><a href="update-student?studentId=<%=student.getStudentId()%>">update</a></td>
			<td><a href="delete-student?studentId=<%=student.getStudentId()%>">delete</a></td>
		</tr>
		<%
       }%>
	</table>
	<br>
	<a  href="index.jsp" id="index">Return to Home page</a>
     </section>
</body>
</html>