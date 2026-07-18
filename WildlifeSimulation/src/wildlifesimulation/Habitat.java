/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildlifesimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bora
 */
    public class Habitat {
        private String name;
        private int capacity;
        private List <Animal> residents;

    public Habitat(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.residents = new ArrayList<>();
    }
    
    /**
     * 
     * @param sc
     * @return 
     */
    public static Habitat fromScanner(Scanner sc) {
        if (!sc.hasNextLine()) 
            return null;
        String line = sc.nextLine().trim();
        if (line.isEmpty())
            return null;
        try {
            String[] parts = line.split("\\s+");
            return new Habitat(parts[0], Integer.parseInt(parts[1]));
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * It causes stress for animals
     */
    public void causeIncursionStress(){
        for(Animal a :residents){
            a.updateStatus(0, 15);
        }
    }
    
    /**
     * 
     * @param animal
     * Adds animals
     */
    public void addAnimal(Animal animal){
        if(residents.size()< capacity) residents.add(animal);
    }

    
    //GETTER SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List <Animal> getResidents() {
        return residents;
    }

    public void setResidents(List <Animal> residents) {
        this.residents = residents;
    }

    
    /**
     * 
     * @return toString
     */
    @Override
    public String toString() {
        return "Habitat{" + "name=" + name + ", capacity=" + capacity + ", residents=" + residents + '}';
    }
}
