<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index</title>
</head>
<body>

<h2>Hello World!</h2>
<a href = "/MySpringMVC/theServlet/hello">点击跳转hello</a>
<a href = "/MySpringMVC/theServlet/goodbye">点击跳转bye</a>
<form action="/MySpringMVC/loginmapper/loginstart" type = "post">
	username:<input type = "text" name = "username"><br>
	
	password:<input type = "text" name = "password"><br>
	<input type = "submit" value = "login">
</form>
</body>
</html>
