package lab8;

import java.util.ArrayList;
import java.util.List;

class VehicleFactory {
    private List<String> availablePlates;
    private int plateIndex = 0;
    
    public VehicleFactory() {
        availablePlates = new ArrayList<>();
        availablePlates.add("ABC123");
        availablePlates.add("DEF456");
        availablePlates.add("GHI789");
    }
    
    public Vehicle createVehicle(String model) throws RuntimeException {
        if (plateIndex >= availablePlates.size()) {
            throw new RuntimeException("No more registration plates available");
        }
        
        String plate = availablePlates.get(plateIndex);
        plateIndex++;
        
        return new Vehicle(plate, model);
    }
    
    public int getAvailablePlates() {
        return availablePlates.size() - plateIndex;
    }
}