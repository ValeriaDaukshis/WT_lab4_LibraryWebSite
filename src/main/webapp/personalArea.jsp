<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
		<head>
			<title>Form input</title>
		</head>
		<body>
		<h1>Booked books</h1>
            <c:forEach items="${list}" var = "book">
                 <h2>${book.getName()}</h2>
                 <h4>${book.getAuthor()}</h4>
                 <form action="mainReader" method="POST">
                     <br><br><input type="submit" value= "${book}" name="remove" />
                 </form>
                 <hr>
             </c:forEach>
		</body>
</html>