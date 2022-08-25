<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Registration</title>
    </head>

    <body>

     <form id = "main" method="post">
            <label for="name">Name:</label>
            <input type="text" name="name" placeholder="Name" id = "name"><br><br>
            <label for="password">Password:</label>
            <input type="password" name="pass" placeholder="Password" id = "pass"><br><br>
            <label for="repass">Password verification:</label>
            <input type="password" name="repass" placeholder="Password verification" id = "repass"><br><br>
            <input type="submit" name="submit" value="Done">
        </form>

        <br>
        <br>

        <div>
            <button onclick="location.href='/list'">View all registered users</button>
        </div>

        <br>
        <br>

        <div>
            <button onclick="location.href='/'">Back to main</button>
        </div>

    </body>
</html>