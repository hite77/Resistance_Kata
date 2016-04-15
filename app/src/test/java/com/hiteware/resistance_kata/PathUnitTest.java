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

    public List<Integer> construct_positions_list(Integer... args) {
        List<Integer> positions = new ArrayList<>();
        for (Integer arg : args) {
            positions.add(arg);
        }
        return positions;
    }

    @Test
    public void can_store_start_position_and_recall_position() {
        Path path = new Path(grid_five_tall);
        int row_position = 3;
        path.setStartPosition(row_position);
        assertThat(path.recallPositions(), equalTo(construct_positions_list(row_position)));
    }

    @Test
    public void can_store_a_move_up_and_recall_positions() {
        Path path = new Path(grid_five_tall);
        path.setStartPosition(5);
        path.moveUp();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(5,4)));
    }

    @Test
    public void can_wrap_around_the_top_to_bottom_position() {
        Path path = new Path(grid_five_tall);
        path.setStartPosition(1);
        path.moveUp();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(1,5)));
    }
}