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
#@tag
#Feature: Title of your feature
#  I want to use this template for my feature file

#  @tag1
#  Scenario: Title of your scenario
#    Given I want to write a step with precondition
#    And some other precondition
#    When I complete action
#    And some other action
#    And yet another action
#    Then I validate the outcomes
#    And check more outcomes

#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |


Feature: Login

@Sanity		#to run specific scenarios
Scenario: Successful Login with Valid Credentials
	Given User launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login button
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on Logout link
	Then Page title should be "Your store. Login"
	And close browser 
	
@Regression	
Scenario Outline: Login Data Driven
	Given User launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "<email>" and Password as "<password>"
	And Click on Login button
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on Logout link
	Then Page title should be "Your store. Login"
	And close browser 
	
		Examples: 
   		| email  | password | status  |
      #| admin@yourstore.com | admin | success |
      | admin@yourstore.com | admin1 | fail |