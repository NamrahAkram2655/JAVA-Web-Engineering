

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("passwd");
		
		PrintWriter out = response.getWriter();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			String url = "jdbc:mysql://127.0.0.1/car_rental";
			  
			Connection con = DriverManager.getConnection(url,"root","root");
			PreparedStatement p = con.prepareStatement("SELECT * FROM registered_data WHERE Email=? AND Password=?");
			
			p.setString(1, email);
			p.setString(2, password);
			
			ResultSet rs = p.executeQuery();
			
			if(rs.next())
			{
				String userType = rs.getString("userType");
				HttpSession hs = request.getSession();
				
				hs.setAttribute("type", userType);
                hs.setAttribute("email", email);
                
                if ("admin".equals(userType)) 
                {
                    response.sendRedirect("AdminPage.jsp");
                } 
                else if ("user".equals(userType)) 
                {
                    response.sendRedirect("SimpleUser.jsp");
                }
                else
                {
                	response.sendRedirect("Signup.html");
                }
                
				//RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				//response.sendRedirect("Loginsuccess.html");
				//rd.include(request, response);
			}
			else
			{
				out.print("<p>Can't login check your username or password again</p><br>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
				
			}
			
			con.close();
			rs.close();
			p.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
