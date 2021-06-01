package com.sparta.karim.start;

import com.sparta.karim.Exceptions.ChildNotFoundException;
import com.sparta.karim.sorters.BubbleSort;
import com.sparta.karim.sorters.MergeSort;
import com.sparta.karim.binaryTree.BinaryTreeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class StarterHarcoded {

    public static final Logger logger = LogManager.getLogger(Main.class);

    public void start(){

        int[] nums = {5, -7, 0, 45, 4, 15, 165, 14, 16};

        System.out.println("\n\n");

        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sortArray(nums)));

        MergeSort merged = new MergeSort();

        int[] mergedArray = merged.sortArray(nums);
        System.out.println(Arrays.toString(mergedArray));

        BinaryTreeClass binaryTree1 = new BinaryTreeClass(12);
        binaryTree1.addElement(14);
        binaryTree1.addElement(8);
        binaryTree1.addElement(8);
        binaryTree1.addElement(42);
        binaryTree1.addElement(6);
        binaryTree1.addElement(7);
        binaryTree1.addElements(new int[]{50, 62, 44, 18, 2});

        System.out.println("Root Element: " + binaryTree1.getRootElement());
        System.out.println("Number of Elements: " + binaryTree1.getNumberOfElements());

        int num = 8;
        System.out.printf("\nDoes it contain %s: %s", num, binaryTree1.findElement(num));
        System.out.println();




        int[] numsBinary = {12, 14, 8, 42, 6, 7, 50, 62, 44, 18, 2, 0, 444};


        for (int number : numsBinary){
            try {
                System.out.printf("\nThe value of the left child of %s: %s", number, binaryTree1.getLeftChild(number));
            } catch (ChildNotFoundException e){
                System.out.printf("\nThe value of the left child of %s: %s", number, e.getMessage());
                logger.error(e.getMessage(), e);
            }
        }

        num = 18;
        System.out.println("\n\nFinding a Particular Node: ");
        System.out.printf("\nDoes a %s node exists: %s", num, binaryTree1.findElement(num));
//        int value = binaryTree1.returnNode(num).getNodeValue();
        System.out.println("\nProof: " + binaryTree1.getNode(num).getNodeValue());
        System.out.println();


        for (int number : numsBinary){
            try {
                System.out.printf("\nThe value of the right child of %s: %s", number, binaryTree1.getRightChild(number));
            } catch (ChildNotFoundException e){
                System.out.printf("\nThe value of the right child of %s: %s", number, e.getMessage());
                logger.error(e.getMessage(), e);
            }
        }

        System.out.println("\n\nTotal Number of Elements: " + binaryTree1.getNumberOfElements());

        int[] outputArray = binaryTree1.getSortedTreeAsc();
        System.out.println("\nHere is the Sorted Array in Ascending order");
        for (int number : outputArray){
            System.out.println(number);
        }


        outputArray = binaryTree1.getSortedTreeDesc();
        System.out.println("\nHere is the Sorted Array in Descending order");
        for (int number : outputArray){
            System.out.println(number);
        }


    }
}
