package com.toyrobot.helper;

import com.toyrobot.exception.ToyRobotException;


public class Robot {
	
	 private Position position;
	 
	 public Robot() {}
	 
	 public Robot(Position position) {
		 this.position = position;
	 }
	
	 public boolean setPosition(Position position) {
	    if (position == null){
	    	return false;
	    }
	
	    this.position = position;
	    return true;
	 }
	 
	 public boolean move() throws ToyRobotException {
        return move(position.getNextPosition());
	 }
	 
	/**
	 * Moves the robot one unit forward in the direction it is currently facing
	 * @param newPosition
	 * @return true if successful
	 */
	 public boolean move(Position newPosition) {
        if (newPosition == null)
            return false;

        this.position = newPosition;
        return true;
	 }

    public Position getPosition() {
        return this.position;
    }
    
    /**
     * Rotates the robot to LEFT
     *
     * @return true if rotated successfully
     */
    public boolean rotateLeft() {
        if (this.position.direction == null)
            return false;

        this.position.direction = this.position.direction.leftDirection();
        return true;
    }

    
    /**
     * Rotates the robot to RIGHT
     *
     * @return true if rotated successfully
     */
    public boolean rotateRight() {
        if (this.position.direction == null)
            return false;

        this.position.direction = this.position.direction.rightDirection();
        return true;
    }
}
