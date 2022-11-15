import java.util.ArrayList;

public class Cat implements Contract{

    /* Attributes */
    String name;
    int xCoordinate;
    int yCoordinate;
    ArrayList<String> inventory;
    int size;
    int energy;
    String lastMethod;
    int lastX;
    int lastY;

    /* Constructor */
    public Cat(String name){
        this.name = name;
        xCoordinate = 0;
        yCoordinate = 0;
        inventory = new ArrayList<String>();
        size = 100;
        energy = 100;
    }

    /* Accessor for name attribute
     * @return String name of this Cat
     */
    public String getName(){
        return name;
    }

    /* Accessor for xCoordinate attribute
     * @return int xCoordinate of this Cat
     */
    public int getXCoordinate(){
        return xCoordinate;
    }

    /* Accessor for yCoordinate attribute
     * @return int yCoordinate of this Cat
     */
    public int getYCoordinate(){
        return yCoordinate;
    }

    /* Accessor for inventory
     * @return ArrayList inventory of this Cat
     */
    public ArrayList<String> getInventory(){
        return inventory;
    }

    /* Accessor for size
     * @return int size of this Cat
     */
    public int getSize(){
        return size;
    }

    /* Accessor for energy
     * @return int energy of this Cat
     */
    public int getEnergy(){
        return energy;
    }

    /* Manipulator for the name attribute
     * @param String newName will be the newName of this Cat
     * @return String returns the updated name of this Cat
     */
    public String setName(String newName){
        lastMethod = "setName_" + name;
        name = newName;
        return name;
    }

