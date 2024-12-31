<!DOCTYPE html>
<html>
<title>Add Student</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="/students/add" method="post">
		<label for="id">ID:</label> <input type="number" id="id" name="id">
		<label for="name">Name:</label> <input type="text" id="name"
			name="name"> <label for="deptName">Department Name:</label> <input
			type="text" id="deptName" name="deptName">
		<button type="submit">Add Student</button>
	</form>
</body>
</html>
