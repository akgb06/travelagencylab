/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The Frame of this project, in here we add all the panels and set
 * actionlistener to all the buttons.
 *
 * @author Joel
 */
public class TravelAgencyFrame extends JFrame implements ActionListener {

    private int height = 400;
    private int width = 400;
    private CardLayout c = new CardLayout();
    private JPanel card = new JPanel(c);
    /*
     * create instances of all the panels
     */
    TravelAgencyStartPanel tap = new TravelAgencyStartPanel();
    SearchTripsPanel stp = new SearchTripsPanel();
    BookedTripsPanel btp = new BookedTripsPanel();
    LogInPanel lip = new LogInPanel();
    AddAccountPanel aap = new AddAccountPanel();
    DestinationsAvailablePanel dap = new DestinationsAvailablePanel();

    public TravelAgencyFrame(String title) {
        setUpFrame();
        AddListenerToButtons();
        AddPanels();
    }

    @Override // handles all the buttons and what panels to show when they are being pressed.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(tap.searchMyBookings)) {
            c.show(card, "3");
        }
        if (e.getSource().equals(tap.searchTravels)) {
            c.show(card, "2");
        }
        if (e.getSource().equals(tap.logOut)) {
            c.show(card, "4");
        }
        if (e.getSource().equals(stp.back)) {
            c.show(card, "1");
        }
        if (e.getSource().equals(btp.back)) {
            c.show(card, "1");
        }
        if (e.getSource().equals(lip.addAccount)) {
            c.show(card, "5");
        }
        if (e.getSource().equals(aap.createAccount)) { // connect to database and if the username isnt duplicated create a new account and show a info message.
            c.show(card, "4");
            JOptionPane.showMessageDialog(null, "You created a new account", "New Account", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(lip.logIn)) {
            c.show(card, "1");
        }
        if (e.getSource().equals(dap.backToSearch)) {
            c.show(card, "2");
        }
        if (e.getSource().equals(stp.searchTrips)) {
            c.show(card, "6");
        }

    }
    /*
     * add a actionlistener to all the buttons
     */

    private void AddListenerToButtons() {
        tap.searchMyBookings.addActionListener(this);
        tap.searchTravels.addActionListener(this);
        tap.logOut.addActionListener(this);
        stp.back.addActionListener(this);
        stp.searchTrips.addActionListener(this);
        btp.back.addActionListener(this);
        lip.logIn.addActionListener(this);
        lip.addAccount.addActionListener(this);
        aap.createAccount.addActionListener(this);
        dap.backToSearch.addActionListener(this);

    }

    /*
     * add the panels to the frame and show the first panel
     */
    private void AddPanels() {
        card.add(tap, "1");
        card.add(stp, "2");
        card.add(btp, "3");
        card.add(lip, "4");
        card.add(aap, "5");
        card.add(dap, "6");
        add(card);
        c.show(card, "4");
    }

    private void setUpFrame() {
        setSize(height, width); // set size of this component.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the application when the closing symbol is pressed.
        setTitle("SunTrip Travel Agency"); // title of the window
        setLocationRelativeTo(null); // centers the component.
    }
}
