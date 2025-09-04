package lab7;

import java.util.*;

class Zoo {
    private HashMap<String, Integer> animalMap;
    private String[] originalAnimals;
    private String[] newAnimals;
    
    public Zoo() {
        animalMap = new HashMap<String, Integer>();
        originalAnimals = new String[]{"Zebra", "Lion", "Buffalo"};
        newAnimals = new String[]{"Zebra", "Gazelle", "Buffalo", "Zebra"};
        addAnimals(originalAnimals);
        addAnimals(newAnimals);
    }
    
    public void addAnimals(String[] animals) {
        for (String animal : animals) {
            if (animalMap.containsKey(animal)) {
                int currentCount = animalMap.get(animal);
                animalMap.put(animal, currentCount + 1);
            } else {
                animalMap.put(animal, 1);
            }
        }
    }
    
    public void displayAnimalData() {
        System.out.println("Animal\tCount");
        for (Map.Entry<String, Integer> entry : animalMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}