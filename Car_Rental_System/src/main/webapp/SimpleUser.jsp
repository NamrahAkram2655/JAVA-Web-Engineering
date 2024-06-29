<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    HttpSession sh = request.getSession(false);
    if (sh == null || !"user".equals(sh.getAttribute("type"))) {
        response.sendRedirect("Login.html");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Simple User Dashboard - Car Rental System</title>
<style>
    /* Reset and general styles */
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f5f5f5;
        background-image: url('https://images.unsplash.com/photo-1535732820275-9ffd998cac22?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        overflow-x: hidden; /* Prevent horizontal scrolling */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #fff;
        max-width: 600px;
        margin: 20px;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    h1 {
        margin-bottom: 15px;
        font-size: 28px;
        color: #333;
    }

    h3 {
        margin-bottom: 20px;
        color: #555;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    form button {
        cursor: pointer;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        color: white;
        padding: 10px 20px;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }

    form button:hover {
        background-color: #0056b3;
    }
    
    @media (max-width: 600px) {
        .container {
            padding: 20px;
        }

        h1 {
            font-size: 24px;
        }

        h3 {
            font-size: 18px;
        }

        form button {
            padding: 8px 16px;
        }
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Simple User Dashboard</h1>
        <h3>You can search for cars by clicking below</h3>
        <form action="SearchCar.jsp" method="post">
            <button type="submit">Search</button>
        </form>
    </div>
</body>
</html>
