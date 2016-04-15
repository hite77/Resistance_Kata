package com.hiteware.resistance_kata;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 4/14/16.
 */
public class PathUnitTest {

    Integer[][] grid_five_tall = new Integer[5][2];

    @Before
    public void setup() {
        initialize_grid_five_tall();
    }

    public void initialize_grid_five_tall() {
        grid_five_tall[0][0] = 0; grid_five_tall[0][1] = 0;
        grid_five_tall[1][0] = 0; grid_five_tall[1][1] = 0;
        grid_five_tall[2][0] = 0; grid_five_tall[2][1] = 0;
        grid_five_tall[3][0] = 0; grid_five_tall[3][1] = 0;
        grid_five_tall[4][0] = 0; grid_five_tall[4][1] = 0;
    }

    @Test
    public void can_store_start_position_and_recall_position() {
        Path path = new Path(grid_five_tall);
        path.setStartPosition(3);
        List<Integer> positions = new ArrayList<>();
        positions.add(3);
        assertThat(path.recallPositions(), equalTo(positions));
    }

    @Test
    public void can_store_a_move_up_and_recall_positions() {
        Path path = new Path(grid_five_tall);
        path.setStartPosition(5);
        path.moveUp();
        List<Integer> positions = new ArrayList<>();
        positions.add(5);
        positions.add(4);
        assertThat(path.recallPositions(), equalTo(positions));
    }

    @Test
    public void can_wrap_around_the_top_to_bottom_position() {
        Path path = new Path(grid_five_tall);
        path.setStartPosition(1);
        path.moveUp();
        List<Integer> positions = new ArrayList<>();
        positions.add(1);
        positions.add(5);
        assertThat(path.recallPositions(), equalTo(positions));
    }
}