package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

//Our path creates a webroute for the url rest. Ex: rest/orders
@RequestScoped
@Path("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrdersRestService 
{
	@Inject
	OrdersBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson()
	{
		//returns the arraylist of orders to rest/orders/getjson
		return service.getOrders();
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXML()
	{
		//get list of orders
		List<Order> lstOrders = service.getOrders();
		//new array of type Order from using the list size.
		Order[] arrOrders = new Order[lstOrders.size()];
		int counter = 0; //iterator
		for (Order order : lstOrders)
		{ //each order gets added to the array.
			arrOrders[counter] = order;
			counter++;
		}
		//returns the array of orders to rest/orders/getxml
		return arrOrders;
	}
	
}
