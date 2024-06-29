<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
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
<title>Admin Dashboard - Car Rental System</title>
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
    
    
    overflow-x: hidden; /* Prevent horizontal scrolling */
}

.container {
    background-color: #fff;
    max-width: 800px;
    margin: 20px auto;
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

.actions {
    display: flex;
    gap: 11rem;
}

.btn-action {
    cursor: pointer;
    background-color: #4899b9;
    border: none;
    border-radius: 5px;
    color: white;
    padding: 12px 24px;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

.btn-action:hover {
    background-color: #5b81a9;
}

.additional-content {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    gap: 30px;
    margin-top: 30px;
    text-align: left;
}

.additional-content > div {
    flex: 1 1 45%; /* Adjust width of each column */
}

.additional-content h2 {
    font-size: 24px;
    color: #333;
    margin-bottom: 10px;
}

.additional-content p {
    font-size: 14px;
    color: #666;
    line-height: 1.6;
}


#navbar {
    height: 10vh;
    color: white;
    display: flex;
    align-items: center;
    background-color: #83a3c5;
}

#navbar ul {
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 20px;
    padding: 0 0 0 20px;
    list-style: none;
}

#navbar ul li a {
    color: white;
    text-decoration: none;
    font-size: 16px;
    padding: 10px;
    transition: background-color 0.3s ease;
}

#navbar ul li a:hover {
    background-color: #5b81a9;
    border-radius : 10px;
}

.section-image {
    max-width: 40%;
    height: 30%;
    border-radius: 8px;
    text-align: center;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

</style>


</head>
<body>
    <nav id="navbar">
        <ul>   
            <li><a href="Home"><span>Home</span></a></li>
            <li><a href="About Us">About Us</a></li>
            <li><a href="Contact Us">Contact Us</a></li>
        </ul>
    </nav>
    <div class="container">
        <h1>Admin Dashboard</h1>
        <h3>Welcome! Manage cars in the system.</h3>
        
        <div class="actions">
            <form action="AddCar.jsp" method="post">
                <button type="submit" class="btn-action">Add Cars</button><br>
            </form>
            <form action="UpdateCar.jsp" method="post">
                <button type="submit" class="btn-action">Update Cars</button><br>
            </form>
            <form action="DeleteCar.jsp" method="post">
                <button type="submit" class="btn-action">Delete Cars</button><br>
            </form>
        </div>
        
        <div class="additional-content">
        <div>
        
         <h2>Manage Car Listings</h2>
            <p>View and manage all cars in the system. Ensure accurate and updated details.</p>
            <img src="https://th.bing.com/th/id/OIP.qBG-0V04rY045IohQaFb3AHaE8?rs=1&pid=ImgDetMain" alt="Manage Car Listings" class="section-image">
            
            <h2>Analytics and Reports</h2>
            <p>Track usage statistics, rental trends, and generate insightful reports.</p>
            <img src="https://th.bing.com/th/id/OIP.M_THA7BVYDlqGZykoD_WgwHaHa?pid=ImgDet&w=189&h=189&c=7" alt="Analytics and Reports" class="section-image">
            
        </div>
           <div>
            <h2>Manage Users</h2>
            <p>Administer user accounts, permissions, and roles within the system.</p>
            <img src="https://th.bing.com/th/id/OIP.PVDMNm1jQFme3hF2ScvaLgHaEj?rs=1&pid=ImgDetMain" alt="Manage Users" class="section-image">
            
            <h2>Settings</h2>
            <p>Adjust system configurations, notifications, and other settings as needed.</p>
            <img src="https://th.bing.com/th/id/OIP.xWV39W4YWcbkytdVouPO3AHaEK?w=255&h=180&c=7&r=0&o=5&pid=1.7" alt="Settings" class="section-image">
           </div>
           
           
        </div>
    </div>
</body>
</html>
