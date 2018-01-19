<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 09.03.2017
  Time: 15:38
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
            <div class="form-group">
            </div>
        </form>

        <form action="/loginprocessing" method="post">
            <ul class="nav navbar-nav">
                <li><p>Enter your login:</p></li>
                <li><input name="username" class="colortext" type="text" size="20"></li>
                <li><p>Enter your password:</p></li>
                <li><input name="password" class="colortext" type="password" size="20">
                    <a class="forgot" href="/notRemember"><p>forgot password</p></a></li>
                <li>
                    <button type="submit"><span class="glyphicon glyphicon-log-in"></span> Sign in</button>
                </li>
            </ul>
        </form>
    </div>
</nav>
<div class="container">
    <div class="imgReg">
        <div class="info">The public is very intresting newtwork, with many interesting functions. Every day we read
            messages from our user and create something new what whey want.
        </div>
        <div class="img"></div>

    </div>
    <div class="registration">
        <h1>Check in</h1>
        <div class="reg">

            <form action="/registration" method="post">
                <p>Enter your surname:
                    <input id="surname" name="surname" type="text" required placeholder="Pupkin" size="25"></p>
                <p>Enter your name:
                    <input id="name" name="name" type="text" size="25" required placeholder="Ivan"></p>
                <p>Date of birth:
                    <input id="date" type="date" name="bday"></p>

                <p>Enter your phone number:
                    <input id="phone" Name="number" size="25" required placeholder="XXX-XX-XX-XX-XXX">
                </p>

                <p id="errorMessage"></p>
                <p>Enter your email:
                    <input id="email" Name="email" required placeholder="ivan.pupkin@m.com.ua" size="25">
                </p>
                <p>Enter your login:
                    <input id="login" Name="login" required placeholder="ivan.pupkin" size="25">
                </p>

                <p>Enter your password:
                    <input id="password" type="password" Name="password" size="25" required>
                </p>
                <p>Repeat your password:
                    <input id="passwordConfirm" type="password" Name="password2" size="25" required>
                </p>
                <button id="click">Send data</button>
            </form>
            <script src="../resources/jquery/jquery-3.2.0.min.js"></script>
            <script>
                $(document).ready(function () {

                    $("#click").click(function (e) {
                        e.preventDefault();

                        if (validate(getObject())) {
                            $.ajax({
                                url: '/registration',
                                method: 'POST',
                                contentType: 'application/json',
                                data: JSON.stringify(getObject()),
                                success: function () {
                                    window.location.assign("/nextStepRegistration")
                                }
                            })
                        }
                    })

                    function getObject() {
                        return {
                            surname: $("#surname").val()
                            , name: $("#name").val()
                            , date: $("#date").val()
                            , phone: $("#phone").val()
                            , email: $("#email").val()
                            , login: $("#login").val()
                            , password: $("#password").val()
                        }
                    }

                    function showError(message) {
                        $("#errorMessage").empty();
                        $("#errorMessage").append("<p>Check your " + message + "</p>")
                    }

                    function validate(object) {
                        var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                        var phoneRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
                        if (object.surname == "") {
                            alert("Error input all form")
                            return false;
                        }
                        if (object.name == "") {
                            alert("Error input all form")
                            return false;
                        }
                        if (object.date == "") {
                            alert("Error input all form")
                            return false;
                        }
                        if (object.phone == "" || !object.phone.match(phoneRegex)) {
                            alert("Error input all form")
                            return false;
                        }
                        if (object.email == "" || !object.email.match(emailRegex)) {
                            showError("email")
                            return false;
                        }
                        if (object.login == "") {
                            alert("Error input all form")
                            return false;
                        }

                        if (object.password == "" || object.password != $("#passwordConfirm").val()) {
                            alert("Error input all form")
                            return false;
                        }
                        return true;
                    }
                })

            </script>
        </div>
    </div>
</div>
</body>
</html>
