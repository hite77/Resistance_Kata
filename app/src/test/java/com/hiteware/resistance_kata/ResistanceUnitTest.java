package com.hiteware.resistance_kata;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ResistanceUnitTest {
    Integer[][] grid_condition_one;

    @Before
    public void setup() {
        int rows = 5;
        int columns = 6;
        grid_condition_one = new Integer[rows][columns];
        grid_condition_one[0][0]=3 ;
        grid_condition_one[0][1]=4 ;
        grid_condition_one[0][2]=1 ;
        grid_condition_one[0][3]=2 ;
        grid_condition_one[0][4]=8 ;
        grid_condition_one[0][5]=6 ;
        grid_condition_one[1][0]=6 ;
        grid_condition_one[1][1]=1 ;
        grid_condition_one[1][2]=8 ;
        grid_condition_one[1][3]=2 ;
        grid_condition_one[1][4]=7 ;
        grid_condition_one[1][5]=4 ;
        grid_condition_one[2][0]=5 ;
        grid_condition_one[2][1]=9 ;
        grid_condition_one[2][2]=3 ;
        grid_condition_one[2][3]=9 ;
        grid_condition_one[2][4]=9 ;
        grid_condition_one[2][5]=5 ;
        grid_condition_one[3][0]=8 ;
        grid_condition_one[3][1]=4 ;
        grid_condition_one[3][2]=1 ;
        grid_condition_one[3][3]=3 ;
        grid_condition_one[3][4]=2 ;
        grid_condition_one[3][5]=6 ;
        grid_condition_one[4][0]=3 ;
        grid_condition_one[4][1]=7 ;
        grid_condition_one[4][2]=2 ;
        grid_condition_one[4][3]=8 ;
        grid_condition_one[4][4]=6 ;
        grid_condition_one[4][5]=4 ;
    }

    @Test
    public void given_condition_one_resistance_is_calculated() {
        Resistance resistance = new Resistance(grid_condition_one);
        assertThat(resistance.leastResistanceCount(), equalTo(16));
    }

    @Test
    public void given_condition_one_path_is_completed() {
        Resistance resistance = new Resistance(grid_condition_one);
        assertTrue(resistance.pathComplete());
    }

    @Test
    public void given_condition_one_path_positions_are_correct() {
        Resistance resistance = new Resistance(grid_condition_one);
        List<Integer> path = resistance.path();
        List<Integer> expected_path = UtilityMethods.construct_list(1,2,3,4,4,5);
        assertThat(path, equalTo(expected_path));
    }

    @Test
    public void worst_case_scenario_largest_grid_computes_in_timely_manner() {
       int rows = 10;
       int columns = 100;

    }
}