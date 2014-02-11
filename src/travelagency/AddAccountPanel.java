/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Joel
 */
public class AddAccountPanel extends JPanel {
    
    private JLabel userNameLabel = new JLabel("Username:");
    private JLabel firstNameLabel = new JLabel("First name:");
    private JLabel lastNameLabel = new JLabel("Last name:");
    private JLabel passwordLabel = new JLabel("Password:");
    
    JTextArea userName = new JTextArea("           ");
    JTextArea firstName = new JTextArea("          ");
    JTextArea lastName = new JTextArea("           ");
    JTextArea password = new JTextArea("          ");
    
    JButton createAccount = new JButton("Create account");
    
    public AddAccountPanel() {
        setLayout(new GridLayout(0, 1));
        add(userNameLabel);
        add(userName);
        add(firstNameLabel);
        add(firstName);
        add(lastNameLabel);
        add(lastName);
        add(passwordLabel);
        add(password);
        
        add(createAccount);
        
    }
    
}
