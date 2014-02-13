/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * In this class the user can search for available trips in our system by going through a database of trips.
 * @author Joel
 */
public class SearchTripsPanel extends JPanel {
    
    private JLabel text = new JLabel("Search for a trip (All fields must be filled in)");
    JButton back = new JButton("Back to Menu");
    JLabel destinationLabel = new JLabel("Destination:");
    JTextField destination = new JTextField("berlin");
    JLabel dateLabel = new JLabel("Date:");
    JTextField date = new JTextField("00/00/00");
    JLabel departureLabel = new JLabel("Departure:");
    JTextField departure = new JTextField("copenhagen");
    JButton searchTrips = new JButton("Search");
    
    public SearchTripsPanel() {
        
        setLayout(new GridLayout(0, 1));
        add(text);
        add(destinationLabel);
        add(destination);
        add(departureLabel);
        add(departure);
        add(dateLabel);
        add(date);
        add(searchTrips);
        add(back);
    }
    
}
