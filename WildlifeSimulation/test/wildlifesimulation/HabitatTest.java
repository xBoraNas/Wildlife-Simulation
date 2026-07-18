/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package wildlifesimulation;

import java.util.List;
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
public class HabitatTest {
    
    public HabitatTest() {
    }
    /**
     * Test of causeIncursionStress method, of class Habitat.
     */
    @Test
    public void testCauseIncursionStress() {
        System.out.println("\n--- Running: testCauseIncursionStress ---");
        
        Habitat instance = new Habitat("Jungle", 5);
        Animal a1 = new Animal("Giraffe", 70, 10, Animal.Temperament.PASSIVE);
        instance.addAnimal(a1);

        System.out.print("Initial Stress: " + a1.getStressLvl()+"\n");
        
        System.out.print("-> Simulating Poacher Incursion... ");
        instance.causeIncursionStress(); // Stresi 15 artırmalı 
        
        assertEquals("Stress should increase by 15", 15, a1.getStressLvl());
        System.out.println("PASSED");
    }

    /**
     * Test of addAnimal method, of class Habitat.
     */
    @Test
    public void testAddAnimal() {
        Habitat instance = new Habitat("Savannah", 2);
        Animal a1 = new Animal("Zebra", 80, 0, Animal.Temperament.CURIOUS);
        Animal a2 = new Animal("Elephant", 100, 0, Animal.Temperament.DEFENSIVE);
        Animal a3 = new Animal("Lion", 90, 0, Animal.Temperament.AGGRESSIVE);
        
        System.out.print("Testing: Adding first two animals... ");
        instance.addAnimal(a1);
        instance.addAnimal(a2);
        assertEquals("Habitat should have 2 animals", 2, instance.getResidents().size());
        System.out.println("PASSED");
        
        System.out.print("Testing: Adding third animal (should exceed capacity)... ");
        instance.addAnimal(a3);
        assertEquals("Habitat should still have only 2 animals", 2, instance.getResidents().size());
        System.out.println("PASSED");
      
    }

    
    /**
     * Test of toString method, of class Habitat.
     */
    @Test
    public void testToString() {
        System.out.println("\n--- Running: testToString ---");
        Habitat instance = new Habitat("Mountain", 5);
        String result = instance.toString();
        
        assertTrue(result.contains("Mountain"));
        assertTrue(result.contains("capacity=5"));
        System.out.println(instance);
    }
    
}
