package controllers;

/*
 * Brian Basinger
 * CST-235
 * Assignment 5
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;
import data.DataAccessInterface;

/*
 * Controller to direct our web routes.
 */
@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	OrdersBusinessInterface service;
	
	@Inject
	DataAccessInterface DAO;

	@EJB
	MyTimerService timer;

	public String onSubmit(User user)
	{
		//Call getAllOrders (for testing connection to DB)
		DAO.findAll();
				
		// Call insertOrder()
		//Order order = new Order(1, "0001","This is Another product one.",(float)1.00,1);
		//DAO.create(order);
				
		// See if the orders are properly inserted.
		DAO.findAll();
		// Forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		// Call EJB Business Service Injection
		service.test();
		// Call Timer Service
		timer.setTimer(10000);

		return "TestResponse.xhtml";
	}

	public OrdersBusinessInterface getService() 
	{
		return service;
	}
}
