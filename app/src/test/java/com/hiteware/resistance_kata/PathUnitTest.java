package com.hiteware.resistance_kata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 4/14/16.
 */
public class PathUnitTest {
    @Test
    public void can_store_move_and_recall_move() {
        Path path = new Path();
        Path.addRow(3);
        assertThat(path.recallMoves(), equalTo(3));
    }
}