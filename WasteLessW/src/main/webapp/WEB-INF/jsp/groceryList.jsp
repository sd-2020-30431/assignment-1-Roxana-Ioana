<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    Create a new grocery list
</head>

<body>

<form method="post" action="/groceryList">
    <input type="hidden" name="idUser" value="${idUser}">
    <br><label for="lname">Grocery list name  </label>
    <input type="text" id="lname" name="lname" value=""><br><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>