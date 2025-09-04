package lab8;

class MotorwaySimulator {
    private VehicleFactory factory;
    
    public MotorwaySimulator() {
        factory = new VehicleFactory();
    }
    
    public void runSimulation() {
        try {
            Vehicle car1 = factory.createVehicle("Toyota Camry");
            System.out.println("Created: " + car1);
            
            Vehicle car2 = factory.createVehicle("Honda Civic");
            System.out.println("Created: " + car2);
            
            Vehicle car3 = factory.createVehicle("Ford Focus");
            System.out.println("Created: " + car3);
            
            Vehicle car4 = factory.createVehicle("BMW X5");
            System.out.println("Created: " + car4);
            
        } catch (RuntimeException e) {
            System.out.println("Factory Error: " + e.getMessage());
            System.out.println("Cannot create more vehicles at this time.");
        }
    }
    
    public static void main(String[] args) {
        MotorwaySimulator simulator = new MotorwaySimulator();
        simulator.runSimulation();
    }
}