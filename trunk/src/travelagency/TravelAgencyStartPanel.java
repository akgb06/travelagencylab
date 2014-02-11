/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This is the main panel. here the user can choose between two options
 * either to search for a trip or check for bookings made. 
 * this panel is shown if the log in succeded.
 * @author Joel
 */

public class TravelAgencyStartPanel extends JPanel{
    
    int startPanelHeight = 400;
    int startPanelWidth = 400;
    JButton searchMyBookings = new JButton("Search my bookings");
    JButton searchTravels = new JButton("Search Trips");
    JButton logOut = new JButton("Log out");
    
    public TravelAgencyStartPanel() {
        setSize(startPanelHeight, startPanelWidth);
        addButtons();
    }
    
    private void addButtons() {
        setLayout(null);
        searchMyBookings.setBounds(90, 20, 200, 20);
        searchTravels.setBounds(90, 50, 200, 20);
        logOut.setBounds(90,80,200,20);
        add(searchMyBookings);
        add(searchTravels);
        add(logOut);
    }
    
}
