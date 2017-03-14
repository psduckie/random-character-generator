using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CharGen
{
    class ESOGen
    {
        // Declare the arrays
        private String[] factions;
        private String[] charClasses;
        private String[] races;

        // And the randomizer
        private Random rand;
        private int randomValue;

        // Flags for certain DLC
        public bool imperial;
        public bool araf;

        // And finally a space to hold the character
        public ESOChar character;

        // Constructor to populate the faction and character class arrays
        public ESOGen()
        {
            // Initialize the randomizer
            rand = new Random();

            // Declare the arrays
            factions = new String[3];
            charClasses = new String[4];
            races = new String[10];

            // Populate the arrays
            factions[0] = "Aldmeri Dominion";
            factions[1] = "Daggerfall Covenant";
            factions[2] = "Ebonheart Pact";
            charClasses[0] = "Dragonknight";
            charClasses[1] = "Sorcerer";
            charClasses[2] = "Templar";
            charClasses[3] = "Nightblade";

            // As some race/faction combinations are locked behind DLC, race array will be populated once faction is randomly determined.

            // Mark both DLC flags as off by default
            araf = false;
            imperial = false;

            // And initialize the holding area
            character = new ESOChar();
        }

        public int populateRaces(char faction) // D for Dominion, C for Covenant, P for Pact
        {
            int numRaces;

            // Check for ARAF DLC
            if (araf)
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
                try
                {
                    switch (faction)
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
                            throw new Exception();
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine("Cannot populate races: Not a valid faction.");
                    return -1;
                }
            }

            // Now check for Imperial DLC.  If present, add Imperial to end of list.
            if (imperial)
            {
                races[numRaces] = "Imperial";
                numRaces++;
            }

            return numRaces;
        }

        public void randomCharacter()
        {
            // Randomize faction
            randomValue = rand.Next(3);
            int faction = randomValue; // Will be used for race selection
            character.faction = factions[randomValue];

            // Randomize character class
            randomValue = rand.Next(4);
            character.charClass = charClasses[randomValue];

            // Determine which faction's races
            int numRaces;
            try
            {
                switch (faction)
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
                        throw new Exception();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Cannot select race: Faction number outside range.");
                return;
            }

            // Randomize race
            randomValue = rand.Next(numRaces);
            character.race = races[randomValue];
        }
    }
}
