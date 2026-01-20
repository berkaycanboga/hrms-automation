@US3

Feature: Create Login Details for Employee

  Scenario: Admin creates ESS user for existing employee
    Given admin is logged in for user creation
    When admin navigates to Add User page
    And admin creates ESS user for employee
    And admin saves the new user
    Then user should be created successfully
