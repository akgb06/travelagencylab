/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

/**
 *
 * @author Joel
 */
public class TravelAgency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TravelAgency ta = new TravelAgency(); // create a instance of travel agency
        ta.run(); 
    }
    
    private void run() {
        TravelAgencyFrame taf = new TravelAgencyFrame("Travel Agency");
        taf.setVisible(true); // show the Jframe
    }
}
