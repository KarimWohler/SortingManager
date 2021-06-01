package com.sparta.karim.start;

import com.sparta.karim.binaryTree.BinaryTreeClass;
import com.sparta.karim.sorters.BubbleSort;
import com.sparta.karim.sorters.Sorter;

public class SortAndTime {

    public static float timeTakenToSort(Sorter sorter, int[] array){
        long startTime = System.nanoTime();
        int[] output = sorter.sortArray(array);
        long endTime = System.nanoTime();
        long timeTaken = (endTime - startTime);

        System.out.printf("\nSorted Array using %s: ", sorter.getSorterType());
        for(int num : output){
            System.out.print(num + " ");
        }

        float timeTakenInMilliSeconds = (float)timeTaken / 1000000;
        System.out.println("\nTime Taken to Sort:             " + (float)timeTaken / 1000000  + " milli-seconds");
        return timeTakenInMilliSeconds;
    }

    public static float timeTakenToSort(BinaryTreeClass binaryTree, int[] array){
        BinaryTreeClass currentBinary = new BinaryTreeClass();
        currentBinary.addElements(array);
        long startTime = System.nanoTime();
        int[] output = currentBinary.getSortedTreeAsc();
        long endTime = System.nanoTime();
        long timeTaken = (endTime - startTime);

        System.out.printf("\nSorted Array using Binary Tree: ");
        for(int num : output){
            System.out.print(num + " ");
        }

        float timeTakenInMilliSeconds = (float)timeTaken / 1000000;
        System.out.println("\nTime Taken to Sort:             " + (float)timeTaken / 1000000  + " milli-seconds");
        return timeTakenInMilliSeconds;
    }

}
