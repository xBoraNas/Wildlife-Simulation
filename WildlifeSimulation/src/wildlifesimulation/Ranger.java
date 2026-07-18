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
public class Ranger {
    private String name;
    private int experience;
    private int efficiency;
    private int stressLvl;

    public Ranger(String name, int experience, int efficiency, int stressLvl) {
        this.name = name;
        this.experience = experience;
        this.efficiency = efficiency;
        this.stressLvl = stressLvl;
    }
    
    
    /**
     * 
     * @param sc
     * @return 
     */
    public static Ranger fromScanner(Scanner sc) {
        if (!sc.hasNextLine()) return null;
        String line = sc.nextLine().trim();
        if (line.isEmpty()) return null;
        try {
            String[] parts = line.split("\\s+");
            return new Ranger(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), 0);
        } catch (Exception e) {
            return null;
        }
    }
    
    
    /**
     * 
     * @param animal
     * Assist animal as a ranger, it helps animal to heal,
     * Also adds experience to ranger and stress level
     */
    public void assistAnimal(Animal animal){
        
        int effectiveEfficiency = (this.stressLvl > 80) ? this.efficiency / 2 : this.efficiency;
        
        int healingPower = this.efficiency*2;
        animal.updateStatus(healingPower, -10);
        this.experience++;
        this.stressLvl +=5;
    }
    
    
    /**
     * 
     * @param animal 
     * Ranger helps animal to reduce stress level
     * Also increase stress level
     */
    public void helpAnimal(Animal animal){
        int effectiveEfficiency = (this.stressLvl > 80) ? this.efficiency / 2 : this.efficiency;
        animal.updateStatus(efficiency, -10);
        this.stressLvl +=3;
        
    }
    
    
    /**
     * 
     * @param poacherDanger
     * @return fights Poachers and increases stress level
     */
    public boolean fightPoacher(int poacherDanger){
        int rangerPower = this.experience + (int)(Math.random()* 10) - (this.stressLvl /10);
        this.stressLvl+=15;
        
        return rangerPower > poacherDanger;
    }
    
    /**
     * Rangers rest to reduce stress lvl in a random value
     */
    public void rest(){
        this.stressLvl = Math.max(0, this.stressLvl-20);
    }

    
    //GETTER SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public int getStressLvl() {
        return stressLvl;
    }

    public void setStressLvl(int stressLvl) {
        this.stressLvl = stressLvl;
    }

    @Override
    /**
     * return toString
     */
    public String toString() {
        return "Ranger{" + "name=" + name + ", experience=" + experience + ", efficiency=" + efficiency + ", stressLvl=" + stressLvl + '}';
    }
    
}
