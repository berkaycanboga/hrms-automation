@US5
Feature: ESS user edits and saves personal details via PIM

  Background:
    Given ESS user is logged in

  Scenario: ESS user edits and saves personal details
    When ESS user navigates to Employee List page
    And ESS user searches for employee "Ali Veli"
    And ESS user opens personal details of "Ali Veli"
    Then personal details page should be displayed
    When ESS user updates personal details with "Ahmet", "Mehmet", "Yilmaz", "Female", "Turkish", "Single"
    Then personal details should be updated successfully
