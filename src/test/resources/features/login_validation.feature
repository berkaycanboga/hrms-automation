@US9
Feature: Login Error Validation

  Scenario Outline: Validate login errors
    Given User is on login validation page
    When User enters validation username "<username>" and password "<password>"
    And User clicks login button
    Then Validation error message "<error>" should be shown
    And User stays on login page

    Examples:
      | username     | password     | error                 |
      | Admin        | wrongpass    | Invalid credentials   |
      | Admin        | EMPTY        | Required              |
      | EMPTY        | admin123     | Required              |
      | EMPTY        | EMPTY        | Required              |
