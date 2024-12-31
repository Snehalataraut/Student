<!DOCTYPE html>
<html>
<head>
<title>Edit Student</title>
</head>
<body>
	<h1>Edit Student</h1>
	<form action="/students/edit/${student.id}" method="post">
		<label for="id">ID:</label> <input type="number" id="id" name="id"
			value="${student.id}"> <label for="name">Name:</label> <input
			type="text" id="name" name="name" value="${student.name}"> <label
			for="deptName">Department Name:</label> <input type="text"
			id="deptName" name="deptName" value="${student.deptName}">
		<button type="submit">Update Student</button>
	</form>
</body>
</html>