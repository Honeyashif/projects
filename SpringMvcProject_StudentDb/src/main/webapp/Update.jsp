<%@page import="com.jsp.spring_mvc.studentdb.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#form {
	display: flex;
	justify-content: center;
	margin: 50px 0 0 0;
}

input {
	margin: 0 25px;
	border-radius: 55px;
	height: 25px;
}

#id {
	margin: 0 50px;
}

#mobile {
	margin: 0 0 0 10px;
}

#marks {
	margin: 0 0 0 20px;
}

form {
	border: 2px solid black;
	padding: 10px;
	background-color: #9b9b37;
}

button {
	height: 25px;
	padding: 0 10px;
	margin: 0 140px;
}

#lobby {
	text-decoration: none;
	margin: 440px;
}

#lobby:visited {
	color: #a49090;
}
#lobby:hover {
	color: orange;
}
</style>
</head>
<body>
      <%
      Student student = (Student) request.getAttribute("student");
      %>
    
    <div id="form">
      <form action="save-updated-student" method="post">
        <label>Student Id:-</label> <input type="number" id="id" value="<%=student.getStudentId() %>" name="studentId" readonly="readonly"> <br> <br>
        <label>Student Name:-</label> <input type="text"  value="<%=student.getStudentName() %>" name="studentName"> <br> <br>
        <label>Student Email:-</label> <input type="text"  value="<%=student.getStudentEmail() %>" name="studentEmail"> <br> <br>
        <label>Student Number:-</label> <input type="number" id="mobile" value="<%=student.getMobile() %>"  name="mobile"> <br> <br>
        <label>Student Marks:-</label> <input type="number" id="marks" value="<%=student.getStudentMarks() %>" name="studentMarks"> <br> <br>
         <button type="submit">Update</button>
     </form>
    </div>
    <br>
    <a id="lobby" href="index.jsp">No I dont Want to Update Just Want Return To Dashboard</a>
    
</body>
</html>