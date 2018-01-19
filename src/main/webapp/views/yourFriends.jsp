<%@ taglib prefix="friends" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 30.03.2017
  Time: 16:53
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
            <a href="/requests">
                <button class="requests">Requests</button>
            </a>
            <button class="lookAllFriend" style="background-color: #a4aaf4;">All friends</button>
            <button class="lookAllFriendOnline">Friends online</button>
        </div>
        <friends:forEach var="f" items="${listFriend}">
            <div class="people"><img src="/imageDisplay?id=${f.id}" alt="">
                <h4 class="nameSurname">${f.surname} ${f.name}</h4>
                <h5 class="country">Country</h5>
                <h5 class="country">City</h5>
                <button class="addToFriend">Remove friend!</button>
                <a href="writeMessage/${f.id}">
                    <button class="writeMessage">Write a message!</button>
                </a>
            </div>
        </friends:forEach>
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
            <option> from 14</option>
            <option> from 15</option>
            <option> from 16</option>
            <option> from 17</option>
            <option> from 18</option>
            <option> from 19</option>
            <option> from 20</option>
            <option> from 21</option>
            <option> from 22</option>
            <option> from 23</option>
            <option> from 24</option>
            <option> from 25</option>
            <option> from 26</option>
            <option> from 27</option>
            <option> from 28</option>
            <option> from 29</option>
            <option> from 30</option>
            <option> from 31</option>
            <option> from 32</option>
            <option> from 33</option>
            <option> from 34</option>
            <option> from 35</option>
            <option> from 36</option>
            <option> from 37</option>
            <option> from 38</option>
            <option> from 39</option>
            <option> from 40</option>
            <option> from 41</option>
            <option> from 42</option>
            <option> from 43</option>
            <option> from 44</option>
            <option> from 45</option>
            <option> from 46</option>
            <option> from 47</option>
            <option> from 48</option>
            <option> from 49</option>
            <option> from 50</option>
            <option> from 51</option>
            <option> from 52</option>
            <option> from 53</option>
            <option> from 54</option>
            <option> from 55</option>
            <option> from 56</option>
            <option> from 57</option>
            <option> from 58</option>
        </select>
        <label for="">To</label>
        <select name="" id="">
            <option> To 14</option>
            <option> To 15</option>
            <option> To 16</option>
            <option> To 17</option>
            <option> To 18</option>
            <option> To 19</option>
            <option> To 20</option>
            <option> To 21</option>
            <option> To 22</option>
            <option> To 23</option>
            <option> To 24</option>
            <option> To 25</option>
            <option> To 26</option>
            <option> To 27</option>
            <option> To 28</option>
            <option> To 29</option>
            <option> To 30</option>
            <option> To 31</option>
            <option> To 32</option>
            <option> To 33</option>
            <option> To 34</option>
            <option> To 35</option>
            <option> To 36</option>
            <option> To 37</option>
            <option> To 38</option>
            <option> To 39</option>
            <option> To 40</option>
            <option> To 41</option>
            <option> To 42</option>
            <option> To 43</option>
            <option> To 44</option>
            <option> To 45</option>
            <option> To 46</option>
            <option> To 47</option>
            <option> To 48</option>
            <option> To 49</option>
            <option> To 50</option>
            <option> To 51</option>
            <option> To 52</option>
            <option> To 53</option>
            <option> To 54</option>
            <option> To 55</option>
            <option> To 56</option>
            <option> To 57</option>
            <option> To 58</option>
        </select>
        <h4>Gender</h4>
        <label for="">Man</label>
        <input type="radio" placeholder="Man">
        <label for="">Woman</label>
        <input type="radio" placeholder="Woman"></div>
</div>
</body>

</html>

