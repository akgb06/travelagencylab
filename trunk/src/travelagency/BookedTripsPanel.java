/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * In this class the user can access their booked trips
 * @author Joel
 */
public class BookedTripsPanel extends JPanel {
    
    private JLabel text = new JLabel("booked trips:"); // label
    JButton back = new JButton("Menu"); // Jbutton back to menu
    private JLabel dest = new JLabel("dest:"); // label
    private JLabel dep = new JLabel("dep:"); // label
    private JLabel price = new JLabel("price:"); // label
    private JLabel date = new JLabel("date:"); // label
        
    public BookedTripsPanel () {
        setLayout(null); // to place the labels and buttons at specific points in the panel
        text.setBounds(10, 10, 100, 20);
        back.setBounds(140, 300, 100, 20);
        dest.setBounds(35, 30, 40, 20);
        dep.setBounds(110, 30, 40, 20);
        price.setBounds(185, 30, 40, 20);
        date.setBounds(260, 30, 40, 20);
        add(dest);
        add(dep);
        add(price);
        add(date);
        add(text);
        add(back);
    }
    
}
