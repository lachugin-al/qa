Feature: Test google.com search page

  @google
  Scenario: Open google.com, find "Hello World"
    Given Choose "Google" profile
    Given Open "http://google.com" page
    Then Find "HelloWorld"