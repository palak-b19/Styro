# StickHeroAP

Overview:
The Stick Hero Game is a Java application designed to simulate a gaming experience where
players control a stick to cross platforms and reach different levels. The game includes features
such as extending and falling sticks, hero walking animation, and platform shifting.
Project Structure:
The project consists of the following key classes and interfaces:
1. GameController - Manages the overall game logic, including stick and hero actions.
2. BaseController - Represents a base controller class for the game.
3. RectangleLengthExtension - Provides functionality for extending the stick vertically.
4. Stick - Represents the stick in the game.
5. Hero - Represents the game character (hero) in the Stick Hero game.
6. GamePauseController - Manages the game pause screen.
Functionality:


GameController Functions:
1. Shift Platform: Moves the game platforms horizontally.
2. Start Extension: Initiates the stick extension when the mouse is pressed.
3. Pause Game: Pauses the game and navigates to the pause screen.
4. Quit Game: Quits the game and returns to the home page.
- Stick and Hero Actions:
- Extend Stick Vertically: Allows the player to extend the stick vertically.
- Fall Stick: Simulates the fall of the stick after extension.
- Hero Walk: Animates the hero's walking movement.
Assumptions:
1. The initial stick height is set to 0.0.
2. Certain flags (e.g., stick_extend_flag, stick_fall_flag) control the game's flow.
3. Specific conditions trigger stick extension, falling, and hero walking.
4. The platformShiftSpeed variable controls the speed of platform movement.
5. Various flags control hero animations and platform translations.
OOPS Concepts Used:
1.Inheritance: BaseController is extended by GameController, demonstrating the inheritance
concept.
2. Polymorphism:GameController uses various methods for stick and hero actions, showcasing
polymorphic behavior.
3. Abstraction: Stick and Hero classes abstract the complexity of stick and hero actions,
providing a higher-level view.
4. Encapsulation: Private fields and methods encapsulate the internal state and behavior of
GameController and related classes.
5. Composition: The GameController class uses composition to manage Stick and Hero
instances, creating a more modular design.
6.Multithreading - Implemented while using sound effects
7.Written three junit tests
8. All the pages are linked and switched using fxmls
9. All the appropriate components like hero generation has been taken for
