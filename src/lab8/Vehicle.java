package lab8;

class Vehicle {
    private String registrationPlate;
    private String model;
    
    public Vehicle(String registrationPlate, String model) {
        this.registrationPlate = registrationPlate;
        this.model = model;
    }
    
    public String getRegistrationPlate() {
        return registrationPlate;
    }
    
    public String getModel() {
        return model;
    }
    
    @Override
    public String toString() {
        return model + " (Reg: " + registrationPlate + ")";
    }
}