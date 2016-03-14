Loyola University Chicago 

Fall 2014

COMP 313 - Intermediate Object Oriented Development

Project 3 - Pair Project

## Learning Objectives ##

An understanding of

- Requirements analysis
    - functional requirements
    - nonfunctional requirements
- Modeling
    - UML class diagrams
    - UML sequence diagrams
- Design principles and patterns
    - Dependency inversion principle
    - Composite pattern
    - Decorator pattern
    - Visitor pattern
- Java coding
    - final-correctness
    - Override correctness
    - anonymous inner classes
    - basic Android graphics

## Description ##

In this project, you will complete the implementation of the simple API for drawing graphical shapes. The API design is based on the requirements from the group activity.

See also the practice midterm and its attached solutions, on which this project is based: http://laufer.cs.luc.edu/teaching/313/handouts/practice-midterm

See also the [expressions](https://github.com/LoyolaChicagoCode/misc-java/blob/master/src/main/java/expressions/SimpleExpressions.java) and [vexpressions](https://github.com/LoyolaChicagoCode/misc-java/blob/master/src/main/java/vexpressions/VisitorExpressions.java) examples. 

##Functional Requirements##

Start with this code skeleton: https://github.com/LoyolaChicagoCode/shapes-android-java. The functional requirements are embodied in the JUnit tests in the test folder; instructions for running the test are included in the README file. When your code passes all the tests, you will have fulfilled the functional requirements for grading purposes. If some of the tests do not pass, you will receive partial credit. In addition, your app should look exactly like this screenshot: http://t.co/gaYmzRki.

##Nonfunctional Requirements##

Specifically, complete the code in the various Java source files within the src folder. Look in the Android Studio TODO view for sections marked as TODO or FIXME and use the test cases as your guide. Besides other minor tasks, the main implementation tasks are:

- Implementing the Size, BoundingBox, and Draw visitors
- Implementing the missing classes Stroke, Outline, Point, and Polygon
    - The Stroke decorator indicates the foreground color for drawing its shape.
    - The Outline decorator does the opposite of the Fill decorator: it indicates that its shape should be drawn in outline (default) mode.
    - A Point is a location without a shape. You should implement it using a Circle with radius 0 as its shape and override any methods as needed.
    - A (closed) Polygon is a shape defined by a list of points; the last point should be connected to the first. Implement it as a special case of Group.

You must not make any other changes to the code skeleton or the test cases.

## Running the Application##

Android: as usual through Android Studio

## Running the Tests##

Test with JUnit: on the command line, run

        gradle unitTest

(Android Studio integration of this unit tests was not available at time of development.)