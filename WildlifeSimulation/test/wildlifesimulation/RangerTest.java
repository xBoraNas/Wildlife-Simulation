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
public class RangerTest {
    
    public RangerTest() {
    }  

    /**
     * Test of assistAnimal method, of class Ranger.
     */
    @Test
    public void testAssistAnimal() {
        System.out.println("\n--- Running: testAssistAnimal ---");
        
        Ranger instance = new Ranger("Sofiia", 5, 10, 0);
        Animal animal = new Animal("Giraffe", 70, 20, Animal.Temperament.PASSIVE);

        System.out.print("Testing: Assisting an animal (advanced treatment)... ");
        instance.assistAnimal(animal);
        
        assertEquals("Health should increase by double efficiency (20)", 90, animal.getHealth());
        assertEquals("Stress should decrease by 10", 0, animal.getStressLvl());
        System.out.println("PASSED");
               
    }

    /**
     * Test of helpAnimal method, of class Ranger.
     */
    @Test
    public void testHelpAnimal() {
        System.out.println("Testing ---helpAnimal---");
        Ranger instance = new Ranger("Mark",5,10,0);
        Animal animal = new Animal("Elephant",50,40,Animal.Temperament.DEFENSIVE);
        System.out.println("Testing: Helping Animal");
        instance.helpAnimal(animal);        
        
        //Helping Animal
        assertEquals("Health should increase by efficiency (10)", 60, animal.getHealth());
        assertEquals("Stress should decrease by 10", 0, animal.getStressLvl());
        System.out.println("PASSED"); 
    }

    /**
     * Test of fightPoacher method, of class Ranger.
     */
    @Test
    public void testFightPoacher() {
        System.out.println("\n--- Running: testFightPoacher ---");
        
        // Create experienced ranger
        Ranger strongRanger = new Ranger("Veteran", 100, 10, 0);
        
        System.out.print("Testing: Strong Ranger vs Weak Poacher... ");
        
        assertTrue("Veteran should always win against danger 5", strongRanger.fightPoacher(5));
        System.out.println("PASSED");

        // Create rookie ranger
        Ranger weakRanger = new Ranger("Rookie", 0, 5, 0);
        
        System.out.print("Testing: Weak Ranger vs Strong Poacher... ");
        
        assertFalse("Rookie should lose against danger 20", weakRanger.fightPoacher(20));
        System.out.println("PASSED");
    }

   
    /**
     * Test of toString method, of class Ranger.
     */
    @Test
    public void testToString() {
        System.out.println("Testing ---toString---");
        Ranger instance = new Ranger("Mark", 80 ,50,0);

        String result = instance.toString();
        assertTrue(result.contains("Mark"));
        assertTrue(result.contains("experience=80"));
        assertTrue(result.contains("efficiency=50"));
        System.out.println(instance);
    }
    
}
