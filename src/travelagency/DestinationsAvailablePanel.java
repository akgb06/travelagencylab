/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Joel
 * 
 */
public class DestinationsAvailablePanel extends JPanel {
    
    JButton backToSearch = new JButton(" Back to search");
    JButton book = new JButton("Book");
    JPanel buttonPanel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JLabel infoLabel = new JLabel("Available trips to your destination this date");
    private JLabel infoLabel1 = new JLabel("(dest,dep,price,date)");
    Border loweredetched;
    
    public DestinationsAvailablePanel() {
        setLayout(new BorderLayout());
        buttonPanel.setSize(400, 40);
        textPanel.setSize(400, 80);
        textPanel.add(infoLabel);
        textPanel.add(infoLabel1);
        buttonPanel.add(backToSearch);
        buttonPanel.add(book);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setBorder(loweredetched);
        add(textPanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);
    }
    
}
