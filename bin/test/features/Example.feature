Feature: Library

  @Search
  Scenario: User can search for resources
    Given I log in to the website
    When I navigate to the search page
    Then I can search for "hippo"

  @Articles
  Scenario: User can add an article
    Given I log in to the website
    When I navigate to the article page
    Then I can add an article
