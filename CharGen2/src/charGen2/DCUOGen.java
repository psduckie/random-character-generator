package charGen2;

import java.util.ArrayList;
import java.util.Random;

public class DCUOGen {
	// Declare the arrays
	private ArrayList<String> factions;
	private ArrayList<String> mentors;
	private ArrayList<String> powersets;
	private ArrayList<String> weapons;
	private ArrayList<String> movement;
	private ArrayList<String> personalities;
	
	// And the randomizer
	private Random rand;
	private int randomValue;
	
	// Flag
	private char side;
	
	// And finally a space to hold the character
	private BnSChar character;

	public BnSChar getCharacter() {
		return character;
	}

	public void setCharacter(BnSChar character) {
		this.character = character;
	}

	public DCUOGen()
	{
		// Initialize the randomizer
		rand = new Random();
		
		// Populate the arrays
		factions.add("Hero");
		factions.add("Villain");
		
		
	}
}
