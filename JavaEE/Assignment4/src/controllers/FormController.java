package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;


/*
 * Controller to direct our web routes.
 */
@ManagedBean
@ViewScoped
public class FormController 
{
	@Inject
	OrdersBusinessInterface service; 
	
	@EJB
	MyTimerService timer;
	
	public String onSubmit(User user)
	{
		//Forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//Call EJB Business Service Injection
		service.test();
		//Call Timer Service
		timer.setTimer(10000);
		
		return "TestResponse.xhtml";
	}

	public OrdersBusinessInterface getService() 
	{
		return service;
	}
	
}
