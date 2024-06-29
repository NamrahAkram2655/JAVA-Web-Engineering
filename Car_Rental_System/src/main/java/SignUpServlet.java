

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String myname = request.getParameter("personName");
		String email = request.getParameter("email");
		String G = request.getParameter("gender");
		String phn = request.getParameter("contact");
		String city = request.getParameter("City");
		String pass = request.getParameter("passwd");
		String usertype = request.getParameter("userType");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/car_rental";
			  
			Connection con = DriverManager.getConnection(url,"root","root");
			
			PreparedStatement ps = con.prepareStatement("Select * from registered_data WHERE Email=?");
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				out.println("<html><body><p>Already exist email</p></body></html>");
			}
			else
			{
				
				PreparedStatement p = con.prepareStatement("Insert into registered_data values(?,?,?,?,?,?,?)");
				
				p.setString(1, myname);
				p.setString(2, email);
				p.setString(3, G);
				p.setString(4, phn);
				p.setString(5, city);
				p.setString(6, pass);
				p.setString(7, usertype);
				
				int count=0;
				count = p.executeUpdate();
				
				if(count > 0)
				{
					response.sendRedirect("success.html");
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/SignUp.html");
					out.print("<h1>Can't Register fill form completely</h1>");
					rd.include(request, response);
				}
				
			}
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
