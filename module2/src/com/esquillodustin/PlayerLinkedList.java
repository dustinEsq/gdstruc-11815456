package com.esquillodustin;

public class PlayerLinkedList {

    private PlayerNode head;

    //adding an element
    public void addToFront(Player player){

        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        sizeOfLinkedList();

    }

    //removing the first element
    public void removeFirstElement(){

        head = head.getNextPlayer();
        sizeOfLinkedList();

    }

    //counting the size of the Linked List
    public int sizeOfLinkedList(){

        int size = 0;
        PlayerNode current = head;

        while (current != null){
            current = current.getNextPlayer();
            size++;
        }

        return size;

    }

    //imitating the contains function
    public boolean containElement(Player player){

        boolean contain = false;
        PlayerNode current = head;

        while (current != null){

            if (current.getPlayer() == player){

                contain = true;
                break;
            }

            else {

                current = current.getNextPlayer();

            }

        }

        return contain;
    }

    //imitating the indexOf function
    public int indexOfElement (Player player){

        int index = -1;
        PlayerNode current = head;

        while (true){

            if (current.getPlayer() != player && current.getNextPlayer() == null){

                index = -1;
                break;
            }

            else if (current.getPlayer() == player){

                index++;
                break;

            }

            else if (current.getPlayer() != player){

                index++;
                current = current.getNextPlayer();
            }


        }

        return index;

    }

    //printing the Linked List
    public void printList(){
        int size = sizeOfLinkedList();
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
        System.out.println("Size of the linked list: " + size);

    }
}
