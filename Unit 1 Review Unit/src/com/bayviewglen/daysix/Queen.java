package com.bayviewglen.daysix;

public class Queen {

	private int row;
	private int col;
	
	public Queen(){
		row = 0;
		col = 0;
	}


	public Queen(int x, int y) {
		row = x;
		col = y;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
