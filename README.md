# Information Security - Project

## Requirements

Create a GUI application that has a simple form, that when submitted will send the data to a Windows Service that will log the retrieved data into Windows Application Logs.

## Overview

In this repository you will find two projects in Java, the first one wil be used a Windows Service that will log the info submitted in the form. The form is in the second project and it consists of a simple form and a client class that sends the data to the service.

## Prerequisites

These projects were developed in Java and the JAR file that is used as a Windows Service is installed using NSSM.

[JAVA](https://www.java.com/download/ie_manual.jsp)  
[IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows)  
[JDK 21](https://www.oracle.com/java/technologies/downloads/)  
[OPENJFX SDK 21](https://gluonhq.com/products/javafx/)  
[NSSM](https://nssm.cc/download)  

## How to run the projects

First generate the JAR files for each of the projects. After that use NSSM to install the service to Windows Services, execute the command below in CMD (as Administrator):

```bash
nssm install NameOfTheService "Link to JDK 21 java.exe" "-jar" "Link to JAR file of the service"
nssm start NameOfTheService
nssm status NameOfTheService (check if the service is running)
```

After generating the JAR file of the project that has the form and the client, execute it with a command like the one below (or any other way)
```bash
java --module-path "Path to javafx sdk lib folder" --add-modules javafx.controls,javafx.fxml -jar "Name of the form application JAR file"
```
After running the form application and the service, submit your data to the form and check Event Viewer in your machine under the Application Logs category where the submitted data wil be logged.

## Contributors

Contributors: Artan Thaqi & Lirim Maloku.  
If you'd like to contribute or improve the project, feel free to raise a pull request. 


