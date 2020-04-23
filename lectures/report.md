## Reporting

Frankly speaking reporting is not strong part of Cucumber. If you want to have informative and readable report after test execution you need to attach external tool. According to Cucumber's documentation there is many opportunities:  

*  https://cucumber.io/docs/cucumber/reporting/

One of additional third-party plugin mentioned in above documentation is Cluecumber.
This is maven plugin supporting presentation of test execution delivered by Trivago developers.

For more details look at this document:
[Cluecumber report](https://tech.trivago.com/2017/11/16/cluecumber-report-maven-plugin-for-cucumber-test-reporting/)


Now let’s make some update in our project and configure Cluecumber.

1. Update pom.xml file and made plugin configuration:


