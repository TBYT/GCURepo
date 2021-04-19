package data;

import beans.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface {

    /**
     * Default constructor. 
     */
    public OrdersDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#findAll()
     * Establishes a connection to database and selects all orders from the orders table.
     */
    public List<Order> findAll() 
    {
    	Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		try
		{
			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("DB Connection Successful!");
			conn.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("DB Connection Failure!");
		}

		 String sql = "SELECT * FROM testapp.orders"; 
		 List<Order> orders = new ArrayList<Order>();
		  
		 try 
		 {
			 //Connect to the DB 
			 conn = DriverManager.getConnection(url, username,password);
			 
			 //Execute SQL Query 
		     Statement stmt = conn.createStatement(); 
		     ResultSet rs = stmt.executeQuery(sql);
			 
			  // Adding the database info through while loop
			  
			  while(rs.next())
			  { 
					  //Double.valueOf(String.format("%.2f", rs.getString("price")));
				  orders.add(new Order(rs.getInt("id"),rs.getString("order_no"),
				  rs.getString("product_name"), 
				  Double.valueOf(String.format("%.2f", rs.getDouble("price"))),
				  rs.getInt("quantity")));
				  
				  /*System.out.println(String.format("ID is %d for Product %s at a price of %.2f",
						  rs.getInt("id"), rs.getString("product_name"), rs.getDouble("price"))); */
			  }		  
			  
			  //Cleanup 
			  rs.close();
		  }
		  
		  catch (SQLException e) 
		  { e.printStackTrace();
	 	  	System.out.println("Failed in executing query or formatting resultset."); 
	 	  } 
		 finally
		  { 
			  //Close the connection
			  if(conn != null)
			  {
			  try {
				    conn.close(); } catch(SQLException e)
			  		{ 
				    	e.printStackTrace(); 
			  		} 
			  }
		  }
		 return orders;
    }

    //optional
	@Override
	public Order findById(int id) {
		return null;
	}

	/*
	 * Takes an order object and inserts its properties in the database to create a new order
	 */
	@Override
	public boolean create(Order order) 
	{
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		//String sql = "INSERT INTO testapp.orders(order_no, product_name, price, quantity) VALUES('18731824', 'This was inserted new 2', 55.00, 100)";
		String sql = String.format("INSERT INTO testapp.orders(order_no, product_name, price, quantity) VALUES('%s', '%s', %f, %d)", order.getOrderNumber(), order.getProductName(), order.getPrice(), order.getQuantity());
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("DB Connection and Query Successful!");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Insertion Query Failed.");
		}
		finally
		{
			//Close the connection.
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	//optional
	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
		return true;
	}

	//optional
	@Override
	public boolean delete(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
