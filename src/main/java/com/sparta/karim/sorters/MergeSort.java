package com.sparta.karim.sorters;

public class MergeSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        if (arrayToSort.length < 2) {
            return arrayToSort;
        }
        int[] leftArray = new int[arrayToSort.length / 2];
        int[] rightArray;

        if (arrayToSort.length % 2 == 0) {
            rightArray = new int[arrayToSort.length / 2];
        } else {
            rightArray = new int[(arrayToSort.length / 2) + 1];
            rightArray[arrayToSort.length / 2] = arrayToSort[arrayToSort.length - 1];
        }

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arrayToSort[i];
            rightArray[i] = arrayToSort[i + leftArray.length];
        }

        int[] answer = new int[arrayToSort.length];

        leftArray = sortArray(leftArray);
        rightArray = sortArray(rightArray);

        answer = mergingArrays(leftArray, rightArray);
        return answer;

    }

    @Override
    public String getSorterType() {
        return "Merge Sort";
    }

    public int[] mergingArrays(int[] leftArray, int[] rightArray) {
        int[] merged = new int[leftArray.length + rightArray.length];

        int ileft = 0;
        int iright = 0;
        int imerged = 0;

        while (ileft < leftArray.length || iright < rightArray.length) {

            if (ileft < leftArray.length && iright < rightArray.length) {
                if (leftArray[ileft] > rightArray[iright]) {
                    merged[imerged] = rightArray[iright];
                    iright++;
                } else {
                    merged[imerged] = leftArray[ileft];
                    ileft++;
                }
            } else if (ileft >= leftArray.length) {
                merged[imerged] = rightArray[iright];
                iright++;
            } else if (iright >= rightArray.length) {
                merged[imerged] = leftArray[ileft];
                ileft++;
            }
            imerged++;
        }
        return merged;
    }

}
