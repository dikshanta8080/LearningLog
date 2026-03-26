<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Register Page</title>
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
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
            font-size: 14px;
            text-align: center;
        }

        .link {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Register</h2>

    <%String error = (String) request.getAttribute("error");%>
    <%if (error != null) {%>
    <p class="error"><%=error%>
    </p>
    <%}%>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="name" placeholder="Enter Name" required/>
        <input type="email" name="email" placeholder="Enter Email" required/>
        <input type="password" name="password" placeholder="Enter Password" required/>
        <button type="submit">Register</button>
    </form>

    <div class="link">
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a></p>
    </div>
</div>

</body>
</html>