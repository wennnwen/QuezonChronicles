# QuezonChronicles
A console-based, text RPG inspired by Filipino culture and folklore. Players create a character and choose a path across the province—fighting local monsters, collecting items, and upgrading skills as they progress.

---

## ⚔️ Features
- Choose from five playable classes: Bruid, Mage, Tagalog Monk, Thief, and Warrior.
- Turn-based combat system with stamina/MP mechanics, status effects (poison, burn, stun, etc.), and skill cooldowns.
- Two branching main paths: West Side (Lucban -> Lucena -> ... -> Tiaong) and East Side (Gumaca -> Lopez -> ... -> Real).
- Town exploration with enemies, minibosses, boss fights, and lootable items (Filipino-themed consumables).
- Simple save-like progression when moving between towns (path & progress tracking).

---

## 🧭 Project structure (important files)
- `Main/Main.java` — Entry point: instantiates `Game` and calls `start()`.
- `Main/game/Game.java` — Top-level menu and launcher for starting the game or viewing About.
- `Main/game/GameMenu.java` — Character creation, main menu, and path choice.
- `Main/game/BattleSystem.java` — Implements the turn-based combat loop.
- `Main/worldBuilder/WorldMap.java` — Builds the West and East paths and towns.
- `Main/worldBuilder/Town.java` — Town exploration, enemies, and travel between towns.
- `Main/character/Character.java` — Base class for `Player` and `Enemy`.
- `Main/character/player/Player.java` — Base player class; contains inventory, moves, leveling, and progress tracking.
- `Main/character/player/classes/*` — Five player classes implementing class-specific behavior.
- `Main/character/enemy/Enemy.java` — Base enemy with drop and debuff logic; many enemy subclasses under `subclasses/`.
- `Main/item/*.java` — Consumable items used in battles and exploration.
- `Main/styles/` — Utilities for typewriter effects, text color, clearing screen, and print alignment.

---

## ▶️ How to compile & run

Prereqs: JDK 11+ (Java 11 or later) installed.

Clone (if necessary) then from project root run:

```bash
# create sources list and compile to 'out' directory
find Main -name "*.java" > sources.txt
javac -d out @sources.txt

# run the entrypoint
java -cp out Main.Main
```

Tip: Running `javac` this way compiles all project files. If you want to target a single package change, re-run `find` before compiling again.

---

## 🎮 Gameplay quick-start & controls
- On start, you can Create Character or view About. Create a name and choose a class.
- Player classes affect HP, MP/Stamina usage, attacks, and unique skills.
- Combat: choose attack moves (1–4), or use items (5). Player and enemy turn order depends on speed.
- Action requirements: some moves need stamina/MP and some have cooldowns.
- Towns: explore to fight enemies and bosses; defeat enemies in town to progress to the next town.

---

## 📦 Items & Enemies
- Items are under `Main/item` and include Filipino-themed consumables (e.g., `Bibingka`, `Lambanog`, `PugonCoffee`) — they typically heal HP/MP or provide buffs.
- Enemies and bosses are under `Main/character/enemy/subclasses/` with varied behaviors and drops.

---

## 🛠️ Extending the game
- Add new enemy subclasses by implementing `Enemy` and adding them in `WorldMap` for towns.
- Create new items in `Main/item` extending `Item`, then add them to enemy loot tables.
- Add map or town variations by updating `WorldMap.buildWestPath()` or `WorldMap.buildEastPath()`.

---

## ♻️ Misc & Developer notes
- Styling utilities: `Main/styles/*` — look at `TypeWriter`, `TextColorHub`, and `CenterHub` for console effects.
- The `Player` system stores path progress; death resets player using `Player.resetProgress()`.
- Inventory is static across `Player` instances (currently sized 10).
