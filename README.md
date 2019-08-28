# Toy Robot Application

## Application Requirements

- This application is built in Java 8 

- Dependencies are managed by Maven

- JUnit and Mockito testing frameworks have been used

- IDE used : Idea IntelliJ


## Steps to run the application

- Clone the project from the repository (https://github.com/mayuresh-sawant/toy-robot-challenge.git)
- Import the project as 'Existing Maven Projects'
- Configure project buildpath for JDK if necessary
- Add maven goals 'clean compile test exec:java'
- Check console when all the goals are completed successfully

Alternatively, download maven from https://maven.apache.org/download.cgi and use below commands:

- Clean: mvn clean
- Compile: mvn compile
- Test: mvn test
-Run: mvn exec:java


## Test Data:
    
a)

	PLACE 0,0,NORTH
    MOVE
    REPORT

	Output: 0,1,NORTH

b)

	PLACE 0,0,NORTH
	LEFT
	REPORT
	
	Output: 0,0,WEST

c)

	PLACE 1,2,EAST
	MOVE
	MOVE
	LEFT
	MOVE
	REPORT

	Output: 3,3,NORTH


