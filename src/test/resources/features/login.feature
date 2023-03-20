@SEAMLES10-508 #test execution
Feature: Seamlessly login Function

  User Story : As a user, I should be able to login.


  @SEAMLES10-505 #US1 AC1

  Background:
          Given user is on login page

  Scenario: login with valid credentials by clicking on the "Login button"
    When  enter "Employee2" and "Employee123"
    And   click the login button
    Then  user should be on the dashboard

  Scenario: login with valid credentials by hitting the "Enter" key from keyboard
    When  enter "Employee3" and "Employee123"
    And   hit the enter button from keyboard
    Then  user should be on the dashboard
