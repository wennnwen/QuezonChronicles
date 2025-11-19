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

---

## 🎯 Balancing changes (implemented)
Below are the balance changes I applied to player characters and some major enemies to make progression clearer and more consistent:

### Player classes (base stats at Level 1)
- Warrior: HP 140 | Stamina 50 | Defense 12 | Attack 18 | Speed 5
  - Level up: +10 HP, +5 Stamina, +1 Defense, +2 Attack
- Mage: HP 70 | MP 120 | Defense 6 | Attack 12 | Speed 18
  - Level up: +5 HP, +8 MP, +1 Defense, +2 Attack
- Bruid: HP 100 | MP 80 | Defense 8 | Attack 12 | Speed 6
  - Level up: +8 HP, +6 MP, +1 Defense, +2 Attack
- Tagalog Monk: HP 110 | Stamina 50 | Defense 8 | Attack 16 | Speed 8
  - Level up: +8 HP, +3 Stamina, +1 Defense, +2 Attack
- Thief: HP 85 | Stamina 60 | Defense 5 | Attack 22 | Speed 14
  - Level up: +6 HP, +3 Stamina, +0 Defense, +2 Attack, +1 Speed

> Note: I updated the `setBaseStats(...)` calls and the per-class `levelStats()` methods to match these numbers in the code.

### Boss / miniboss examples (rebalanced)
- Harbor Sentinel (miniboss): HP 140 | Attack 20 | Defense 14 | Speed 6 | Exp 650
- Old Train Spirit (miniboss): HP 160 | Attack 18 | Defense 10 | Exp 400
- Don Mariano (boss): HP 220 | Attack 30 | Defense 14 | Exp 2000
- Queen Amihan (final boss): HP 240 | Attack 28 | Defense 12 | Speed 20 | Exp 3000

> I intentionally targeted minibosses and named bosses to make them more durable. If you prefer softer progression or more punishing boss fights, I can adjust these numbers (or implement scaling based on player level).

---

