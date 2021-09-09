<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Grocery Edit Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<div>
<a href="https://www.javaguides.net" class="navbar-brand"> Grocery edit page</a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/GroceryItems" class="items">items</a></li>
</ul>
</nav>
</header>
<br>
<div class="container col-md-5">
<div class="card">
<div class="card-body">
<caption>
<h2>
<c:if test="${items != null}">
Edit Items
</c:if>
<c:if test="${items == null}">
Edit New Items
</c:if>
</h2>
</caption>

<c:if test="${items != null}">
<input type="hidden" name="oriItems" value="<c:out value='${items.items}' />" />
</c:if>

<fieldset class="form-group">
<label>Items</label> <input type="text" value="<c:out value='${items.items}' />" class="form-control" name="Items" required="required">
</fieldset>
<fieldset class="form-group">
<label>Country</label> <input type="text" value="<c:out value='${items.country}' />" class="form-control" name="Country">
</fieldset>
<fieldset class="form-group">
<label>Price</label> <input type="text" value="<c:out value='${items.price}' />" class="form-control" name="Price">
</fieldset>
<fieldset class="form-group">
<label> Weight</label> <input type="text" value="<c:out value='${items.weight}' />" class="form-control" name="Weight">
</fieldset>
<fieldset class="form-group">
<label>Category</label> <input type="text" value="<c:out value='${items.category}' />" class="form-control" name="Category">
</fieldset>
<fieldset class="form-group">
<label>Supermarket</label> <input type="text" value="<c:out value='${items.supermarket}' />" class="form-control" name="Supermarket">
</fieldset>
<fieldset class="form-group">
<label>Stock</label> <input type="text" value="<c:out value='${items.stock}' />" class="form-control" name="Stock">
</fieldset>
<button type="submit" class="items">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>

