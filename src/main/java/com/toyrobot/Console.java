package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.helper.*;

public class Console {
	
	TableTop tableTop;
	Robot robot;
	
	public Console(TableTop tableTop, Robot robot) {
		this.tableTop = tableTop;
		this.robot = robot;
	}
	
	/**
	 * This methods sets the position of the Toy Robot according to the user' inputs
	 * @param position
	 * @return if valid inputs and successful return true else false
	 * @throws ToyRobotException
	 */
	 public boolean setToyRobotPosition(Position position) throws ToyRobotException {

	        if (tableTop == null)
	            throw new ToyRobotException("Invalid tableTop object");

	        if (position == null)
	            throw new ToyRobotException("Invalid position");

	        if (position.getDirection() == null)
	            throw new ToyRobotException("Invalid direction");

	        // validate the position
	        if (!tableTop.isPositionValid(position))
	        	throw new ToyRobotException("Invalid co-ordinates entered");

	        // if position is valid then assign values to fields
	        robot.setPosition(position);
	        return true;
	    }
	 
	 /**
	  * This method evaluates the user inputs and based on user inputs return necessary output string
	  * @param userInput
	  * @return output string
	  * @throws ToyRobotException
	  */
	    public String process(String userInput) throws ToyRobotException {
	        String[] args = userInput.split(" ");

	        Command command;
	        try {
	            command = Command.valueOf(args[0]);
	        } catch (IllegalArgumentException e) {
	            throw new ToyRobotException("Invalid command");
	        }
	        if (command == Command.PLACE && args.length < 2) {
	            throw new ToyRobotException("Invalid command");
	        }

	        String[] params;
	        int x = 0;
	        int y = 0;
	        Direction commandDirection = null;
	        if (command == Command.PLACE) {
	            params = args[1].split(",");
	            try {
	                x = Integer.parseInt(params[0]);
	                y = Integer.parseInt(params[1]);
	                commandDirection = Direction.valueOf(params[2]);
	            } catch (Exception e) {
	                throw new ToyRobotException("Invalid command");
	            }
	        }

	        String output;

	        switch (command) {
	            case PLACE:
	                output = String.valueOf(setToyRobotPosition(new Position(x, y, commandDirection)));
	                break;
	            case MOVE:
	                Position newPosition = robot.getPosition().getNextPosition();
	                if (!tableTop.isPositionValid(newPosition))
	                    output = String.valueOf(false);
	                else
	                    output = String.valueOf(robot.move(newPosition));
	                break;
	            case LEFT:
	                output = String.valueOf(robot.rotateLeft());
	                break;
	            case RIGHT:
	                output = String.valueOf(robot.rotateRight());
	                break;
	            case REPORT:
	                output = report();
	                break;
	            default:
	                throw new ToyRobotException("Invalid command");
	        }

	        return output;
	    }
	    
	    /**
	     * This method return the x and y co-rdinates along with the current direction of the Toy Robot
	     * @return
	     */
	    public String report() {
	        if (robot.getPosition() == null)
	            return null;

	        return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getDirection().toString();
	    }
	

}
