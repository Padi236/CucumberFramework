package stepDefinitions;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass{
		
	@Then("close browser")
	public void close_browser() {
	  
		logger.info("*******Closing browser********");
		//driver.close();
		
	}
	
}
