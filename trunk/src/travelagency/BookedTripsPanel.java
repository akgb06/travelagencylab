/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * In this class the user can access their booked trips.s
 * @author Joel
 */
public class BookedTripsPanel extends JPanel {
    
    private JLabel text = new JLabel("add connection to a database with booked trips");
    JButton back = new JButton("Back to Menu");
    public BookedTripsPanel () {
        add(text);
        add(back);
    }
    
}
