<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring Security</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Login form</h2><br>
    <b>${SPRING_SECURITY_LAST_EXCEPTION.message}</b>
    <form class="form-inline" action="/login" method="post">

        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div><br><br>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div><br><br>
        <button type="submit" class="btn btn-default">Submit</button>

    </form>
</div>

</body>
</html>
