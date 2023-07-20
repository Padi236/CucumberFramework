package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.assertEquals;

import pageObjects.AddNewCustomer;
import pageObjects.LoginPage;
import pageObjects.SearchCustomePage;
import utilities.TimeStamp;

public class StepDef extends BaseClass{
	
	//Implement step definition methods for every step in the Login.feature
	
	@Before		//Annotation/hook for cucumber. This method will execute one time before stepDefinitions starts executing
	public void setup()
	{			
		logger = LogManager.getLogger(StepDef.class);
		logger.info("*******Executing setup********");
		configProp = new Properties();
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(".//Configuration/config.properties");
			configProp.load(fis);
			fis.close();
			
		}
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		String browserName = configProp.getProperty("browser");
		
		switch(browserName)
		{
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
				driver = new ChromeDriver(options);
				logger.info("Launching Chrome Browser");
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				logger.info("Launching Firefox Browser");
				break;
				
			case "edge":
				driver= new EdgeDriver();
				logger.info("Launching Edge Browser");
				break;
				
			default:
				throw new IllegalArgumentException("Invalid browser specified: "+browserName);			
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*******Terminating setup********");
	}
	
	@After
	public void tearDown2(Scenario scenario)
	{
		logger.info("*******Executing TearDown********");
		if(scenario.isFailed())
		{
			//Take Screenshot
			System.out.println("********Inside if Loop tearDown2***********");
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			String screenShotName = "./Screenshot/"+scenario.getName()+TimeStamp.addTimeStamp()+".png";
			
			scenario.attach(screenshot, "image/png", screenShotName);
			logger.info("Screenshot saved successfully");			
		}
		
		driver.close();
		logger.info("*******Terminating tearDown2********");
	}
	
	//@After
	public void tearDown(Scenario scenario)
	{
		logger.info("*******Executing TearDown********");
		if(scenario.isFailed())
		{
			//Take Screenshot
			System.out.println("********Inside if Loop***********");
			TakesScreenshot screenShot = (TakesScreenshot)driver;
			File souceFile = screenShot.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("./Screenshot/Screenshot_"+TimeStamp.addTimeStamp()+".png");
			
			try {
				FileUtils.copyFile(souceFile, targetFile);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			logger.info("Screenshot saved successfully");
			//scenario.embed(Files.readAllBytes(targetFile.toPath()), "image/png")
			
		}
		
	//	driver.quit();
	}
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {		
		loginPage = new LoginPage(driver);				
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		
		driver.get(url);
		logger.info("*******Opening URL********");
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		
		logger.info("*******Providing Login Details********");
		loginPage.inputUserEmail(email);
		loginPage.inputUserPassword(password);
		
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	    
		logger.info("*******Started Login********");
		loginPage.clickLoginBtn();
		
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	   
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			logger.info("*******Login Successful********");
			assertTrue(false);
		}
		else
		{
			logger.info("*******Login failed********");
			assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() {
	    
		logger.info("*******Click on Logout link********");
		loginPage.clickLogoutLink();
		
		
	}

	////////Customer Feature Step Definition///////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		
		addNewCustomer = new AddNewCustomer(driver);
		assertEquals("Dashboard / nopCommerce administration", driver.getTitle());	
	}

	@When("User click on Customers menu")
	public void user_click_on_customers_menu() {
	    addNewCustomer.clickLinkCustomersMenu();
	}
	
	@When("User click on Customers menu item")
	public void user_click_on_customers_menu_item() {
		addNewCustomer.clickLinkCustomersMenuItem();
	}

	@When("click on Add new link")
	public void click_on_add_new_link() {
	   addNewCustomer.clickLinkAddNewCustomer();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
		
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		
		logger.info("*******Adding New Customer********");
		logger.info("*******Providing Customer Details********");
		addNewCustomer.setTxtEmail(randomString()+"@example.com");
		addNewCustomer.setTxtPassword("P@di123");
	   
	}

	@When("click on Save button")
	public void click_on_save_button() {
	   
		logger.info("*******Saving Customer Data********");
		addNewCustomer.clickSaveBtn();
	}
	

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String successMessage) {
	   
		assertTrue(driver.getPageSource().contains(successMessage));
	}

///////////////Search Customer////////////////////
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		
		logger.info("*******Searching a customer by using EmailID********");
		searchCustomer = new SearchCustomePage(driver);
		searchCustomer.setEmail("michael.scott@gmail.com");
	}

	@When("click on Search button")
	public void click_on_search_button() {
		searchCustomer.clickSearchBtn();
	}

	@Then("User should find Email in the search results")
	public void user_should_find_email_in_the_search_results() {
		assertTrue(searchCustomer.searchCustomerByEmail("michael.scott@gmail.com"));
	}


}
