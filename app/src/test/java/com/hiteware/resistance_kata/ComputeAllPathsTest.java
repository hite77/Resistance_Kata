package com.hiteware.resistance_kata;

import org.junit.Before;
import org.junit.Test;

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
    public void path_should_be_first_row_straight_across() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_two);
        Path current_path = computeAllPaths.getCurrentPath();
        Path expected_path = new Path(grid_three_by_two,1);
        expected_path.moveSideways();
        assertTrue(paths_are_the_same(current_path, expected_path));
    }

    @Test
    public void once_path_is_incremented_it_will_be_on_first_row_going_up() {
        ComputeAllPaths computeAllPaths = new ComputeAllPaths(grid_three_by_two);
        computeAllPaths.calculate_next_path();
        Path current_path = computeAllPaths.getCurrentPath();
        Path expected_path = new Path(grid_three_by_two,1);
        expected_path.moveUp();
        assertTrue(paths_are_the_same(current_path, expected_path));
    }

    @Test
    public void third_path_will_still_be_first_row_going_down() {
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
}
