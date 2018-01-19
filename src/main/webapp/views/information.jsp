<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 24.03.17
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button class="btn btn-default" type="submit">
                <i class="glyphicon glyphicon-search"></i>
            </button>
        </form>
        <ul class="nav navbar-nav">
            <li><a href="/search">People</a></li>
            <li><a href="#">Groups</a></li>
            <li><a href="#">News</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/info"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
            <li><sec:authorize access="isAuthenticated()"><a href="/logout"></sec:authorize><span
                    class="glyphicon glyphicon-log-out"></span> Exit</a></li>
        </ul>
    </div>
</nav>
<div class="container8">
    <h1>Change your data</h1>
    <form action="/info" method="post" enctype="multipart/form-data">
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

