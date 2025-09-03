package lab6;

class Vehicle {
    int speed;
    int lane;
    int distanceTravelled;
    RegistrationPlate registrationPlate;

    private static int vehicleCount = 0;

    public Vehicle(int speed, int lane) {
        this.speed = speed;
        this.lane = lane;
        this.distanceTravelled = 0;
        vehicleCount++;
    }

    void accelerate(int amount) {
        this.speed += amount;
        if (this.speed > 200) {
            this.speed = 200;
        }

        this.distanceTravelled += amount;
    }
    
    void brake(int amount) {
        this.speed -= amount;
        if (this.speed < 0) {
            this.speed = 0;
        }
    }
    
    String getDetails() {
        return "Vehicle " + registrationPlate.getNumber() + 
               " - Speed: " + speed + 
               ", Lane: " + lane + 
               ", Distance: " + distanceTravelled + 
               ", Plate: " + registrationPlate.getNumber();
    }

    public static int getCount() {
        return vehicleCount;
    }
}