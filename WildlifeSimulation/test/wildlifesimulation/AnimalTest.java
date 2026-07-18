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
public class AnimalTest {
    
    public AnimalTest() {
    }

    /**
     * Test of updateStatus method, of class Animal.
     */
    @Test    
    public void testUpdateStatus() {
        System.out.println("\n--- Running: testUpdateStatus ---");
        
        Animal instance = new Animal("Lion", 100, 0, Animal.Temperament.AGGRESSIVE);
        System.out.println("Initial State: " + instance);

        // First Scenario
        System.out.print("Testing: Decreasing health by 20 and increasing stress by 10... ");
        instance.updateStatus(-20, 10);
        assertEquals("Health check failed", 80, instance.getHealth());
        assertEquals("Stress check failed", 10, instance.getStressLvl());
        System.out.println("PASSED");

        // Second Scenario
        System.out.print("Testing: Stress negative boundary check (dropping by 50)... ");
        instance.updateStatus(0, -50);
        assertEquals("Stress should stay at 0", 0, instance.getStressLvl());
        System.out.println("PASSED");

        // Third Scenario
        System.out.print("Testing: Increasing health by 30... ");
        instance.updateStatus(30, 0);
        assertEquals("Health check failed", 110, instance.getHealth());
        System.out.println("PASSED");
        
        System.out.println("--- All updateStatus scenarios PASSED ---");
    }
    
    
    /**
     * Test of toString method, of class Animal.
     */
    @Test
    public void testToString() {
        System.out.println("Testing ---toString---");
        Animal instance = new Animal("Zebra", 80 ,0, Animal.Temperament.CURIOUS);

        String result = instance.toString();
        assertTrue(result.contains("Zebra"));
        assertTrue(result.contains("health=80"));
        System.out.println(instance);
        
        
    }
    
}
