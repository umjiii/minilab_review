/*
CSC 205: 14890 / Monday 11AM - 1PM
Minilab: 2
Author: Stephen Arel & 36825961
Description: This program will allow the user to create an array of pseudorandom integers using a specified seed and array size, presenting them with a menu of
options used to manipulate elements of the array or perform operations with them. This includes printing the array, finding its average, finding the largest element,
count how many times the number 3 occurs in the array, how many are half of the first element, how many times numbers consecutively repeat, swapping the first and last
elements of the array, and exiting the program.
*/
import java.util.*;

//Constants

public class Minilab_2
{
    //Constants
    final static int MAX = 8;
    final static int INTtoCount = 3;

    //Variables
    private static long seed;
    private static int size;
    private static int option;
    private static float avgFinal;
    private static float avgCount;
    private static float avgDividend;
    private static boolean quit = false;


    //Objects
    private static Scanner kb = new Scanner(System.in);
    private static Random rand = new Random();

    //Main class
    public static void main(String[] args) {
        //Ask the user to enter a seed and enter seed using Random object
        System.out.println("Please enter a seed:");
        seed = kb.nextLong();
        rand.setSeed(seed);

        //Ask the user to specify array size (positive int), create array to size
        System.out.println("Please enter the size of the array:");
        size = kb.nextInt();
        while (size <= 1)
        {
            System.out.println("Array size must be greater than 1. Please reenter:");
            size = kb.nextInt();
        }
        int[] randArray = new int[size];

        //Implementing random integers into the array as elements
        for (int i = 0; i < randArray.length; i++)
        {
            randArray[i] = rand.nextInt((MAX - 1 + 1) + 1);
        }

        //Select an option with array
        System.out.println("Please choose an option:");
        System.out.println("""
                \t1\tPrint the array\s
                \t2\tFind the average\s
                \t3\tFind the largest element\s
                \t4\tCount how many times 3 occured
                \t5\tCount how many elements are less than half of the first element
                \t6\tFind how many times numbers repeat consecutively\s
                \t7\tSwap the first and last elements\s
                \t8\tExit""");
        option = kb.nextInt();

        //switch using while loop to repeat option selection
        while (!quit) {
            switch (option) { //Each case number corresponds to the option number. Each case will prompt the user to select an option until exit is selected.

               //Print each array element
                case 1:
                    System.out.print("Array: " + randArray[0]);
                    for (int i = 1; i < randArray.length; i++)
                    {

                        System.out.print("  " + randArray[i]);
                    }

                    //Menu repeated after each operation
                    System.out.println("\nPlease choose an option:");
                    System.out.println("""
                     \t1\tPrint the array\s
                      \t2\tFind the average\s
                    \t3\tFind the largest element\s
                    \t4\tCount how many times 3 occured
                    \t5\tCount how many elements are less than half of the first element
                     \t6\tFind how many times numbers repeat consecutively\s
                     \t7\tSwap the first and last elements\s
                     \t8\tExit""");
                    option = kb.nextInt();
                    break;

                    //Find average
                case 2:
                    for (int i = 0; i < randArray.length; i++) {
                        avgCount++;
                        avgDividend += randArray[i];
                    }
                    avgFinal = avgDividend / avgCount;
                    System.out.println("Average: " + avgFinal);

                    System.out.println("\nPlease choose an option:");
                    System.out.println("""
                     \t1\tPrint the array\s
                      \t2\tFind the average\s
                    \t3\tFind the largest element\s
                    \t4\tCount how many times 3 occured
                    \t5\tCount how many elements are less than half of the first element
                     \t6\tFind how many times numbers repeat consecutively\s
                     \t7\tSwap the first and last elements\s
                     \t8\tExit""");
                    option = kb.nextInt();
                    break;

                    //Find the largest number in the array
                case 3:
                    int largest = randArray[0];
                    for (int i = 0; i < randArray.length; i++) {
                        if (randArray[i] > largest) largest = randArray[i];
                    }
                    System.out.println("Largest: " + largest);

                    System.out.println("\nPlease choose an option:");
                    System.out.println("""
                     \t1\tPrint the array\s
                      \t2\tFind the average\s
                    \t3\tFind the largest element\s
                    \t4\tCount how many times 3 occured
                    \t5\tCount how many elements are less than half of the first element
                     \t6\tFind how many times numbers repeat consecutively\s
                     \t7\tSwap the first and last elements\s
                     \t8\tExit""");
                    option = kb.nextInt();
                    break;

                    //Count how many times 3 occured
                case 4:
                    int constantIntCount = 0;
                    for (int i = 0; i < randArray.length; i++) {
                        if (randArray[i] == INTtoCount) constantIntCount++;
                    }
                    System.out.println("3Count: " + constantIntCount);

                    System.out.println("\nPlease choose an option:");
                    System.out.println("""
                     \t1\tPrint the array\s
                      \t2\tFind the average\s
                    \t3\tFind the largest element\s
                    \t4\tCount how many times 3 occured
                    \t5\tCount how many elements are less than half of the first element
                     \t6\tFind how many times numbers repeat consecutively\s
                     \t7\tSwap the first and last elements\s
                     \t8\tExit""");
                    option = kb.nextInt();
                    break;

                    //Count how many elements are less than half of the first element
                case 5:
                    double firstElementHalf = randArray[0] * 0.5;
                    int halfCount = 0;
                    for (int i = 1; i < randArray.length; i++) {
                        if (randArray[i] < firstElementHalf) halfCount++;
                    }
                    System.out.println("Less than half of first: " + halfCount);

                    System.out.println("\nPlease choose an option:");
                    System.out.println("""
                     \t1\tPrint the array\s
                      \t2\tFind the average\s
                    \t3\tFind the largest element\s
                    \t4\tCount how many times 3 occured
                    \t5\tCount how many elements are less than half of the first element
                     \t6\tFind how many times numbers repeat consecutively\s
                     \t7\tSwap the first and last elements\s
                     \t8\tExit""");
                    option = kb.nextInt();
                    break;

                    //Count how many numbers repeat consecutively
                case 6:
                    int repeatsCount = 0;
                    for (int i = 0; i < (randArray.length - 1); i++) {
                        if (randArray[i] == randArray[i + 1]) repeatsCount++;
                    }
                    System.out.println("Repeats: " + repeatsCount);

                    System.out.println("\nPlease choose an option:");
                    System.out.println("""
                     \t1\tPrint the array\s
                      \t2\tFind the average\s
                    \t3\tFind the largest element\s
                    \t4\tCount how many times 3 occured
                    \t5\tCount how many elements are less than half of the first element
                     \t6\tFind how many times numbers repeat consecutively\s
                     \t7\tSwap the first and last elements\s
                     \t8\tExit""");
                    option = kb.nextInt();
                    break;

                    //Swap the first and the last elements
                case 7:
                    int first = randArray[0];
                    int last = randArray[size - 1];
                    randArray[0] = last;
                    randArray[size - 1] = first;

                    System.out.println("\nPlease choose an option:");
                    System.out.println("""
                     \t1\tPrint the array\s
                      \t2\tFind the average\s
                    \t3\tFind the largest element\s
                    \t4\tCount how many times 3 occured
                    \t5\tCount how many elements are less than half of the first element
                     \t6\tFind how many times numbers repeat consecutively\s
                     \t7\tSwap the first and last elements\s
                     \t8\tExit""");
                    option = kb.nextInt();
                    break;

                    //Shutdown the process/program
                case 8:
                    System.exit(0);
            }
        }
    }



}
