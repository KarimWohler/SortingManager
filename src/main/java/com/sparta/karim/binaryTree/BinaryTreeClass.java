package com.sparta.karim.binaryTree;

import com.sparta.karim.Exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreeClass implements BinaryTree  {
    public NestedNode headNode;
    private int numOfElements = 1;
    private static int counting = 0;
    private NestedNode answerNode = new NestedNode();
    private List<Integer> sortedTree = new ArrayList<>();

    public BinaryTreeClass(){
        numOfElements--;
    }

    public BinaryTreeClass(String placeholder){
        Scanner inputHead = new Scanner(System.in);

        System.out.println("Enter the Head of the Binary Tree: ");
        int head = inputHead.nextInt();
        this.headNode = new NestedNode(head);
    }

    public BinaryTreeClass(int headNode){
        this.headNode = new NestedNode(headNode);
    }

    @Override
    public int getRootElement() {
        return headNode.nodeValue;
    }

    @Override
    public int getNumberOfElements() {
        return numOfElements;
    }

    @Override
    public void addElement(int value){

        if (headNode == null){
            headNode = new NestedNode(value);
            numOfElements++;
            return;
        }

        NestedNode currentNode = headNode;

        int inserted = 0;
        do {
            if (value > currentNode.nodeValue){
                if(currentNode.rightNext != null){
                    currentNode = currentNode.rightNext;
                } else {
                    currentNode.rightNext = new NestedNode(value);
                    numOfElements++;
                    inserted++;
                }
            } else if (value < currentNode.nodeValue){
                if(currentNode.leftNext != null){
                    currentNode = currentNode.leftNext;
                } else {
                    currentNode.leftNext = new NestedNode(value);
                    numOfElements++;
                    inserted++;
                }
            } else {
                inserted++;
            }
        } while (inserted == 0);
    }

    @Override
    public void addElements(int[] elements) {
        for(int element : elements){
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        counting = 0;
        return (findElementRecursive(headNode, value) != 0);
    }


    public int findElementRecursive(NestedNode node, int value){

        if(node.nodeValue == value){
            counting++;
            return counting;
        } else {
            if (node.rightNext != null){
                counting += findElementRecursive(node.rightNext, value);
            }
            if (node.leftNext != null){
                counting += findElementRecursive(node.leftNext, value);
            }
        }
        return counting;
    }


    public NestedNode getNode(int element) {
        getNodeRecursive(headNode, element);
        return answerNode;
    }


    public void getNodeRecursive(NestedNode node, int element){

        if (node == null) {
        } else if (node.nodeValue == element){
            answerNode = node;
        } else {
                if (node.rightNext != null){
                    getNodeRecursive(node.rightNext, element);
                }
                if (node.leftNext != null){
                    getNodeRecursive(node.leftNext, element);
                }
        }
    }

    public NestedNode getParentNode(int element) {
        getNodeRecursive(headNode, element);
        return answerNode;
    }

    public void returnNodeParentRecursive(NestedNode node, int element){

        if((node == null) || (node == headNode)){

        } else if ((node.leftNext.nodeValue == element) || (node.rightNext.nodeValue == element)){
            answerNode = node;
        } else {
            if (node.rightNext != null){
                getNodeRecursive(node.rightNext, element);
            }
            if (node.leftNext != null){
                getNodeRecursive(node.leftNext, element);
            }
        }
    }



    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        if (!findElement(element)){
            throw new ChildNotFoundException("Element does not exist.");
        } else if (getNode(element).leftNext == null){
            throw new ChildNotFoundException("Left Child does not exist.");
        } else {
            return getNode(element).leftNext.nodeValue;
        }
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        if (!findElement(element)) {
            throw new ChildNotFoundException("Element does not exist.");
        } else if (getNode(element).rightNext == null){
            throw new ChildNotFoundException("Right Child does not exist.");
        } else {
            return getNode(element).rightNext.nodeValue;
        }
    }

    @Override
    public int[] getSortedTreeAsc(){

        getSortedTreeAscRecursive(headNode);

        int[] answerArray = new int[getNumberOfElements()];
        for(int i = 0; i < sortedTree.size(); i++){
            answerArray[i] = sortedTree.get(i);
        }
        return answerArray;
    }


    public void getSortedTreeAscRecursive(NestedNode node){

        if (node.leftNext != null){
            getSortedTreeAscRecursive(node.leftNext);
        }
        sortedTree.add(node.nodeValue);
        if (node.rightNext != null){
            getSortedTreeAscRecursive(node.rightNext);
        }
    }


    @Override
    public int[] getSortedTreeDesc() {
        sortedTree = new ArrayList<>();
        getSortedTreeDescRecursive(headNode);

        int[] answerArray = new int[getNumberOfElements()];
        for(int i = 0; i < sortedTree.size(); i++){
            answerArray[i] = sortedTree.get(i);
        }
        return answerArray;
    }

    public void getSortedTreeDescRecursive(NestedNode node){

        if (node.rightNext != null){
            getSortedTreeDescRecursive(node.rightNext);
        }
        sortedTree.add(node.nodeValue);
        if (node.leftNext != null){
            getSortedTreeDescRecursive(node.leftNext);
        }
    }

    public static class NestedNode {
        NestedNode rightNext;
        NestedNode leftNext;
        int nodeValue;

        public NestedNode(int nodeValue){
            this.nodeValue = nodeValue;
        }

        public NestedNode(){}

        public int getNodeValue(){
            return nodeValue;
        }
    }
}

