package com.sparta.karim.sorters;

import java.util.Arrays;

public class BubbleSort implements com.sparta.karim.sorters.Sorter {

    //check if the array is already sorted
    public int[] bubbleSortAscending(int[] nums) {
        int count;
        int temp;
        int endIndex = nums.length - 1;


        do {
            count = 0;
            for (int i = 1; i <= endIndex; i++) {
                if (nums[i] < nums[i - 1]) {
                    temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    count++;
                    if (i == endIndex){
                        endIndex--;
                    }
                }
            }
        } while (count != 0);

        return nums;
    }



    public int[] sortArray(int[] arrayToSort){
        int[] ints = bubbleSortAscending(arrayToSort);
        return ints;
    }

    @Override
    public String getSorterType() {
        return "Bubble Sort";
    }
}
