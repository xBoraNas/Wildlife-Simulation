/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildlifesimulation;

import java.util.Scanner;

/**
 *
 * @author Bora
 */
    public class Poacher {
        private String name;
        private String targetSpecies;
        private int dangerLvl;

    public Poacher(String name, String targetSpecies, int dangerLvl) {
        this.name = name;
        this.targetSpecies = targetSpecies;
        this.dangerLvl = dangerLvl;
    }
    
    //READ FROM FILE
    /**
     * 
     * @param sc
     * @return 
     */
    public static Poacher fromScanner(Scanner sc) {
        if (!sc.hasNextLine())
            return null;
        String line = sc.nextLine().trim();
        if (line.isEmpty())
            return null;
        try {
            String[] parts = line.split("\\s+");
            return new Poacher(parts[0], parts[1], Integer.parseInt(parts[2]));
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 
     * @param animal
     * It hunts the animals and updates animal health and stress level status
     */
    public void hunt(Animal animal){
        if(animal.getSpecies().equals(targetSpecies)){
            animal.updateStatus(-15, 25);
        }
    }

    
    //GETTER SETTERS
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetSpecies() {
        return targetSpecies;
    }

    public void setTargetSpecies(String targetSpecies) {
        this.targetSpecies = targetSpecies;
    }

    public int getDangerLvl() {
        return dangerLvl;
    }

    public void setDangerLvl(int dangerLvl) {
        this.dangerLvl = dangerLvl;
    }
    
    

    @Override
    /**
     * return toString
     */
    public String toString() {
        return "Poacher{" + "name=" + name + ", targetSpecies=" + targetSpecies + ", dangerLvl=" + dangerLvl + '}';
    }    
}
