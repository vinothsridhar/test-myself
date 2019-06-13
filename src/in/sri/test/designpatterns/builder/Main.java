package in.sri.test.designpatterns.builder;

public class Main {

    public static void main(String[] args) {
        
        House TwoBHKHouse = new House.Builder()
                .setFloors(2)
                .setRooms(2)
                .setKitchen()
                .build();
        
    }
    
}
