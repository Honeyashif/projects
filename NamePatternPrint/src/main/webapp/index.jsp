<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
   margin: 0;
   padding: 0;
}

h1{
 text-align: center;
 background-color: green;
 color: #decbcb;
}

    div {
	display: flex;
	justify-content: center;
	height: 100vh;
	background: green;
}

.labels{
   text-align: center;
}

form{
    border: 2px solid black;
    padding: 15px;
    background-color: orange;
    height: 150px;
    margin-top: 100px 
}
</style>
</head>
<body>
 <h1>Welocome Home</h1>
     <div>
      <form action="print-name-pattern">
          <label class="labels">Enter Name</label> <br> <input type="text" name="name" > <br> <br>
          <label class="labels">Enter Size</label> <br> <input type="number" name="size" value="size"> <br> <br>
          <input type="submit" value="Send">
          <input type="reset" value="Reset">
          
      </form>
     </div>
</body>
</html>