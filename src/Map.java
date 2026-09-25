public class Map {

    private Room currentRoom;
    private Room next;
    private Room previousRoom = null;

    public void setupMap() {

        Room room1 = new Room("Room 1", "The entrance to the abandoned building.", false);
        Room room2 = new Room("Room 2", "An old office with a desk and some documents.", true);
        Room room3 = new Room("Room 3", "A meeting room with notes left on the board.", false);
        Room room4 = new Room("Room 4", "An old kitchen that looks like it was left in a hurry.", false);
        Room room5 = new Room("Room 5", "A storage room filled with old boxes and equipment.", false);
        Room room6 = new Room("Room 6", "A technical room with old machines and electrical panels.", false);
        Room room7 = new Room("Room 7", "An archive containing reports about an old incident.", false);
        Room room8 = new Room("Room 8", "A break room with a few personal belongings left behind.", false);
        Room room9 = new Room("Room 9", "An empty room with a strange map of the building.", false);

        currentRoom = room1;


        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setEast(room3);

        room3.setSouth(room6);

        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setSouth(room9);

        room7.setEast(room8);

        room8.setEast(room9);

    }

    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getNext() {
        return next;
    }

    public void setNext(Room room) {
        next = room;
    }

    public Room getPreviousRoom(){
        return previousRoom;
    }

    public void setPreviousRoom(Room room){
        previousRoom = room;

    }
}
