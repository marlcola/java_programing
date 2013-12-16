/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.mmprac.dbaccess;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DBAccessTest{
    
    public DBAccessTest() {
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
    public void testInit() {
        DBAccess dbAccess = new DBAccess("java_prac", "masaki", "cola3101");
        Class c = dbAccess.getClass();
        try {
            Field fld = c.getDeclaredField("dbConnection");
            fld.setAccessible(true);
            assertNotNull(fld.get(dbAccess));
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}