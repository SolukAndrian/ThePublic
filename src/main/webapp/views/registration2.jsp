<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 09.03.2017
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/registration.css">
    <link rel="shortcut icon" href="../img/3.png" type="image/x-icon">
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
            <div class="form-group">
            </div>
        </form>


        </ul>
    </div>
</nav>
<div class="container8">
    <h1>Next step registration give more information about you</h1>
    <form action="/nextStepRegistration" method="post" enctype="multipart/form-data">
        <div class="leftContainer">
            <label for="country">Your coutntry:</label>
            <input name="country" id="country" type="text">
            <label for="city">Your city:</label>
            <input name="city" id="city" type="text">
            <label for="language">Languages:</label>
            <input name="language" id="language" type="text">
            <label for="inf">Gender:</label>
            <input type="text" name="inf" id="inf">
            <label for="age">How old are you?</label>
            <input type="number" name="age" id="age">
            <label for="maritalStatus">Relationship:</label>
            <input name="maritalStatus" id="maritalStatus" type="text">
            <label>Select photo</label>
            <input type="file" name="image" multiple accept="image/*">
            <button type="submit">Push!</button>
        </div>

    </form>
</div>
</body>
</html>