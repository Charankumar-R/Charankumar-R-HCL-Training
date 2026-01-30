Feature: SauceDemo Login

  Scenario Outline: Login validation for SauceDemo users
    Given user "<username>" should be allowed to login
    When user logs in with "<username>" and "<password>"
    And user selects a product "<product>"
    And user adds product to cart
    And user proceeds to checkout
    And user enters customer details "<firstname>" "<lastname>" "<zipcode>"
    And user completes the order
    Then order should exist in database

    Examples:
      | username                | password     | firstname | lastname | zipcode |
      | standard_user           | secret_sauce | John      | Doe      | 600001  |
      | locked_out_user         | secret_sauce | John      | Doe      | 600001  |
      | problem_user            | secret_sauce | John      | Doe      | 600001  |
      | performance_glitch_user | secret_sauce | John      | Doe      | 600001  |
      | error_user              | secret_sauce | John      | Doe      | 600001  |
      | visual_user             | secret_sauce | John      | Doe      | 600001  |
