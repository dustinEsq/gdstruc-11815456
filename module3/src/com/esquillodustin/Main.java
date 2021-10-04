package com.esquillodustin;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        CardStack deckOfCards = createDeck();

        Scanner scanner = new Scanner(System.in);

        int round = 1;

        while (!deckOfCards.isPlayerDeckStackEmpty()){

            playRound(round, deckOfCards);
            scanner.nextLine();

            //to check what is the top element
            System.out.println("Player Deck Peek - " + deckOfCards.peekPlayerDeckStack());
            System.out.println("Current Hand Peek - " + deckOfCards.peekCurrentPlayerCards());
            System.out.println("Discarded Pile Peek - " + deckOfCards.peekDiscardedPileStack());
            System.out.print("\n");

            round++;

        }

        if (deckOfCards.isPlayerDeckStackEmpty()){

            System.out.println("\nThere are no remaining cards available on the Player Deck");

        }


    }

    private static void playRound (int round, CardStack deck){

        //for randomization of the commands
        Random value = new Random();
        int randCommand = value.nextInt(3) + 1;

        //for player input and nextLine
        Scanner scanner = new Scanner(System.in);

        System.out.println("Round: " + round);

        if (randCommand == 1){ // 1 is equal to draw command

            System.out.println("The selected command is Draw! ");


            //for randomization of how many cards will be drawn
            int randDraw = value.nextInt(5) + 1;

            //check if the playerDeck has sufficient cards to be drawn
            boolean check = checkPlayerDeckDraw(deck);

            if (check == true){

                //if the random value surpasses the number of cards in the player's deck
                //and the player's deck has at least one card
                if (randDraw > deck.getPlayerDeckCards() && deck.getPlayerDeckCards() >= 1){

                    randDraw = deck.getPlayerDeckCards();
                    System.out.println("The player draws: " + randDraw + " cards!");
                    scanner.nextLine();
                    deck.playerDraw(randDraw);

                }

                else {

                    System.out.println("The player draws: " + randDraw + " cards!");
                    scanner.nextLine();
                    deck.playerDraw(randDraw);

                }

                scanner.nextLine();
                System.out.println("Printing the current cards on hold");
                deck.printCurrentPlayerCards();
                scanner.nextLine();

                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + deck.getDiscardedPileCards());


            }

            else if (check == false){

                System.out.println("The selected command is Draw! ");
                System.out.println("Player Deck does not have sufficient cards to be drawn ");

                System.out.println("Printing the current cards on hold");
                deck.printCurrentPlayerCards();
                scanner.nextLine();

                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + deck.getDiscardedPileCards());

            }

        }

        else if (randCommand == 2){ // 2 is equal to discard Command

            //if the current cards on hand is empty
            if (deck.getPlayerCurrentCards() == 0){

                System.out.println("The selected command is Discard! ");
                scanner.nextLine();

                System.out.println("The player does not have any remaining cards on his/her hand ");
                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + deck.getDiscardedPileCards());

                scanner.nextLine();
            }


            //if there are cards on hand
            else if (deck.getPlayerCurrentCards() > 0){

                System.out.println("The selected command is Discard! ");
                scanner.nextLine();
                int input = playerInputForDiscard(deck);
                deck.playerDiscard(input);
                scanner.nextLine();

                System.out.println("Printing the current cards on hold");
                deck.printCurrentPlayerCards();
                scanner.nextLine();

                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + deck.getDiscardedPileCards());

            }

        }

        else if (randCommand == 3){ // 3 is equal to get from discarded pile command

            //If there are no cards available
            if (deck.getDiscardedPileCards() == 0){
                System.out.println("The selected command is Get! ");
                scanner.nextLine();

                if (deck.getPlayerCurrentCards() > 0){

                    System.out.println("Printing the current cards on hold");
                    deck.printCurrentPlayerCards();
                    scanner.nextLine();

                }

                else {

                    System.out.println("The player does not have any remaining cards on his/her hand ");
                    scanner.nextLine();

                }

                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println("The player does not have any remaining cards on his/her discarded pile ");

            }

            //If there are cards available
            else if (deck.getDiscardedPileCards() > 0){

                System.out.println("The selected command is Get! ");
                int input = playerInputForGet(deck);
                deck.playerGetFromDiscarded(input);
                scanner.nextLine();

                System.out.println("Printing the current cards on hold");
                deck.printCurrentPlayerCards();

                scanner.nextLine();
                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + deck.getDiscardedPileCards());

            }


        }


    }

    private static int playerInputForGet(CardStack deck){

        int value;

        //for player input
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many cards do you want to get from the discarded pile?");

        do {

            value = scanner.nextInt();

            if (deck.getDiscardedPileCards() >= value){

                break;

            }

            //if the player has at least one card on discarded pile
            //but the player typed a value that is greater than the number of cards
            //that are available in discarded pile
            else if (deck.getDiscardedPileCards() > 0 && deck.getDiscardedPileCards() < value) {

                continue;

            }


        }while(deck.getDiscardedPileCards() > 0);

        return value;


    }

    private static int playerInputForDiscard(CardStack deck){

        int value;

        //for player input
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many cards do you want to discard?");

        do {

            value = scanner.nextInt();

            if (deck.getPlayerCurrentCards() >= value){

                break;

            }

            //if the player has at least one card on hold
            //but the player typed a value that is greater than the number of cards
            //he/she currently holds
            else if (deck.getPlayerCurrentCards() > 0 && deck.getPlayerCurrentCards() < value) {

                continue;

            }


        }while(deck.getPlayerCurrentCards() > 0);

        return value;

    }

    private static boolean checkPlayerDeckDraw(CardStack card){

        if (card.getPlayerDeckCards() > 0){

            return true;

        }

        else {

            return false;

        }

    }

    private static CardStack createDeck(){

        CardStack stack = new CardStack();

        //Ace
        stack.pushPlayerDeckStack(new Card(1 , "Ace of Diamonds"));
        stack.pushPlayerDeckStack(new Card(2, "Ace of Cloves"));
        stack.pushPlayerDeckStack(new Card(3, "Ace of Spades"));

        //Two
        stack.pushPlayerDeckStack(new Card(4, "Two of Diamonds"));
        stack.pushPlayerDeckStack(new Card(5, "Two of Cloves"));
        stack.pushPlayerDeckStack(new Card(6, "Two of Spades"));

        //Three
        stack.pushPlayerDeckStack(new Card(7, "Three of Diamonds"));
        stack.pushPlayerDeckStack(new Card(8, "Three of Cloves"));
        stack.pushPlayerDeckStack(new Card(9, "Three of Spades"));

        //Four
        stack.pushPlayerDeckStack(new Card(10, "Four of Diamonds"));
        stack.pushPlayerDeckStack(new Card(11, "Four of Cloves"));
        stack.pushPlayerDeckStack(new Card(12, "Four of Spades"));

        //Five
        stack.pushPlayerDeckStack(new Card(13, "Five of Diamonds"));
        stack.pushPlayerDeckStack(new Card(14, "Five of Cloves"));
        stack.pushPlayerDeckStack(new Card(15, "Five of Spades"));

        //Six
        stack.pushPlayerDeckStack(new Card(16, "Six of Diamonds"));
        stack.pushPlayerDeckStack(new Card(17, "Six of Cloves"));
        stack.pushPlayerDeckStack(new Card(18, "Six of Spades"));

        //Seven
        stack.pushPlayerDeckStack(new Card(19, "Seven of Diamonds"));
        stack.pushPlayerDeckStack(new Card(20, "Seven of Cloves"));
        stack.pushPlayerDeckStack(new Card(21, "Seven of Spades"));

        //Eight
        stack.pushPlayerDeckStack(new Card(22, "Eight of Diamonds"));
        stack.pushPlayerDeckStack(new Card(23, "Eight of Cloves"));
        stack.pushPlayerDeckStack(new Card(24, "Eight of Spades"));

        //Nine
        stack.pushPlayerDeckStack(new Card(25, "Nine of Diamonds"));
        stack.pushPlayerDeckStack(new Card(26, "Nine of Cloves"));
        stack.pushPlayerDeckStack(new Card(27, "Nine of Spades"));

        //Ten
        stack.pushPlayerDeckStack(new Card(28, "Ten of Diamonds"));
        stack.pushPlayerDeckStack(new Card(29, "Ten of Cloves"));
        stack.pushPlayerDeckStack(new Card(30, "Ten of Spades"));

        return stack;

    }
}
