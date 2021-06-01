package com.sparta.karim;

import com.sparta.karim.binaryTree.BinaryTreeClass;
import com.sparta.karim.sorters.BubbleSort;
import com.sparta.karim.sorters.MergeSort;
import com.sparta.karim.sorters.Sorter;
import com.sparta.karim.start.SortAndTime;

import java.util.Random;

public class PerformanceTimeTest {
    public static void main(String[] args){
        Random random = new Random();
        int[] shortArray = new int[30];
        int[] longArray = new int[5000];


        for (int i = 0; i < shortArray.length; i++){
            shortArray[i] = random.nextInt();
            longArray[i] = random.nextInt();
        }
        for (int i = shortArray.length; i < longArray.length; i++){
            longArray[i] = random.nextInt();
        }

        Sorter sorterBubble = new BubbleSort();
        Sorter sorterMerge = new MergeSort();
        BinaryTreeClass binaryTree = new BinaryTreeClass();
        float bubbleShort = SortAndTime.timeTakenToSort(sorterBubble, shortArray);
        float mergeShort = SortAndTime.timeTakenToSort(sorterMerge, shortArray);
        float binaryShort = SortAndTime.timeTakenToSort(binaryTree, shortArray);

        float bubbleLong = SortAndTime.timeTakenToSort(sorterBubble, longArray);
        float mergeLong = SortAndTime.timeTakenToSort(sorterMerge, longArray);
        float binaryLong = SortAndTime.timeTakenToSort(binaryTree, longArray);


        float min = bubbleShort;
        String quickest = "Bubble Sort";
        if (mergeShort < min){
            min = mergeShort;
            quickest = "Merge Sort";
        } if (binaryShort < min){
            min = binaryShort;
            quickest = "Binary Tree Sort";
        }
        System.out.println("\nShort Array:");
        System.out.println("---Bubble sort on a Short Array:     " + bubbleShort + " Milliseconds");
        System.out.println("---Merge sort on a Short Array:      " + mergeShort + " Milliseconds");
        System.out.println("---BinaryTree sort on a Short Array: " + binaryShort + " Milliseconds");
        System.out.printf("\n---Quickest Sort: %s\n------ With a time of: %s Milliseconds\n\n", quickest, min);

        min = bubbleLong;
        quickest = "Bubble Sort";
        if (mergeLong < min){
            min = mergeLong;
            quickest = "Merge Sort";
        } if (binaryLong < min){
            min = binaryLong;
            quickest = "Binary Tree Sort";
        }
        System.out.println("\nLong Array:");
        System.out.println("---Bubble sort on a Long Array:     " + bubbleLong);
        System.out.println("---Merge sort on a Long Array:      " + mergeLong);
        System.out.println("---BinaryTree sort on a Long Array: " + binaryLong);
        System.out.printf("\n---Quickest Sort: %s\n------ With a time of: %s Milliseconds\n", quickest, min);

    }
}
