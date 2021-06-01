package com.sparta.karim.sorters;

import com.sparta.karim.Exceptions.*;
import com.sparta.karim.binaryTree.BinaryTree;
import com.sparta.karim.binaryTree.BinaryTreeClass;

import java.util.Locale;

public class AlgorithmFactory {

    public Sorter getSorter(String sorterType) throws notAValidSorterException{

        Sorter sorter;

            switch(sorterType.toLowerCase()){
                case "bubble": case "bubblesort": case "bs":
                    sorter = new BubbleSort();
                    break;

                case "merge": case "mergesort": case "ms":
                    sorter = new MergeSort();
                    break;

                default:
                    throw new notAValidSorterException("Not a valid Sorting Algorithm.");
            }
        return sorter;
    }

    public BinaryTreeClass getTree() throws NotAValidNumberException {
        String placeholder = "";
        try {
            BinaryTreeClass binaryTree = new BinaryTreeClass(placeholder);
            return binaryTree;
        } catch (Exception e){
            throw new NotAValidNumberException("Not a Valid Number Exception.");
        }
    }
}
