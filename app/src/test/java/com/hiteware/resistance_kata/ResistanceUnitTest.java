package com.hiteware.resistance_kata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ResistanceUnitTest {
    @Test
    public void sums_up_resistance_for_one_row_sum_less_than_50() {
        int rows = 1;
        int columns = 5;
        Integer[][] grid = new Integer[rows][columns];
        Resistance resistance = new Resistance(grid);
        assertThat(42, equalTo(resistance.leastResistanceCount()));
    }
}