package business;

import beans.Order;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
//import javax.faces.bean.ViewScoped;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface 
{
	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() 
    {
    	orders.add(new Order("0001","This is Another product one.",(float)1.00,1));
		orders.add(new Order("0002","This is Another product two.",(float)2.00,2));
		orders.add(new Order("0003","This is Another product three.",(float)3.00,3));
		orders.add(new Order("0004","This is Another product four.",(float)4.00,4));
		orders.add(new Order("0005","This is Another product five.",(float)5.00,5));
		orders.add(new Order("0006","This is Another product six.",(float)6.00,6));
		orders.add(new Order("0007","This is Another product seven.",(float)7.00,7));
		orders.add(new Order("0008","This is Another product eight.",(float)8.00,8));
		orders.add(new Order("0009","This is Another product nine.",(float)9.00,9));
		orders.add(new Order("0010","This is Another product ten.",(float)10.00,10));
    }

	/**
     * @see OrdersBusinessInterface#getOrders()
     */
    public List<Order> getOrders()
    {
        // TODO Auto-generated method stub
			return orders;
    }

	/**
     * @see OrdersBusinessInterface#setOrders(List<Orders>)
     */
    public void setOrders(List<Order> orders) 
    {
        // TODO Auto-generated method stub
    	this.orders = orders;
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() 
    {
    	System.out.println("Hello from the AnotherOrdersBusinessService");
    }

}
