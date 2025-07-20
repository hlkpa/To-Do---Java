# To-Do---Java

This is a To Do Manager

Java 23 
Spring boot: 3.4.2
Spring Security
Gradle

To make it run:

1. from command line:
go to the folder -> gradlew run

2. from IDE:
import as gradle project
run as gradle project

then go:
localhost:8080/ and click register

Currently this setting is up: hibernate.hbm2ddl.auto=create-drop 
this will cancel everything in the db everytime the app runs
for not having it, comment it

Changes to do:

Functionalities:
- costum login
- api documentation
- dividing the css from the main file 
- adding a calendar on the right to give an idea of the week in general
- adding a search function for seeing the list of tasks of the day
- adding filters
- showing the date of the day on the left corner so that people know which day it is
- adding a delete button so that people can cancel the tasks
- adding a cancellation option for the tasks based on the dates or that after a certain period the tasks get deleted
- others

Security:
- adding password checker
- adding jwt token
- role based
