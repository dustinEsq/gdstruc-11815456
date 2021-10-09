package com.esquillodustin;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedQueue {

    private LinkedList<Player> playerQueue;
    private int queue = 0;
    private int id = 1;

    public LinkedQueue(){

        playerQueue = new LinkedList<Player>();

    }

    public boolean isQueueEmpty(){

        return playerQueue.isEmpty();

    }

    public void enqueueElement (Player player){


        playerQueue.offer(player);
        id++;
        queue++;

    }

    public Player dequeueElement(){

        return playerQueue.poll();

    }

    public Player peekElement(){

        return playerQueue.peek();

    }

    public void removeElement(){

        for (int i = 0; i < 5; i++){

            dequeueElement();
            queue--;

        }


    }

    public int getQueueValue(){

        return queue;

    }

    public int getIdValue(){

        return id;

    }

    public void printQueue(){

        ListIterator<Player> iterator = playerQueue.listIterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());

        }

    }

}
