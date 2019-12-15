<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
		<head>
			<title>Form input</title>
		</head>
		<body>

			<form action="index" method="POST">
				<h2>Write your name and password</h2>
				<input type="text" placeholder="name" name="name" />
				<br><br>
				<input type="password" placeholder="password" name="password" />
				<br><br><input type="submit" value="sign in" />
			</form>
			<form action="registration" method="POST">
            	<input type="submit" value="registration" />
            </form>
		</body>
</html>