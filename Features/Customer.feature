#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Customers

Background: Below are the common steps for each scenario
		
		Given User launch Chrome browser
		When User opens URL "https://admin-demo.nopcommerce.com/login"
		And User enter Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login button
		Then User can view Dashboard
		When User click on Customers menu
		When User click on Customers menu item
  
Scenario: Add a new Customer
				
		And click on Add new link
		Then User can view Add new customer page
		When User enter customer info
		And click on Save button
		Then User can view confirmation message "The new customer has been added successfully."
		And close browser

Scenario: Search Customer By using EmailId
				
		And Enter customer Email
		When click on Search button
		Then User should find Email in the search results
		
		And close browser
	

