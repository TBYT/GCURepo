package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.inject.Inject;

import business.OrdersBusinessInterface;


/*
 * A class that uses the order.java model to make a list of orders.
 * 
 */
@ManagedBean
@ViewScoped
public class Orders 
{
	@Inject
	OrdersBusinessInterface service;
	
	List<Order> orders = new ArrayList<Order>();
	
	public void init()
	{
		orders = service.getOrders();
	}
	public Orders()
	{
		
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
