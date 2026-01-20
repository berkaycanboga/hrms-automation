@US2

Feature: Add Employee in HRMS

  Scenario: Admin adds a new employee without providing employee ID
    Given admin is logged in
    When admin navigates to Add Employee page
    And admin enters employee first and last name
    And admin saves the employee
    Then employee should be added successfully
