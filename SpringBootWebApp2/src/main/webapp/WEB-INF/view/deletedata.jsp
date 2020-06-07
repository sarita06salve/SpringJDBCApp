<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h4> Delete Languages .. </h4>		
		<form action = "deletedata" method="post">
			Language Id : <input type = "text" name = "lang_id" /> <br/> <br/>
			<input type="submit" value="Delete Language" />
		</form>
		
		<form action="showinfo" method="post">
			<input type = "submit" value = "Show Language" />
		</form>
</body>
</html>