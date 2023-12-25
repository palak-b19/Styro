# StickHeroAP

# Overview
The Stick Hero Game is a Java application that offers an immersive gaming experience. Players control a stick to navigate platforms and progress through different levels. The game features extending and falling sticks, hero walking animations, and platform shifting.

# Project Structure
The project is organized into key classes and interfaces:

1. **GameController**: Manages overall game logic, including stick and hero actions.
2. **BaseController**: Serves as a base controller class for the game.
3. **RectangleLengthExtension**: Provides functionality for vertically extending the stick.
4. **Stick**: Represents the stick in the game.
5. **Hero**: Represents the game character (hero) in Stick Hero.
6. **GamePauseController**: Manages the game pause screen.

# Functionality

# GameController Functions
1. **Shift Platform**: Moves the game platforms horizontally.
2. **Start Extension**: Initiates stick extension when the mouse is pressed.
3. **Pause Game**: Pauses the game and navigates to the pause screen.
4. **Quit Game**: Quits the game and returns to the home page.

# Stick and Hero Actions
- **Extend Stick Vertically**: Allows the player to vertically extend the stick.
- **Fall Stick**: Simulates the fall of the stick after extension.
- **Hero Walk**: Animates the hero's walking movement.

# Assumptions
1. The initial stick height is set to 0.0.
2. Flags (e.g., `stick_extend_flag`, `stick_fall_flag`) control the game's flow.
3. Specific conditions trigger stick extension, falling, and hero walking.
4. The `platformShiftSpeed` variable controls the speed of platform movement.
5. Various flags control hero animations and platform translations.

# OOPS Concepts Used
1. **Inheritance**: `BaseController` is extended by `GameController`, demonstrating the inheritance concept.
2. **Polymorphism**: `GameController` uses various methods for stick and hero actions, showcasing polymorphic behavior.
3. **Abstraction**: `Stick` and `Hero` classes abstract the complexity of stick and hero actions, providing a higher-level view.
4. **Encapsulation**: Private fields and methods encapsulate the internal state and behavior of `GameController` and related classes.
5. **Composition**: The `GameController` class uses composition to manage `Stick` and `Hero` instances, creating a more modular design.
6. **Multithreading**: Implemented while using sound effects.
7. **JUnit Tests**: Three JUnit tests have been written to ensure code correctness.
8. **FXML Integration**: All pages are linked and switched using FXML files.
9. **Component Reusability**: Appropriate components like hero generation have been taken into account for a more modular design.


