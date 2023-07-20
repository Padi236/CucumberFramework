package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomer;
import pageObjects.LoginPage;
import pageObjects.SearchCustomePage;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomer addNewCustomer;
	public SearchCustomePage searchCustomer;
	public static Logger logger;
	public Properties configProp;
	
	public static String randomString()
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}

	
}
