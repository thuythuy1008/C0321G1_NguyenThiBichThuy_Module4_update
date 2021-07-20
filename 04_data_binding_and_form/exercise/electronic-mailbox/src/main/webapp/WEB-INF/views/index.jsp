<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2021
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2 class="text-center text-danger">Settings</h2>
<div class="container">
    <form:form action="/save" modelAttribute="email">
        <table>
            <tr>
                <td><p class="font-weight-bold">Languages:</p></td>
                <td>
                    <form:select path="language" class="form-control">
                        <form:option value="English"/>
                        <form:option value="Vietnamese"/>
                        <form:option value="Chinese"/>
                        <form:option value="Japanese"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><p class="font-weight-bold">Page Sizes:</p></td>
                <td>
                    <span>Show</span>
                    <form:select path="pageSize" cssStyle="display: inline">
                        <form:option value="5"/>
                        <form:option value="10"/>
                        <form:option value="15"/>
                        <form:option value="25"/>
                        <form:option value="50"/>
                        <form:option value="100"/>
                    </form:select>
                    <span>emails per page</span>
                </td>
            </tr>
            <tr>
                <td><p class="font-weight-bold">Spams filter:</p></td>
                <td>
                    <form:checkbox path="spamsFilter"/>
                    <span>Enable spams filter</span>
                </td>
            </tr>
            <tr>
                <td><p class="font-weight-bold">Signature:</p></td>
                <td>
                    <form:textarea path="signature" rows="5" class="form-control"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button class="btn btn-primary" type="submit">Update</button>
                    <button class="btn btn-primary" type="reset">Cancel</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
