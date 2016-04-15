package com.hiteware.resistance_kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 4/14/16.
 */
public class PathUnitTest {
    @Test
    public void can_store_start_position_and_recall_position() {
        Path path = new Path();
        path.setStartPosition(3);
        List<Integer> positions = new ArrayList<>();
        positions.add(3);
        assertThat(path.recallPositions(), equalTo(positions));
    }

    @Test
    public void can_store_a_move_up_and_recall_positions() {
        Path path = new Path();
        path.setStartPosition(5);
        path.moveUp();
        List<Integer> positions = new ArrayList<>();
        positions.add(5);
        positions.add(4);
        assertThat(path.recallPositions(), equalTo(positions));
    }
}