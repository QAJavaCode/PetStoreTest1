# `Introduction`

This Pet Store (https://petstore.swagger.io/) testing framework covers most of 
positive and negative scenarios that are crucial for the Petstore server. 
Here we can emulate placing/editing/deletion of orders, pets and user info. The
testing framework has been written in BDD style, so it's human-readable. 
BDD-approach drastically reduces time QA specialists spend to get used to 
the project structure. Framework uses Gherkin language for test cases and Java
for testing REST interactions.
## `Technologies`

As we started talking of technologies that made creation of this framework
possible it would be great to underline key ones:

1. Java 8 (Maven compiler is also set to Java 8 to avoid any unexpected errors
   and incompatibilities);
2. Maven as build automation tool (Maven surefire plugin for auto-reporting and 
   Maven Failsafe plugin to properly manage failed tests);
3. JUnit 4 - powerful framework for unit testing that is smoothly combined 
   with Cucumber (which actually supports the fourth version of JUnit or requires 
   vintage-core dependency in case if JUnit 5 is used), Serenity and Rest Assured;
4. Serenity BDD framework - allows dividing test logic to step classes and
test ones. It is alo a source of reporting for following Pet Store testing framework;
5. Cucumber BDD framework - allows associating test cases with step methods by create 
   so-called step definition classes. Also allows creating .feature files
   which currently act as test cases and short feature descriptions;
6. Rest Assured - powerful BDD-style Groovy framework for testing REST API 
   services.
## `Test Framework Structure`

Following testing software consists of several parts. First and foremost, it's
divided by two big parts: **main/java** and **test/java** ones. First one
contains so-called util classes which serve as technical background.
For example, **MainAPILogic** package contains **BaseClass** (basic request 
functionality), **RequestSpecifications** (extends **BaseClass** and 
provides detailed request specifications) and **Vars** (contains important
global reusable variables, and some util methods) classes.

**test/java** part contains three packages divided by Pet Store functionality 
(OrderTests, PetsInfoTests and UserFunctionality). Each and every package 
contains **Tests** and **Steps** subpackages. **Tests** one contains pure 
JUnit test classes that are running CucumberSerenityRunner.class and 
have specific Cucumber parameters (.feature files and step definition classes
location, etc.) Step subpackages create step definition methods tied to 
.feature test cases. These methods use technical solutions of **main/java**
classes.

**Main/Resources** directory contains **Features** directory and its 
subdirectories (test cases subdirectories are also divided by Pet Store 
functionality). **Main/Resources** folder also includes file folders (for example
pics, text, etc.)
## `How to Run and Support Framework`

Frameworks can be launched with specific trigger containing **mvn clean verify**
procedure. Report results are the artifacts of GitLab CI pipeline.

In order to update framework it's recommended to become familiar with both
**main/java** and **test/java** classes logic. Editing of the first part 
will allow the specialists to tune REST util methods perfectly for their needs.
Meanwhile, updating **test/java** classes and .features files will allow 
test developers to cover more and more user scenarios and to create 
lots of relevant test cases perfectly tied to the codebase. In case if needed,
API tests can be easily integrated with UI ones. Test framework can be updated
to the Java 11 which is also LTS version but Java 8 has been chosen intentionally
to provide framework users with the stability.
##`Pet Store API interactions`

All the Pet Store API functionality can be divided to 4 parts:

1. Pets Info
2. Orders functionality
3. User info and operations.

API interactions and every endpoint as a part of them are properly documented
at https://petstore.swagger.io/ so there's no need to repeat well-structured
information from product creators. But it would be great to add few details.
Every of three sections allows user to perform CRUD operations. For examples, 
clients can create, modify and delete users, pet info or orders. As these
CRUD operations provide key service clients with core functionality they 
should be properly tested. It's v1.0 framework version so of course adding 
more negative tests methods and test cases is and will be appreciated especially 
if Pet Store endpoints amount will be growing.
##`Thanks for attention and have a good day!`