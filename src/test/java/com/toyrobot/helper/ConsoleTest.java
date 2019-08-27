package com.toyrobot.helper;

import com.toyrobot.Console;
import com.toyrobot.exception.ToyRobotException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConsoleTest {
	
	final int BOARD_ROWS = 5;
    final int BOARD_COLUMNS = 5;
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Test
    public void testToyRobotPlacing() throws ToyRobotException {

        SquareTableTop tableTop = new SquareTableTop(BOARD_ROWS, BOARD_COLUMNS);
        Robot toyRobot = new Robot();
        Console console = new Console(tableTop, toyRobot);

        Assert.assertTrue(console.setToyRobotPosition(new Position(0, 1, Direction.NORTH)));
        Assert.assertTrue(console.setToyRobotPosition(new Position(2, 2, Direction.SOUTH)));
        exceptionRule.expect(ToyRobotException.class);
        exceptionRule.expectMessage("Invalid co-ordinates entered");
        console.setToyRobotPosition(new Position(6, 6, Direction.WEST));
        console.setToyRobotPosition(new Position(-1, 5, Direction.EAST));
    }

}
