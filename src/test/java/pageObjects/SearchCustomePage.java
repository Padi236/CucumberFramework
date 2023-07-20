package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomePage {
	
	WebDriver driver; 
	WaitHelper wait;
	
	public SearchCustomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		wait = new WaitHelper(driver);
	}
	
	@FindBy(how=How.ID, using="SearchEmail")
	WebElement txtSearchEmail;
	
	@FindBy(how=How.ID, using="search-customers")
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']/tbody/tr/td[2]")
	List<WebElement> tableEmailColumn;
		
	public void setEmail(String searchEmailText)
	{
		wait.WaitForElement(txtSearchEmail, 10);
		txtSearchEmail.sendKeys(searchEmailText);
		
	}
	
	public void clickSearchBtn()
	{
		btnSearch.click();
	}
	
	public int getNoOfRows()
	{
		return tableRows.size();
	}
		
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;
		for (WebElement webElement : tableEmailColumn) 
		{				
			System.out.println(webElement.getText());
			if(webElement.getText().equals(email))
			{
				
				flag = true;;
				break;
			}			
		}	
		return flag;
	}
	
	//List<WebElements> rowData = new Arr
	

}
