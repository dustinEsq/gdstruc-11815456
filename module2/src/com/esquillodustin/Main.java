package com.esquillodustin;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player (2, "LethalBacon", 205);
        Player hpDeskjet = new Player (3, "HPDeskjet", 34);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        System.out.print("\n");

        //filling up the linked list and printing it one by one
        System.out.println("Adding Elements to Linked List: ");
        playerLinkedList.addToFront(asuna);
        playerLinkedList.printList();

        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.printList();

        playerLinkedList.addToFront(hpDeskjet);
        playerLinkedList.printList();

        System.out.print("\n");

        //printing the linked list
        System.out.println("Linked list before removing an element: ");
        playerLinkedList.printList();

        System.out.print("\n");

        //removing the first element and printing the list
        System.out.println("Remvoing the First Element: ");
        playerLinkedList.removeFirstElement();
        playerLinkedList.printList();

        System.out.print("\n");

        //finding the index of an element
        System.out.println("Using the indexOf to HPDeskJet");
        int indexOfOne = playerLinkedList.indexOfElement(hpDeskjet);
        System.out.println("IndexOf: " + indexOfOne);

        System.out.println("Using the indexOf to LethalBacon ");
        int indexOfTwo = playerLinkedList.indexOfElement(lethalBacon);
        System.out.println("IndexOf: " + indexOfTwo);

        System.out.print("\n");

        //finding if the linked list contains a certain element
        System.out.println("Using the contains to HPDeskjet ");
        boolean containOne = playerLinkedList.containElement(hpDeskjet);
        System.out.println("Result: " + containOne);

        System.out.println("Using the contains to Asuna ");
        boolean containTwo = playerLinkedList.containElement(asuna);
        System.out.println("Result: " + containTwo + "\n");

    }

}

