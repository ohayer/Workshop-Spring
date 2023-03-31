<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 31.03.2023
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: snow;
            color: black;

        }
        th{
            color: darkblue;
        }
        td, th{
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        td:not(:last-child), th:not(:last-child) {
            border-right: 1px solid #ddd;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Type</th>
        <th>Del</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${list}">
        <tr>
            <td>${book.id}</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.type}</td>
            <td>
                <form method="post" action="/books/list/remove/${book.id}" onsubmit="return confirm('Czy na pewno chcesz usunąć książkę?');">
                    <input type="hidden" name="_method" value="DELETE" />
                    <button type="submit" class="btn-delete" name="btn-delete">Usuń</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
