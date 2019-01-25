package charGen2;

import java.util.Random;

public class STOGen {
	// Declare the arrays
	private String[] factions;
	private String[] races;
	private String[] charClasses;
	private String[] shipClasses;
	
	// And the randomizer
	private Random rand;
	private int randomValue;
	
	// Flags
	private boolean dominion;
	private int zen;
	private boolean lifetime;
	private boolean reman;
	
	public boolean isDominion() {
		return dominion;
	}

	public void setDominion(boolean dominion) {
		this.dominion = dominion;
	}

	public int getZen() {
		return zen;
	}

	public void setZen(int zen) {
		this.zen = zen;
	}

	public boolean isLifetime() {
		return lifetime;
	}

	public void setLifetime(boolean lifetime) {
		this.lifetime = lifetime;
	}

	// And finally a space to hold the character
	private STOChar character;
	
	public STOChar getCharacter() {
		return character;
	}

	public void setCharacter(STOChar character) {
		this.character = character;
	}

	// Constructor to populate the faction and character class arrays
	public STOGen()
	{
		// Initialize the randomizer
		rand = new Random();
		
		// Declare the arrays
		factions = new String[8];
		races = new String[20];
		charClasses = new String[3];
		shipClasses = new String[3];
		
		// Populate the static array
		charClasses[0] = "Tactical";
		charClasses[1] = "Science";
		charClasses[2] = "Engineering";
		
		// As ship classes are different by faction, ship class array will be populated once faction is randomly determined.
		
		// And initialize the holding variable
		character = new STOChar();
	}
	
	public int populateFactions()
	{
		factions[0] = "Federation";
		factions[1] = "Klingon";
		factions[2] = "Romulan (Federation aligned)";
		factions[3] = "Romulan (Klingon aligned)";
		factions[4] = "TOS Federation";
		factions[5] = "DSC Federation";
		
		if(dominion) {
			factions[6] = "Dominion (Federation aligned)";
			factions[7] = "Dominion (Klingon aligned)";
			return 8;
		}
		else {
			return 6;
		}
	}
	
