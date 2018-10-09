
Feature: Booking Flow

  @JBS_SC01_TC01
  Scenario Outline: SC01_TC02_Verify user is able to book cruise through Jet blue application
    Given User Launches JetBlue Application
    When User clicks on I am feeling Lucky
    
    Examples: 
      | Google | lucky |
      | Google | lucky |
      
       @JBS_SC01_TC02	
     Scenario Outline: Finding some cheese
   Given I am on the Google search page
   When I search for "Cheese!"
   Then the page title should start with '<cheese>'
     Examples: 
      | Google |cheese|