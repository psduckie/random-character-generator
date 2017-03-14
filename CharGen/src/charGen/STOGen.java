package charGen;

import java.util.Random;

public class STOGen {
	// Declare the arrays
	private String[] factions;
	private String[] charClasses;
	private String[] shipClasses;
	
	// And the randomizer
	private Random rand;
	private int randomValue;
	
	// And finally a space to hold the character
	public STOChar character;
	
	// Constructor to populate the faction and character class arrays
	public STOGen()
	{
		// Initialize the randomizer
		rand = new Random();
		
		// Declare the arrays
		factions = new String[5];
		charClasses = new String[3];
		shipClasses = new String[3];
		
		// Populate the arrays
		factions[0] = "Federation";
		factions[1] = "Klingon";
		factions[2] = "Romulan (Federation aligned)";
		factions[3] = "Romulan (Klingon aligned)";
		factions[4] = "TOS Federation";
		charClasses[0] = "Tactical";
		charClasses[1] = "Science";
		charClasses[2] = "Engineering";
		
		// As ship classes are different by faction, ship class array will be populated once faction is randomly determined.
		
		// And initialize the holding variable
		character = new STOChar();
	}
	
	public int populateShipClasses(char faction) // F for Fed, K for KDF, R for Romulan.  Returns the number of possible classes that have ships from T2 and up.
	{
		try{
			
			switch(faction)
			{
			case 'F':
				shipClasses[0] = "Cruiser";
				shipClasses[1] = "Escort";
				shipClasses[2] = "Science Vessel";
				return 3;
			case 'K':
				shipClasses[0] = "Raider";
				shipClasses[1] = "Raptor";	
				shipClasses[2] = "Battle Cruiser";
				return 3;
			case 'R':
				shipClasses[0] = "Warbird";
				// There's only one ship class that meets the specifications.
				shipClasses[1] = null;
				shipClasses[2] = null;
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
	
	public void randomCharacter()
	{
		// Randomize faction
		randomValue = rand.nextInt(5);
		int faction = randomValue; // Will be used for ship selection
		character.faction = factions[randomValue];
		
		// Randomize character class
		randomValue = rand.nextInt(3);
		character.charClass = charClasses[randomValue];
		
		// Determine which faction's ships
		int numShips;
		try{
			switch(faction)
			{
			// Federation ships
			case 0:
			case 4:
				numShips = populateShipClasses('F');
				break;
			// Klingon ships
			case 1:
				numShips = populateShipClasses('K');
				break;
			// Romulan ships
			case 2:
			case 3:
				numShips = populateShipClasses('R');
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
		character.shipClass = shipClasses[randomValue];
	}
	
	public void printCharacter()
	{
		System.out.println("STO character generated.");
		System.out.println("Faction: " + character.faction);
		System.out.println("Character class: " + character.charClass);
		System.out.println("Ship class: " + character.shipClass);
	}
	
	public void generate()
	{
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
