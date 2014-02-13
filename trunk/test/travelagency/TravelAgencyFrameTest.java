/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joel
 */
public class TravelAgencyFrameTest {
    
    public TravelAgencyFrameTest() {
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

    /**
     * Test of actionPerformed method, of class TravelAgencyFrame.
     */
//    @Test
//    public void testActionPerformed() {
//        System.out.println("actionPerformed");
//        ActionEvent e =
//        TravelAgencyFrame instance = new TravelAgencyFrame("test");
//        instance.actionPerformed(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of CheckLogIn method, of class TravelAgencyFrame.
     */
    @Test
    public void testCheckLogIn() {
        System.out.println("CheckLogIn");
        TravelAgencyFrame instance = new TravelAgencyFrame("test");
        instance.CheckLogIn();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createNewAccount method, of class TravelAgencyFrame.
     */
    @Test
    public void testCreateNewAccount() {
        System.out.println("createNewAccount");
        TravelAgencyFrame instance = new TravelAgencyFrame("test");
        instance.createNewAccount();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SortAvailableTrips method, of class TravelAgencyFrame.
     */
    @Test
    public void testSortAvailableTrips() {
        System.out.println("SortAvailableTrips");
        TravelAgencyFrame instance = new TravelAgencyFrame("test");
        instance.SortAvailableTrips();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of showBookedTrips method, of class TravelAgencyFrame.
     */
    @Test
    public void testShowBookedTrips() {
        System.out.println("showBookedTrips");
        TravelAgencyFrame instance = new TravelAgencyFrame("test");
        instance.showBookedTrips();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of clearTable method, of class TravelAgencyFrame.
     */
//    @Test
//    public void testClearTable() {
//        System.out.println("clearTable");
//        JTable table = null;
//        TravelAgencyFrame.clearTable(table);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
