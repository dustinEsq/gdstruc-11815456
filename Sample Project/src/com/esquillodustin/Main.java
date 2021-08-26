package com.esquillodustin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //prints out Hello World
        //System.out.println ("Hello World");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
    }
}
