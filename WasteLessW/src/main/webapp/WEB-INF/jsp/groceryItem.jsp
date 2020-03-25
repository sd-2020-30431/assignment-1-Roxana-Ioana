<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

</head>

<body>

<form method="post" action="/groceryItems">
    <div1>
        <h2>Introduce items for the grocery list ${lName}</h2>
    </div1>
    <input type="hidden" name="idList" value="${idList}">
    <input type="hidden" name="lName" value="${lName}">
    <label for="iname">Item name </label>
    <input type="text" id="iname" name="iname" value=""><br><br>
    <label for="quantity">Quantity </label>
    <input type="text" id="quantity" name="quantity" value=""><br><br>
    <label for="calories">Calories </label>
    <input type="text" id="calories" name="calories" value=""><br><br>
    <label for="pDate">Purchase Date</label>
    <input type="text" id="pDate" name="pDate" value=""><br><br>
    <label for="eDate">Expiration Date </label>
    <input type="text" id="eDate" name="eDate" value=""><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>