package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// setup connection variable
		String user = "root";
		String password = "3306";
		String jdbcUrl = "jdbc:mysql://localhost:3306/users_sign_up_details?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";

		// get connection
		try {
			PrintWriter out = response.getWriter();
			out.println("connecting to db "+ jdbcUrl);
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			out.println("Succesful!!!");
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
