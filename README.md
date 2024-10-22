# Text Battle Adventure

![Java](https://img.shields.io/badge/Java-11%2B-blue) 
![License](https://img.shields.io/badge/license-MIT-green)
![Contributions](https://img.shields.io/badge/contributions-welcome-brightgreen)

**Text Battle Adventure** is a fully-featured, interactive, text-based RPG written in Java. Players can choose from various character classes, battle dangerous monsters, and utilize a wide array of items like potions to enhance their gameplay.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [License](#license)

## Features

- **Character Classes**: Choose from four distinct classes, each with unique abilities:
  - Mage
  - Ninja
  - Rogue
  - Warrior
- **Item System**: Use different types of potions (health, mana, strength, poison) to gain advantages in battles.
- **Turn-based Combat**: Engage in tactical battles with monsters.
- **Simple and Customizable**: The game is text-based and easily customizable for those who want to extend the game or add features.

## Project Structure

- TextBattleAdventure/
  ─ .classpath              # IDE-specific project file for Eclipse
  ─ .gitignore              # Files to be ignored by Git
  ─ .project                # Eclipse project settings
  ─ src/                    # Source code directory
    ─ Battle.java         # Core battle mechanics
    ─ HealthPotion.java   # Defines health potion functionality
    ─ ManaPotion.java     # Defines mana potion functionality
    ─ PoisonPotion.java   # Defines poison potion functionality
    ─ StrengthPotion.java # Defines strength potion functionality
    ─ Item.java           # Base class for all items
    ─ Player.java         # Defines player properties and methods
    ─ Monster.java        # Defines monster properties and methods
    ─ Mage.java           # Mage class with unique abilities
    ─ Ninja.java          # Ninja class with unique abilities
    ─ Rogue.java          # Rogue class with unique abilities
    ─ Warrior.java        # Warrior class with unique abilities

## License

This project is licensed under the MIT License.


