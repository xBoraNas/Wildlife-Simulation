package wildlifesimulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WildlifeSimulation {
    
    private final List<Habitat> habitats = new ArrayList<>();
    private final List<Ranger> rangers = new ArrayList<>();
    private final List<Poacher> poachers = new ArrayList<>();
    private final List<Vehicle> vehicles = new ArrayList<>();
       
    public static void main(String[] args) {
       WildlifeSimulation sim = new WildlifeSimulation();
       
       try {
           sim.loadHabitats("habitats.txt");           
           sim.loadAnimals("animals.txt");
           sim.loadPoachers("poachers.txt");
           sim.loadVehicles("vehicles.txt");
           sim.loadRangers("rangers.txt");

           for (int day = 1; day <= 7; day++) {
               sim.simulateDay(day);
           }
           
       } catch (Exception e) {
           System.err.println("Critical Error: " + e.getMessage());
       }
    }
    
    private void loadHabitats(String filename) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                Habitat h = Habitat.fromScanner(sc);
                if (h != null) habitats.add(h);
            }
        } catch (IOException e) {
            System.err.println("Error reading habitats: " + e.getMessage());
        }
    }
    
    private void loadAnimals(String filename) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                Animal a = Animal.fromScanner(sc);
                if (a != null && !habitats.isEmpty()) {
                    habitats.get(0).addAnimal(a);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading animals: " + e.getMessage());
        }
    }
    
    private void loadPoachers(String filename) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                Poacher p = Poacher.fromScanner(sc);
                if (p != null) poachers.add(p);
            }
        } catch (IOException e) {
            System.err.println("Error reading poachers: " + e.getMessage());
        }
    }
    
    private void loadVehicles(String filename) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                Vehicle v = Vehicle.fromScanner(sc);
                if (v != null) vehicles.add(v);
            }
        } catch (IOException e) {
            System.err.println("Error reading vehicles: " + e.getMessage());
        }
    }
    
    private void loadRangers(String filename) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                Ranger r = Ranger.fromScanner(sc);
                if (r != null) rangers.add(r);
            }
        } catch (IOException e) {
            System.err.println("Error reading rangers: " + e.getMessage());
        }
    }  
    
   /**
    * 
    * @param day 
    * Simulates the habitat 
    */
    public void simulateDay(int day) {
    System.out.println("\n======================== Day " + day + " Report ========================\n");
    
    // Every day poacher inflate to random habitat
    if (!poachers.isEmpty() && !habitats.isEmpty()) {
        Poacher p = poachers.get((int)(Math.random() * poachers.size()));
        Habitat h = habitats.get((int)(Math.random() * habitats.size()));
        
        System.out.println("ALERT: Poacher " + p.getName() + " infiltrated " + h.getName() + "!");
        h.causeIncursionStress(); // Everyone will have stress
        
        // Ranger target animal
        if (!h.getResidents().isEmpty()) {
            Animal target = h.getResidents().get((int)(Math.random() * h.getResidents().size()));
            p.hunt(target);
        }
    }

   
    // Everyday ranger will help animal
    if (!rangers.isEmpty() && !habitats.isEmpty()) {
        Ranger r = rangers.get((int)(Math.random() * rangers.size()));
        for (Habitat h : habitats) {
            for (Animal a : h.getResidents()) {
                if (a.getState() == Animal.State.CRITICAL) {
                    System.out.println("RESCUE: Ranger " + r.getName() + " is treating " + a.getSpecies());
                    r.assistAnimal(a); // Heal the "CRITICAL" animal
                }
            }
        }
    }

    // Day raport
    for (Habitat h : habitats) {
        System.out.println(h);
        for (Animal a : h.getResidents()) {
            System.out.println(" Status: " + a);
        }
    }
}

}