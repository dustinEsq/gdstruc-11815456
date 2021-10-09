package com.esquillodustin;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int game = 0;

        LinkedQueue playerList = new LinkedQueue();

        Random value = new Random();

        Scanner scanner = new Scanner(System.in);

        while (game < 10){

            scanner.nextLine();

            int randNumberOfPlayers = value.nextInt(7) + 1;

            if (playerList.getQueueValue() >= 5){

                playerList.removeElement();
                game++;

                if (playerList.isQueueEmpty()){

                    System.out.println("There are no remaining players in queue");

                }

                else {

                    System.out.println("Remaining players: ");
                    playerList.printQueue();

                }

                System.out.println("Successful matches " + game);

                scanner.nextLine();

                System.out.print("\n");

            }

            else if (playerList.getQueueValue() < 5){

                for (int i = 0; i < randNumberOfPlayers; i++){

                    int randomLevel = value.nextInt(200);
                    playerList.enqueueElement(new Player(playerList.getIdValue(),
                            "Player" + playerList.getIdValue(), randomLevel));


                }

                System.out.println("Queued players: ");
                playerList.printQueue();
                scanner.nextLine();
                System.out.print("\n");

            }

        }

    }
}
