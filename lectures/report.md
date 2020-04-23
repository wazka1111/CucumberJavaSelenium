## Reporting

Frankly speaking reporting is not strong part of Cucumber. If you want to have informative and readable report after test execution you need to attach external tool. According to Cucumber's documentation there is many opportunities:  

*  https://cucumber.io/docs/cucumber/reporting/

One of additional third-party plugin mentioned in above documentation is Cluecumber.
This is maven plugin supporting presentation of test execution delivered by Trivago developers.

For more details look at this document:
[Cluecumber report](https://tech.trivago.com/2017/11/16/cluecumber-report-maven-plugin-for-cucumber-test-reporting/)


Now let’s make some update in our project and configure Cluecumber.

1. Update pom.xml file and made plugin configuration:

![report](./img/bdd/pom.jpg)


Please look at <configuration> section.
Here you can define your custom requirements. Mandatory entries are:
sourceJsonReportDirectory – Indicate directory where json file is stored after execution
generatedHtmlReportDirectory - Indicate directory where final HTML file report will be stored after execution. This report is created based on json defined in sourceJsonReportDirectory

Additionally you can define following details:
- test name
- log level
- css file for new format of the report
- custom properties and many more
For more details look at:  https://github.com/trivago/cluecumber-report-plugin


2. In order to give suggestion to Cucumber where is json file you need to add @Cucumber Option()
@CucumberOptions( plugin = {"json:target/cucumberReport/cucumber.json"},

3. Run your tests using RunTest class (this class is annotated by @CucumberOptions)

4. Using Terminal panel in Intelij run this command to generate HTML report based on json file:
mvn cluecumber-report:reporting





















5. In order to see report navigate to location defined in pom.xml
In most cases it is target folder within the project. 
Open in any browser index.html file:














































6. Here is example of report view:






