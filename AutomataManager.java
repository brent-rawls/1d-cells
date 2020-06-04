package com.brent.ca;

public class AutomataManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CellArray cellularAutomata = new CellArray(71, 90);
		
		int delay = 100;
		int lineCount = 40;
				
		
		CellArray cellularAutomata = new CellArray(131);
		cellularAutomata.printAutomata(lineCount, delay);
		
		
	}


}
