package in.sri.test.designpatterns.builder;

public class House {
    
    int floorCount;
    
    int roomCount;
    
    boolean hasKitchen;
    
    private House(int floorCount) {
        this.floorCount = floorCount;
    }
    
    public static class Builder {
        
        private House house;
        
        public Builder() {
            this.setFloors(1);
        }
        
        public Builder setFloors(int floorCount) {
            house.floorCount = floorCount;
            return this;
        }
        
        public Builder setRooms(int roomCount) {
            house.roomCount = roomCount;
            return this;
        }
        
        public Builder setKitchen() {
            house.hasKitchen = true;
            return this;
        }
        
        public House build() {
            return house;
        }
        
    }
    
}
