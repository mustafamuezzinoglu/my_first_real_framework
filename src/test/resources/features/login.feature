@SEAMLES10-508 #test execution
Feature: Seamlessly login Function

  User Story : As a user, I should be able to login.


  @SEAMLES10-505 #US1 AC1

  Background:
          Given user is on login page

  Scenario: login with valid credentials by clicking on the "Login button"
    When  users enter "Employee2" and "Employee123"
    And   users click the login button
    Then  users should be on the dashboard

  Scenario: login with valid credentials by hitting the "Enter" key from keyboard
    When  users enter "Employee3" and "Employee123"
    And   users hit the enter button from keyboard
    Then  users should be on the dashboard



    Scenario Outline:

      When user enters "<username>"
      And user enters a "<password>"
      And user click on the login button
      Then user should see "<message>"
      Examples:
        | username   | password    | message                     |
        | EMPLOYEE30 | Employee123 | Wrong username or password. |
        | EMPLOYEE30 | Employee    | Wrong username or password. |
        | Employee3  | Employee    | Wrong username or password. |