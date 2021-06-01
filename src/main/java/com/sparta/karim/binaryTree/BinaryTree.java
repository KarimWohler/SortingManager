package com.sparta.karim.binaryTree;


import com.sparta.karim.Exceptions.ChildNotFoundException;

public interface BinaryTree {

        int getRootElement();

        int getNumberOfElements();

        void addElement(int element);

        void addElements(int[] elements);

        boolean findElement(int value);

        int getLeftChild(int element) throws ChildNotFoundException;

        int getRightChild(int element)throws ChildNotFoundException;

        int[] getSortedTreeAsc();

        int[] getSortedTreeDesc();

}
