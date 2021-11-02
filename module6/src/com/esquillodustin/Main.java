package com.esquillodustin;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int number [] = {68, 33, 12, 64, 17, 105, -53, 90, 120, 78, 10, 86, 16};


        System.out.println(bunnyHopSearch(number, 68));
        System.out.println(bunnyHopSearch(number, 78));
        System.out.println(bunnyHopSearch(number, -53));
        System.out.println(bunnyHopSearch(number, 1000));
    }

    public static int bunnyHopSearch (int [] input, int value){

        int start = 0;
        int end = input.length - 1;

        while (start <= end){

            //checking at the beginning
            for (int i = 0; i < 3; i ++){

                if (input[start] == value){

                    return start;

                }

                else {

                    start++;

                }


            }

            //checking at the end
            for (int i = 0; i < 3; i++){

                if (input[end] == value){

                    return end;

                }

                else {

                    end--;
                }

            }

        }

        return -1;

    }
}
