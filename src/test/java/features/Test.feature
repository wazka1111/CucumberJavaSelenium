Feature: Verification all features provided by Cucumber
  Let's try out scenario outline and other regexp options

  @test
  Scenario Outline: Add new student into Student management system
    Given New student is going to join to school
    When  Student details are added to the system: '<Name>', '<Surname>', '<Date_of_birth>', '<Country>'
    Then  Student id <Id> is assigned to new student

    Examples: Students
      | Id  | Name     | Surname  | Date_of_birth | Country |
      | 122 | Angelina | Jolie    | 02-12-1977    | USA     |
      | 123 | Brad     | Pitt     | 23-03-1973    | USA     |
      | 124 | Janusz   | Kowalski | 12-04-1987    | Poland  |
      | 125 | Grażyna  | Nowak    | 15-09-1985    | Poland  |

  @test
  Scenario: Test add method from calculator function
    Given user wants to add the following numbers:
      | 100 |
      | 200 |
      | 300 |
    When user perform add method from calculator function
    Then correct result is 600

  @test
  Scenario: Test add method from calculator function and print sumResult
    Given user wants to add the following numbers:
      | 100 |
      | 200 |
      | 300 |
    When user perform add method from calculator function
    Then correct result is 'sumResult'