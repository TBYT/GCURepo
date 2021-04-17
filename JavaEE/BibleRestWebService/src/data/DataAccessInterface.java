package data;

import javax.ejb.Local;

import beans.SearchModel;

@Local
public interface DataAccessInterface 
{
	//interface acts like a blueprint
	public String getVerse(SearchModel model);
}