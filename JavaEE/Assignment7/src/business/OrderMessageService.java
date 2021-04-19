package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import data.OrdersDataService;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener 
{
	@EJB
	OrdersDataService dao;
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) 
    {
    	// If message is an instance of TextMessage, print text message, if message is an Instance of ObjectMessage, forward this objectmessage to our database.
  	  try 
  	  {
    	if(message instanceof TextMessage)
  	  	{
  		  
  			TextMessage msg = (TextMessage) message;
			System.out.println("======> OrderMessageService.onMessage() with a Text Message: " + msg.getText());
  		  
  	  	}
  	  	else if(message instanceof ObjectMessage)
  	  	{
  	  		ObjectMessage msg = (ObjectMessage) message;
  	  		// for output and dao
  	  		Order out = (Order) msg.getObject();
  	  		System.out.println("======> OrderMessageService.onMessage() with a Send Order Message: OrderNumber = "+out.getOrderNumber());
  	  		dao.create(out);
  	  	}
  	  	else
  	  	{
  	  		System.out.println("=======> OrderMessageService.onMessage() with UNKNOWN Message type.");
  	  	}
  	  }
  	  catch (JMSException e)
  	  {
  		  e.printStackTrace();
  	  }

    }

}
