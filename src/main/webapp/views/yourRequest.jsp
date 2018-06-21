<%@ taglib prefix="requests" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 30.03.2017
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>The Public</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="shortcut icon" href="/resources/img/logo2.png" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../resources/font-awesome-4.7.0/css/font-awesome.css">
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
<div class="container1">
    <menu>
        <ul type="none">
            <li class="size"><a href="/" class="text">
         <span class="all">
         <span class="fa fa-home fa-1x"></span>
         <span>My Page</span>
      </span>
            </a>
            </li>
            <br>
            <li class="size"><a href="#" class="text">
         <span class="all">
         <span class="fa fa-newspaper-o"></span>
          <span>News</span>
      </span></a></li>
            <br>
            <li class="size"><a href="#" class="text">
         <span class="all">
         <span class="fa fa-comments-o"></span>
          <span>Anonim chat</span>
      </span></a></li>
            <br>
            <li class="size"><a href="/myMessages" class="text">
                <span class="glyphicon glyphicon-envelope"></span>
                <span>Messages</span>
            </a></li>
            <br>

            <li class="size"><a href="/requests" class="text">
         <span class="all">
         <span class="fa fa-user"></span>
          <span>Friends</span>
      </span></a></li>
            <br>
            <li class="size"><a href="#" class="text">
         <span class="all">
         <span class="fa fa-camera"></span>
          <span>Photos</span>
      </span></a></li>
            <br>
            <li class="size"><a href="#" class="text">
                <span class="glyphicon glyphicon-picture"></span>
                <span>Places</span>
            </a></li>
            <br>

            <li class="size"><a href="#" class="text">
         <span class="all">
         <span class="fa fa-music"></span>
          <span>Music</span>
      </span></a></li>
            <br>
            <li class="size"><a href="#" class="text">
         <span class="all">
         <span class="fa fa-film"></span>
          <span>Video</span>
      </span></a></li>
            <br>
            <li class="size"><a href="#" class="text">
         <span class="all">
         <span class="fa fa-gamepad"></span>
          <span>Game</span>
      </span></a></li>
        </ul>
        <hr>
        <ul type="none">
            <li class="size"><a href="#" class="text">
                <span class="glyphicon glyphicon-shopping-cart"></span>
                <span>Shop</span>
            </a></li>
            <br>
            <li class="size"><a href="#" class="text">
                <span class="glyphicon glyphicon-resize-full"></span>

                <span>Rental</span>
            </a></li>

            <br>
            <li class="size"><a href="#" class="text">
         <span class="all">
         <span class="fa fa-file"></span>
          <span>Document</span>
      </span></a></li>
        </ul>
    </menu>
    <div class="containerFriendsRequests">
        <div class="requestAndFriend">
            <button class="requests" style="background-color: #a4aaf4;">Requests</button>
            <a href="/yourFriends">
                <button class="lookAllFriend">All friends</button>
            </a>
            <button class="lookAllFriendOnline">Friends online</button>
        </div>
        <requests:forEach var="requests" items="${requests}">
            <div class="people"><img src="/imageDisplay?id=${requests.id}" alt="">
                <h4 class="nameSurname">${requests.surname} ${requests.name}</h4>
                <h5 class="country">Country </h5>
                <h5 class="country">City</h5>
                <a href="/acceptRequest/${requests.id}">
                    <button class="addToFriend">Add to friend!</button>
                </a>
                <a href="/rejectRequest/${requests.id}">
                    <button class="writeMessage">Reject requests!</button>
                </a>
            </div>
        </requests:forEach>
    </div>
    <div class="sort">
        <h3>Sorting</h3>
        <label for="">Country</label>
        <select>
            <option>Ukraine</option>
            <option>England</option>
            <option>Russia</option>
            <option>Portugal</option>
        </select>
        <h4>Age</h4>
        <label for="">From</label>
        <select>
            <requests:forEach var="i" begin="16" end="80">
                <option> From ${i}</option>
            </requests:forEach>
        </select>
        <label for="">To</label>
        <select>
            <requests:forEach var="i" begin="16" end="80">
                <option> To ${i}</option>
            </requests:forEach>
        </select>
        <h4>Gender</h4>
        <label for="">Man</label>
        <input type="radio" placeholder="Man">
        <label for="">Woman</label>
        <input type="radio" placeholder="Woman"></div>
</div>
</body>

</html>