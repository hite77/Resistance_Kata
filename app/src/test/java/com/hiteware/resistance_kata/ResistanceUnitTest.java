package com.hiteware.resistance_kata;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ResistanceUnitTest {
    Integer[][] grid_condition_one;
    Integer[][] grid_condition_two;
    Integer[][] grid_condition_three;

    public void setup_condition_one() {
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

    public void setup_condition_two() {
        int rows = 5;
        int columns = 6;
        grid_condition_two = new Integer[rows][columns];
        grid_condition_two[0][0]=3 ;
        grid_condition_two[0][1]=4 ;
        grid_condition_two[0][2]=1 ;
        grid_condition_two[0][3]=2 ;
        grid_condition_two[0][4]=8 ;
        grid_condition_two[0][5]=6 ;
        grid_condition_two[1][0]=6 ;
        grid_condition_two[1][1]=1 ;
        grid_condition_two[1][2]=8 ;
        grid_condition_two[1][3]=2 ;
        grid_condition_two[1][4]=7 ;
        grid_condition_two[1][5]=4 ;
        grid_condition_two[2][0]=5 ;
        grid_condition_two[2][1]=9 ;
        grid_condition_two[2][2]=3 ;
        grid_condition_two[2][3]=9 ;
        grid_condition_two[2][4]=9 ;
        grid_condition_two[2][5]=5 ;
        grid_condition_two[3][0]=8 ;
        grid_condition_two[3][1]=4 ;
        grid_condition_two[3][2]=1 ;
        grid_condition_two[3][3]=3 ;
        grid_condition_two[3][4]=2 ;
        grid_condition_two[3][5]=6 ;
        grid_condition_two[4][0]=3 ;
        grid_condition_two[4][1]=7 ;
        grid_condition_two[4][2]=2 ;
        grid_condition_two[4][3]=1 ;
        grid_condition_two[4][4]=2 ;
        grid_condition_two[4][5]=3 ;
    }

    public void setup_condition_three() {
        int rows = 3;
        int columns = 5;
        grid_condition_three = new Integer[rows][columns];
        grid_condition_three[0][0]=19 ;
        grid_condition_three[0][1]=10 ;
        grid_condition_three[0][2]=19 ;
        grid_condition_three[0][3]=10 ;
        grid_condition_three[0][4]=19 ;
        grid_condition_three[1][0]=21 ;
        grid_condition_three[1][1]=23 ;
        grid_condition_three[1][2]=20 ;
        grid_condition_three[1][3]=19 ;
        grid_condition_three[1][4]=12 ;
        grid_condition_three[2][0]=20 ;
        grid_condition_three[2][1]=12 ;
        grid_condition_three[2][2]=20 ;
        grid_condition_three[2][3]=11 ;
        grid_condition_three[2][4]=10 ;
    }

    @Before
    public void setup() {
        setup_condition_one();
        setup_condition_two();
        setup_condition_three();
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
    public void given_condition_two_resistance_is_calculated() {
        Resistance resistance = new Resistance(grid_condition_two);
        assertThat(resistance.leastResistanceCount(), equalTo(11));
    }

    @Test
    public void given_condition_two_path_is_completed() {
        Resistance resistance = new Resistance(grid_condition_two);
        assertTrue(resistance.pathComplete());
    }

    @Test
    public void given_condition_two_path_positions_are_correct() {
        Resistance resistance = new Resistance(grid_condition_two);
        List<Integer> path = resistance.path();
        List<Integer> expected_path = UtilityMethods.construct_list(1,2,1,5,5,5);
        assertThat(path, equalTo(expected_path));
    }

    @Test
    public void given_condition_three_resistance_is_calculated() {
        Resistance resistance = new Resistance(grid_condition_three);
        assertThat(resistance.leastResistanceCount(), equalTo(48));
    }

    @Test
    public void given_condition_three_path_is_completed() {
        Resistance resistance = new Resistance(grid_condition_three);
        assertFalse(resistance.pathComplete());
    }

    @Test
    public void given_condition_three_path_positions_are_correct() {
        Resistance resistance = new Resistance(grid_condition_three);
        List<Integer> path = resistance.path();
        List<Integer> expected_path = UtilityMethods.construct_list(1,1,1);
        assertThat(path, equalTo(expected_path));
    }

    public void worst_case_scenario_largest_grid_computes_in_timely_manner() {
       int rows = 10;
       int columns = 100;

    }
}