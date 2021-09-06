package ps.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class GroceryItems
 */
@WebServlet("/GroceryItems")
public class GroceryItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/groceryitems";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private static final String SELECT_ITEMS_BY_ITEMS = "select Items, Country, Price, Weight, Category, Supermarket,Stock from grocery where Items =?";
	private static final String SELECT_ALL_ITEMS = "select * from grocery";
	private static final String DELETE_ITEMS_SQL = "delete from grocery where Items = ?;";
	private static final String UPDATE_ITEMS_SQL = "update grocery set Items= ?,Country= ?, Price =?,Weight =? ,Category =? ,Supermarket =?,Stock =? where Items = ?;";
    
	protected Connection getConnection() {
	Connection connection = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return connection;
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroceryItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		System.out.println("action is " + action);
		try {
		switch (action) {
		case "/GroceryItems/new":
		showNewForm(request, response);
		break;
		case "/GroceryItems/delete":
		deleteUser(request, response);
		break;
		case "/GroceryItems/edit":
		showEditForm(request, response);
		break;
		case "/GroceryItems/update":
		updateUser(request, response);
		break;
		default:
		listUser(request, response);
		break;
		}
		} catch (SQLException ex) {
		throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
			List < items > GroceryList = new ArrayList < > ();
			try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEMS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
			String Items = rs.getString("Items");
			String Country = rs.getString("Country");
			String Price = rs.getString("Price");
			String Weight = rs.getString("Weight");
			String Category = rs.getString("Category");
			String Supermarket = rs.getString("Supermarket");
			String Stock = rs.getString("Stock");
			GroceryList.add(new items(Items, Country, Price, Weight, Category, Supermarket,Stock));
			System.out.println(Items);
			}
			} catch (SQLException e) {
			printSQLException(e);
			
			}
			//List < User > listUser = databaseOperations.selectAllUsers();
			System.out.println("total items is: " + GroceryList.size());
			request.setAttribute("listUser", GroceryList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("groceryitem.jsp");
			dispatcher.forward(request, response);
			}
	
	//method to redirect to register page
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("groceryitem.jsp");
			dispatcher.forward(request, response);
			}
	
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
			System.out.println("comes to showEditForm");
			//get parameter passed in the URL
			String Items = request.getParameter("Items");
			items existingUser = new items();
			//database operation, get data for existing user
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ITEMS_BY_ITEMS);) {
			preparedStatement.setString(1, Items);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
			Items = rs.getString("Items");
			String Country = rs.getString("Country");
			String Price = rs.getString("Price");
			String Weight = rs.getString("Weight");
			String Category = rs.getString("Category");
			String Supermarket = rs.getString("Supermarket");
			String Stock= rs.getString("Stock");
			existingUser = new items(Items, Country, Price, Weight, Category, Supermarket,Stock);
			}
			} catch (SQLException e) {
			printSQLException(e);
			}
			//Serve up the user-form.jsp
			request.setAttribute("items", existingUser);
			request.getRequestDispatcher("/groceryedit.jsp").forward(request, response);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			
			//dispatcher.forward(request, response);
			}
	
	//method to update the user data
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
			System.out.println("comes to updateItems");
			//get values from the request
			String oriItems = request.getParameter("oriItems");
			String Items = request.getParameter("Items");
			String Country = request.getParameter("Country");
			String Price = request.getParameter("Price");
			String Category = request.getParameter("Category");
			String Supermarket = request.getParameter("Supermarket");
			String Stock = request.getParameter("Stock");
			System.out.println(Items);
			System.out.println(Country);
			System.out.println(Price);
			System.out.println(Category);
			System.out.println(Supermarket);
			System.out.println(Stock);
			//database operation
			try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ITEMS_SQL);) {
			statement.setString(1, Items);
			statement.setString(2, Country);
			statement.setString(3, Price);
			statement.setString(4, Category);
			statement.setString(5, Supermarket);
			statement.setString(6, Stock);
			statement.setString(7, oriItems);
			statement.executeUpdate();
			}
			//redirect us back to UserServlet !note: do change the url to your project name
			response.sendRedirect("http://localhost:8080/PersonalShopper/GroceryItems");
			}
	
	//method to delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
			System.out.println("comes to deleteUser");
			String Items = request.getParameter("Items");
			try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ITEMS_SQL);) {
			statement.setString(1, Items);
		    statement.executeUpdate();
			}
			//redirect us back to UserServlet !note: do change the url to your project name
			response.sendRedirect("http://localhost:8080/PersonalShopper/GroceryItems");
			}
			
			private void printSQLException(SQLException ex) {
				for (Throwable e: ex) {
				if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
				}
				}
				}
				}
		}
		






