package com.brent.ca;

import java.util.Random;

public class CellArray {

	private int size;
	private int ruleset;
	private Cell[] automataRow;
	
	public CellArray(int size, int rules) {
		this.size = size;
		this.ruleset = rules;
		
		automataRow = new Cell[size];
		for(int i = 0; i < size; i++) {
			automataRow[i] = new Cell();
		}
		
		automataRow[size/2].setState(1);
	}
	
	public CellArray(int size) {
		Random rand = new Random();
		this.size = size;
		this.ruleset = rand.nextInt(255);
		
		automataRow = new Cell[size];
		for(int i = 0; i < size; i++) {
			automataRow[i] = new Cell();
		}
		
		automataRow[size/2].setState(1);
	}
	
	
	
	//prints multiple rows of the system, progressing the automata
	public void printAutomata(int lineCount, int delay) {
		System.out.println("ruleset: " + ruleset);
		for(int i = 0; i < lineCount; i++) {
			printState();
			updateCells();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}
	
	//prints a single row of the system
	public void printState() {
		for(int i = 0; i < size; i++) {
			int state = automataRow[i].getState();
			switch(state) {
			case 1:
				System.out.print("x");
				break;
			default:
				System.out.print(" ");
				break;
			}
		}
		System.out.println("");
	}
	
	public void updateCells() {
		for(int i = 0; i < size; i++) {
			int neighborStatus = getNeighbors(i);
			if((ruleset & (1 << neighborStatus)) != 0) {
				automataRow[i].setNextState(1);
			}
		}
		for(int i = 0; i < size; i++) {
			automataRow[i].updateState();
		}
		return;
	}
	
	public int getNeighbors(int index) {
		int left, center, right;
		
		if(index == 0) {
			left = 0;
		}
		else {
			left = automataRow[index - 1].getState();
		}
		
		center = automataRow[index].getState();
		
		if(index == size - 1) {
			right = 0;
		}
		else {
			right = automataRow[index + 1].getState();
		}
		
		return left*4 + center*2 + right;
	}
	
}
