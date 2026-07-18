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
public class Vehicle {  
    
    public enum EquipmentType{
        TRANQUILLISER_KIT,
        MOBILE_MEDIC_UNIT,
        NONE
    }
    
    private String id;
    private int fuelLvl;
    private int capacity;
    private EquipmentType equipment;

    public Vehicle(String id, int fuelLvl, int capacity, EquipmentType equipment) {
        this.id = id;
        this.fuelLvl = fuelLvl;
        this.capacity = capacity;
        this.equipment = equipment;
    }
    
    /**
     * 
     * @param sc
     * @return 
     */
    public static Vehicle fromScanner(Scanner sc) {
        if (!sc.hasNextLine()) 
            return null;
        String line = sc.nextLine().trim();
        if (line.isEmpty()) 
            return null;
        try {
            String[] parts = line.split("\\s+");
            EquipmentType eq = EquipmentType.valueOf(parts[3].toUpperCase());
            return new Vehicle(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), eq);
        } catch (Exception e) {
            return null;
        }
    }

    //GETTER SETTERS    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFuelLvl() {
        return fuelLvl;
    }

    public void setFuelLvl(int fuelLvl) {
        this.fuelLvl = fuelLvl;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public EquipmentType getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentType equipment) {
        this.equipment = equipment;
    }
    
    
    
    /**
     * Refuels the car to the full
     */
    public void refuel(){
        this.fuelLvl=100;
    }    

    @Override
    /**
     * return toString
     */
    public String toString() {
        return "Vehicle{" + "id=" + id + ", fuelLvl=" + fuelLvl + ", capacity=" + capacity + ", equipment=" + equipment + '}';
    }
    
    
}
