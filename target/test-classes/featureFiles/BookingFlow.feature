
Feature: Booking Flow

  @JBS_SC01_TC02
  Scenario Outline: SC01_TC01_Verify user is able to book cruise through Jet blue application
    Given User Launches JetBlue Application
    When User clicks on Lets Cruise
    Then User filter cruise by'<Cruiseline>'
    And User selects a cruise from search results
    And User Enter the '<Passengerdetails>'
    And Enters '<Carddetails>'
    And User Enters '<BillingAddress>'
    Then Agree to terms and conditions
    And Verify Confirmation Message   
    Examples: 
      | Cruiseline |Passengerdetails|Carddetails|BillingAddress|
      | Cruiseline |Passengerdetails|Carddetails|BillingAddress|
      
    @JBS_SC01_TC01
    Scenario Outline: Search java9 in google
    Given User Launches Google
    Examples:
    | google |
     