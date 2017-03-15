//
//  STOGen.swift
//  CharGen
//
//  Created by Douglas Pope on 3/14/17.
//  Copyright © 2017 Douglas Pope. All rights reserved.
//

import Foundation

class STOGen
{
    // Declare the arrays
    var factions: [String]
    var charClasses: [String]
    var shipClasses: [String]
    
    // And the randomizer
    var randomValue: Int
    
    // And finally a space to hold the character
    var character: STOChar
    
    // Constructor to populate the faction and character class arrays
    init() {
        // Declare the arrays
        factions = [String]()
        charClasses = [String]()
        shipClasses = [String]()
        
        // Populate the arrays
        factions[0] = "Federation"
        factions[1] = "Klingon"
        factions[2] = "Romulan (Federation aligned)"
        factions[3] = "Romulan (Klingon aligned)"
        factions[4] = "TOS Federation"
        charClasses[0] = "Tactical"
        charClasses[1] = "Science"
        charClasses[2] = "Engineering"
        
        // As ship classes are different by faction, ship class array will be populated once faction is randomly determined.
        
        // And initialize the holding variable
        character = STOChar()
        
        // Finally, the random value has to be initialized
        randomValue = 0
    }
    
    func populateShipClasses(faction: Character) -> Int // F for Fed, K for KDF, R for Romulan.
    {
        switch faction {
        case "F":
            shipClasses[0] = "Cruiser"
            shipClasses[1] = "Escort"
            shipClasses[2] = "Science Vessel"
            return 3
        case "K":
            shipClasses[0] = "Raider"
            shipClasses[1] = "Raptor"
            shipClasses[2] = "Battle Cruiser"
            return 3
        case "R":
            shipClasses[0] = "Warbird"
            // There's only one ship class that meets the specifications.
            return 1
        default:
            return -1
        }
    }
    
    func randomCharacter() // Random faction
    {
        // Randomize faction
        randomValue = Int(arc4random_uniform(5))
        var faction: Int
        faction = randomValue
        character.faction = factions[randomValue]
        
        // Randomize character class
        randomValue = Int(arc4random_uniform(3))
        character.charClass = charClasses[randomValue];
        
        // Determine which faction's ships
        var numShips: Int
        switch faction
        {
        case 0,4:
            numShips = populateShipClasses(faction: "F")
        case 1:
            numShips = populateShipClasses(faction: "K")
        case 2,3:
            numShips = populateShipClasses(faction: "R")
        default:
            return
        }
        
        // Randomize ship class
        randomValue = Int(arc4random_uniform(UInt32(numShips)))
        character.shipClass = shipClasses[randomValue]
    }
    
    func randomCharacter(alignment: Character)
    {
        // Randomize faction within alignment
        if alignment == "F" { // Fed alignment
            repeat {
                randomValue = Int(arc4random_uniform(5))
            } while randomValue != 0 && randomValue != 2 && randomValue != 4 // Throw away KDF-aligned values
        }
        else if alignment == "K" { // KDF alignment
            repeat {
                randomValue = Int(arc4random_uniform(5))
            } while randomValue != 1 && randomValue != 3 // Throw away Fed-aligned values
        }
        else {
            return
        }
        
        var faction: Int
        faction = randomValue
        character.faction = factions[randomValue]
        
        // Randomize character class
        randomValue = Int(arc4random_uniform(3))
        character.charClass = charClasses[randomValue];
        
        // Determine which faction's ships
        var numShips: Int
        switch faction
        {
        case 0,4:
            numShips = populateShipClasses(faction: "F")
        case 1:
            numShips = populateShipClasses(faction: "K")
        case 2,3:
            numShips = populateShipClasses(faction: "R")
        default:
            return
        }
        
        // Randomize ship class
        randomValue = Int(arc4random_uniform(UInt32(numShips)))
        character.shipClass = shipClasses[randomValue]
    }
    
    func randomCharacter(factionPicked: Int)
    {
        var faction: Int
        faction = factionPicked
        character.faction = factions[factionPicked]
        
        // Randomize character class
        randomValue = Int(arc4random_uniform(3))
        character.charClass = charClasses[randomValue];
        
        // Determine which faction's ships
        var numShips: Int
        switch faction
        {
        case 0,4:
            numShips = populateShipClasses(faction: "F")
        case 1:
            numShips = populateShipClasses(faction: "K")
        case 2,3:
            numShips = populateShipClasses(faction: "R")
        default:
            return
        }
        
        // Randomize ship class
        randomValue = Int(arc4random_uniform(UInt32(numShips)))
        character.shipClass = shipClasses[randomValue]
    }
}
