package com.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
       
/**
 * Servlet implementation class Myservlet
 */
public class Myservlet extends HttpServlet {
	Connection con=DbConnection.connect();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			
		String Name=request.getParameter("Name");
		String RollNo1=request.getParameter("RollNo");
		int RollNo=Integer.parseInt(RollNo1);
		String Email=request.getParameter("Email");
		String City=request.getParameter("City");
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
		pstmt.setString(1,Name);
		pstmt.setInt(2,RollNo);
		pstmt.setString(3,Email);
		pstmt.setString(4,City);
		pstmt.setString(5,Username);
		pstmt.setString(6,Password);
		
		int i=pstmt.executeUpdate();
		
		if(i>0)
		{
			response.sendRedirect("registration.html");//registration calling
		}		
		else
		{
			response.sendRedirect("index.html");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
