using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CharGen
{
    class STOGen
    {
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
            try
            {

                switch (faction)
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
                        throw new Exception();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Cannot populate ship classes: Not a valid faction.");
                return -1;
            }
        }

        public void randomCharacter() // Random faction
        {
            // Randomize faction
            randomValue = rand.Next(5);
            int faction = randomValue; // Will be used for ship selection
            character.faction = factions[randomValue];

            // Randomize character class
            randomValue = rand.Next(3);
            character.charClass = charClasses[randomValue];

            // Determine which faction's ships
            int numShips;
            try
            {
                switch (faction)
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
                        throw new Exception();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Cannot select ship faction: Faction number outside range.");
                return;
            }

            // Randomize ship class
            randomValue = rand.Next(numShips);
            character.shipClass = shipClasses[randomValue];
        }

        public void randomCharacter(char alignment) // Specific alignment.  F for Fed, K for KDF
        {
            // Randomize faction within alignment
            if (alignment == 'F') // Fed alignment
            {
                do
                {
                    randomValue = rand.Next(5);
                } while (randomValue != 0 && randomValue != 2 && randomValue != 4); // Throw away values that lead to KDF alignment
            }
            else if(alignment == 'K') // KDF alignment
            {
                do
                {
                    randomValue = rand.Next(5);
                } while (randomValue != 1 && randomValue != 3); // Throw away values that lead to Fed alignment
            }
            else
            {
                Console.WriteLine("Invalid alignment.");
                return;
            }

            int faction = randomValue; // Will be used for ship selection
            character.faction = factions[randomValue];

            // Randomize character class
            randomValue = rand.Next(3);
            character.charClass = charClasses[randomValue];

            // Determine which faction's ships
            int numShips;
            try
            {
                switch (faction)
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
                        throw new Exception();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Cannot select ship faction: Faction number outside range.");
                return;
            }

            // Randomize ship class
            randomValue = rand.Next(numShips);
            character.shipClass = shipClasses[randomValue];
        }

        public void randomCharacter(int factionPicked) // Specific faction.
        {
            int faction = factionPicked; // Will be used for ship selection
            character.faction = factions[factionPicked];

            // Randomize character class
            randomValue = rand.Next(3);
            character.charClass = charClasses[randomValue];

            // Determine which faction's ships
            int numShips;
            try
            {
                switch (faction)
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
                        throw new Exception();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Cannot select ship faction: Faction number outside range.");
                return;
            }

            // Randomize ship class
            randomValue = rand.Next(numShips);
            character.shipClass = shipClasses[randomValue];
        }
    }
}
