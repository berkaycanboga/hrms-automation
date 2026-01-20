@US7

Feature: Profile Picture Upload

  Scenario: ESS user uploads a profile picture
    Given ESS user is logged in for profile picture upload
    When ESS user navigates to profile picture of "Ali Veli"
    Then Profile picture section should be displayed
    When ESS user uploads a profile picture
