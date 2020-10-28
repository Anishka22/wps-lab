package assign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv
 */
@WebServlet("/Serv")
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter(); 
		int cnt=0;
		String que1 ="", que2="",que3="",que4="",que5="",que6="",que7="",que8="",r1="";
		que1=request.getParameter("que1");
		que2=request.getParameter("que2");
		que3=request.getParameter("que3");
		que4=request.getParameter("que4");
		que5=request.getParameter("que5");
		que6=request.getParameter("que6");
		que7=request.getParameter("que7"); 
		que8=request.getParameter("que1");
		r1=request.getParameter("roll");
		if(que1.equals("df"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		}

		if(que2.equals("cp"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		} 

		if(que3.equals("tech"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		}


		if(que4.equals("pro"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		}


		if(que5.equals("qop1"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		}


		if(que6.equals("Mq"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		}


		if(que7.equals("cuq"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		}


		if(que8.equals("2q"))
		{
		    out.println("Correct Answer<br/>");
		    cnt++;
		} 
		else{
		    out.println("Wrong Answer<br/>");
		} 

		if(cnt==8)
		{
		    out.println("<h1> Congratulations!! </h1>");
		} 
		else{
		    out.println("<h1> You have scored "+cnt+"Great try!");
		}

		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");  
			//here sonoo is database name, root is username and password  
		PreparedStatement pstmt=con.prepareStatement("insert into mark(roll,marks) values(?,?)");
			
			pstmt.setString(1,r1);
			pstmt.setInt(2,cnt);
			pstmt.executeUpdate();
			ResultSet rs=pstmt.executeQuery("select * from mark");
			
			
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getInt(2));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}