<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Greet yourself</title>
	</head>
	<body>
		<form action="/warp6/greet" method="post" >
			<label for="name" >Name: </label>
			<input type="text" name="name" value="" />
			<br />
			<input type="submit" name="doGreet" value="Greet me!" />
		</form>
	</body>
</html>