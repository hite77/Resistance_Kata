package com.hiteware.resistance_kata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 4/17/16.
 */
public class BaseTwoCounterTest {
    @Test
    public void can_be_constructed_with_number_of_rows_and_columns_returns_row_1_and_all_zero() {
        int rows = 3;
        int columns = 5;
        BaseTwoCounter counter = new BaseTwoCounter(rows,columns);
        assertThat(counter.currentCount(), equalTo(UtilityMethods.construct_array(1,0,0,0,0)));
    }

    @Test
    public void once_constructed_adding_one_will_correctly_add() {
        int rows = 2;
        int columns = 3;
        BaseTwoCounter counter = new BaseTwoCounter(rows, columns);
        counter.increment();
        assertThat(counter.currentCount(), equalTo(UtilityMethods.construct_array(1,0,1)));
    }

    @Test
    public void incrementing_past_one_will_add() {
        BaseTwoCounter counter = new BaseTwoCounter(2,UtilityMethods.construct_array(1,0,1));
        counter.increment();
        assertThat(counter.currentCount(), equalTo(UtilityMethods.construct_array(1,0,2)));
    }

    @Test
    public void incrementing_past_two_will_carry_at_first_decimal_place() {
        BaseTwoCounter counter = new BaseTwoCounter(2,UtilityMethods.construct_array(1,0,2));
        counter.increment();
        assertThat(counter.currentCount(), equalTo(UtilityMethods.construct_array(1,1,0)));
    }

    @Test
    public void incrementing_will_carry_over() {
        BaseTwoCounter counter = new BaseTwoCounter(2,UtilityMethods.construct_array(1,2,2));
        counter.increment();
        assertThat(counter.currentCount(), equalTo(UtilityMethods.construct_array(2,0,0)));
    }
}