	public int populateShipClasses(String faction) // F for Fed, K for KDF, R for Romulan, D for Dominion.  Returns the number of possible classes that have ships from T2 and up.
	{
		try{
			
			switch(faction)
			{
			case "Fed":
				shipClasses[0] = "Cruiser";
				shipClasses[1] = "Escort";
				shipClasses[2] = "Science Vessel";
				return 3;
			case "KDF":
				shipClasses[0] = "Raider";
				shipClasses[1] = "Raptor";	
				shipClasses[2] = "Battle Cruiser";
				return 3;
			case "Rom":
				shipClasses[0] = "Warbird";
				// There's only one ship class that meets the specifications.
				return 1;
			case "Dom":
				shipClasses[0] = "Escort";
				// There's only one ship class that meets the specifications.
				return 1;
			default:
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Cannot populate ship classes: Not a valid faction.");
			return -1;
		}
	}
	
	public int populateRaces(String faction) //Returns the number of possible races, given the max amount of ZEN
	{
		try{
			int currentIndex = 0;
			switch(faction)
			{
			case "Fed":
				races[currentIndex++] = "Andorian";
				races[currentIndex++] = "Bajoran";
				races[currentIndex++] = "Benzite";
				races[currentIndex++] = "Betazoid";
				races[currentIndex++] = "Bolian";
				races[currentIndex++] = "Ferengi";
				races[currentIndex++] = "Human";
				races[currentIndex++] = "Pakled";
				races[currentIndex++] = "Rigelian";
				races[currentIndex++] = "Saurian";
				races[currentIndex++] = "Tellarite";
				races[currentIndex++] = "Trill";
				races[currentIndex++] = "Vulcan";
				races[currentIndex++] = "Alien";
				if(zen >= 600) {
					races[currentIndex++] = "Caitian";
					races[currentIndex++] = "Klingon";
					races[currentIndex++] = "Trill (joined)";

				}
				if(zen >= 1000) {
					races[currentIndex++] = "Cardassian";
				}
				if(lifetime) {
					races[currentIndex++] = "Liberated Borg";
					races[currentIndex++] = "Talaxian";
				}
				return currentIndex;
			case "TOS":
				races[currentIndex++] = "Andorian";
				races[currentIndex++] = "Human";
				races[currentIndex++] = "Tellarite";
				races[currentIndex++] = "Vulcan";
				return currentIndex;
			case "DSC":
				races[currentIndex++] = "Human";
				races[currentIndex++] = "Vulcan";
				races[currentIndex++] = "Alien";
				return currentIndex;
			case "KDF":
				races[currentIndex++] = "Gorn";
				races[currentIndex++] = "Klingon";
				races[currentIndex++] = "Lethean";
				races[currentIndex++] = "Nausicaan";
				races[currentIndex++] = "Orion";
				races[currentIndex++] = "Alien";
				if(zen >= 600) {
					races[currentIndex++] = "Ferasan";
					races[currentIndex++] = "Trill (joined)";
				}
				if(zen >= 1000) {
					races[currentIndex++] = "Cardassian";
				}
				if(lifetime) {
					races[currentIndex++] = "Liberated Borg";
					races[currentIndex++] = "Talaxian";
				}
				return currentIndex;
			case "Rom":
				races[currentIndex++] = "Romulan";
				races[currentIndex++] = "Alien";
				if(lifetime) {
					races[currentIndex++] = "Liberated Borg";
				}
				if(reman) {
					races[currentIndex++] = "Reman";
				}
				return currentIndex;
			case "Dom":
				races[currentIndex++] = "Jem'Hadar";
				if(zen >= 600) {
					races[currentIndex++] = "Jem'Hadar Vanguard";
				}
				return currentIndex;
			default:
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Cannot populate races: Not a valid faction.");
			return -1;
		}
	}
	
	public void randomCharacter()
	{
		// Randomize faction
		randomValue = rand.nextInt(5);
		int faction = randomValue; // Will be used for ship selection
		character.setFaction(factions[randomValue]);
		
		// Randomize gender
		if(faction == 6 || faction == 7) {
			character.setGender("Male"); // Dominion characters are always male
		}
		else {
			randomValue = rand.nextInt(2);
			if(randomValue == 0) {
				character.setGender("Male");
			}
			else {
				character.setGender("Female");
			}
		}
		
		// Randomize character class
		randomValue = rand.nextInt(3);
		character.setCharClass(charClasses[randomValue]);
		
		// Determine each faction's races
		int numRaces;
		try {
			switch(faction)
			{
			// Fed
			case 0:
				numRaces = populateRaces("Fed");
				break;
			// KDF
			case 1:
				numRaces = populateRaces("KDF");
				break;
			// Romulan
			case 2:
			case 3:
				numRaces = populateRaces("Rom");
				break;
			// TOS
			case 4:
				numRaces = populateRaces("TOS");
				break;
			// DSC
			case 5:
				numRaces = populateRaces("DSC");
				break;
			// Dominion
			case 6:
			case 7:
				numRaces = populateRaces("Dom");
				break;
			default:
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Cannot select ship faction: Faction number outside range.");
			return;
		}
		
		// Randomize race
		randomValue = rand.nextInt(numRaces);
		character.setRace(races[randomValue]);
		
		
		// Determine which faction's ships
		int numShips;
		try{
			switch(faction)
			{
			// Federation ships
			case 0:
			case 4:
			case 5:
				numShips = populateShipClasses("Fed");
				break;
			// Klingon ships
			case 1:
				numShips = populateShipClasses("KDF");
				break;
			// Romulan ships
			case 2:
			case 3:
				numShips = populateShipClasses("Rom");
				break;
			case 6:
			case 7:
				numShips = populateShipClasses("Dom");
				break;
			default:
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Cannot select ship faction: Faction number outside range.");
			return;
		}
		
		// Randomize ship class
		randomValue = rand.nextInt(numShips);
		character.setShipClass(shipClasses[randomValue]);
	}
	
	public void printCharacter()
	{
		System.out.println("STO character generated.");
		System.out.println("Faction: " + character.getFaction());
		System.out.println("Race: " + character.getRace());
		System.out.println("Gender: " + character.getGender());
		System.out.println("Character class: " + character.getCharClass());
		System.out.println("Ship class: " + character.getShipClass());
	}
	
	public void generate()
	{
		char input;
		boolean properInput;
		try {
			do {
				System.out.println();
				System.out.print("Do you have a Lifetime subscription?  (Y/N) ");
				input = (char) System.in.read();
				switch(input)
				{
				case 'Y':
				case 'y':
					lifetime = true;
					properInput = true;
					break;
				case 'N':
				case 'n':
					lifetime = false;
					properInput = true;
					break;
				default:
					System.out.println();
					System.out.println("Invalid character.");
					properInput = false;
					break;
				}
			} while(properInput == false);
		}
		catch(Exception e)
		{
			System.out.println("Error reading keypress.");
		}

		try {
			do {
				System.out.println();
				System.out.print("Have you unlocked the Reman race?  (Y/N) ");
				input = (char) System.in.read();
				switch(input)
				{
				case 'Y':
				case 'y':
					reman = true;
					properInput = true;
					break;
				case 'N':
				case 'n':
					reman = false;
					properInput = true;
					break;
				default:
					System.out.println();
					System.out.println("Invalid character.");
					properInput = false;
					break;
				}
			} while(properInput == false);
		}
		catch(Exception e)
		{
			System.out.println("Error reading keypress.");
		}
		
		try {
			do {
				System.out.println();
				System.out.print("Do you want to include Dominion characters in the generator table?  (Y/N) ");
				input = (char) System.in.read();
				switch(input)
				{
				case 'Y':
				case 'y':
					dominion = true;
					properInput = true;
					break;
				case 'N':
				case 'n':
					dominion = false;
					properInput = true;
					break;
				default:
					System.out.println();
					System.out.println("Invalid character.");
					properInput = false;
					break;
				}
			} while(properInput == false);
		}
		catch(Exception e)
		{
			System.out.println("Error reading keypress.");
		}
		
		try {
			System.out.println();
			System.out.print("What is the maximum number of ZEN you would be willing to spend to unlock a character race? ");
			zen = (int) System.in.read();
		}
		catch(Exception e)
		{
			System.out.println("Error reading keypress.");
		}


		System.out.println();
		try{
			System.out.print("Press any key to generate STO character: ");
			System.in.read();
			System.out.println();
		}
		catch(Exception e)
		{
			System.out.println("Error reading keypress.");
		}
		
		randomCharacter();
		printCharacter();
	}
}
