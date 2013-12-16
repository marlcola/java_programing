/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.mmprac.main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mori
 */
public class HelloMessageTest {
    
    public HelloMessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetMessage(){
        System.out.println("Test getMessage() method.");
        HelloMessage helloWorld = new HelloMessage("Hello World!!");
        assertEquals("Hello World!!", helloWorld.getMessage());
    }
}