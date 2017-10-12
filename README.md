The tasks given:
 
1. To implement the remaining two scenarios tagged as @wip in the search.feature file. The first two scenarios have been implemented to serve as examples of implementing the tests via Page Object and Screenplay patterns. Candidates may use either pattern and modify the framework as they see fit.

 
2. To write and implement a few more BDD scenarios for UI and API tests to demonstrate candidates understanding of what scenarios are best for UI and what scenarios are best for API tests. Tips: Refer to Reference #2 for API tests.
3. Good to have but not required: How to run the tests in parallel, with batch strategy, etc.
4. Any other improvements / suggestions. 

Tasks Performed - 

Cucumber JVM Tests using Serenity

I've used the existed framework and extended the same using IntelliJ IDE I've written @wip scenarios and added a couple of more scenarios, one for UI and one for API automation. However i've been using jvm cucumber maven framework, i didn't get chance to explore serenity before. 

I've used ChromeDriver for UI automation, it should exist in the project root folder e.g. test-developer-interview-stage-1\chromedriver.exe.

Test #3 was a bit tricky, as website has two different headers, first one contains first item as Jewellery & Accessories and 2nd header contains Clothing and Accessories. So i've created test on the based of header type.

Tests should run on Windows and Mac, I've tested on both, On Mac i had to upgrade the chrome driver version which exists in the project folder.


Execution - 

User should be able to run the test from command line by running below commands -

$ gradle clean test aggregate

To run scenarios tagged as pageobject on Chrome:

$ gradle clean test aggregate -Dwebdriver.driver=chrome -Dcucumber.options="--tags @pageobject"

Note - I didn't touch the second scenario as i don't know how to write screenplay stuff. I am new to serenity. I usually use maven and cucumber.

Reporting - 
View the report at target/site/serenity/index.html, however it shows 0 tests executed most of the time.

Parallel Exectution -

I've tried running tests with batch parameters but no luck, seems like it runs on CI tool e.g. Jenkins
i tried providing parameters Serenity.batch.count, Serenity.batch.size, Serenity.batch.number in the command line.

I've setup my automation tests in maven to run parallel, they run fine using these 2 plugins -

   <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.20</version>
            <configuration>
                <includes>
                    <include>**/*IT.class</include>
                </includes>
                <reuseForks>false</reuseForks>
                <forkCount>4</forkCount>
                <parallel>classes</parallel>
                <threadCount>1</threadCount>
            </configuration>
    </plugin>



<plugin>
  <groupId>com.github.temyers</groupId>
  <artifactId>cucumber-jvm-parallel-plugin</artifactId>
  <version>4.2.0</version>
  <executions>
    <execution>
      <id>generateRunners</id>
      <phase>generate-test-sources</phase>
      <goals>
        <goal>generateRunners</goal>
      </goals>
      <configuration>
        <!-- List of package names to scan for glue code. -->
        <glue>
          <package>com.bharti.software</package>
        </glue>
        <format>html</format>
      </configuration>
    </execution>
  </executions>
</plugin>
