<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

h1 {
	text-align: center;
	margin: 100px;
	color: #b94757;
}

input {
	margin: 0 25px;
	border-radius: 55px;
	height: 25px;
}

#mobile {
	margin: 0 0 0 10px;
}

#marks {
	margin: 0 0 0 20px;
}

#id {
	margin: 0 50px;
}

div {
	margin: 0 100px;
}

form {
	border: 2px solid black;
	padding: 10px;
	background-color: #9b9b37;
}

#form {
	display: flex;
	justify-content: center;
	margin: 20px;
}

button {
	height: 25px;
	padding: 0 10px;
	margin: 0 5px;
}
</style>
</head>
<body>
     <h1>Adding Student Object into Database</h1>

    <div id="form">
     <form action="add-Student" method="post">
         <label>Student Id:-</label>     <input type="number" id="id" name="studentId" required="required"> <br><br>
         <label>Student Name:-</label> <input type="text" name="studentName" required="required"> <br> <br>
         <label>Student Email:-</label> <input type="text" name="studentEmail" required="required"> <br> <br>
         <label>Student Number:-</label> <input id="mobile" type="number" name="mobile" required="required"> <br> <br>
         <label>Student Marks:-</label> <input id="marks" type="number" name="studentMarks" required="required"> <br> <br>
         <div>
           <button type="submit">Add</button>
           <button type="reset">Reset</button>
         </div>
     </form>
    </div>

</body>
</html>