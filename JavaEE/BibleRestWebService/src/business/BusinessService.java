/*
 * Brian Basinger
 * Professor: Jevon Jackson
 * CST-235
 * 4/8/2021
 */
package business;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.SearchModel;
import data.BibleDataService;

/**
 * Session Bean implementation class BusinessService
 * Returns from the data class.
 */
@Stateless
@Local(BusinessInterface.class)
@Alternative
public class BusinessService implements BusinessInterface 
{
	@EJB
	BibleDataService service;
	
	public BusinessService()
	{
		
	}

	public String getVerse(SearchModel model)
	{
		String json = service.getVerse(model);
		return json;
		//could not find an open api such as bible-api.com to format json to pretty json,
		//so it is coming out default since I did not focus much time on manually substring-ing the string for the items I need to put in facescontext,
		//I may work on it on my own time later.
	}
		
}

