package controllers;
/*
	 * Brian Basinger
	 * Professor: Jevon Jackson
	 * CST-235
	 * 4/8/2021
	 */


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

//import org.json.JSONArray;
//import org.json.JSONObject;

import business.BusinessInterface;
import beans.SearchModel;

	//the controller to communicate with our model and our web content
	@ManagedBean
	@ViewScoped
	public class FormController 
	{
		@Inject
		BusinessInterface service;
		
		public String onSubmit(SearchModel searchModel)
		{
			String result = service.getVerse(searchModel);
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", result);
			return "badresult.xhtml";
			//I get a class not found error although I add the jar to the buildpath, and to my workspace...
			//
//			JSONObject obj = new JSONObject(result);
//    		if (obj.getString("error").equals("not found"))
//    		{
//    			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("error", result);
//    			return "badresult.xhtml";
//    		}
//    		else
//    		{
//    			String textResult = obj.getString("text");
//    			String translationType = obj.getString("translation_name");
//    			JSONArray arr = obj.getJSONArray("verses");
//    			String resultBookName = arr.getJSONObject(0).getString("book_name");
//    			String chapterNum = arr.getJSONObject(0).getString("chapter");
//    			System.out.println("bookName bruv: "+resultBookName);
//    	
//    			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("text", textResult);
//    			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("book", resultBookName);
//    			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("chapter", chapterNum);
//    			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("translation", translationType);
//    			return "result.xhtml";
//    		}
		}
		
		public BusinessInterface getService() 
		{
			return service;
		}
	
}
