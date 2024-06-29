<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HttpSession sh = request.getSession(false);
    if (sh == null || !"user".equals(sh.getAttribute("type"))) {
        response.sendRedirect("Login.html");
        return; // Prevents further processing of the JSP page after redirect
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Car Search</title>
<style>
    body {
        margin: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background-image: url("https://images.unsplash.com/photo-1494905998402-395d579af36f");
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        font-family: Arial, sans-serif;
        color: #333;
    }

    .container {
        text-align: center;
        background: rgba(255, 255, 255, 0.9);
        padding: 40px 50px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        max-width: 450px;
        width: 90%;
    }

    h2 {
        font-size: 2rem;
        color: #007bff;
        margin-bottom: 20px;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    label {
        font-size: 1rem;
        margin: 10px 0 5px;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 1rem;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #218838;
    }

    @media (max-width: 600px) {
        .container {
            padding: 20px;
        }

        h2 {
            font-size: 1.6rem;
        }

        button {
            padding: 8px;
        }
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Car Search</h2>
        <form action="SearchServlet" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="Name" />

            <label for="model">Model</label>
            <input type="text" id="model" name="Model" /> 

            <button type="submit">Search</button>
        </form>
    </div>
</body>
</html>
