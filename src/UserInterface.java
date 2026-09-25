public class UserInterface {

    public static void printHelp(){
        System.out.println("Possible commands:");
        System.out.println("- Go North");
        System.out.println("- Go South");
        System.out.println("- Go West");
        System.out.println("- Go East");
        System.out.println("- Go back - goes back to the previous room you just were in");
        System.out.println("- Turn on light - turns on the light in the current room");
        System.out.println("- Turn off light - turns off the light in the current room");
        System.out.println("- Look - Describe the current room");
        System.out.println("- Exit - End game");
    }

    public static void printRoomDescription(Room room){
        System.out.println(room.getDescription());
    }
}
