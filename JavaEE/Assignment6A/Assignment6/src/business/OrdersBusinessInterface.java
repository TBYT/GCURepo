package business;

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersBusinessInterface 
{
	//interface acts like a blueprint
	public void test();
	public List<Order> getOrders();
	public void setOrders(List<Order> orders);
}
