<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<div class="row">
<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
<div class="container">
<h3 class="text-center">List of Groceries</h3>
<hr>
</header>
<div class="container text-left">
<a href="<%=request.getContextPath()%>/groceryadmin.jsp" class="btn btn-success">Add
New Items</a>
</div>
<br>
<table class="table table-bordered">
<thead>
<tr>
<th>Items</th>
<th>Country</th>
<th>Price</th>
<th>Weight</th>
<th>Category</th>
<th>Supermarket</th>
</tr>
</thead>
<tbody>
<c:forEach var="Gritems" items="${listUser}">
<script>
console.log("${Gritems.items}");
console.log("comes here");
</script>

<tr>
<td>
<c:out value="${Gritems.items}" />
</td>
<td>
<c:out value="${Gritems.country}" />
</td>
<td>
<c:out value="${Gritems.price}" />
</td>
<td>
<c:out value="${Gritems.weight}" />
</td>
<td>
<c:out value="${Gritems.category}" />
</td>
<td>
<c:out value="${Gritems.supermarket}" />
</td>

<td><a href="GroceryItems/edit?Items=<c:out value='${Gritems.items}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="GroceryItems/delete?Items=<c:out value='${Gritms.name}' />">Delete</a></td>



</tr>
</c:forEach>
<!-- } -->
</tbody>
</table>
</div>
</div>
</body>
</html>