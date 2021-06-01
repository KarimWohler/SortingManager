
Sorting Manager

- This Sorting Manager project is a user friendly project that allows for the manipulation and sorting of data within a Bubble Sort, a Merge Sort and/or a Binary Tree sort. 

The user is given the following options:

-Bubble Sort
-|- Sort Array - which returns the sorted array as well as the time taken in milliseconds to perform such an action
-|-|- an array can be entered manually, one after the other, pressing enter after each element. Or generated randomly, by entering 'random' and defining the number of elements you wish to sort.

- Merge Sort
-|- Sort Array - which returns the sorted array as well as the time taken in milliseconds to perform such an action
-|-|- an array can be entered manually, one after the other, pressing enter after each element. Or generated randomly, by entering 'random' and defining the number of elements you wish to sort.

- Binary Tree
-|- (Add) : Add Element to the Binary Tree
-|- (List) : Adds a list of elements to the Binary Tree
-|- (Number) : returns the number of elements (including the head element) in the binary tree to the user
-|- (Find) : searches the binary tree to find a particular element
-|- (Left) : returns the left child of a particular element.
-|- (Right) : returns the right child of a particular element
-|- (Ascending) : returns each element of the binary tree sorted in ascending order
-|- (Descending) : returns each element of the binary tree sorted in descending order


Various Tools used:
- Maven 
- junit
- Logging
- Exception Handling
- Abiding by OOP & SOLID
- Scanner
- Design Patterns
- Unit Testing 
- Performance Testing
- Recursion & Iteration
- switch case
- if statemenets
- nested for & if statements
- Randomly Generated Arrays


Testing:
- This project utilizes the TDD method of coding. Which means that the testing was started before the coding of the project.
- This project includes 2 types of testing:
-|- The first being your standard method testing utilizing JUnit
-|- The next being a timed test. Which tests the speed of each sorting algorithm with regards to time. for both small arrays and large arrays of randomly generated numbers. it is found that for small arrays, Bubble sort is mostly the fastest. However, for large arrays, Merge sort is mostly the fastest with Binary Tree being very close. 

Exceptions:
- There are a number of created exceptions specifically for this project. Which are:
-|- ChildNotFoundException : For when a left or right child does not exists for the binary tree
-|- NotAValidNumberException : This project utilizes allot of user input as the data. This exception is thrown when a non-numerical value is entered for inputs that are strictly meant to be numerical
-|- NotAValidOptionException : This exception is specifically for the Binary Tree, which allows for a number of options (see above) to be chosen. If the user instead enters an option that is not found in the list, then this exception is thrown.
-|- NotAValidSorterException : This exception is thrown when a sorter other than Bubble Sort, Merge Sort or Binary Tree sort is entered. 


