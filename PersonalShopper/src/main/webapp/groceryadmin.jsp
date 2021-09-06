<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Add</title>
</head>

<body>
     <form action="RegisterServlet" method="post">
      <fieldset>
      
      <legend>Please input your new grocery items with the below fields</legend>
      Items:<br><input type="text" name="Items" style="width: 120px;" maxlength="15";/><br/><br>
      Origin Country:<br><input type="text" name="Country" style="width: 120px;" maxlength="15";/><br/><br>
      Price:<br><input type="text" name="Price" style="width: 120px;" maxlength="15"; /><span style="margin-right:-18px;">$</span><br/><br>
      Weight:<br><input type="text" name="Weight" style="width: 120px;" maxlength="15";/><span style="margin-right:-18px;">KG</span><br/><br>
      Category:<br><select name="Category" style="width: 120px;">
		<option>Meat</option>
		<option>Vegetables</option>
		<option>Seafood</option>
		<option>Frozen foods</option>
		<option>Drinks</option>
		<option>daily use</option>
		</select> <br/><br>
	  Supermarket:<br><select name="Supermarket" style="width: 120px;" >
		<option>NTUC</option>
		<option>GIANT</option>
		<option>SHENGSHIONG</option>
		<option>OTHERS</option>
		</select><br><br>
	  Stock :<br><input type="text" name="Stock" style="width: 120px;" maxlength="15";/><br/><br>
      <input type="submit" value="Submit"/><br/>
     
      </fieldset>
      </form>
</body>

</html>

