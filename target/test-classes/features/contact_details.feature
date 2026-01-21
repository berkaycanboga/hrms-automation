@US6
Feature: ESS user updates their contact details
  Scenario: ESS user edits and saves their contact details
    Given ESS user is logged in
    When ESS user navigates to Contact Details of "Ali Veli"
    Then Contact Details page should be displayed
    When ESS user updates contact details with "Street 1" "Street 2" "City" "State" "12345" "Turkey" "111111111" "222222222" "333333333"
    Then contact details should be updated successfully
