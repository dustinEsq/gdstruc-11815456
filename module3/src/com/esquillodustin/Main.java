package com.esquillodustin;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        CardStack deckOfCards = createDeck();
        CardStack hand = new CardStack();
        CardStack pile = new CardStack();

        Scanner scanner = new Scanner(System.in);

        int round = 1;

        while (!deckOfCards.isDeckStackEmpty()){

            playRound(round, deckOfCards, hand, pile);
            scanner.nextLine();

            //to check what is the top element
            System.out.println("Player Deck Peek - " + deckOfCards.peekStack());
            System.out.println("Current Hand Peek - " + hand.peekStack());
            System.out.println("Discarded Pile Peek - " + pile.peekStack());
            System.out.print("\n");

            round++;

        }

        if (deckOfCards.isDeckStackEmpty()){

            System.out.println("\nThere are no remaining cards available on the Player Deck");

        }


    }

    private static void playRound (int round, CardStack deck, CardStack hand, CardStack pile){

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
                    playerDraw(randDraw, deck, hand);

                }

                else {

                    System.out.println("The player draws: " + randDraw + " cards!");
                    scanner.nextLine();
                    playerDraw(randDraw, deck, hand);

                }

                scanner.nextLine();
                System.out.println("Printing the current cards on hold");
                hand.printCards();
                scanner.nextLine();

                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + pile.getDiscardedPileCards());


            }

            else if (check == false){

                System.out.println("The selected command is Draw! ");
                System.out.println("Player Deck does not have sufficient cards to be drawn ");

                System.out.println("Printing the current cards on hold");
                hand.printCards();
                scanner.nextLine();

                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + pile.getDiscardedPileCards());

            }

        }

        else if (randCommand == 2){ // 2 is equal to discard Command

            //if the current cards on hand is empty
            if (hand.getCurrentCards() == 0){

                System.out.println("The selected command is Discard! ");
                scanner.nextLine();

                System.out.println("The player does not have any remaining cards on his/her hand ");
                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + pile.getDiscardedPileCards());

                scanner.nextLine();
            }


            //if there are cards on hand
            else if (hand.getCurrentCards() > 0){

                System.out.println("The selected command is Discard! ");
                scanner.nextLine();
                int input = playerInputForDiscard(hand);
                playerDiscard(input, hand, pile);
                scanner.nextLine();

                System.out.println("Printing the current cards on hold");
                hand.printCards();
                scanner.nextLine();

                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + pile.getDiscardedPileCards());

            }

        }

        else if (randCommand == 3){ // 3 is equal to get from discarded pile command

            //If there are no cards available
            if (pile.getDiscardedPileCards() == 0){
                System.out.println("The selected command is Get! ");
                scanner.nextLine();

                if (hand.getCurrentCards() > 0){

                    System.out.println("Printing the current cards on hold");
                    hand.printCards();
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
            else if (pile.getDiscardedPileCards() > 0){

                System.out.println("The selected command is Get! ");
                int input = playerInputForGet(pile);
                playerGet(input, hand, pile);
                scanner.nextLine();

                System.out.println("Printing the current cards on hold");
                hand.printCards();

                scanner.nextLine();
                System.out.println("Remaining Cards on the Player Deck: " + deck.getPlayerDeckCards());
                System.out.println ("Remaining Cards on the Discarded Pile: " + pile.getDiscardedPileCards());

            }


        }


    }

    private static void playerDraw(int number, CardStack deck, CardStack hand){

        for (int i = 0; i < number; i ++) {

            Card currentCard = deck.popStack();
            hand.pushStack(currentCard);
            deck.setPlayerDeckCards(deck.getPlayerDeckCards() - 1);
            hand.setCurrentCards(hand.getCurrentCards() + 1);

        }

    }

    private static void playerDiscard(int number, CardStack hand, CardStack pile){

        for (int i = 0; i < number; i ++) {

            Card currentCard = hand.popStack();
            pile.pushStack(currentCard);
            hand.setCurrentCards(hand.getCurrentCards() - 1);
            pile.setDiscardedPileCards(pile.getDiscardedPileCards() + 1);

        }
    }

    private static void playerGet(int number, CardStack hand, CardStack pile){

        for (int i = 0; i < number; i ++) {

            Card currentCard = pile.popStack();
            hand.pushStack(currentCard);
            hand.setCurrentCards(hand.getCurrentCards() + 1);
            pile.setDiscardedPileCards(pile.getDiscardedPileCards() - 1);

        }

    }

    private static int playerInputForGet(CardStack pile){

        int value;

        //for player input
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many cards do you want to get from the discarded pile?");

        do {

            value = scanner.nextInt();

            if (pile.getDiscardedPileCards() >= value){

                break;

            }

            //if the player has at least one card on discarded pile
            //but the player typed a value that is greater than the number of cards
            //that are available in discarded pile
            else if (pile.getDiscardedPileCards() > 0 && pile.getDiscardedPileCards() < value) {

                continue;

            }


        }while(pile.getDiscardedPileCards() > 0);

        return value;


    }

    private static int playerInputForDiscard(CardStack hand){

        int value;

        //for player input
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many cards do you want to discard?");

        do {

            value = scanner.nextInt();

            if (hand.getCurrentCards() >= value){

                break;

            }

            //if the player has at least one card on hold
            //but the player typed a value that is greater than the number of cards
            //he/she currently holds
            else if (hand.getCurrentCards() > 0 && hand.getCurrentCards() < value) {

                continue;

            }


        }while(hand.getCurrentCards() > 0);

        return value;

    }

    private static boolean checkPlayerDeckDraw(CardStack deck){

        if (deck.getPlayerDeckCards() > 0){

            return true;

        }

        else {

            return false;

        }

    }

    private static CardStack createDeck(){

        CardStack deck = new CardStack();

        //Ace
        deck.pushStack(new Card(1 , "Ace of Diamonds"));
        deck.pushStack(new Card(2, "Ace of Cloves"));
        deck.pushStack(new Card(3, "Ace of Spades"));

        //Two
        deck.pushStack(new Card(4, "Two of Diamonds"));
        deck.pushStack(new Card(5, "Two of Cloves"));
        deck.pushStack(new Card(6, "Two of Spades"));

        //Three
        deck.pushStack(new Card(7, "Three of Diamonds"));
        deck.pushStack(new Card(8, "Three of Cloves"));
        deck.pushStack(new Card(9, "Three of Spades"));

        //Four
        deck.pushStack(new Card(10, "Four of Diamonds"));
        deck.pushStack(new Card(11, "Four of Cloves"));
        deck.pushStack(new Card(12, "Four of Spades"));

        //Five
        deck.pushStack(new Card(13, "Five of Diamonds"));
        deck.pushStack(new Card(14, "Five of Cloves"));
        deck.pushStack(new Card(15, "Five of Spades"));

        //Six
        deck.pushStack(new Card(16, "Six of Diamonds"));
        deck.pushStack(new Card(17, "Six of Cloves"));
        deck.pushStack(new Card(18, "Six of Spades"));

        //Seven
        deck.pushStack(new Card(19, "Seven of Diamonds"));
        deck.pushStack(new Card(20, "Seven of Cloves"));
        deck.pushStack(new Card(21, "Seven of Spades"));

        //Eight
        deck.pushStack(new Card(22, "Eight of Diamonds"));
        deck.pushStack(new Card(23, "Eight of Cloves"));
        deck.pushStack(new Card(24, "Eight of Spades"));

        //Nine
        deck.pushStack(new Card(25, "Nine of Diamonds"));
        deck.pushStack(new Card(26, "Nine of Cloves"));
        deck.pushStack(new Card(27, "Nine of Spades"));

        //Ten
        deck.pushStack(new Card(28, "Ten of Diamonds"));
        deck.pushStack(new Card(29, "Ten of Cloves"));
        deck.pushStack(new Card(30, "Ten of Spades"));

        return deck;

    }
}
