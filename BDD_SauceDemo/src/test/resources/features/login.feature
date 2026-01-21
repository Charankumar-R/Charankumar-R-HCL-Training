Feature: SauceDemo Login

Scenario Outline: Login using different users
  Given user opens SauceDemo login page
  When user logs in with "<username>" and "<password>"
  Then login result should be validated

Examples:
  | username                | password      |
  | standard_user           | secret_sauce  |
  | locked_out_user         | secret_sauce  |
  | problem_user            | secret_sauce  |
  | performance_glitch_user | secret_sauce  |
  | error_user              | secret_sauce  |
  | visual_user             | secret_sauce  |
