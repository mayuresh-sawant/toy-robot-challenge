package com.toyrobot.helper;

public class SquareTableTop implements TableTop {
	
	 int tabelRows;
	 int tablecColumns;
	 
	public SquareTableTop(int tabelRows, int tablecColumns){
		this.tabelRows = tabelRows;
        this.tablecColumns = tablecColumns;
	}

	/**
	 * Check if the position of toy robot is valid
	 * @param position
	 * @return boolean
	 */
	public boolean isPositionValid(Position position) {
		 return !(
	                position.getX() > this.tablecColumns || position.getX() < 0 ||
	                        position.getY() > this.tabelRows || position.getY() < 0
	        );
	}

}
