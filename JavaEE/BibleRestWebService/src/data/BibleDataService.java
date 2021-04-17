package data;

import beans.SearchModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BibleDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class BibleDataService implements DataAccessInterface 
{
    /**
     * Default constructor. 
     */
    public BibleDataService()
    {
        // TODO Auto-generated constructor stub
    }
    
	public String getVerse(SearchModel model)
	{
		String bookName = model.getBookName().replaceAll(" ", "");
		
//		System.out.println("BookName: "+bookName
//				+ "\nChapter: "+model.getChapterName()
//				+ "\nVerse: "+model.getVerseName()
//				+ "\nTranslation: "+model.getTranslationType()+
//				"\nCallback: "+model.getCallbackType()+"\nVerseNum: "+model.getShowVerseNumbers());
		
		String urlTranslation = "&translation="+model.getTranslationType();
		String urlCallback = "?callback="+model.getCallbackType();
		String urlVerseNumBool = "&verse_numbers="+model.getShowVerseNumbers();
		if (model.getTranslationType().equals(""))
		{
			urlTranslation="&";
		}
		if (model.getCallbackType().equals(""))
		{
			urlCallback="?";
		}
		if (model.getShowVerseNumbers().equals(false) || model.getShowVerseNumbers().equals(null))
		{
			urlVerseNumBool="&";
		}
		/**
	     * Reads the strings from the passed URL from parameter.
	     * @return String data from the inputed URL
	     * @throws Exception
	     * @author https://stackoverflow.com/questions/7467568/parsing-json-from-url
	     */
		BufferedReader reader;
        
        	String urlStr = "https://bible-api.com/"+model.getBookName()+model.getChapterName()+":"+model.getVerseName()+urlCallback+urlVerseNumBool+urlTranslation;
        	System.out.println(urlStr);
        	try 
        	{
	            URL url = new URL(urlStr);
	            reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer buffer = new StringBuffer();
	            int read;
	            char[] chars = new char[1024];
	            while ((read = reader.read(chars)) != -1)
	                buffer.append(chars, 0, read);
	            
	            return buffer.toString();
        	}
        	catch (Exception e) { return "{\"error\":\"not found\"}"; }
        
//        finally 
//        {
//            if (reader != null)
//                reader.close();
//        }
	}

}
