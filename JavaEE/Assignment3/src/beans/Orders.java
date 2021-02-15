package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;

@ManagedBean
@ViewScoped
public class Orders 
{
	List<Order> orders = new ArrayList<Order>();
	
	public Orders()
	{
		orders.add(new Order("0001","This is product one.",(float)1.00,1));
		orders.add(new Order("0002","This is product two.",(float)2.00,2));
		orders.add(new Order("0003","This is product three.",(float)3.00,3));
		orders.add(new Order("0004","This is product four.",(float)4.00,4));
		orders.add(new Order("0005","This is product five.",(float)5.00,5));
		orders.add(new Order("0006","This is product six.",(float)6.00,6));
		orders.add(new Order("0007","This is product seven.",(float)7.00,7));
		orders.add(new Order("0008","This is product eight.",(float)8.00,8));
		orders.add(new Order("0009","This is product nine.",(float)9.00,9));
		orders.add(new Order("0010","This is product ten.",(float)10.00,10));
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
