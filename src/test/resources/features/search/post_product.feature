Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario Outline: to check whether the application url invokes for apple/mango
    When he calls endpoint <url> with <product> from <path>
    Then he sees the results displayed for <product>
    Examples:
      | url            | product | path                                                       |
      | applicationurl | apple   | \\src\\test\\resources\\constants\\Applications.properties |
      | applicationurl | mango   | \\src\\test\\resources\\constants\\Applications.properties |

  Scenario Outline: to check whether the application throws error for cars
    When he calls endpoint <url> with <product> from <path>
    Then he does not see the results <result>
    Examples:
      | url            | product | result | path                                                       |
      | applicationurl | car     | true   | \\src\\test\\resources\\constants\\Applications.properties |
      | applicationurl | Apple   | true   | \\src\\test\\resources\\constants\\Applications.properties |