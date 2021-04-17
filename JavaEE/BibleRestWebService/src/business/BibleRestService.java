package business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


//example: localhost:8080/BibleRestWebService/rest/bible/john3:16
@RequestScoped
@Path("/bible")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class BibleRestService
{

	@DefaultValue("-1") @QueryParam("translation") String translation;
	@DefaultValue("-1") @QueryParam("callback") String callbackType;
	@DefaultValue("-1") @QueryParam("verse_numbers") Boolean verseNumbersBoolean;
	
	@GET
	public String returnHome()
	{
		return "index.html";
	}
	
	@GET
	@Path("/{path}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVerse(@PathParam("path")String param) throws IOException
	{
		String bookVerse = param.replaceAll(" ", "");
		System.out.println(bookVerse);
		System.out.println("Params:\nTranslation: "+translation+"\nCallback: "+callbackType+"\nVerseNum: "+verseNumbersBoolean);
		String urlTranslation = "&translation="+translation;
		String urlCallback = "?callback="+callbackType;
		String urlVerseNumBool = "&verse_numbers="+verseNumbersBoolean;
		if (translation.equals("-1"))
		{
			urlTranslation="&";
		}
		if (callbackType.equals("-1"))
		{
			urlCallback="?";
		}
		if (verseNumbersBoolean.equals("-1"))
		{
			urlVerseNumBool="&";
		}
		/**
	     * Reads the strings from the passed URL from parameter.
	     * @return String data from the inputed URL
	     * @throws Exception
	     * @author https://stackoverflow.com/questions/7467568/parsing-json-from-url
	     */
		BufferedReader reader = null;
        try 
        {
        	String urlStr = "https://bible-api.com/"+bookVerse+urlCallback+urlVerseNumBool+urlTranslation;
        	System.out.println(urlStr);
            URL url = new URL(urlStr);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read); 

            return buffer.toString();
        } 
        finally 
        {
            if (reader != null)
                reader.close();
        }
		
	}
	
}
