package com.sparta.karim.binaryTree;

import com.sparta.karim.Exceptions.ChildNotFoundException;
import com.sparta.karim.Exceptions.NotAValidNumberException;
import com.sparta.karim.Exceptions.NotAValidOptionException;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class binaryTreeToUser extends BinaryTreeClass {

    public static void userAccess(BinaryTreeClass binaryTree) throws Exception {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Available Options: ");
        System.out.println("(add) : Add Element");
        System.out.println("(list)  : Add Multiple Elements");
        System.out.println("(number) : Get Number of Elements");
        System.out.println("(find) : Checks if a particular element is in the binary tree");
        System.out.println("(left) : Print the left child of an element");
        System.out.println("(right) : Print the right child of an element");
        System.out.println("(ascending) : returns the binary tree elements in ascending order");
        System.out.println("(descending) : returns the binary tree elements in descending order");
        System.out.println("\n(exit) : to exit the program\n");

        int continueLoop = 1;
        int element;
        //String userInputString;

        BinaryTreeClass currentBinaryTree = binaryTree;

        while (continueLoop != 0) {
            String userOption = userInput.next().toLowerCase();

            if (userOption.equals("add")) {
                System.out.println("enter the element you would like to add: ");
                String num = userInput.next();
                try {
                    Integer.parseInt(num);
                } catch (Exception e) {
                    throw new NotAValidNumberException("Sorry, only numbers are accepted");
                }
                currentBinaryTree.addElement(Integer.parseInt(num));
                System.out.println("Success");
            } else if (userOption.equals("list") || userOption.equals("addlist")) {
                System.out.println("Add any number of elements seperated by just commas");
                String userString = userInput.next();
                String[] numElements = userString.split(",");
                int[] numbersElements = new int[numElements.length];
                for (int i = 0; i < numbersElements.length; i++) {
                    try {
                        numbersElements[i] = Integer.parseInt(numElements[i]);
                    } catch (Exception e) {
                        throw new NotAValidNumberException("Sorry, only numbers are accepted");
                    }
                    System.out.println("Successfully added: " + numbersElements[i]);
                }
                currentBinaryTree.addElements(numbersElements);
                System.out.println();
            } else if (userOption.equals("number") || userOption.equals("getnumber")) {
                System.out.print("The number of elements in the Binary Tree is: ");
                int num = currentBinaryTree.getNumberOfElements();
                System.out.println(num);
            } else if (userOption.equals("findelement") || userOption.equals("find")) {
                System.out.println("What element would you like to find? ");
                String num = userInput.next();
                try {
                    element = Integer.parseInt(num);
                } catch (Exception e) {
                    throw new NotAValidNumberException("Sorry, only numbers are accepted");
                }
                if (currentBinaryTree.findElement(element)) {
                    System.out.printf("%s does exist in the Binary Tree\n", element);
                } else {
                    System.out.printf("%s does exist in the Binary Tree\n", element);
                }
            } else if ((userOption.equals("leftchild")) || (userOption.equals("left")) || (userOption.equals("getleftchild"))) {
                System.out.println("Enter which element you would like the left child of: ");
                String num = userInput.next();
                try {
                    element = Integer.parseInt(num);
                } catch (Exception e) {
                    throw new NotAValidNumberException("Sorry, only numbers are accepted");
                }
                try {
                    System.out.println("Left Child: " + currentBinaryTree.getLeftChild(element));
                } catch (Exception e) {
                    throw e;
                }
            } else if ((userOption.equals("rightchild")) || (userOption.equals("right")) || (userOption.equals("getrightchild"))) {
                System.out.println("Enter which element you would like the right child of: ");
                String num = userInput.next();
                try {
                    element = Integer.parseInt(num);
                } catch (Exception e) {
                    throw new NotAValidNumberException("Sorry, only numbers are accepted");
                }
                element = userInput.nextInt();
                try {
                    System.out.println("Right Child: " + currentBinaryTree.getRightChild(element));
                } catch (Exception e) {
                    throw e;
                }
            } else if (userOption.equals("ascending")) {
                System.out.println("The Binary Tree in ascending order: ");
                System.out.println(Arrays.toString(currentBinaryTree.getSortedTreeAsc()));
            } else if (userOption.equals("descending")) {
                System.out.println("The Binary Tree in descending order: ");
                System.out.println(Arrays.toString(currentBinaryTree.getSortedTreeDesc()));
            } else if (userOption.equals("exit")) {
                continueLoop = 0;
                System.out.println("Exited Successfully");
            } else {
                System.out.println("Sorry, that wasn't one of the aforementioned options\n");
                throw new NotAValidOptionException("Not a Valid Option Exception\n");
            }
        }
    }
}