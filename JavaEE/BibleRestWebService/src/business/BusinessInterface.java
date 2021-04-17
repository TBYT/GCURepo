package business;

import javax.ejb.Local;

import beans.SearchModel;

@Local
public interface BusinessInterface 
{
	//interface acts like a blueprint
	public String getVerse(SearchModel model);
}