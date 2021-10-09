package com.esquillodustin;

import java.util.LinkedList;
import java.util.ListIterator;


public class CardStack {

    private LinkedList<Card> deckStack;

    private int playerDeckCards = 30;
    private int discardedPileCards = 0;
    private int currentCards = 0;


    public CardStack(){

        deckStack = new LinkedList<Card>();

    }

    public void pushStack (Card card){

        deckStack.push(card);

    }

    public boolean isDeckStackEmpty(){

        return deckStack.isEmpty();

    }

    public Card peekStack (){

        return deckStack.peek();

    }

    public Card popStack(){

        return deckStack.pop();

    }

    public void printCards(){

        ListIterator<Card> cardIterator = deckStack.listIterator();

        while (cardIterator.hasNext()){

            System.out.println(cardIterator.next());

        }

    }

    public void setPlayerDeckCards(int value){

        playerDeckCards = value;

    }

    public void setDiscardedPileCards(int value){

        discardedPileCards = value;

    }

    public void setCurrentCards(int value){

        currentCards = value;

    }

    public int getPlayerDeckCards(){

        return playerDeckCards;

    }

    public int getDiscardedPileCards(){

        return discardedPileCards;

    }

    public int getCurrentCards(){

        return currentCards;

    }


}
