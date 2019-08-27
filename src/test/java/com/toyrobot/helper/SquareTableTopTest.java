package com.toyrobot.helper;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SquareTableTopTest {
	
	@Test
    public void testIsPositionValid() throws Exception {
        Position mockPosition = mock(Position.class);
        when(mockPosition.getX()).thenReturn(6);
        when(mockPosition.getY()).thenReturn(7);

        SquareTableTop board = new SquareTableTop(5, 5);
        Assert.assertFalse(board.isPositionValid(mockPosition));


        when(mockPosition.getX()).thenReturn(1);
        when(mockPosition.getY()).thenReturn(1);
        Assert.assertTrue(board.isPositionValid(mockPosition));


        when(mockPosition.getX()).thenReturn(-1);
        when(mockPosition.getY()).thenReturn(-1);
        Assert.assertFalse(board.isPositionValid(mockPosition));
    }

}
