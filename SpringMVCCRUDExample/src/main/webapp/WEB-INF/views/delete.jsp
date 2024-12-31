<!DOCTYPE html>
<html>
<head>
<title>Delete Student</title>
</head>
<body>
	<h1>Delete Student</h1>
	<form action="/students/delete/${student.id}" method="post">
		<label for="id">ID:</label> <input type="number" id="id" name="id">
		<button type="submit">Delete Student</button>
	</form>
</body>
</html>