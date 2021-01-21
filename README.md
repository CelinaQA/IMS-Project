## Coverage: 80.4%  
![Coverage screenshot](https://github.com/CelinaQA/celina-ims/blob/UMLFeature/Coverage.png)

# Inventory Management System (IMS)

This Inventory Management System (IMS) is designed so that an end user can interact with it via a Command-Line Interface (CLI).  A user will be able to store details of customers, items and orders in a database connected to a Google Cloud Platform (GCP) instance, with full CRUD capabilities. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You will need to have Java and Git Bash installed on your computer to run the IMS.  
  
For Java: https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html  
For Git Bash: https://git-scm.com/download/win



### Installing

To be able to run this project from Git Bash, open Git Bash in an empty folder you want to save the repository in and run the following command:

```
$ git clone https://github.com/CelinaQA/celina-ims.git
```

See Deployment section for additional information on running the IMS from Git Bash.

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Before deploying the project, make sure that the GCP instance the IMS connects to is running.  

Next, to execute the fat .jar file enter the command:

```
$ java -jar target/celina-ims-0.0.1-jar-with-dependencies.jar
```
You will then be prompted to enter a username and password before you get access to the database.  After this, you can choose to create, read, update or delete customers, items and orders.  At least one customer and item must be present in the database before an order can be created, and before a customer or item can be deleted, the orders in which they are present in must be deleted first.  

Example output for customers:  
```
Customer ID: 1
First name: first
Surname: person

Customer ID: 2
First name: second
Surname: person
```
Example output for items:  
```
Item ID: 1
Name: bread
Stock: 100
Price: £1.0

Item ID: 2
Name: cookies
Stock: 100
Price: £2.0
```
Example output for orders:  
```
Order ID = 101
Customer ID = 1
Date placed = 2021-01-21
Total price: £5.0

Order ID = 102
Customer ID = 2
Date placed = 2021-01-21
Total price: £10.0
```
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

