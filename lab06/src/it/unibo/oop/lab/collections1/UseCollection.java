package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int START = 1000;
	private static final int STOP = 2000;
	private static final int POS = 0;
	private static final int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;
	private static final int READS = 1000;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	final List<Integer> arrayList = new ArrayList<>();
    	for (int i = START; i < STOP; i++) {
    		arrayList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	final List<Integer> linkedList = new LinkedList<>();
    	linkedList.addAll(arrayList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int temp = arrayList.get(arrayList.size() - 1);
    	arrayList.set(arrayList.size() - 1, arrayList.get(POS));
    	arrayList.set(POS, temp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (int i = 0; i < (STOP-START); i++) {
    		System.out.print(arrayList.get(i) + ", ");
    	}
    	System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long time = System.nanoTime();
    	for (int i = 0; i <= ELEMS; i++) {
    		arrayList.add(POS, i);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS
                + " in a ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
        time = System.nanoTime();
    	for (int i = 0; i <= ELEMS; i++) {
    		linkedList.add(POS, i);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS
                + " in a linkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        time = System.nanoTime();
    	for (int i = 0; i <= READS; i++) {
    		arrayList.get(arrayList.size() / 2);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Reading " + READS
                + " times the element in the middle of a arrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        time = System.nanoTime();
    	for (int i = 0; i <= READS; i++) {
    		linkedList.get(linkedList.size() / 2);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Reading " + READS
                + " times the element in the middle of a linkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        final Map<String,Long> heart = new HashMap<>();
        heart.put("Africa", 1110635000L);
        heart.put("Americas", 972005000L);
        heart.put("Antarctica", 0L);
        heart.put("Asia", 4298723000L);
        heart.put("Europe", 742452000L);
        heart.put("Oceania", 38304000L);
        
        /*
         * 8) Compute the population of the world
         */
        
        long tot = 0;
        for(final long pop : heart.values()) {
        	tot += pop;
        }
        System.out.println("Population of the World : " + tot);
    }
}
