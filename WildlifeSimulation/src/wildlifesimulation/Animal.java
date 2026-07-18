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

public class Animal {    
    
   
    public enum State {
        CALM,
        ALERTED,
        DEFENSIVE,
        CURIOUS,
        AGGRESSIVE,
        FLEEING,
        ATTACKING,
        STABILIZED,
        CRITICAL
    }

    public enum Temperament{        
        PASSIVE,      
        DEFENSIVE,
        CURIOUS,
        AGGRESSIVE
    }

    private String species;
    private int health;
    private int stressLvl;
    private Temperament temperament;
    private State state;
    
    /**
     *
     * @param species
     * @param health
     * @param stressLvl
     * @param temperament
     */
    public Animal(String species,int health,int stressLvl,Temperament temperament){
        this.species = species;
        this.health=health;
        this.stressLvl=0; 
        this.temperament=temperament; 
        this.state=State.CALM;    //Animals begin in calm state
    }

   

    
    //GETTER SETTERS
    
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStressLvl() {
        return stressLvl;
    }
    
    public void setStressLvl(int stressLvl) {
        this.stressLvl = stressLvl;
    }

    public Temperament getTemperament() {
        return temperament;
    }

    public void setTemperament(Temperament temperament) {
        this.temperament = temperament;
    } 
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
   
    
    /**
     * 
     * @param healthDelta
     * @param stressDelta 
     * It updates the animals health and stress level
     */
    public void updateStatus(int healthDelta, int stressDelta){
        this.health+=healthDelta;
        this.stressLvl= Math.max(0,this.stressLvl+stressDelta);
        if (this.health<20 || this.stressLvl>80){
            this.state=State.CRITICAL;
        } else if(this.health>=80 && this.stressLvl <20){
            this.state=State.STABILIZED;
        } else{
            this.state=State.CALM;
        }

    }

    
    //READ FROM FILE
    /**
     * 
     * @param sc
     * @return 
     */
    public static Animal fromScanner(Scanner sc){
        if(!sc.hasNextLine())
            return null;
        
        String line = sc.nextLine().trim();
        if(line.isEmpty())
            return null;
        
        try{
            String[] parts = line.split("\\s+");
            String species = parts[0];
            int health = Integer.parseInt(parts[1]);
            int stress = Integer.parseInt(parts[2]);
            Temperament temp = Temperament.valueOf(parts[3].toUpperCase());
            
            return new Animal(species,health,stress,temp);
        } catch(Exception e){
            System.err.println("Error reading animal from scanner " + e.getMessage());
            return null;
        }   
    }

    /**
     * 
     * @return toString method
     */
    @Override
    public String toString() {
        return "Animal{" + "species=" + species + ", health=" + health + ", stressLvl=" + stressLvl + ", temperament=" + temperament + '}';
    }    
}


