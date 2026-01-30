Feature: Flipkart OrderPlacement

  Scenario Outline: Order Placement Validation for Flipkart users
    Given user opens Flipkart application
    When user logs in with "<mobileno>"
    And user searches product "<product>"
    And user selects "<nth>" product from results
    And user adds product to cart
    And user proceeds to checkout
    And user enters customer details
    And user completes the order
    Then user should be logged out successfully

    Examples:
      | mobileno    | product | nth |
      | 9345820435  | Asus Laptop  | 10   |
