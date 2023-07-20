package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="input#Email")		//CSS with id Email
	@CacheLookup
	private WebElement inputEmail;
	
	@FindBy(how=How.CSS, using="input.password")	//CSS with class password
	@CacheLookup
	private WebElement inputPassword;
	
	@FindBy(how=How.XPATH, using ="//button[text()='Log in']")
	@CacheLookup
	private WebElement btnLogin;
	
	@FindBy(how=How.LINK_TEXT, using = "Logout")
	@CacheLookup
	private WebElement btnLogout;
	
	public void inputUserEmail(String email)
	{
		inputEmail.clear();
		inputEmail.sendKeys(email);
	}
	
	public void inputUserPassword(String password)
	{
		inputPassword.clear();
		inputPassword.sendKeys(password);
	}
	
	public void clickLoginBtn() 
	{
		btnLogin.click();
	}
	
	public void clickLogoutLink()
	{
		btnLogout.click();
	}
	
	
	
	
}
