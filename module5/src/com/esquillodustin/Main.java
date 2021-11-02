package com.esquillodustin;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player ploo = new Player(912, "Plooful", 100);
        Player wardell = new Player(2012, "TSM Wardell", 200);
        Player deadlyJimmy = new Player(3094, "DeadlyJimmy", 150);
        Player subroza = new Player(5093, "Subroza", 170);
        Player annieDro = new Player(8, "C9 Annie", 90);

        SimpleHashtable hashtable = new SimpleHashtable();

        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(subroza.getUserName(), subroza);
        hashtable.put(annieDro.getUserName(), annieDro);

        hashtable.printHashtable();

        System.out.println("\n");

        System.out.println("Removed Subroza");
        hashtable.remove("Subroza");

        System.out.println("\n");

        hashtable.printHashtable();

        System.out.println("\n");

        //to check if index 8 is already empty
        System.out.println(hashtable.get("Subroza"));
        Player chicken = new Player(110, "chicken", 110);
        hashtable.put(chicken.getUserName(), chicken);

        System.out.println("\n");

        hashtable.printHashtable();

    }
}
