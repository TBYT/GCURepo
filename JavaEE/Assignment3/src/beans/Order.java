package beans;

public class Order 
{
	private String OrderNumber;
	private String ProductName;
	private float Price;
	private int Quantity;
	
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

	public float getPrice() {
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

	public Order(String orderNumber, String productName, float price, int quantity) 
	{
		super();
		OrderNumber = orderNumber;
		ProductName = productName;
		Price = price;
		Quantity = quantity;
	}

	
}
