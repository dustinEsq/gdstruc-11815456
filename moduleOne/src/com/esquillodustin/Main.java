package com.esquillodustin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] numbers = new int [10];

        numbers[0] = 35;
        numbers[1] = 69;
        numbers[2] = 1;
        numbers[3] = 10;
        numbers[4] = -50;
        numbers[5] = 320;
        numbers[6] = 63;
        numbers[7] = 58;
        numbers[8] = 26;
        numbers[9] = 13;

        System.out.print("Before Sorting: \n");
        printElements(numbers);

        System.out.print("\n\nAfter Bubble Sort Descending Order:\n ");
        bubbleSortDesc(numbers);
        printElements(numbers);

        System.out.print("\n\nAfter Selection Sort Descending Order:\n ");
        selectionSortDesc(numbers);
        printElements(numbers);

    }

    private static void selectionSortDesc(int[] array){

        for (int lastSortedIndex = array.length - 1; lastSortedIndex > 0; lastSortedIndex--){

            int smallestIndex = 0;

            for (int i = 0; i <= lastSortedIndex; i ++){

                if (array[i] < array[smallestIndex]){

                    smallestIndex = i;
                }
            }

            if (array[smallestIndex] < array[lastSortedIndex]){

                int temp = array[lastSortedIndex];
                array[lastSortedIndex] = array[smallestIndex];
                array[smallestIndex] = temp;

            }

            else{

                continue;
            }


        }

    }

    private static void bubbleSortDesc(int[] array){

        for (int lastSortedIndex = array.length - 1; lastSortedIndex > 0; lastSortedIndex--){

            for (int i = 0; i < lastSortedIndex; i++){

                if (array[i] < array[i + 1]){

                    int temp = array[i];
                    array [i] = array[i + 1];
                    array[i + 1] = temp;

                }

            }

        }
    }

    private static void printElements(int[] array){

        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
