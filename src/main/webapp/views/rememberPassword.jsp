<!DOCTYPE html>
<html lang="en">

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
<div class="restorePassword">
    <h1>Restore Password</h1>
    <form action="notRemember" method="post">
        <p>Please enter your login to search for your account:
        </p>
        <p id="errorMessage"></p>
        <p><label for="login">Login</label>
            <input type="text" id="login" name="login">
            <button onclick="myFunction()" id="click" type="submit">Restore!</button>
        <p id="waitForResult"></p>
        </p>
    </form>
    <script src="jquery-3.2.0.min"></script>
    <script>
        function myFunction() {
            $("#waitForResult").append("Check your mail for password recovery");
        }
    </script>
</div>
</body>

</html>