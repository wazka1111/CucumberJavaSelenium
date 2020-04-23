## Tag

Using tags eg: **@regression, @api, @gui, @sanity** we can organize our set of scenarios in better way and take control over running. Tags are useful within Run Test class. Creation of tags is very straightforward:

Before Feature, Scenario, Scenario Outline, Examples write one or more @your_tag_name

![imperative](./img/bdd/tag.jpg)


Here is maven command that support tags: 

        mvn test -Dcucumber.filter.tags="@student and @create"
        
Maven plugin will run only those scenarios with 2 tags at the same time
