package com.hiteware.resistance_kata;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created on 4/17/16.
 */
public class ComputeAllPathsTest {

    private Integer[][] grid_three_by_two = new Integer[3][2];
    private Integer[][] grid_three_by_three = new Integer[3][3];
    @Before
    public void setup() {
        initialize_grid_two_by_three();
        initialize_grid_three_by_three();
    }

    private void initialize_grid_two_by_three() {
        grid_three_by_two[0][0]=10; grid_three_by_two[0][1]=10;
        grid_three_by_two[1][0]=15; grid_three_by_two[1][1]=30;
        grid_three_by_two[2][0]=13; grid_three_by_two[2][1]=30;
    }

    private void initialize_grid_three_by_three() {
        grid_three_by_three[0][0]=10; grid_three_by_three[0][1]=10; grid_three_by_three[0][2]=1;
        grid_three_by_three[1][0]=15; grid_three_by_three[1][1]=3;  grid_three_by_three[1][2]=2;
        grid_three_by_three[2][0]=13; grid_three_by_three[2][1]=4;  grid_three_by_three[2][2]=3;
    }

    private boolean paths_are_the_same(Path path1, Path path2) {
        boolean same = true;
        if (!path1.recallPositions().equals(path2.recallPositions()))
        {
            System.out.println("Positions not the same:" +path1.recallPositions()+":"+path2.recallPositions());
            same = false;
        }
        path1.recallPositions();
        path2.recallPositions();
        if (path1.resistance() != path2.resistance()) {
            System.out.println("Resistance not the same:" +path1.resistance()+":"+path2.resistance());
            same = false;
        }
        if (path1.resistance_too_high() != path2.resistance_too_high()) {
            System.out.println("Too High is not the same:" +path1.resistance_too_high()+":"+path2.resistance_too_high());
            same = false;
        }
        return same;
    }

    @Test
    public void test_for_moving_sideways_on_initial_counter() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_two);
        Path current_path = computeAllPaths.getCurrentPath();
        Path expected_path = new Path(grid_three_by_two,1);
        expected_path.moveSideways();
        assertTrue(paths_are_the_same(current_path, expected_path));
    }

    @Test
    public void test_for_row_going_up() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_two);
        computeAllPaths.calculate_next_path();
        Path current_path = computeAllPaths.getCurrentPath();
        Path expected_path = new Path(grid_three_by_two,1);
        expected_path.moveUp();
        assertTrue(paths_are_the_same(current_path, expected_path));
    }

    @Test
    public void test_for_row_going_down() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_two);
        computeAllPaths.calculate_next_path();
        computeAllPaths.calculate_next_path();
        Path current_path = computeAllPaths.getCurrentPath();
        Path expected_path = new Path(grid_three_by_two,1);
        expected_path.moveDown();
        assertTrue(paths_are_the_same(current_path, expected_path));
    }

    @Test
    public void fourth_path_will_be_second_row_going_across() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_two);
        computeAllPaths.calculate_next_path();
        computeAllPaths.calculate_next_path();
        computeAllPaths.calculate_next_path();
        Path current_path = computeAllPaths.getCurrentPath();
        Path expected_path = new Path(grid_three_by_two,2);
        expected_path.moveSideways();
        assertTrue(paths_are_the_same(current_path, expected_path));
    }

    @Test
    public void when_on_a_row_other_than_first_with_multiple_moves_the_path_matches() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_three, UtilityMethods.construct_array(3,1,2));
        Path current_path = computeAllPaths.getCurrentPath();
        Path expected_path = new Path(grid_three_by_three,3);
        expected_path.moveUp();
        expected_path.moveDown();
        assertTrue(paths_are_the_same(current_path, expected_path));
    }

    @Test
    public void done_will_be_true_when_all_combinations_have_been_processed() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_three, UtilityMethods.construct_array(3,2,2));
        assertTrue(computeAllPaths.done());
    }

    @Test
    public void is_not_done_if_more_combinations_are_left() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_three, UtilityMethods.construct_array(3,0,0));
        assertFalse(computeAllPaths.done());
    }

    @Test
    public void best_path_will_be_the_only_path_if_first_move() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_three);
        Path best_path = computeAllPaths.getBestPath();
        Path expected_path = new Path(grid_three_by_three,1);
        expected_path.moveSideways();
        expected_path.moveSideways();
        assertTrue(paths_are_the_same(best_path, expected_path));
    }

    @Test
    public void best_path_will_pick_the_most_moves_made_if_both_are_no_path_to_edge() {
        Integer[][] grid = new Integer[2][3];
        grid[0][0] = 20; grid[0][1] = 20; grid[0][2] = 15;
        grid[1][0] = 0;  grid[1][1] = 35; grid[1][2] = 15;
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid, UtilityMethods.construct_array(1,0,2));
        computeAllPaths.calculate_next_path();
        Path best_path = computeAllPaths.getBestPath();
        Path expected_path = new Path(grid,1);
        expected_path.moveSideways();
        expected_path.moveDown();
        assertTrue(paths_are_the_same(best_path, expected_path));
    }

    @Test
    public void best_path_will_pick_row_across_over_one_that_does_not_make_it() {
        Integer[][] grid = new Integer[2][2];
        grid[0][0] = 20; grid[0][1] = 35;
        grid[1][0] = 0;  grid[1][1] = 10;
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid);
        computeAllPaths.calculate_next_path();
        Path best_path = computeAllPaths.getBestPath();
        Path expected_path = new Path(grid,1);
        expected_path.moveUp();
        assertTrue(paths_are_the_same(best_path, expected_path));
    }

    @Test
    public void best_of_completed_paths_will_be_chosen() {
        Integer[][] grid = new Integer[2][2];
        grid[0][0] = 20; grid[0][1] = 25;
        grid[1][0] = 0;  grid[1][1] = 10;
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid);
        computeAllPaths.calculate_next_path();
        Path best_path = computeAllPaths.getBestPath();
        Path expected_path = new Path(grid,1);
        expected_path.moveUp();
        assertTrue(paths_are_the_same(best_path, expected_path));
    }
}
