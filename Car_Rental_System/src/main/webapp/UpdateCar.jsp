<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    HttpSession sh = request.getSession(false);
    if (sh == null || !"admin".equals(sh.getAttribute("type"))) {
        response.sendRedirect("Login.html");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Car - CarRentalSystem</title>
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
    background-image: url('https://th.bing.com/th/id/R.fbb592011490bc2f84e2022148e67fed?rik=v3AxQXF%2fG44c%2fQ&pid=ImgRaw&r=0');
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    overflow-x: hidden; /* Prevent horizontal scrolling */
}

.container {
    background-color: rgba(255, 255, 255, 0.7);
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
    text-align: center;
    position: relative;
}

h1 {
    font-size: 24px;
    margin-bottom: 20px;
    color: #333;
}

label {
    display: block;
    margin-bottom: 8px;
    text-align: left;
    font-weight: bold;
    font-size: 14px;
}

input[type="text"],
input[type="number"],
input[type="submit"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 14px;
}

input[type="submit"] {
    background-color: #4c6faf;
    color: white;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
    background-color: #2e4c83;
}

.dropdown {
    position: absolute;
    top: 10px;
    right: 10px;
}

.dropdown select {
    padding: 8px;
    font-size: 14px;
    border-radius: 5px;
    border: 1px solid #ccc;
    background-color: #fff;
    cursor: pointer;
}

.dropdown select:hover {
    background-color: #f0f0f0;
}

</style>
</head>
<body>
	 <div class="dropdown">
            <select id="navigateDropdown" onchange="navigateToPage()">
                <option value="">Navigate</option>
                <option value="Admin.jsp">Admin Main Page</option>
                <option value="Login.html">Login</option>
                <option value="AddCar.jsp">Add Car</option>
                <option value="UpdateCar.jsp">Update Car</option>
                <option value="DeleteCar.jsp">Delete Car</option>
            </select>
        </div>
    <div class="container">
       
        <h1>Update Car</h1>
        <form action="UpdateCarServlet" method="post">
            <label for="carID">Car ID:</label>
            <input type="text" id="carID" name="carID" required />

            <label for="carName">New Name:</label>
            <input type="text" id="carName" name="carName" />

            <label for="carModel">New Model:</label>
            <input type="text" id="carModel" name="carModel" />

            <label for="carPrice">New Price:</label>
            <input type="text" id="carPrice" name="carPrice" />

            <input type="submit" value="Update" />
        </form>
    </div>
	
	 <script>
        function navigateToPage() {
            const dropdown = document.getElementById('navigateDropdown');
            const selectedValue = dropdown.value;
            if (selectedValue) {
                window.location.href = selectedValue;
            }
        }
    </script>

</body>
</html>
