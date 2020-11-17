Feature: Calculate BMI
  @RegressionTest
  Scenario Outline: Calculation of BMI
    Given I open the Calculator.Net URL
    And Click on BMI Calculator Link
    When I Enter Age "<age>", Height "<height>", Weight "<weight>"
    And Click on Calculate button
    Then I validate the BMI Result
    And Close the Browser
    Examples:
      | age  | height | weight  |
      | 10   |127     |40       |
			| 30	 |156     |70 			|
			| 25	 |152			|55 			|
			| 20	 |160			|45 			|
			| 35	 |160			|70 			|