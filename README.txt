This is a recreation of the game Stick Hero made in JavaFX

Controls and gameplay instructions :

- Press and hold the ctrl key on the keyboard to extend the stick and then
  release ctrl to make the stick fall on to the next platform.

- The player will move on to the next platform if the stick length is correct.

- You can press the shift key on the keyboard to invert the player and collect
  coins that are randomly generated. If the player collides with the next pillar
  while inverted, the game ends.

- These collected coins can then be used to revive the player and continue the game.
  It takes 2 coins to revive the player.

- The game can also be saved and loaded on pressing the pause button and opening the
  pause menu.

Design Patterns employed :

- Singleton : used for getting the single instance of a random number generator
              so that it has only a single instance and does not need to be created
              again and again.

- Chain of Responsibility : actions have been passed through a chain of responsibility in the
                            set on key released handler. A different handler handles the events
                            after completion of its predecessor.

Github Link :

Intermediate files Repository : https://github.com/BingoBoy479/Stick-hero.git
Final Repository : https://github.com/pluto-tofu/Stick_Hero_2022343_2022479.git
