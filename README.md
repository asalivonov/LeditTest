# LeditTest
This is Demo application built on JAVA SE platform developed to ilustrate ability to create simple CLI text editor
 
Usage:
java -jar .\build\libs\leditor.jar c:\temp\myfile.txt
 
Commands:
list - list each line in n:xxx format, e.g.
1: first line
2: second line
3: last line
del n - delete line at n
ins n - insert a line at n
save - saves to disk
quit - quits the editor and returns to the command line

## Installation:
1. Latest JDK - [link to installation guide](https://docs.oracle.com/en/java/javase/16/install/overview-jdk-installation.html)
2. Gradle - [link to installation guide](https://docs.gradle.org/current/userguide/installation.html)

## Building:
Enter the project directory with *build.gradle* file in root and execute gradle command in console: 

*gradle build* 

You should see .\build\libs\leditor.jar file in project folder.

## Run the application:
Execute following command from the the project directory in console:

*java -jar .\build\libs\leditor.jar \<test file in UTF8 format\>*

