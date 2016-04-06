# Bootstrap_Integrated_Translater
hare the webapp is integrated with bootstrap and also Testng

> two basic functionalities occuring in this web app is validating the user entered credentials and translating the entered text in a selected language to the selected language.

#### Prerequisities
- jdk 1.8.07
- MySQL 5.6
- Maven 3.3.3
- Tomcat 8.0.9
- Yandex API Key

> Other than the above mentioned basic funtionalities, there are some integrated features. They are listed below

#### Integrated Features
- BootStrap is integrated to give a rich look to the app
- TestNg is integrated for Unit Testing and thereby to test each of the class
- All the parameters are gathered in system.properties file and read from that file

> below shows the basic file structure of where to insert the above mentioned feature rending packages and files. In addition to that pom.xml file has to be updated adding dependencies as in the project

#### File Structure
- src
  * main
      + java
      - resources
          - system.properties  
      - webapp
          - bootstrap
          - css
          - images
  - test
      - java
    
- pom.xml

#### COnsiderations
- package structure of `main/java` should be identical to that of `test/java`.
- Give a valid name for the test class so as to relate to the perticular class it is testing 
