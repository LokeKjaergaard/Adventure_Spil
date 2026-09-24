import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private boolean hasVisited = false;
    private boolean isDark;

    private Room north;
    private Room south;
    private Room east;
    private Room west;

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
        if (getNorth() != null) {
            doors += "north";
        }

        // add a comma (,) if it's empty
        if (getSouth() != null) {
            if (doors.isEmpty()) {
                doors += "south";
            } else doors += ", south";

        }

        if (getEast() != null) {
            if (doors.isEmpty()) {
                doors += "east";
            } else doors += ", east";

        }

        // west is always the last value we can end the sentence with an "and" here.
        if (getWest() != null) {
            if (doors.isEmpty()) {
                doors += "west";
            } else doors += " and west";

        }

        // prints result.
        System.out.println("There are doors to the: " + doors + ".");
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
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
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
        isDark = true;
    }

    public void turnOffLight() {
        isDark = false;
    }




}
