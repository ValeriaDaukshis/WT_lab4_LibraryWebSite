<!DOCTYPE html>
<html>
		<head>
			<title>Registration form</title>
		</head>
		<body>
			<form action="mainLibrarian" method="POST">
				<h2>Write book info</h2>
				<input type="text" placeholder="name" name="name" />
                <br><br>
                <input type="text" placeholder="author" name="author" />
                <br><br>
				<input type="text" placeholder="count" name="count" />
				<br><br>
				<input type="text" placeholder="pages" name="pages" />
                <br><br>
                <p> description </p>
                <textarea name="description">write description</textarea>
                <br><br>
				<br><br><input type="submit" value="insert" />
			</form>
		</body>
</html>