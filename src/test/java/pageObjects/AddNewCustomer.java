package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer {

	WebDriver driver;
	
	public AddNewCustomer(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	By linkCustomersMenu = By.xpath("//div[@class='sidebar-form']/following-sibling::nav//p[contains(text(),'Customers')]//ancestor::a[@href='#']");
	By linkCustomersMenuItem = By.xpath("//div[@class='sidebar-form']/following-sibling::nav//p[contains(text(),'Customers')]//ancestor::a[@href='/Admin/Customer/List']");
	By linkAddNewCustomer = By.xpath("//a[normalize-space()='Add new']");
	By txtEmail = By.cssSelector("input#Email");
	By txtPassword = By.cssSelector("input[name='Password']");
	By txtFirstName = By.cssSelector("input#FirstName");
	By txtLastName = By.cssSelector("input[name='LastName']");
	By radioBtnMale = By.cssSelector("input#Gender_Male");
	By radioBtnFemale = By.id("Gender_Female");
	By txtDateOfBirth = By.id("DateOfBirth");
	By txtCompanyName = By.id("Company");
	By checkboxIsTaxExempt = By.name("IsTaxExempt");
	By dropDownNewsletter = By.xpath("//label[text()='Newsletter']//ancestor::div/following-sibling::div//div[@role=\"listbox\"]");
	By listOptionNewsletterYourStoreName = By.xpath("//li[text()='Your store name']");
	By listOptionNewsletterTestStore2 = By.xpath("//li[text()='Test store 2']");
	
	
	By selectedCustomerRole = By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[not(@title=\"delete\")]");	//Should be registered by default
	By selectedCustomerRoles = By.cssSelector("ul#SelectedCustomerRoleIds_taglist>li");		//Should be 1
	//By dropDownCustomerRoles = By.xpath("//label[text()='Customer roles']//ancestor::div/following-sibling::div//div[@role='listbox']");
	By selectCustomerRoles = By.xpath("//select[@id='SelectedCustomerRoleIds']");
	
	
	
	
	By selectManagerOfVendor = By.id("VendorId");	//options = Vendor 1, Vendor 2
	By checkBoxActive = By.id("Active");
	By textAreaAdminComment = By.id("AdminComment");
	By btnSave = By.xpath("//button[@name='save']");
	By btnSaveContinueEdit = By.xpath("//button[@name='save-continue']");
	By linkBackToCustomerList = By.linkText("back to customer list");
	
	public void clickLinkCustomersMenu()
	{
		driver.findElement(linkCustomersMenu).click();
	}
	
	public void clickLinkCustomersMenuItem()
	{
		driver.findElement(linkCustomersMenuItem).click();
	}
	
	public void clickLinkAddNewCustomer()
	{
		driver.findElement(linkAddNewCustomer).click();
	}
	
	public void setTxtEmail(String email)
	{
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setTxtPassword(String password)
	{
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setTxtFirstName(String firstName)
	{
		driver.findElement(txtFirstName).sendKeys(firstName);
	}
	
	public void setTxtLastName(String lastName)
	{
		driver.findElement(txtLastName).sendKeys(lastName);
	}
		
	public void clickRadioBtnMale()
	{
		driver.findElement(radioBtnMale).click();
	}
	
	public void clickRadioBtnFemale()
	{
		driver.findElement(radioBtnFemale).click();
	}	
	
	public void setTxtDateOfBirth(String dateOfBirth)	//6/29/2011
	{
		driver.findElement(txtDateOfBirth).sendKeys(dateOfBirth);
	}
		
	public void setTxtCompanyName(String lastName)
	{
		driver.findElement(txtCompanyName).sendKeys(lastName);
	}
	
	public boolean istaxEmptChecked()
	{
		WebElement isTaxExemptCheckbox = driver.findElement(checkboxIsTaxExempt);
		String attrValue = isTaxExemptCheckbox.getAttribute("data-val");
		if(attrValue.toString().equals("true"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickCheckboxIsTaxExempt(boolean toBeChecked)
	{	
		boolean isTaxExempted = istaxEmptChecked();
		
		if(!isTaxExempted)
		{
			driver.findElement(checkboxIsTaxExempt).click();		
		}
		
	}
	
	public List<String> defaultCustomerRoles()
	{
		List<WebElement> selectedCustRoles = driver.findElements(selectedCustomerRole);
		List<String> selectedCustRolesText = new ArrayList<String>();
		for (WebElement webElement : selectedCustRoles) 
		{
			selectedCustRolesText.add(webElement.getText());
		}
		return selectedCustRolesText;
	}
	
	public void selectCustomerRoles(List<String> roles)
	{	
		WebElement selectCustRoleLoc = driver.findElement(selectCustomerRoles);		
		Select selectRole = new Select(selectCustRoleLoc);		
		
		for (String string : roles) 
		{
			if(!string.equals("Registered"))
			{
				
			}
		}	
	
	}
	
	
	
	public void clickSaveBtn()
	{
		driver.findElement(btnSave).click();
	}
	
}
