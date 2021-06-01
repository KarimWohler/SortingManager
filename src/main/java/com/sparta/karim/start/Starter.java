package com.sparta.karim.start;

import com.sparta.karim.binaryTree.BinaryTreeClass;
import com.sparta.karim.sorters.AlgorithmFactory;
import com.sparta.karim.sorters.Sorter;
import static com.sparta.karim.binaryTree.binaryTreeToUser.userAccess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class Starter {

    public static final Logger logger = LogManager.getLogger(Main.class);

    public void start(){
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter What type of algorithm you would like to work with: ");
        System.out.println("Bubble Sort (bubble), Merge Sort (merge) or Binary Tree (binary)");
        String algorithmType = userInput.next();
        BinaryTreeClass binaryTree;
        Sorter sorter = null;



        switch(algorithmType.toLowerCase()){
            case "bt": case "binary": case "binarytree":
                try {
                    binaryTree = algorithmFactory.getTree();
                    userAccess(binaryTree);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    logger.error(e.getMessage(), e);
                }
                break;

            default:
                try{
                    sorter = algorithmFactory.getSorter(algorithmType);
                } catch(Exception e){
                    System.out.println(e.getMessage());
                    logger.error(e.getMessage(), e);
                    break;
                }


                System.out.println("Please enter as many numbers as you would like, pressing 'Enter' after each number.\n\nSimply write 'end' or 'x' to start the sort.\n\nOr simply write 'random' to create a random array");
                List<Integer> array = new ArrayList<>();
                String start = userInput.next().toLowerCase();
                if (start.equals("random")) {
                    System.out.println("How many random elements would you like to sort?");
                    start = userInput.next().toLowerCase();
                    int numOfElements  = 0;
                    try {
                        numOfElements = Integer.parseInt(start);
                    } catch (Exception e) {
                        System.out.println("Sorry, you did not enter a number.");
                        System.out.println(e.getMessage());
                        logger.error(e.getMessage(), e);
                    }
                    Random random = new Random();
                    if(numOfElements < 1){
                        System.out.println("Sorry, there must be 1 or more elements in order to sort");
                        logger.error("must be 1 or more elements to sort", "InsufficientNumberOfElementsException");
                    } else {
                        for (int i = 0; i < numOfElements; i++) {
                            array.add(random.nextInt());
                        }
                    }
                } else {
                    while (!((start.equals("end") || start.equals("x")))) {
                        try {
                            array.add(Integer.parseInt(start));
                        } catch (Exception e) {
                            System.out.println("Sorry, you did not enter a number.");
                            System.out.println(e.getMessage());
                            logger.error(e.getMessage(), e);
                        }
                        start = userInput.next();
                    }
                }
                int[] input = new int[array.size()];

                for (int i = 0; i < input.length; i++){
                    input[i] = array.get(i);
                }

                System.out.print("\nOriginal Array:                 ");
                for(int num : array){
                    System.out.print(num + " ");
                }

                SortAndTime.timeTakenToSort(sorter, input);

        }



    }
}
