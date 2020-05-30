Feature: Desktop WEB UI - Redmine - Projects
  As a user
  I want to ...

  @E2E
  Scenario: Create a Project
    Given I go to the Redmine login page on URL
    When I login with my credentials user "user" and "bitnami1"
    And I create a project
      | name        | RedmineProject                    |
      | description | Esta es una descripción de prueba |
      | homepage    | RedmineProject                    |
      | public      | true                              |
    Then The project was successfully created