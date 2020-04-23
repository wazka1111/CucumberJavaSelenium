## Running test cases


Now let’s consider how we can run our test cases. There are 3 ways. Choose the best for you:

1. **Feature file run**

Currently we have one feature file: Login.feature.  In order to run our feature we need external plugin to Intelij. Navigate to File→Settings→Plugins and search Cucumber for java plugin. 



Once plugin is installed jump to its edit configuration panel: Run→Edit Configurations…




Set following mandatory options:


*  Main class:	io.cucumber.core.cli.Main	This is main class from Cucumber library that handle runner operation. 

*  Glue:	stepDefinition	This is place (your package name) where step definition class is stored.

*  Feature or folder path:	C:/Users/DH/Desktop/cucumberSeleniumDemo/src/test/java/features/Login.feature	This is full path to your feature file. 



Now you have IDE ready to run feature file. Right click on that and click “Run Feature login. ” option. 

**NOTE!**
Please have in mind that all scenarios within feature file will be executed regardless tags.  

2. **Cucumber runner class - It is RECOMMENDED way.** 

You need to create separate class. Class name should contains “Test” word eg:
RunnerTest, RunTest.

Class body is actually empty. The most crucial part are annotations before class:

*  @RunWith(Cucumber.class)

*  @CucumberOptions()

Benefit of this solution is define additional option within @CucumberOptions():
*  plugin
*  features
*  strict
*  glue
*  tags



For more details refer to:
[Cucumber documentation](https://cucumber.io/docs/cucumber/api/?sbsearch=cucumberOptions#list-configuration-options)

3. **Maven plugin**

  You can use maven plugin to run runTest class.  In order to do that use maven command:
        mvn test 
  either in terminal panel or maven window in IDE:


For more details refer to:
[Cucumber documentation](https://cucumber.io/docs/cucumber/api/?sbsearch=cucumberOptions#list-configuration-options)



**TIP:**
Using maven command we can combine two goals: test and report plugin. After that all desired test scenarios are running and test report is created after execution. 

        mvn test cluecumber-report:reporting


For more details refer to:
[Cucumber documentation](https://cucumber.io/docs/cucumber/api/)





