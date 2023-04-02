@SEAMLES10-374 #user story

Feature: Seamlessly login Function

"""
  User Story :
  As a user, I should be able to login.
  Acceptance Criteria:
  1-User can login with valid credentials (either clicking on the "Login button" or hitting the "Enter" key from the keyboard as the last step)
  2-User can not login with any invalid credentials
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field" message should be displayed if the password or username is empty
  3-User can see the password in a form of dots by default
  4-User can see the password explicitly if needed
  5-User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
  6-User can see valid placeholders on Username and Password fields
  """

  Background:
    Given user is on login page

 @smoke @SEAMLES10-505 @wip #US1 AC1
  Scenario: login with valid credentials by clicking on the "Login button"
    When  user enters "Employee2" and "Employee123"
    And   user clicks the login button
    Then  user should be on the dashboard

  @smoke @SEAMLES10-506 @wip #US1 AC1-2
  Scenario: login with valid credentials by hitting the "Enter" key from keyboard
    When  user enters "Employee3" and "Employee123"
    And   user hit the enter button from keyboard
    Then  user should be on the dashboard

  @SEAMLES10-519 @wip #US1 AC2
  Scenario Outline: login with any invalid credentials
    When user enters "<username>" and "<password>"
    And user clicks the login button
    Then user should see "<message>"

    Examples:
      | username   | password    | message                     |
      | Employee20 | Employee123 | Wrong username or password. |
      | Employe20  | Employee123 | Wrong username or password. |
      | Employee   | Employee    | Wrong username or password. |

  @SEAMLES10-523 @wip #US1 AC2-2
  Scenario Outline: login with blank credentials
    When user enters "<username>" and "<password>"
    And user clicks the login button
    Then user should see blank "<message>"

    Examples:
      | username | password | message                     |
      |          | Employee | Please fill out this field. |
      | Employee |          | Please fill out this field. |
      |          |          | Please fill out this field. |

  @SEAMLES10-524 @wip #US1 AC3
  Scenario: password in a form of dots
    When  user enters "Employee2" and "Employee123"
    Then User should see the password in a form of dots

  @SEAMLES10-527 @wip #US1 AC4
  Scenario:  password explicitly if needed
    When  user enters "Employee2" and "Employee123"
    And  user clicks on toggle image
    Then User should see the password explicitly

  @SEAMLES10-528 @wip #US1 AC5
  Scenario: Forgot password? link is displayed
    Then user should see the "Forgot password?" link on the login page

  @SEAMLES10-529 @wip #US1 AC5-2
  Scenario: Reset Password link is displayed after clicking on forget password link
    When  user clicks the "Forgot password" link
    Then user should see the "Reset Password" link

  @smoke @SEAMLES10-531@wip  #US1 AC6
  Scenario: valid placeholders fields
    Then user should see valid placeholder on "Username or email"  field

  @SEAMLES10-532 @wip #US1 AC6-2
  Scenario: valid placeholders fields
    Then user should see valid placeholder on "Password" field


