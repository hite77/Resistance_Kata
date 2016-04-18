package com.hiteware.resistance_kata;

/**
 * Created on 4/17/16.
 */
public class BaseTwoCounter {
    private Integer[] counter_stored;
    private boolean done = false;
    private int rows;

    private static Integer[] construct_start_counter(int columns) {
        Integer[] new_counter = new Integer[columns];
        new_counter[0] = 1;
        for (int column=1; column<columns; column++)
        {
            new_counter[column]=0;
        }
        return new_counter;
    }

    public BaseTwoCounter(int row, int columns) {
        this(row, construct_start_counter(columns));
    }

    public BaseTwoCounter(int row, Integer[] setCounter) {
        counter_stored = setCounter;
        rows = row;
    }

    public Integer[] currentCount() {
        return counter_stored;
    }

    public void increment() {
        int current_decimal_place = counter_stored.length-1;

        counter_stored[current_decimal_place] += 1;

        while (current_decimal_place > 0) {
            if (counter_stored[current_decimal_place] > 2 && current_decimal_place != 0) {
                counter_stored[current_decimal_place] = 0;
                current_decimal_place -= 1;
                counter_stored[current_decimal_place] += 1;
                if (counter_stored[0] > rows) done = true;
            }
            else break;
        }
    }

    public boolean isDone() {
        return done;
    }
}
