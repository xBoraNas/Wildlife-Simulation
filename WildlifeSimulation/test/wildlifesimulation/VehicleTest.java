/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package wildlifesimulation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bora
 */
public class VehicleTest {
    
    public VehicleTest() {
    }
    
    
    /**
     * Test of refuel method, of class Vehicle.
     */
    @Test
    public void testRefuel() {
        System.out.println("Testing ---refuel---");
        Vehicle instance = new Vehicle("V1",50,2,Vehicle.EquipmentType.MOBILE_MEDIC_UNIT);
        System.out.println("Initial State: " + instance);   
        
        System.out.println("Testing: Refuelling vehicle...");
        instance.refuel(); //It should be 100 due to code;        
        
        assertEquals("Fuel level should be restored to 100", 100,instance.getFuelLvl());
        System.out.println(instance);
        System.out.println("PASSED");       
    }

    /**
     * Test of toString method, of class Vehicle.
     */
    @Test
    public void testToString() {
        System.out.println("Testing ---toString---");
        Vehicle vehicle = new Vehicle("V2", 80 ,50,Vehicle.EquipmentType.TRANQUILLISER_KIT);

        String result = vehicle.toString();
        assertTrue(result.contains("V2"));
        assertTrue(result.contains("fuelLvl=80"));
        assertTrue(result.contains("capacity=50"));
        System.out.println(vehicle);
    }
    
}
