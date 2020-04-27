## Hook

Hook is a concept similar to those existing in JUnit, TestNG. It is action executed at some point of test flow. In most cases it is method: setUp or tearDown that is running before or after scenarios.   

In our project we are using:

*  @Before – repeated before each scenario
*  @After - repeated after each scenario
*  @BeforeStep - repeated before each step
*  @AfterStep - repeated after each step
  

**NOTE:**
Interesting additional options possible for @Before hook:

*  order – order of methods execution
*  value – method will be executed before scenarios annotated by specific tag.

For more details refer to:
[Cucumber documentation](https://cucumber.io/docs/cucumber/api/)

