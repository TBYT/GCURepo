package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
//import javax.faces.bean.ViewScoped;

import beans.Order;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface 
{
	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
    public OrdersBusinessService()
    {
    	orders.add(new Order("1001","This is regular product one.",(float)1.00,1));
		orders.add(new Order("2002","This is regular product two.",(float)2.00,2));
		orders.add(new Order("3003","This is regular product three.",(float)3.00,3));
		orders.add(new Order("4004","This is regular product four.",(float)4.00,4));
		orders.add(new Order("5005","This is regular product five.",(float)5.00,5));
		orders.add(new Order("6006","This is regular product six.",(float)6.00,6));
		orders.add(new Order("7007","This is regular product seven.",(float)7.00,7));
		orders.add(new Order("8008","This is regular product eight.",(float)8.00,8));
		orders.add(new Order("9009","This is regular product nine.",(float)9.00,9));
		orders.add(new Order("1010","This is regular product ten.",(float)10.00,10));
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
		// TODO Auto-generated method stub
		return orders;
	}

	
	public void setOrders(List<Order> orders)
	{
		// TODO Auto-generated method stub
		this.orders = orders;
	}

}
