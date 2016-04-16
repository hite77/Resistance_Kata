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

    private Integer[][] grid_five_rows_tall = new Integer[5][4];
    private Integer[][] grid_three_rows_tall = new Integer[3][3];

    @Before
    public void setup() {
        initialize_grid_five_rows_tall();
        initialize_grid_three_rows_tall();
    }

    public void initialize_grid_five_rows_tall() {
        grid_five_rows_tall[0][0] = 0; grid_five_rows_tall[0][1] = 0; grid_five_rows_tall[0][2] = 0; grid_five_rows_tall[0][3] = 0;
        grid_five_rows_tall[1][0] = 0; grid_five_rows_tall[1][1] = 0; grid_five_rows_tall[1][2] = 0; grid_five_rows_tall[1][3] = 0;
        grid_five_rows_tall[2][0] = 0; grid_five_rows_tall[2][1] = 0; grid_five_rows_tall[2][2] = 0; grid_five_rows_tall[2][3] = 0;
        grid_five_rows_tall[3][0] = 0; grid_five_rows_tall[3][1] = 0; grid_five_rows_tall[3][2] = 0; grid_five_rows_tall[3][3] = 0;
        grid_five_rows_tall[4][0] = 0; grid_five_rows_tall[4][1] = 0; grid_five_rows_tall[4][2] = 0; grid_five_rows_tall[4][3] = 0;
    }

    private void initialize_grid_three_rows_tall() {
        grid_three_rows_tall[0][0] = 1; grid_three_rows_tall[0][1] = 2; grid_three_rows_tall[0][2] = 3;
        grid_three_rows_tall[1][0] = 4; grid_three_rows_tall[1][1] = 5; grid_three_rows_tall[1][2] = 6;
        grid_three_rows_tall[2][0] = 7; grid_three_rows_tall[2][1] = 8; grid_three_rows_tall[2][2] = 9;
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
        Path path = new Path(grid_five_rows_tall);
        int row_position = 3;
        path.setStartPosition(row_position);
        assertThat(path.recallPositions(), equalTo(construct_positions_list(row_position)));
    }

    @Test
    public void can_store_a_move_up_and_recall_positions() {
        Path path = new Path(grid_five_rows_tall);
        path.setStartPosition(5);
        path.moveUp();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(5,4)));
    }

    @Test
    public void can_wrap_around_the_top_to_bottom_position() {
        Path path = new Path(grid_five_rows_tall);
        path.setStartPosition(1);
        path.moveUp();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(1,5)));
    }

    @Test
    public void can_store_move_down_and_recall_position() {
        Path path = new Path(grid_five_rows_tall);
        path.setStartPosition(2);
        path.moveDown();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(2,3)));
    }

    @Test
    public void can_move_down_wrapping_to_the_top_position() {
        Path path = new Path(grid_five_rows_tall);
        path.setStartPosition(4);
        path.moveDown();
        path.moveDown();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(4,5,1)));
    }

    @Test
    public void can_move_up_and_down_wrapping_both_ways() {
        Path path = new Path(grid_three_rows_tall);
        path.setStartPosition(3);
        path.moveDown();
        path.moveUp();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(3,1,3)));
    }

    @Test
    public void can_move_sideways() {
        Path path = new Path(grid_three_rows_tall);
        path.setStartPosition(2);
        path.moveSideways();
        assertThat(path.recallPositions(), equalTo(construct_positions_list(2, 2)));
    }

    @Test
    public void copied_path_has_same_moves_and_is_not_tied_to_original_as_shallow_copy() {
        Path original = new Path(grid_three_rows_tall);
        original.setStartPosition(3);
        original.moveDown();
        Path copy = new Path(original);
        original.moveDown();
        assertThat(copy.recallPositions(), equalTo(construct_positions_list(3, 1)));
    }

    @Test
    public void path_has_starting_resistance_value_of_the_row_and_first_column() {
        Path path = new Path(grid_three_rows_tall);
        path.setStartPosition(1);
        assertThat(path.resistance(), equalTo(1));
    }

    @Test
    public void path_can_add_up_its_resistance_value() {
        Path path = new Path(grid_three_rows_tall);
        path.setStartPosition(2);
        path.moveDown();
        path.moveSideways();
        assertThat(path.resistance(), equalTo(21));
    }

    @Test
    public void path_when_copied_still_has_correct_resistance_value() {
        Path path = new Path(grid_three_rows_tall);
        path.setStartPosition(3);
        path.moveUp();
        Path copy = new Path(path);
        copy.moveUp();
        path.moveSideways();
        assertThat(copy.resistance(), equalTo(15)); //7+5+3 (3, 2, 1)
        assertThat(path.resistance(), equalTo(18));
    }
}