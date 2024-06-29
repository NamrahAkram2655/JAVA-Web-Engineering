import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !"user".equals(session.getAttribute("type"))) {
            response.sendRedirect("Login.html");
            return;
        }

        String carName = request.getParameter("Name");
        String carModel = request.getParameter("Model");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Search Results</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".container { background: white; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); border-radius: 10px; padding: 20px; max-width: 600px; width: 100%; margin: 20px; }");
        out.println("h1 { font-size: 24px; color: #333; margin-bottom: 10px; }");
        out.println("p { font-size: 18px; color: #555; }");
        out.println(".error { color: red; }");
        out.println(".car-details { text-align: left; margin-top: 20px; background-color: #f9f9f9; padding: 15px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='container'>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/car_rental";
            Connection con = DriverManager.getConnection(url, "root", "root");

            PreparedStatement p = con.prepareStatement("SELECT * FROM cars WHERE Name = ? AND Model = ?");
            p.setString(1, carName);
            p.setString(2, carModel);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                out.println("<h1>Car Details</h1>");
                out.println("<div class='car-details'>");
                out.println("<p><strong>Car ID:</strong> " + rs.getInt("carID") + "</p>");
                out.println("<p><strong>Car Name:</strong> " + rs.getString("Name") + "</p>");
                out.println("<p><strong>Car Model:</strong> " + rs.getString("Model") + "</p>");
                out.println("<p><strong>Car Price:</strong> $" + rs.getFloat("Price") + "</p>");
                out.println("</div>");
            } else {
                out.println("<h1 class='error'>No car found with the given name and model.</h1>");
            }

            rs.close();
            p.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1 class='error'>Can't find car details.</h1>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }
}
