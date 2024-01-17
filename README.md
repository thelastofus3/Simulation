# Simulation Game README

This simulation game is a simple ecosystem simulation where predators (tigers) and herbivores (penguins) move around the map interacting with static objects (rocks, trees, grass). The simulation includes features like spawning entities, random movement, and a basic game loop.

## Project Structure

- **com.simulation.actions** - package containing classes for spawning different entities.
  - `GrassSpawn` - class for spawning grass entities.
  - `RockSpawn` - class for spawning rock entities.
  - `TreeSpawn` - class for spawning tree entities.
  - `SpawnActions` - interface with default methods for getting random coordinates and spawning entities.

- **com.simulation.essence** - package containing classes for different entities.
  - `Creature` - abstract class representing creatures with health, speed, and movement logic.
  - `Entity` - base class representing any object in the simulation.
  - `Herbivore` - class representing herbivores (e.g., penguins).
  - `Predator` - class representing predators (e.g., tigers).
  - `Grass` - class representing grass objects.
  - `Rock` - class representing rock objects.
  - `Tree` - class representing tree objects.

- **com.simulation** - package containing main classes for the simulation.
  - `Coordinates` - class representing coordinates on the map.
  - `Main` - main class to start the simulation.
  - `Map` - class representing the map with entities and basic operations.
  - `MapRender` - class for rendering the map in the console.
  - `Simulation` - class managing the game simulation, spawning entities, and handling user input.

## How to Play

1. Run the `Main` class to start the simulation.
2. Press `1` for a single move or `2` for infinite moves.
3. Observe the movement and interactions between predators, herbivores, and static objects.

## Entities and Objects

- **Herbivore (Penguin):** Represented by 🐧
  - Moves towards grass entities.
  - Cannot pass through rocks, trees, other herbivores, or predators.

- **Predator (Tiger):** Represented by 🐅
  - Moves towards herbivores.
  - Cannot pass through grass, rocks, trees, or other predators.

- **Grass:** Represented by 🌿
  - Static object that herbivores move towards.

- **Rock:** Represented by 🚨
  - Static object that blocks movement for herbivores and predators.

- **Tree:** Represented by 🌳
  - Static object that blocks movement for herbivores and predators.

## Game Loop Options

- **Single Move (`1`):** Pressing `1` allows you to observe one move of each entity.

- **Infinite Moves (`2`):** Pressing `2` starts an infinite loop where entities continuously move, and the console updates every second.

## Note

- The game has a predefined map size of 10x10.
- The simulation stops when either the herbivore or predator cannot make a move, indicating a win for one of the entities.

