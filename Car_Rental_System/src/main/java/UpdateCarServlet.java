import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateCarServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("type"))) {
            response.sendRedirect("Login.html");
            return;
        }

        String carName = request.getParameter("carName");
        String id = request.getParameter("carID");
        String carModel = request.getParameter("carModel");
        String Price = request.getParameter("carPrice");

        int carID = Integer.parseInt(id);
        float carPrice = Float.parseFloat(Price);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Update Car Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".container { background: white; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); border-radius: 10px; padding: 20px; max-width: 600px; width: 100%; text-align: center; }");
        out.println("h1 { font-size: 24px; color: #333; margin-bottom: 10px; }");
        out.println("p { font-size: 18px; color: #555; }");
        out.println(".success { color: green; }");
        out.println(".error { color: red; }");
        out.println(".btn-back { background-color: #4899b9; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; font-size: 16px; margin-top: 20px; display: inline-block; }");
        out.println(".btn-back:hover { background-color: #5b81a9; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='container'>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/car_rental";
            Connection con = DriverManager.getConnection(url, "root", "root");

            PreparedStatement p = con.prepareStatement("UPDATE cars SET Name = ?, Model = ?, Price = ? WHERE carID = ?");
            p.setString(1, carName);
            p.setString(2, carModel);
            p.setFloat(3, carPrice);
            p.setInt(4, carID);

            int count = p.executeUpdate();

            if (count > 0) {
                out.println("<h1 class='success'>Update Successful</h1>");
                out.println("<p>Car ID: " + carID + "</p>");
                out.println("<p>New Name: " + carName + "</p>");
                out.println("<p>New Model: " + carModel + "</p>");
                out.println("<p>New Price: $" + carPrice + "</p>");
                out.println("<a href='AdminPage.jsp' class='btn-back'>Go Back to Admin Page</a>");
            } else {
                out.println("<h1 class='error'>Update Failed</h1>");
                out.println("<p>Car with ID " + carID + " might not exist. Please check the ID and try again.</p>");
                out.println("<a href='AdminPage.jsp' class='btn-back'>Go Back to Admin Page</a>");
            }

            p.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1 class='error'>Update Failed</h1>");
            out.println("<p>An error occurred while updating the car details. Please try again later.</p>");
            out.println("<a href='AdminDashboard.jsp' class='btn-back'>Go Back to Admin Page</a>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }
}
