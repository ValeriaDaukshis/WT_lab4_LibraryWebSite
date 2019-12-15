<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
		<head>
			<title>Form input</title>
		</head>
		<body>
		<form action="mainLibrarian" method="POST">
            <br><br><input type="submit" value="addBook" name="addBook" />
        </form>
		<c:forEach items="${list}" var = "book">
             <h2>${book.getName()}</h2>
             <h4>${book.getAuthor()}</h4>
             <p>${book.getDescription()}</p>
             <br>
             <p>${book.getPages()}</p>
             <form action="mainLibrarian" method="POST">
             	<br><br><input type="submit" value= ${book.getName()} name="deleteBook" />
             </form>
             <hr>
        </c:forEach>

		</body>
</html>