    /* Prints the player/cat's inventory */
    public void printInventory(){
        lastMethod = "printInventory";
        System.out.println("Your inventory contains the following items:");
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i));
        }
    }

    /* Grabs an item and puts it in the inventory
     * @param String item that you want to grab
     */
    public void grab(String item){
        if (inventory.size() < 5){
            inventory.add(item);
            System.out.println("You have grabbed this " + item + " and it is now in your inventory. There are currently " + inventory.size() + "/5 items in your inventory.");
            lastMethod = "grab_" + item;
        }
        else{
            System.out.println("You have no more space in your inventory. Drop one of your items in order to pick this one up.");
        }
    }

    /* Drops an item and removes it from the inventory
     * @param String item that you want to drop
     * @return String item that has been dropped
     */
    public String drop(String item){
        if (inventory.contains(item)){
            inventory.remove(item);
            System.out.println("You have dropped this " + item + " and it has been removed from your inventory. There are currently " + inventory.size() + "/5 items in your inventory.");
            lastMethod = "drop_" + item;
        }
        else{
            System.out.println("There was no item found called " + item + " in your inventory. Please try again.");
        }
        return item;
    }

    /* Examines the given item
     * @param String item is the item to be examined
     */
    public void examine(String item){
        System.out.println("Examining this " + item + "...");
        lastMethod = "examine";
        //maybe add some sort of log that they have so they can log which items they've examined
    }

    /* Calls the eat method
     * @String item to be eaten
     */
    public void use(String item){
        this.eat(item);
    }

    /* Makes the cat eat the given item (which increases their energy) if they have it in their inventory
     * @param String item is the item to be eaten
     */
    public void eat(String item){
        if (inventory.contains(item)){
            energy++;
            inventory.remove(item);
            System.out.println("You have consumed this " + item + ". Energy +1! \nEnergy level: " + energy + "/100.");
            lastMethod = "eat_" + item;
        }
        else{
            System.out.println("You do not have a " + item + " in your inventory.");
        }
    }

    /* Makes the cat walk in the direction provided
     * @param String direction is the direction to the direction to be walked in
     * @return boolean returns true if the cat was able to sucessfully walk in the direction provided
     */
    public boolean walk(String direction){
        if (energy > 1){
            if (direction.equals("north")){
                yCoordinate += 1;
                energy--;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                System.out.println("Energy level: " + energy + "/100.");
                lastMethod = "walk_north";
                return true;
            }
            else if (direction.equals("south")){
                yCoordinate -= 1;
                energy--;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                System.out.println("Energy level: " + energy + "/100.");
                lastMethod = "walk_south";
                return true;
            }
            else if (direction.equals("east")){
                xCoordinate += 1;
                energy--;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                System.out.println("Energy level: " + energy + "/100.");
                lastMethod = "walk_east";
                return true;
            }
            else if (direction.equals("west")){
                xCoordinate -= 1;
                energy--;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                System.out.println("Energy level: " + energy + "/100.");
                lastMethod = "walk_west";
                return true;
            }
            else {
                System.err.println("Please enter a cardinal direction (north, south, east, west)");
                return false;
            }
        }
        else{
            System.out.println("Your energy levels are too low to walk. You are still at" + xCoordinate + ", " + yCoordinate + "). Please rest and try again.");
            return false;
        }
    }

    /* Flys to the given location
     * @param int x is the x-coordinate of the location to be flown to
     * @param int y is the y-cooordinate of the location to be flown to
     * @return boolean returns true if the fly was successful
     */
    public boolean fly(int x, int y){
        int xDistance = Math.abs(xCoordinate - x);
        int yDistance = Math.abs(yCoordinate - y);
        lastMethod = "fly_" + xCoordinate + "." + yCoordinate + "*" + energy;
        if (energy > (xDistance + yDistance)){
            xCoordinate = x;
            yCoordinate = y;
            energy -= (xDistance + yDistance);
            System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
            System.out.println("Energy level: " + energy + "/100.");
            return true;
        }
        else {
            System.out.println("Your energy levels are too low to fly to this location. You are still at" + xCoordinate + ", " + yCoordinate + "). Please rest and try again.");
            return false;
        }
    }

    /* Shrinks the cat/player by decreasing their size
     * @return Number representing current size of the cat/player
     */
    public Number shrink(){
        if (size - 10 > 0){
            lastMethod = "shrink_" + size;
            size -= 10;
            System.out.println("Shrinking...");
            System.out.println("You are now " + size + "% of your original size.");
        }
        else {
            System.out.println("You cannot be shrunk any smaller. You are still 10% of your original size");
        }
        return size;
    }

    /* Grows the cat/player by increasing their size
     * @return Number representing current size of the cat/player
     */
    public Number grow(){
        lastMethod = "grow_" + size;
        size += 10;
        System.out.println("Growing...");
        System.out.println("You are now " + size + "% of your original size.");
        return size;
    }

    /* The cat rests so their energy levels are replenished */
    public void rest(){
        lastMethod = "rest_" + energy;
        energy = 100;
        System.out.println("Resting... \nEnergy level: 100/100.");
    }

    /* Logically undos the previous method call so the previous states of attributes are restored */
    public void undo(){
        String param = lastMethod.substring(lastMethod.indexOf("_")+1);
        if (lastMethod.contains("setName")){
            name = lastMethod.substring(lastMethod.indexOf("_")+1);
            System.out.println("Undoing setName...\nYour name has been restored to " + param + ".");
        }
        else if (lastMethod.contains("grab")){
            System.out.println("Undoing grab()...");
            this.drop(param);
        }
        else if (lastMethod.contains("drop")){
            System.out.println("Undoing drop()...");
            this.grab(param);
        }
        else if (lastMethod.contains("eat")){
            System.out.println("Undoing eat()...");
            inventory.add(param);
            energy--;
            System.out.println(param + " has been restored to your inventory. There are currently " + inventory.size() + "/5 items in your inventory.");
            System.out.println("Energy level: " + energy + "/100.");
        }
        else if (lastMethod.contains("walk")){
            energy++;
            System.out.println("Undoing walk()...");
            if (lastMethod.contains("north")){
                yCoordinate--;
            }
            else if (lastMethod.contains("south")){
                yCoordinate++;
            }
            else if(lastMethod.contains("east")){
                xCoordinate--;
            }
            else if (lastMethod.contains("west")){
                xCoordinate++;
            }
            System.out.println("Your energy has been restored and your location has been restored to (" + xCoordinate + ", " + yCoordinate + ").");
            System.out.println("Energy level: " + energy + "/100.");
        }
        else if (lastMethod.contains("fly")){
            int oldX = Integer.parseInt(lastMethod.substring(lastMethod.indexOf("_")+1,lastMethod.indexOf(".")));
            int oldY = Integer.parseInt(lastMethod.substring(lastMethod.indexOf(".")+1,lastMethod.indexOf("*")));
            int oldEnergy = Integer.parseInt(lastMethod.substring(lastMethod.indexOf("*")+1));
            xCoordinate = oldX;
            yCoordinate = oldY;
            energy = oldEnergy;
            System.out.println("Undoing fly()...");
            System.out.println("Your energy has been restored and your location has been restored to (" + xCoordinate + ", " + yCoordinate + ").");
            System.out.println("Energy level: " + energy + "/100.");
        }
        else if (lastMethod.contains("shrink")){
            System.out.println("Undoing shrink()...");
            size = Integer.parseInt(param);
            System.out.println("Your size has been restored to " + size + "% of your original size.");
        }
        else if (lastMethod.contains("grow")){
            System.out.println("Undoing grow()...");
            size = Integer.parseInt(param);
            System.out.println("Your size has been restored to " + size + "% of your original size.");
        }
        else if (lastMethod.contains("rest")){
            System.out.println("Undoing rest()...");
            energy = Integer.parseInt(param);
            System.out.println("Energy level: " + energy + "/100.");
        }
        else{
            System.out.println("This action cannot be undone.");
        }
    }

    /* Main method for testing */
    public static void main(String[] args){
        Cat momo = new Cat("Momo");
        momo.grab("toy");
        momo.undo();
        momo.walk("north");
        momo.shrink();
        momo.undo();
        momo.grow();
        momo.fly(10,10);
        momo.undo();
        momo.rest();
        momo.undo();
        momo.examine("food");
        momo.undo();
        momo.grab("food");
        momo.use("food");
        momo.undo();
        momo.setName("Mo");
        System.out.println(momo.getName());
        momo.undo();
        momo.drop("toy");
        momo.printInventory();
    }
}
