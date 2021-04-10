package business;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
//import javax.faces.bean.ViewScoped;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import data.OrdersDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 * Now calls to our database instead of constructing default data.
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface 
{
	@EJB
	OrdersDataService service;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
			
	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
    public OrdersBusinessService()
	{
    	/*
		 * orders.add(new Order("1001","This is regular product one.",(float)1.00,1));
		 * orders.add(new Order("2002","This is regular product two.",(float)2.00,2));
		 * orders.add(new Order("3003","This is regular product three.",(float)3.00,3));
		 * orders.add(new Order("4004","This is regular product four.",(float)4.00,4));
		 * orders.add(new Order("5005","This is regular product five.",(float)5.00,5));
		 * orders.add(new Order("6006","This is regular product six.",(float)6.00,6));
		 * orders.add(new Order("7007","This is regular product seven.",(float)7.00,7));
		 * orders.add(new Order("8008","This is regular product eight.",(float)8.00,8));
		 * orders.add(new Order("9009","This is regular product nine.",(float)9.00,9));
		 * orders.add(new Order("1010","This is regular product ten.",(float)10.00,10));
		 */
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() 
    {
    	System.out.println("Hello from the OrdersBusinessService");
    }

	
	public List<Order> getOrders() 
	{
		return service.findAll();
	}

	
	public void setOrders(List<Order> orders)
	{
		// TODO Auto-generated method stub
		//this.orders = orders;
	}

	@Override
	public void sendOrder(Order order) 
	{
		// Send a Message for an Order
		try
		{
			Connection connection = connectionFactory.createConnection(); //new connection
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //new session
			MessageProducer messageProducer = session.createProducer(queue); //new message producer, acts as a message handler.
			TextMessage message1 = session.createTextMessage(); //new message in the session
			message1.setText("This is test message"); //set the session message text.
			messageProducer.send(message1); //send to session?
			
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			messageProducer.send(message2);
			
			connection.close();
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		}
		
	}

}
