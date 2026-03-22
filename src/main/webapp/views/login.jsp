<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 300px;
            margin: 80px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #ccc;
        }

        h2 {
            text-align: center;
        }

        input {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #2196F3;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #1976D2;
        }

        .error {
            color: red;
            font-size: 14px;
        }

        .link {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Login</h2>


    <form action="login" method="post">
        <input type="email" name="email" placeholder="Enter Email" required/>

        <input type="password" name="password" placeholder="Enter Password" required/>

        <button type="submit">Login</button>
    </form>

    <div class="link">
        <p>Don't have an account? <a href="register.jsp">Register</a></p>
    </div>
</div>

</body>
</html>