# Deutsche
Cucumber JVM Tests using Serenity


I've used the existed framework and extended the same using IntelliJ IDE
I've written @wip scenarios and added a couple of more scenarios, one for UI and one for API automation.

I've used ChromeDriver for UI automation, it should exist in the project root folder e.g. test-developer-interview-stage-1\chromedriver.exe

As I have mentioned in the serenity.properties file

Test #3 was a bit tricky, as website has two different headers, first one contains first item as Jewellery & Accessories and 2nd header contains Clothing and Accessories. So i've created test on the based of header type. 

Tests should run on Windows and Mac, I've tested on both, On Mac i had to upgrade the chrome driver version which exists in the project folder.

User should be able to run the test from command line by running below commands -

$ gradle clean test aggregate

To run scenarios tagged as pageobject on Chrome:

$ gradle clean test aggregate -Dwebdriver.driver=chrome -Dcucumber.options="--tags @pageobject"

Note - I didn't touch the second scenario as i don't know how to write screenplay stuff. I am new to serenity.
I usually use maven and cucumber.

Parallel Exectution - 

I've tried running tests with batch parameters but no luck, seems like it runs on CI tool e.g. Jenkins

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

