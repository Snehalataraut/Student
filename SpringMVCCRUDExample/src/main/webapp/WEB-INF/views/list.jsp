<!DOCTYPE html>
<html>
<head>
<title>Students</title>
</head>
<body>
	<h1>Student List</h1>
	<a href="/students/add">Add Student</a>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.deptName}</td>
					<td><a href="/students/edit/${student.id}">Edit</a> <a
						href="/students/delete/${student.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>