//
//  ESOGen.swift
//  CharGen
//
//  Created by Douglas Pope on 3/14/17.
//  Copyright © 2017 Douglas Pope. All rights reserved.
//

import Foundation

class ESOGen
{
    // Declare the arrays
    var factions: [String]
    var charClasses: [String]
    var races: [String]
    
    // And the randomizer
    // There is a randomizer property in the C# version, but is it needed in Swift?
    var randomValue: Int
    
    // Flags for certain DLC
    var imperial: Bool
    var araf: Bool
    
    // And finally a space to hold the character
    var character: ESOChar
    
    // Constructor to populate the faction and character class arrays
    init() {
        // In the C# version, the randomizer is initialized here
        
        factions = [String]()
        charClasses = [String]()
        races = [String]()
        
        // Populate the arrays
        factions[0] = "Aldmeri Dominion"
        factions[1] = "Daggerfall Covenant"
        factions[2] = "Ebonheart Pact"
        charClasses[0] = "Dragonknight"
        charClasses[1] = "Sorcerer"
        charClasses[2] = "Templar"
        charClasses[3] = "Nightblade"
        
        // As some race/faction combinations are locked behind DLC, race array will be populated once faction is randomly determined.
        
        // Mark both DLC flags as off by default
        araf = false
        imperial = false
        
        // And initialize the holding area
        character = ESOChar()
        
        // Finally, the random value has to be initialized
        randomValue = 0
    }
    
    func populateRaces(faction: Character) -> Int // D for Dominion, C for Covenant, P for Pact
    {
        var numRaces: Int
        
        // Check for ARAF DLC
        if araf {
            races[0] = "Altmer"
            races[1] = "Bosmer"
            races[2] = "Khajiit"
            races[3] = "Breton"
            races[4] = "Redguard"
            races[5] = "Orsimer"
            races[6] = "Dunmer"
            races[7] = "Nord"
            races[8] = "Argonian"
            numRaces = 9
        }
        else
        {
            switch faction {
            case "D":
                races[0] = "Altmer"
                races[1] = "Bosmer"
                races[2] = "Khajiit"
                numRaces = 3
            case "C":
                races[0] = "Breton"
                races[1] = "Redguard"
                races[2] = "Orsimer"
                numRaces = 3
            case "P":
                races[0] = "Dunmer"
                races[1] = "Nord"
                races[2] = "Argonian"
                numRaces = 3
            default:
                return -1
                
            }
        }
        
        // Now check for Imperial DLC.  If present, add Imperial to end of list.
        if imperial
        {
            races[numRaces] = "Imperial"
            numRaces = numRaces + 1
        }
        
        return numRaces;
    }
    
    func randomCharacter()
    {
        // Randomize faction
        randomValue = Int(arc4random_uniform(3))
        var faction: Int
        faction = randomValue
        character.faction = factions[randomValue]
        
        // Randomize character class
        randomValue = Int(arc4random_uniform(4))
        character.charClass = charClasses[randomValue]
        
        // Determine which faction's races
        var numRaces: Int
        switch faction{
        case 0: // Dominion
            numRaces = populateRaces(faction: "D")
        case 1: // Covenant
            numRaces = populateRaces(faction: "C")
        case 2: // Pact
            numRaces = populateRaces(faction: "P")
        default:
            return
        }
        
        // Randomize race
        randomValue = Int(arc4random_uniform(UInt32(numRaces)))
        character.race = races[randomValue]
    }
}
