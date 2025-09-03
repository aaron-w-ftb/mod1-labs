package lab6;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        System.out.println("Vehicle Racing Lab\n");

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Vehicle(0, 1);
        Vehicle vehicle2 = new Vehicle(0, 2);
        Vehicle vehicle3 = new Vehicle(0, 3);

        vehicle1.registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();
        vehicle2.registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();
        vehicle3.registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();
        
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);

        System.out.println("Vehicles created:");
        for (Vehicle v : vehicles) {
            System.out.println(v.getDetails());
        }
        System.out.println();

        System.out.println("Total vehicles created: " + Vehicle.getCount());
        System.out.println();

        System.out.println("RACE START");
        System.out.println("Racing until a vehicle travels 1000m or more.\n");
        
        Random rand = new Random();
        boolean raceFinished = false;
        int iteration = 1;
        
        while (!raceFinished) {
            System.out.println("Iteration " + iteration);

            for (Vehicle vehicle : vehicles) {
                int acceleration = rand.nextInt(10) + 1;
                vehicle.accelerate(acceleration);

                System.out.println(vehicle.getDetails());

                if (vehicle.distanceTravelled >= 1000) {
                    System.out.println("\nWinner! Vehicle " + vehicle.registrationPlate.getNumber() + 
                                     " has traveled " + vehicle.distanceTravelled + "m!");
                    raceFinished = true;
                }
            }
            
            System.out.println();
            iteration++;

            if (iteration > 1000) {
                System.out.println("Race ended due to maximum iterations reached.");
                break;
            }
        }
        
        System.out.println("RACE FINISHED");
    }
}