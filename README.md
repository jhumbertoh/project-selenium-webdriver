# project-selenium-webdriver

## Running  all test classes
* ```mvn clean test```

## Running a Single Test Class
* ```mvn -Dtest=com.jhurtado.seleniumwebdriver.redmine.RedmineLoginTest test```

## Running Cucumber Test with a subset of scenarios tagged
* ```mvn clean test -Dcucumber.filter.tags="@E2E"```
    
## Cross Browser
Mac OS and Linux
 * ```export browserName=firefox```

Windows
 * ```set browserName=firefox```
 
Running Test
 * ```mvn clean test```
 
## Reporting Cucumber
* ```mvn clean install```