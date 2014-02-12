/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Joel
 */
public class TravelAgency {
  public static void main(String[] args) {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/travelagency", "test", "password");
            Statement stmt = (Statement) con.createStatement();
            String firstName = "";
            String lastName = "";
            String password = "";
            String userName = "";
        }catch(Exception e) {
        TravelAgency ta = new TravelAgency(); // create an instance of travel agency
        ta.run(); 
        }
  }
  private void run() {
        TravelAgencyFrame taf = new TravelAgencyFrame("Travel Agency");
        taf.setVisible(true); // show the Jframe
    }
}  
/**
 * @param args the command line arguments
 */