<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    Create a new grocery list

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>

<body>

<input type="hidden" name="idUser" value="${idUser}">

<form method="post" action="/groceryList">
    <input type="hidden" name="idUser" value="${idUser}">
    <br><label for="lname">Grocery list name </label>
    <input type="text" id="lname" name="lname" value=""><br><br><br>
    <input type="submit" value="Add list">
</form>


<h2>ALL LISTS</h2>

<table>
    <tr>
        <th>List Name</th>
        <th>Edit List</th>
    </tr>
    <form action="/groceryList/edit" method="POST">
        <input type="hidden" name="idUser" value="${idUser}">
        <c:forEach items="${lists}" var="list">
            <tr>
                <div1>
                    <td>"${list.name}"</td>
                    <td>
                        <button id="submit" type="submit" class="btn" value="${list.idList}" name="idList">Edit</button>
                    </td>
                </div1>
            </tr>
        </c:forEach>
    </form>

</table>
</body>

</html>