@US1

Feature: HRMS Admin Login

  Scenario: Admin logs in successfully with valid credentials
    When admin logs in with valid credentials
    Then admin should see the dashboard page
