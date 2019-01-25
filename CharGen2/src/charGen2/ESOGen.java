package charGen2;

import java.util.Random;

public class ESOGen {
	// Declare the arrays
	private String[] factions;
	private String[] charClasses;
	private String[] races;
	
	// And the randomizer
	private Random rand;
	private int randomValue;
	
	// Flags for certain DLC
	private boolean imperial;
	private boolean araf;
	private boolean morrowind;
	
	public boolean isImperial() {
		return imperial;
	}

	public void setImperial(boolean imperial) {
		this.imperial = imperial;
	}

	public boolean isAraf() {
		return araf;
	}

	public void setAraf(boolean araf) {
		this.araf = araf;
	}

	public boolean isMorrowind() {
		return morrowind;
	}

	public void setMorrowind(boolean morrowind) {
		this.morrowind = morrowind;
	}

	// And finally a space to hold the character
	private ESOChar character;

	public ESOChar getCharacter() {
		return character;
	}

	public void setCharacter(ESOChar character) {
		this.character = character;
	}

	// Constructor to populate the faction and character class arrays
	public ESOGen()
	{
		// Initialize the randomizer
		rand = new Random();
		
		// Declare the arrays
		factions = new String[3];
		charClasses = new String[5];
		races = new String[10];
		
		// Populate the faction array
		factions[0] = "Aldmeri Dominion";
		factions[1] = "Daggerfall Covenant";
		factions[2] = "Ebonheart Pact";
		
		// As some race/faction combinations are locked behind DLC, race array will be populated once faction is randomly determined.

		// Mark all DLC flags as off by default
		araf = false;
		imperial = false;
		morrowind = false;
		
		// And initialize the holding area
		character = new ESOChar();
	}
	
	public int populateRaces(char faction) // D for Dominion, C for Covenant, P for Pact
	{
		int numRaces;
		
		// Check for ARAF DLC
		if(araf)
		{
			races[0] = "Altmer";
			races[1] = "Bosmer";
			races[2] = "Khajiit";
			races[3] = "Breton";
			races[4] = "Redguard";
			races[5] = "Orsimer";
			races[6] = "Dunmer";
			races[7] = "Nord";
			races[8] = "Argonian";
			numRaces = 9;
		}
		else
		{
			// Populate races array by faction.
			try{
				switch(faction)
				{
				case 'D':
					races[0] = "Altmer";
					races[1] = "Bosmer";
					races[2] = "Khajiit";
					numRaces = 3;
					break;
				case 'C':
					races[0] = "Breton";
					races[1] = "Redguard";
					races[2] = "Orsimer";
					numRaces = 3;
					break;
				case 'P':
					races[0] = "Dunmer";
					races[1] = "Nord";
					races[2] = "Argonian";
					numRaces = 3;
					break;
			default:
				throw new IllegalArgumentException();
				}
			}
			catch(IllegalArgumentException e)
			{
				System.out.print("Cannot populate races: Not a valid faction.");
				return -1;
			}
		}
		
		// Now check for Imperial DLC.  If present, add Imperial to end of list.
		if(imperial)
		{
			races[numRaces] = "Imperial";
			numRaces++;
		}
		
		return numRaces;
	}
	
	public int populateClasses()
	{
		int numClasses;
		
		charClasses[0] = "Dragonknight";
		charClasses[1] = "Sorcerer";
		charClasses[2] = "Templar";
		charClasses[3] = "Nightblade";
		
		if(morrowind) {
			charClasses[4] = "Warden";
			numClasses = 5;
		}
		else {
			numClasses = 4;
		}
		
		return numClasses;
	}
	
	public void randomCharacter()
	{
		// Randomize gender
		randomValue = rand.nextInt(2);
		if(randomValue == 0) {
			character.setGender("Male");
		}
		else {
			character.setGender("Female");
		}
		
		// Randomize faction
		randomValue = rand.nextInt(3);
		int faction = randomValue; // Will be used for race selection
		character.setFaction(factions[randomValue]);
		
		// Randomize character class
		int numClasses = populateClasses();
		randomValue = rand.nextInt(numClasses);
		character.setCharClass(charClasses[randomValue]);
		
		// Determine which faction's races
		int numRaces;
		try{
			switch(faction)
			{
			// Dominion
			case 0:
				numRaces = populateRaces('D');
				break;
			// Covenant
			case 1:
				numRaces = populateRaces('C');
				break;
			// Pact
			case 2:
				numRaces = populateRaces('P');
				break;
			default:
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Cannot select race: Faction number outside range.");
			return;
		}
		
		// Randomize ship class
		randomValue = rand.nextInt(numRaces);
		character.setRace(races[randomValue]);		
	}
	
	public void printCharacter()
	{
		System.out.println("ESO character generated.");
		System.out.println("Gender: " + character.getGender());
		System.out.println("Faction: " + character.getFaction());
		System.out.println("Race: " + character.getRace());
		System.out.println("Class: " + character.getCharClass());
	}
	
	public void generate()
	{
		char input;
		boolean properInput;
		try{
			do{
				System.out.println();
				System.out.print("Do you have the All Races All Factions DLC installed?  (Y/N) ");
				input = (char) System.in.read();
				switch(input)
				{
				case 'Y':
				case 'y':
					araf = true;
					properInput = true;
					break;
				case 'N':
				case 'n':
					araf = false;
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
		
		try{
			do{
				System.out.println();
				System.out.print("Do you have the Imperial race DLC installed?  (Y/N) ");
				input = (char) System.in.read();
				switch(input)
				{
				case 'Y':
				case 'y':
					imperial = true;
					properInput = true;
					break;
				case 'N':
				case 'n':
					imperial = false;
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
		
		try{
			do{
				System.out.println();
				System.out.print("Do you have the Warden class DLC installed?  (Y/N) ");
				input = (char) System.in.read();
				switch(input)
				{
				case 'Y':
				case 'y':
					morrowind = true;
					properInput = true;
					break;
				case 'N':
				case 'n':
					morrowind = false;
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
		
		System.out.println();
		
		randomCharacter();
		printCharacter();
	}
}
