<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 07.04.17
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>The public</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/registration.css">
    <link rel="shortcut icon" href="/resources/img/logo2.png" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"></a>
        </div>
        <form class="navbar-form navbar-left">
            <div class="form-group"></div>
        </form>
        <ul class="nav navbar-nav">
            <li>
                <p>Enter your email:</p>
            </li>
            <li>
                <input name="surname" type="text" size="20"></li>
            <li>
                <p>Enter your password:</p>
            </li>
            <li>
                <input name="password" type="password" size="20">
                <a class="forgot" href="#">
                    <p>forgot password</p>
                </a>
            </li>
            <li>
                <button><span class="glyphicon glyphicon-log-in"></span> Sign in</button>
            </li>
        </ul>
    </div>
</nav>
<div class="newPassword">
    <h3>Last step recovering password. </h3>
    <h4>Check your email, support service sent you message with key.</h4>
    <form action="/newPassword" , method="post">
        <label for="key">Input key</label>
        <input type="text" id="key" name="key">
        <label for="password">Input new password</label>
        <input type="password" name="password" id="password">
        <br>
        <br>
        <button type="submit">Change password!!</button>
    </form>
</div>
</body>
</html>
