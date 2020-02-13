# Inventory Management System

This repository contains my week five project which contains elements of all the work done to this point as a trainee at QA. The project is a java implemented Inventory management system that provides command line interface control to a MySQL database. This enables the user to Create, Read, Update and Delete (CRUD) Customer, Items and Orders in the  


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Listed below are is the software that is needed to run the software

```
Java 1.8 +
maven
MySQL server
```

### Installing

A step by step series of examples that tell you how to get a development env running


Java install.

Java version 8 is required as a minimum to build and run this project 
* [Java](https://www.java.com/en/download)
Once java has been installed you'll need to ensure to add JAVA_HOME to your system varibles and 

```
%JAVA_HOME%/bin;
```
Is added to the System PATH. 

Maven install.

The lastest Maven should downloaded and instaled from.
* [Maven](https://maven.apache.org/)
M2_HOME which points at the install location of maven needs to be added into the system varibles
then insure that
```
%M2_HOME%/bin;
```
Is added to the system PATH.

Then is required to install the IMS on your computer run.

```
mvn install 
```
This will install a jar file of the IMS into the .M2 file on your computerwhere it can be used from the command line.



End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

This repo includes Unit and intergration tests. This can be run using maven, see below on maven usage to run the desired tests.

Unit tests do not test when the method call's another method, when this is required intergration testing is used. intergration testing using a pulgin called mockito can 'Stub' connections to other methods and mock what they should return allowing for full fuctionallity testing with known values over multiple methods. 

### Unit Tests 

Unit tests are performed on methods that do not need to call another function, this is so that each method can be tested inderpendatly with out possible issues being passed from another method.

In the command line navagate to the root of the project folder and run the following command, this will run all the unit tests in the project. Once run jococo would have produced test and stored them in the project folder. These reports with can be used to confirm that the set up is correct, it can be assumed to be working if all tests pass for unit functionallity.

```
mvm test
```

### Integration Tests 

Unit tests do not test when the method call's another method, when this is required intergration testing is used. intergration testing using a pulgin called mockito can 'Stub' connections to other methods and mock what they should return allowing for full fuctionallity testing with known values over multiple methods. 

In the command line navagate to the root of the project folder and run the following command, this will run all the Intergration tests in the project. Once run jococo would have produced test and stored them in the project folder. These reports with can be used to confirm that the set up is correct, it can be assumed to be working if all tests pass for intergration functionallity.


```
mvn interation-test
```

### Coding style tests

Explain what these tests test and why

Coding Style tests are used to ensure that the code produced is following best practices and not leaving the application open to known vunribilities. 
For this project a peice of software called sonarQube was used, once maven has been used to build the project succsesfully the the code can be checked by sonarQube.
In it's default set up it will check for 
* Coverage on New Code
* Duplicated Lines on New Code
* Maintainability Rating on New Code
* Reliability Rating on New Code
* Security Rating on New Code

Once analised it can provide feedback on the code and offer hints on how to correct it to compliant code.

See below for an example code smell.


```
Noncompliant Code Example
boolean foo(Object param) {
  if (expression) { // Noncompliant
    bar(param, true, "qix");
  } else {
    bar(param, false, "qix");
  }

  if (expression) {  // Noncompliant
    return true;
  } else {
    return false;
  }
}
Compliant Solution
boolean foo(Object param) {
  bar(param, expression, "qix");

  return expression;
}
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Tyler Eddy** - *Initial work* - [tylerjohneddy](https://github.com/tylerjohneddy)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

