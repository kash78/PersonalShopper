package ps.project;

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





/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String i = request.getParameter("Items");
		String co = request.getParameter("Country");
		String p = request.getParameter("Price");
		String w = request.getParameter("Weight");
		String ca = request.getParameter("Category");
		String s= request.getParameter("Supermarket");
		String st= request.getParameter("Stock");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/groceryitems", "root", "");
		PreparedStatement ps = con
		.prepareStatement("insert into grocery values(?,?,?,?,?,?,?)");
		ps.setString(1, i);
		ps.setString(2, co);
		ps.setString(3, p);
		ps.setString(4, w);
		ps.setString(5, ca);
		ps.setString(6, s);
		ps.setString(7, st);
		int i1 = ps.executeUpdate();
		if (i1 > 0)
		out.print("Your new grocery items is added into the grocery database");
		else if (i1 < 0) out.print("You have not enter the fields correctly");} 
	
		catch (Exception e2) {
		System.out.println(e2);
		}
		out.close();
	}
	


}
