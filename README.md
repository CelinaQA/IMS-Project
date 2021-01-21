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
  
To run the tests, you will need to have Eclipse workspace installed.  

For Eclipse: https://www.eclipse.org/downloads/

### Installing

To be able to run this project from Git Bash, open Git Bash in an empty folder you want to save the repository in and run the following command:

```
$ git clone https://github.com/CelinaQA/celina-ims.git
```

See Deployment section for additional information on running the IMS from Git Bash.

## Running the tests

To run the tests, open the project on Eclipse workspace.  Right click on the project and select Coverage As -> JUnit Test.

### Unit Tests 
Unit tests are run to ensure that each 'unit' of an application is functioning as they are intended to.  These can be made for individual classes and a test should be made for all the methods and attributes that make up each class.  

Example of a class to be tested:

```
public class ItemServices implements CrudServices<Item>{

	private Dao<Item> itemDao;
	
	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	public List<Item> readAll() {
		return itemDao.readAll();
	}

	public Item create(Item item) {
		return itemDao.create(item);
	}

	public Item update(Item item) {
		return itemDao.update(item);
	}

	public void delete(Long id) {
		itemDao.delete(id);
	}

}
```
Example of tests for the class above:

```
@RunWith(MockitoJUnitRunner.class)
public class ItemServicesTest {
	
	@Mock
	private Dao<Item> itemDao;
	
	@InjectMocks
	private ItemServices itemServices;
	
	@Test
	public void itemServicesCreate() {
		Item item = new Item("bread", 100, 0.99f);
		itemServices.create(item);
		Mockito.verify(itemDao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void itemServicesRead() {
		itemServices.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		Item item = new Item("bread", 100, 0.99f);
		itemServices.update(item);
		Mockito.verify(itemDao, Mockito.times(1)).update(item);
	}
	
	@Test
	public void itemServicesDelete() {
		itemServices.delete(1L);;
		Mockito.verify(itemDao, Mockito.times(1)).delete(1L);
	}

}
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

Before deploying the project, make sure that the GCP instance the IMS connects to is running.  Navigate to the folder containing the Git repository which you cloned in the Installation step using Git Bash.  

To launch the IMS from the command line enter the following command:

```
$ java -jar target/celina-ims-0.0.1-jar-with-dependencies.jar
```
You will then be prompted to enter a username and password before you can access the database.  After this, you can choose to create, read, update or delete customers, items and orders.  At least one customer and item must be present in the database before an order can be created, and before a customer or item can be deleted, the orders in which they are present in must be deleted first.  

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

