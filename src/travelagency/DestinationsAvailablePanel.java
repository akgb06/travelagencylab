/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joel
 * 
 */
public class DestinationsAvailablePanel extends JPanel {
    
    JButton backToSearch = new JButton(" Back to search");
    private JLabel infoLabel = new JLabel("Available trips to your destination this date:");
    JLabel infoToProgrammer = new JLabel("Here we need to list all the destination available the date the user searched for");
    public DestinationsAvailablePanel() {
        add(infoLabel);
        add(backToSearch);
        add(infoToProgrammer);
    }
    
}
