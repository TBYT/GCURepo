package data;

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local

public interface DataAccessInterface 
{
	//interface acts like a blueprint
	public List<Order> findAll(); 
	public Order findById(int id);
	public boolean create(Order order);
	public boolean update(Order order);
	public boolean delete(Order order);
}
