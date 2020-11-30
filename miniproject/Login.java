package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		String k=request.getParameter("email");
		
		String r=request.getParameter("psw");
		boolean st=false;
		try {

            //loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","");  
            PreparedStatement ps = con.prepareStatement("select email from register where email=? and password=?");
            ps.setString(1, k);
            ps.setString(2, r);
            ResultSet rs =ps.executeQuery();
           st=rs.next();
           if(st==false)
           {
        	   out.println("<b>Please Register<b>");
        	   RequestDispatcher rd=request.getRequestDispatcher("/log2.html");
        	   rd.include(request, response);
           }
           else
           {
        	   out.println("Login Sussessful Happy Shopping");
           }
           
            

        }
        catch(Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
