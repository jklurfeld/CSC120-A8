Use this file to record your reflection on this assignment.

- Tell me about your class! What does it represent?
My class represents a player in a video game, and in my game you play as a cat. The methods do similar things to the way you navigate buildings by going up and down floors in the Building class that we implemented last week, where there are print statements telling the player where they are and what has happened. Attributes that the cat has includes a name, x and y coordinates, they have an inventory so they can hold multiple objects, a size, and an energy level. The energy level decreases each time they fly or walk, and they can't go anywhere if their energy is at 0. If their energy reaches 0, they must rest or use items in their inventory. If they call the use method, then it calls the eat method, so they consume the item for energy.

- What additional methods (if any) did you implement alongside those listed in the interface?
I implemented getter methods for each of my attributes, and a setter for the name attribute because I thought that was the only thing that should be able to be modified. I implemented the eat method as explained above. I also implemented the printInventory method so the user could see what was contained in their inventory, and I thought this would be more helpful method to have than the getInventory() method which is just going to return the memory location of the inventory.

- What worked, what didn't, what advice would you give someone taking this course in the future?
The hardest method to implement was the undo method, because I had to come up with a way to keep track of the last method called and how to undo it. It made me regret adding additional functionality and attributes, because now I had more things for myself to undo!