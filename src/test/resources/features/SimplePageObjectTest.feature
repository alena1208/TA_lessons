@simple_test
Feature: Login

  Scenario Outline:
    Given user open site <linkToSite>
    When user login as <login> with password <password>
    Then page title equals to "Home Page"
    Examples:
      | linkToSite| login | password |
      | https://epam.github.io/JDI/index.html|epam|1234|