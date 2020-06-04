package com.brent.ca;

public class Cell {

	private int state;
	private int nextState;
	
	public Cell(int state) {
		this.state = state;
		this.nextState = 0;
	}
	//do this better with nested constructors
	public Cell() {
		this.state = 0;
		this.nextState = 0;
	}
	
	public int getState() {
		return state;
	}
	public int setState(int state) {
		this.state = state;
		return state;
	}
	public int getNextState() {
		return nextState;
	}
	public int setNextState(int next) {
		this.nextState = next;
		return next;
	}
	
	public void updateState() {
		this.state = this.nextState;
		this.nextState = 0;
	}
	
}
