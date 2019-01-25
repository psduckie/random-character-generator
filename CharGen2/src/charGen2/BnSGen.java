package charGen2;

import java.util.Random;

public class BnSGen {
	// Declare the arrays
	private String[] factions;
	private String[] charClasses;
	private String[] races;
	
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
	
	public BnSGen()
	{
		// Initialize the randomizer
		rand = new Random();
		
		// Declare the arrays
		factions = new String[2];
		charClasses = new String[11];
		races = new String[4];
		
		// Populate the faction array
		factions[0] = "Cerulean Order";
		factions[1] = "Crimson Legion";
		
		// Populate the class array
		charClasses[0] = "Assassin";
		charClasses[1] = "Blade Master";
		charClasses[2] = "Destroyer";
		charClasses[3] = "Force Master";
		charClasses[4] = "Kung Fu Master";
		charClasses[5] = "Summoner";
		charClasses[6] = "Blade Dancer";
		charClasses[7] = "Warlock";
		charClasses[8] = "Soul Fighter";
		charClasses[9] = "Gunslinger";
		charClasses[10] = "Warden";

		// And initialize the holding area
		character = new BnSChar();
	}
	
	public int populateRaces(String charClass)
	{
		try {
			switch(charClass)
			{
			case "Assassin":
				races[0] = "Jin";
				return 1;
			case "Blade Master":
				races[0] = "Jin";
				races[1] = "Yun";
				return 2;
			case "Destroyer":
				races[0] = "Gon";
				return 1;
			case "Force Master":
				races[0] = "Gon";
				races[1] = "Yun";
				races[2] = "Lyn";
				return 3;
			case "Kung Fu Master":
				races[0] = "Gon";
				races[1] = "Jin";
				races[2] = "Yun";
				return 3;
			case "Summoner":
				races[0] = "Lyn";
				return 1;
			case "Blade Dancer":
				races[0] = "Lyn";
				return 1;
			case "Warlock":
				races[0] = "Jin";
				races[1] = "Lyn";
				return 2;
			case "Soul Fighter":
				races[0] = "Gon";
				races[1] = "Jin";
				races[2] = "Yun";
				return 3;
			case "Gunslinger":
				races[0] = "Jin";
				races[1] = "Yun";
				races[2] = "Lyn";
				return 3;
			case "Warden":
				races[0] = "Gon";
				races[1] = "Jin";
				races[2] = "Lyn";
				return 3;
			default:
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.print("Cannot populate races: Not a valid class.");
			return -1;
		}
	}
	
	public void randomCharacter()
	{
		// Randomize faction
		switch(side)
		{
		case 'O':
		case 'o':
			character.setFaction("Cerulean Order");
			break;
		case 'L':
		case 'l':
			character.setFaction("Crimson Legion");
			break;
		default:
			randomValue = rand.nextInt(2);
			character.setFaction(factions[randomValue]);
		}
		
		// Randomize class
		randomValue = rand.nextInt(11);
		character.setCharClass(charClasses[randomValue]);
		
		// Populate races
		int numRaces = populateRaces(character.getCharClass());
		
		// Randomize race
		randomValue = rand.nextInt(numRaces);
		character.setRace(races[randomValue]);
		
		// Randomize gender
		if(character.getRace() == "Yun")
		{
			character.setGender("Female"); // Yun are always female
		}
		else
		{
			randomValue = rand.nextInt(2);
			if(randomValue == 0)
			{
				character.setGender("Male");
			}
			else
			{
				character.setGender("Female");
			}
		}
	}
	
	public void printCharacter()
	{
		System.out.println("BnS character generated.");
		System.out.println("Gender: " + character.getGender());
		System.out.println("Faction: " + character.getFaction());
		System.out.println("Race: " + character.getRace());
		System.out.println("Class: " + character.getCharClass());
	}
	
	public void generate()
	{
		char input;
		boolean properInput;
		System.out.println();
		try {
			do {
				System.out.println();
				System.out.print("Do you want to include Cerulean (O)rder characters, Crimson (L)egion characters, or (B)oth? ");
				input = (char) System.in.read();
				switch(input)
				{
				case 'O':
				case 'o':
					side = 'O';
					properInput = true;
					break;
				case 'L':
				case 'l':
					side = 'L';
					properInput = true;
					break;
				case 'B':
				case 'b':
					side = 'B';
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
		
		randomCharacter();
		printCharacter();
	}
}
