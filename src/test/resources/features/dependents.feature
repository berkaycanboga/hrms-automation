@US8
Feature: ESS user can add dependents

  Scenario: Add a dependent for an employee
    Given ESS user is logged in for dependents
    When ESS user navigates to Dependents of "John Doe"
    Then Dependents section should be displayed
    When ESS user adds a dependent with "Jane Doe" "Child" "2015-06-01"
    Then Dependent should be added successfully
