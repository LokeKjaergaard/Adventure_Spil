import java.util.ArrayList;

public class Room {

    // basic room info
    private String name;
    private String description;
    private boolean hasVisited = false;
    private boolean isDark;

    // neighboring rooms
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    // a room adjacent to the current room can be locked (currently unimplemented)
    private boolean isRoomNLocked;
    private boolean isRoomSLocked;
    private boolean isRoomWLocked;
    private boolean isRoomELocked;

    public Room (String name, String description, boolean isDark) {
        this.name = name;
        this.description = description;
        this.isDark = isDark;
    }

    public void printConnectedRooms() {
        // holds the string of all possible directions.
        String doors = "";

        // north is always the first possible value, we don't need to add a comma (,)
        if (getNorth() != null && getNorth().isVisited()) {
            doors += "north";
        }

        // add a comma (,) if it's empty
        if (getSouth() != null && getSouth().isVisited()) {
            if (doors.isEmpty()) {
                doors += "south";
            } else doors += ", south";

        }

        if (getEast() != null && getEast().isVisited()) {
            if (doors.isEmpty()) {
                doors += "east";
            } else doors += ", east";

        }

        // west is always the last value we can end the sentence with an "and" here.
        if (getWest() != null && getWest().isVisited()) {
            if (doors.isEmpty()) {
                doors += "west";
            } else doors += " and west";

        }

        if (doors.isEmpty()){
            System.out.println("Possible directions unknown. Try to go in different directions to find new rooms");
        } else System.out.println("There are door(s) to the: " + doors + ".");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getEast() {
        return east;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public void setEast(Room east) {
        this.east = east;
        east.west = this;
    }

    public void setNorth(Room north) {
        this.north = north;
        north.south = this;
    }

    public void setSouth(Room south) {
        this.south = south;
        south.north = this;
    }

    public void setWest(Room west) {
        this.west = west;
        west.east = this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void makeVisited() {
        hasVisited = true;
    }

    public boolean isVisited() {
        return hasVisited;
    }

    public boolean isDark() {
        return isDark;
    }

    public void turnOnLight() {
        this.isDark = false;
        System.out.println("You turned on the light");
    }

    public void turnOffLight() {
        this.isDark = true;
        System.out.println("You turned off the light");
    }




}
