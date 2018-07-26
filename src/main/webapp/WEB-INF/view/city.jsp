<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Ввод города</title>
    </head>
    <body>
        <form:form method="POST" action="addCity" modelAttribute="city">
            <h1 align="center">Получение информации о погоде по введённому городу</h1>
            <h4>Введите название города</h4>
            <form:input type="text" path="name" placeholder="Введите город"/>
            <input type="submit" value="Ок" name="submitCity" />
        </form:form>
    </body>
</html>