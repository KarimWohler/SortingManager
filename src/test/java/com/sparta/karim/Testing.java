package com.sparta.karim;


import com.sparta.karim.sorters.BubbleSort;
import com.sparta.karim.sorters.MergeSort;
import com.sparta.karim.binaryTree.BinaryTreeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Testing {


    //Bubble Sort
    BubbleSort bubbleSort = new BubbleSort();

        //---sortArray
        @Test
        @DisplayName("Should return a list of numbers reordered in ascending order using a bubble sort.")
        public void shouldReturnOrderedListInAscendingBubbleSort(){
            Assertions.assertEquals("[2, 14, 17, 18, 22, 27, 35, 88]", Arrays.toString(bubbleSort.sortArray(new int[]{17, 18, 22, 27, 35, 2, 88, 14})));
        }


    //Merge Sort
    MergeSort mergeSort = new MergeSort();

        //---sortArray
        @Test
        @DisplayName("Should return a list of numbers reordered in ascending order using a merge sort.")
        public void shouldReturnOrderedListInAscendingMergeSort(){
            Assertions.assertEquals("[2, 14, 17, 18, 22, 27, 35, 88]", Arrays.toString(mergeSort.sortArray(new int[]{17, 18, 22, 27, 35, 2, 88, 14})));
        }



    //Binary Tree
    BinaryTreeClass binaryTree = new BinaryTreeClass(27);

        //---getRootElement
        @Test
        @DisplayName("Should return the head node, the first node, when the getRootElement() method is run.")
        public void shouldReturnTheHead(){
            Assertions.assertEquals(27, binaryTree.getRootElement());
        }

        //---findElement
        @Test
        @DisplayName("Should return true if the element is found")
        public void shouldReturnTrueIfTheELementExists(){
            Assertions.assertEquals(true, binaryTree.findElement(27));
        }

        //---addElement
        @Test
        @DisplayName("Should return True, if the element is successfully added to the binary tree using the addElement method")
        public void shouldReturnTrueIfElementAddedSuccessfully(){
            binaryTree.addElement(23);
            Assertions.assertEquals(true, binaryTree.findElement(23));
        }

        //---addElements
        @Test
        @DisplayName("Should return True, if all the elements have been successfully added to the bianry tree using the addElements method")
        public void shouldReturnTrueIfAllElementsAddedSuccessfyllu(){
            binaryTree.addElements(new int[]{13, 24, 62});
            Assertions.assertEquals(true, binaryTree.findElement(13) && binaryTree.findElement(24) && binaryTree.findElement(62));

        }

        //---getNumberOfElements
        @Test
        @DisplayName("Should return the number of elements found in the binary tree.")
        public void shouldReturnTheNumberOfElements(){
            binaryTree.addElement(17);
            binaryTree.addElements(new int[]{44, 6, 22, 30, 84});
            Assertions.assertEquals(7, binaryTree.getNumberOfElements());
        }

        //---getLeftChild
        @Test
        @DisplayName("Should return the left child when it exists")
        public void shouldReturnTheLeftChildWhenExists(){
            binaryTree.addElements(new int[]{44, 6, 22, 2, 30, 84});
            try {
                Assertions.assertEquals(2, binaryTree.getLeftChild(6));
            } catch (Exception e) {}
        }

        @Test
        @DisplayName("Should return the left child when it exists")
        public void shouldReturnErrorWhenLeftChildDoesntExists(){
            binaryTree.addElements(new int[]{44, 6, 22, 2, 30, 84});
            try {
                binaryTree.getLeftChild(22);
            } catch (Exception e){
                Assertions.assertEquals("Left Child does not exist.", e.getMessage());
            }
        }

        //---getRightChild
        @Test
        @DisplayName("Should return the right child when it exists")
        public void shouldReturnTheRightChildWhenExists(){
            binaryTree.addElements(new int[]{44, 6, 22, 2, 30, 84});
            try {
                Assertions.assertEquals(22, binaryTree.getRightChild(6));
            } catch (Exception e) {}
        }

        @Test
        @DisplayName("Should return the left child when it exists")
        public void shouldReturnErrorWhenRightChildDoesntExists(){
            binaryTree.addElements(new int[]{44, 6, 22, 2, 30, 84});
            try {
                binaryTree.getRightChild(2);
            } catch (Exception e){
                Assertions.assertEquals("Right Child does not exist.", e.getMessage());
            }
        }

        //---getSortedTreeAsc()
        @Test
        @DisplayName("Should return the binary tree is ascending order.")
        public void shouldReturnTheBinaryTreeInAscendingOrder(){
            binaryTree.addElements(new int[]{44, 6, 22, 2, 30, 84});
            Assertions.assertEquals("[2, 6, 22, 27, 30, 44, 84]", Arrays.toString(binaryTree.getSortedTreeAsc()));
        }

        //---getSortedTreeDesc()
        @Test
        @DisplayName("Should return the binary tree is descending order.")
        public void shouldReturnTheBinaryTreeInDescendingOrder(){
            binaryTree.addElements(new int[]{44, 6, 22, 2, 30, 84});
            Assertions.assertEquals("[84, 44, 30, 27, 22, 6, 2]", Arrays.toString(binaryTree.getSortedTreeDesc()));
        }
}
