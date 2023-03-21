@SEAMLES10-508 #test execution
Feature: Seamlessly login Function

  User Story : As a user, I should be able to login.

  Background:
    Given user is on login page

  @SEAMLES10-505 #US1 AC1
  Scenario: login with valid credentials by clicking on the "Login button"
    When  user enters "Employee2" and "Employee123"
    And   user clicks the login button
    Then  user should be on the dashboard

  @SEAMLES10-524 #US1 AC1-2
  Scenario: login with valid credentials by hitting the "Enter" key from keyboard
    When  user enters "Employee3" and "Employee123"
    And   user hit the enter button from keyboard
    Then  user should be on the dashboard

  @SEAMLES10-506 #US1 AC2
  Scenario Outline: login with any invalid credentials
    When user enters "<username>" and "<password>"
    And user clicks the login button
    Then user should see "<message>"
    Examples:
      | username   | password    | message                     |
      | Employee20 | Employee123 | Wrong username or password. |
      | Employe20  | Employee123 | Wrong username or password. |
      | Employee   | Employee    | Wrong username or password. |

  @SEAMLES10-523 #US1 AC2-2
  Scenario Outline: login with blank credentials
    When user enters "<username>" and "<password>"
    And user clicks the login button
    Then user should see blank "<message>"
    Examples:
      | username | password | message                     |
      |          | Employee | Please fill out this field. |
      | Employee |          | Please fill out this field. |
      |          |          | Please fill out this field. |

  @SEAMLES10-519 #US1 AC3
  Scenario: password in a form of dots
    When  user enters "Employee2" and "Employee123"
    Then User should see the password in a form of dots

  @SEAMLES10-527 #US1 AC4
  Scenario:  password explicitly if needed
    When  user enters "Employee2" and "Employee123"
    And  user clicks on toggle image
    Then User can see the password explicitly


