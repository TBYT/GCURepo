package beans;

import javax.xml.bind.annotation.XmlRootElement;

//set the xml root element
@XmlRootElement(name="Order")
public class Order 
{
	private String OrderNumber;
	private String ProductName;
	private double Price;
	private int Quantity;
	int id;
	/*
	 * The order model to make a order.
	 * Properties include order number, product name, price and quantity.
	 * 
	 */
	
	public Order()
	{
		//default constructor created for xmlrootelement.
	}
	
	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order(int id, String orderNumber, String productName, double price, int quantity) 
	{
		super();
		this.id = id;
		this.OrderNumber = orderNumber;
		this.ProductName = productName;
		this.Price = price;
		this.Quantity = quantity;
	}

	
}
