package com.esquillodustin;

import java.util.LinkedList;
import java.util.ListIterator;


public class CardStack {

    private LinkedList<Card> playerDeckStack;
    private LinkedList<Card> currentPlayerCards;
    private LinkedList<Card> discradedPileStack;

    private int playerDeckCards = 30;
    private int discardedPileCards = 0;
    private int currentCards = 0;

    public CardStack(){

        playerDeckStack = new LinkedList<Card>();
        discradedPileStack = new LinkedList<Card>();

        currentPlayerCards = new LinkedList<Card>();


    }

    public void pushPlayerDeckStack (Card card){

        playerDeckStack.push(card);

    }

    public boolean isPlayerDeckStackEmpty(){

        return playerDeckStack.isEmpty();

    }

    public Card peekPlayerDeckStack (){

        return playerDeckStack.peek();

    }

    public Card popPlayerDeckStack(){

        return playerDeckStack.pop();

    }

    public void pushCurrentPlayerCards(Card card){

        currentPlayerCards.push(card);

    }

    public Card peekCurrentPlayerCards(){

        return currentPlayerCards.peek();

    }

    public Card popCurrentPlayerCards(){

        return currentPlayerCards.pop();

    }

    public void pushDiscardedPileStack(Card card){

        discradedPileStack.push(card);

    }

    public Card popDiscardedPileStack(){

        return discradedPileStack.pop();
    }

    public Card peekDiscardedPileStack(){

        return discradedPileStack.peek();

    }

    public void playerDraw(int number){


        for (int i = 0; i < number; i ++){

            Card currentCard = popPlayerDeckStack();
            pushCurrentPlayerCards(currentCard);
            currentCards++;
            playerDeckCards--;

        }

    }

    public void playerDiscard(int number){

        for (int i = 0; i < number; i ++){

            Card currentCard = popCurrentPlayerCards();
            pushDiscardedPileStack(currentCard);
            currentCards--;
            discardedPileCards++;

        }

    }

    public void playerGetFromDiscarded(int number){

        for (int i = 0; i < number; i++){

            Card currentCard = popDiscardedPileStack();
            pushCurrentPlayerCards(currentCard);
            currentCards++;
            discardedPileCards--;

        }

    }

    public void printCurrentPlayerCards(){

        ListIterator<Card> cardIterator = currentPlayerCards.listIterator();

        while (cardIterator.hasNext()){

            System.out.println(cardIterator.next());

        }

    }

    public int getPlayerDeckCards(){

        return playerDeckCards;

    }

    public int getDiscardedPileCards(){

        return discardedPileCards;

    }

    public int getPlayerCurrentCards(){

        return currentCards;

    }

}
