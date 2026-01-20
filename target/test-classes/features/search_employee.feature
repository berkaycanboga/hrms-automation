@US4
Feature: Search for an Employee in HRMS

  Background:
    Given admin is logged in for employee search
    And admin navigates to Employee List page

  Scenario: Search employee by full name
    When admin searches employee by name "Ali Veli"
    Then employee with name "Ali Veli" should be displayed

  Scenario: Search employee by employee id
    When admin searches employee by id "0912"
    Then employee with id "0912" should be displayed

  Scenario: Search with no matching result
    When admin searches employee by name "NotExist User"
    Then system should show No Records Found message
