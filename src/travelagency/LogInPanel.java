/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author Joel
 */
public class LogInPanel extends JPanel {
    
    private JPanel infoPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel fieldPanel = new JPanel();
    
    private String infoText = "Please Log in to book travels or see booked trips";
    private JLabel info = new JLabel(infoText);
    JTextField userName = new JTextField("Username");
    JPasswordField password = new JPasswordField("******");
    JButton addAccount = new JButton("Add account");
    JButton logIn = new JButton("Log in");
    
    public LogInPanel() {
        SetUpLogInPanel();
    }

    private void SetUpLogInPanel() {
        setLayout(new BorderLayout());
        infoPanel.add(info);
        add(infoPanel,BorderLayout.NORTH);
        buttonPanel.add(logIn);
        buttonPanel.add(addAccount);
        add(buttonPanel,BorderLayout.SOUTH);
        fieldPanel.add(userName);
        fieldPanel.add(password);
        add(fieldPanel,BorderLayout.CENTER);
    }
    
}
