/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * this class is the panel we see when add account button is pressed.
 * @author Joel
 */
public class AddAccountPanel extends JPanel {

    private JLabel userNameLabel = new JLabel("Username:"); // label
    private JLabel firstNameLabel = new JLabel("First name:"); // label
    private JLabel lastNameLabel = new JLabel("Last name:"); // label
    private JLabel passwordLabel = new JLabel("Password:"); // label
    JTextArea userName = new JTextArea("");  // username textarea
    JTextArea firstName = new JTextArea(""); // first name textarea
    JTextArea lastName = new JTextArea(""); // lastname textarea
    JTextArea password = new JTextArea(""); // password textare
    JButton createAccount = new JButton("Create account"); // jbutton create account
    Border loweredetched; // declare a border

    // constructor for addaccountpanel
    public AddAccountPanel() {
        setLayout(new GridLayout(0, 1));
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); // create a lowered edge border
        setBorder(loweredetched);
        userNameLabel.setBorder(loweredetched);
        firstNameLabel.setBorder(loweredetched);
        lastNameLabel.setBorder(loweredetched);
        password.setBorder(loweredetched);
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
