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
public class PoacherTest {
    
    public PoacherTest() {
    }    
     /**
     * Test of hunt method, of class Poacher.
     */
    @Test
    public void testHunt() {
        System.out.println("Running ---testHunt---");
        Poacher instance = new Poacher("Wilhelm", "Zebra", 7);
        
        Animal targetAnimal= new Animal("Zebra",80,10,Animal.Temperament.CURIOUS);
        Animal nonTargetAnimal = new Animal("Elephant",100,0,Animal.Temperament.DEFENSIVE);
        
        System.out.println("Testing: Hunting target species (Zebra)");        
        instance.hunt(targetAnimal);
        
        assertEquals("Target animal health should decrease",65 , targetAnimal.getHealth());
        assertEquals("Target animal stress should increase",25 , targetAnimal.getStressLvl());
        System.out.println("PASSED");
        
        System.out.println("Testing: Hunting non-target species(Elephant)");
        instance.hunt(nonTargetAnimal);
        assertEquals("Non-target health should stay same" ,100, nonTargetAnimal.getHealth());
        assertEquals("Non-target stress should stay same" ,0, nonTargetAnimal.getStressLvl());
        System.out.println("PASSED");
    }

    
    /**
     * Test of toString method, of class Poacher.
     */
    @Test
    public void testToString() {
        System.out.println("Testing ---toString---");
        Poacher instance = new Poacher("Mike","Elephant", 5);
        String result = instance.toString();
        System.out.println("Testing:");
        assertTrue("It should contain Name", result.contains("Mike"));
        assertTrue("It should contain Target", result.contains("Elephant"));
        assertTrue("It should contain dangerLvl", result.contains("5"));
        
        System.out.println(instance);
    }
    
}
