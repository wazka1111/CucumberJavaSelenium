## 2. Behavior-driven development (BDD) - introduction

### Gherkin style

  Gherkin is a specific syntax that makes plain text structured enough for Cucumber to understand. Cucumber matches Gherkin steps into respective code snippets in Selenium (step definitions) using regular expressions behind the scene.
  
Gherkin serves multiple purposes:

*  Recommendation for analysts to use Gherkin in order to create unambiguous specification (requirements)
*  Makes automated scripts flow clear and easy to follow
*  Test scripts becomes automatically useful documentation that indicate how the system actually behaves
Gherkin documents are stored in .feature text files and are crucial part of the project: eg:
Login.feature

**TIP!**
Files .feature should be stored in separate package within project structure. 

### Feature file


Here is example of feature file content:

        Feature: Here type name of the feature that you are testing
        Scenario: Here type name of the test that you are going to create
        Given Here type preconditions that have to be prepared before the test
        When Here type action/actions that you need to do in order to complete your test
        Then Here type verifications/assertions that you need to perform. 


Additionally we can use “And” to extend one of the steps:
eg:

        Given Step text
        And Extend step
        When Step text
        And Step text
        Then Step text
        And Step text


**Best practice:**

It is not mandatory but part of best practice only. 
1. Here is a question:

Should I create steps using first person position? (When I input login into the system) 

or rather third person position (When User input his login into the system)

        **My recommendation – third person position**

2. Should I use imperative or declarative communication type in my scripts?
 
        **My recommendation – declarative type.**

What is the difference?

**Imperative** means each step is a precise instruction. The inputs and expected results are specified exactly. It might cause problem after any modification in the system.

**Declarative** means each step communicates an idea, but the exact values aren’t specified. It assumes more flexible way to define steps. 

##### Examples:

**Imperative style:**

        Feature:  Free subscribers see only the free movies 
        Given users with a free subscription can access "Open movies" but not "Premium movies" 
        When I type "openUser@domain.com" in the email field 
        And I type "passwd123" in the password field 
        And I press the "Login" button 
        Then I see "Open movies" on the home page 
        And I do not see "Premium movies" on the home page

**Declarative style – RECOMMENDED :**

        Feature:  Free subscribers see only the free movies 
        Given Free Monica has a free/open subscription
        When Free Monica logs in with her valid credentials
        Then Free Monica sees a only open movies on the home page 

Take a look at other example in my project:
Here is imperative style. There are so many steps related to order some product:

![imperative](./img/bdd/badPracticePurchaseFeature.jpg)


and on the other hand declarative style. This is the same scenario but more concise and readable:

![imperative](./img/bdd/badPracticePurchaseFeature2.jpg)
 


For more details refer to:
[Cucumber documentation](https://cucumber.io/docs/bdd/better-gherkin/)	


Feature file is strictly related to step definition. 
Here is relations between feature file, step definitions and application:

![graph](./img/bdd/arch.jpg)



### Data table

Along with step declaration you can define additional specific data related to test case (type String, Integer, Float, Double, Byte, Short, Long, BigInteger or BigDecimal)  

Here is snippet from .feature file:


![datTable1](./img/bdd/int.jpg)




Numbers 100, 200, 300 presented in table format behind the scene are converted to List<String>. 
Using DataTable object you can use those numbers in your test method. 
Base on that let’s create step definition class:


![datTable1](./img/bdd/datatable.jpg)




From Cucumber version 5 you can achieve the same result using this step definition. In this case, the DataTable is automatically flattened to a List<Integer> by Cucumber (using DataTable.asList(Integer.class)) before invoking the step definition. 

![datTable1](./img/bdd/datatable2.jpg)




For more details refer to:
[Cucumber documentation](https://cucumber.io/docs/cucumber/api/?sbsearch=Data%20Table)



Next take a look at the number 600 in .feature file. This time this data is a part of the step description. If you want use this number in step definition method you can put {int} expression:

![datTable1](./img/bdd/datatable3.jpg)



Also you can use {string} expression in order to send some string data type. Please pay attention on single-quoted or double-quoted strings:

![datTable1](./img/bdd/string.jpg)




and respective step definition:


![datTable1](./img/bdd/string2.jpg)




For more details refer to:
[Cucumber documentation](https://cucumber.io/docs/cucumber/cucumber-expressions/#parameter-types)


### Scenario outline

Let’s assume that you need run your scenario couple of times for different test data values. Cucumber provides Scenario Outline concept in order to achieve that. Instead of Scenario we need define Scenario Outline along with Examples section. Let’s see how it looks like in feature file:

![datTable1](./img/bdd/scenariooutline.jpg)

Cucumber will recognize how many rows are defined in Examples table and test will be executed this number of times – in my example: 4


### Step definition

Scenarios will be executed only if respective step definitions are created. There are two ways to create step definition content. Let’s see how to do that:
1. In the feature file use Intelij prompt and click “Create step definition” option:


![datTable1](./img/bdd/stepdef.jpg)



2. Right click on feature file and select “Run Feature file”. After execution jump to Run panel in Intelij and see results. Cucumber should inform you that steps are not implemented. Copy this content and paste to separate class in the following location: src/test/stepDefinition/LoginSteps.class

![datTable1](./img/bdd/stepdefimplementation.jpg)  


Here is LoginSteps.class:

![datTable1](./img/bdd/classstepdefinition.jpg)


