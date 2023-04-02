@SEAMLES10-375 #user story

Feature: Logout function

  # User Story :
  # As a user, I should be able to log out.
  # Acceptance Criteria:
  # 1-User can log out and ends up in login page
  # 2-User can not go to home page again by clicking step back button after successfully logged out.

  Background:
    Given user logged in

  @smoke @SEAMLES10-535 @wip #US1 AC1
  Scenario: Logout and ends up in login page
    When user clicks on the avatar image dropdown
    And user clicks on the Log out button
    Then user should go back to the login page

  @SEAMLES10-536 @wip #US1 AC2
  Scenario: verify user can not go to home page again by clicking step back button after successfully logged out
    When user logged out successfully
    And user clicks on step back button
    Then user should not go to home page again