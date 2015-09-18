Super Simple Stocks
==============================================================================================

Author: Angelo Verdicchio


What is it?
-----------

This is an implementation of the Super Simple Stocks. For the first release it has been implemented the base functionality.
The next development could provide:
 A detailed implementation  of the unit test (in the source code you can find only an example of implementation), use of the float price, Use of a DB to store the information.


System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.


Build Application
-------------------------
To Build the application you need to execute the following command:

        mvn clean install

If you want to skip the test you need to run the follow command:

        mvn clean install -DskipTests


Run  Application
-------------------------

To run the application you need do execute the follow command:

        mvn exec:java

Note
-------------------------

If you are using non Windows machine for every operation you will be able to see a clean console that help you to distinguish the new operazion/selection from the old one.

Otherwise if you are using a Windows machine then for you will see the follow separator:


       ************************************************************************************************************************************

Unfortunately for Windows there isn't a standard way to clear the console.
