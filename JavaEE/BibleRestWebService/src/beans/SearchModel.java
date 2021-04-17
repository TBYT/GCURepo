package beans;

/*
 * Brian Basinger
 * Professor: Jevon Jackson
 * CST-235
 * 4/8/2021
 */

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@ManagedBean
@ViewScoped
public class SearchModel {
	
	// Properties for the Search Model class
	
	@NotBlank(message = "Enter the book name.")
	String bookName;
	
	@NotBlank(message = "Enter chapter number.")
	@Size(min=1, max=2, message="Size must be between 1-2 characters.")
	String chapterName;
	
	@NotBlank(message = "Enter verse number.")
	@Size(min=1, max=2, message="Size must be between 1-2 characters.")
	String verseName;
	
	String callbackType;
	
	Boolean showVerseNumbers = true;
	
	String translationType;
	
	public SearchModel(String bookName, String chapterName, String verseName, String callbackType, Boolean showVerseNumbers,
			String translationType) 
	{
		super();
		this.bookName = bookName;
		this.chapterName = chapterName;
		this.verseName = verseName;
		this.callbackType = callbackType;
		this.showVerseNumbers = showVerseNumbers;
		this.translationType = translationType;
	}

	// Default value in the constructors
	public SearchModel() 
	{
		
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getVerseName() {
		return verseName;
	}

	public void setVerseName(String verseName) {
		this.verseName = verseName;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public Boolean getShowVerseNumbers() {
		return showVerseNumbers;
	}

	public void setShowVerseNumbers(Boolean showVerseNumbers) {
		this.showVerseNumbers = showVerseNumbers;
	}

	public String getTranslationType() {
		return translationType;
	}

	public void setTranslationType(String translationType) {
		this.translationType = translationType;
	}
	

	
}
