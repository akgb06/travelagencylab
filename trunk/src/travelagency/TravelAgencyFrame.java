/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

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
    JTable triptable = new JTable(15, 5);
    JTable bookedTripTable = new JTable(15, 4);
    ArrayList<String> bookedTrips = new ArrayList();
    ArrayList<String> tripList = new ArrayList();
    int arrayListCounter = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;
    String uName;
    JPanel bookedtrippanel = new JPanel();
    /*
     * create instances of all the panels
     */
    TravelAgencyStartPanel tap = new TravelAgencyStartPanel();
    SearchTripsPanel stp = new SearchTripsPanel();
    BookedTripsPanel btp = new BookedTripsPanel();
    LogInPanel lip = new LogInPanel();
    AddAccountPanel aap = new AddAccountPanel();
    DestinationsAvailablePanel dap = new DestinationsAvailablePanel();
    DBConnector dbc = new DBConnector();

    public TravelAgencyFrame(String title) {
        setUpFrame();
        AddListenerToButtons();
        AddPanels();
    }

    @Override // handles all the buttons and what panels to show when they are being pressed.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(tap.searchMyBookings)) {
            showBookedTrips();
        }
        if (e.getSource().equals(tap.searchTravels)) { // go to search panel
            c.show(card, "2");
        }
        if (e.getSource().equals(tap.logOut)) { // log out of the system
            setTitle("SunTrip Travel Agency");
            c.show(card, "4");
        }
        if (e.getSource().equals(stp.back)) { // go back to main panel
            c.show(card, "1");
        }
        if (e.getSource().equals(btp.back)) { // go back to main panel
            c.show(card, "1");
        }
        if (e.getSource().equals(lip.addAccount)) { // show the addAccount panel
            c.show(card, "5");
        }
        if (e.getSource().equals(aap.createAccount)) {
            createNewAccount();
        }
        if (e.getSource().equals(lip.logIn)) {
            CheckLogIn();
        }
        if (e.getSource().equals(dap.backToSearch)) { // go back to the searchtrips panel
            c.show(card, "2");
        }
        if (e.getSource().equals(stp.searchTrips)) { // add connection to database to see available trips
            SortAvailableTrips();

        }
        if (e.getSource().equals(dap.book)) {
            BookTrip();
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
        dap.book.addActionListener(this);

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
        setResizable(false);
    }

    public void CheckLogIn() {
        String username = lip.userName.getText();
        char[] pass = lip.password.getPassword();
        String passString = new String(pass);
        if (dbc.LogIn(username, passString) == true) {

            c.show(card, "1");
            uName = lip.userName.getText();
            setTitle("Welcome " + uName);
        } else {
            JOptionPane.showMessageDialog(null, "Not a valid username or password", "Error logging in", JOptionPane.INFORMATION_MESSAGE);
            c.show(card, "4");
        }
    }

    public void createNewAccount() {
        // connect to database and if the username isnt duplicated create a new account and show a info message.
        String username = aap.userName.getText();
        String firstName = aap.firstName.getText();
        String lastName = aap.lastName.getText();
        String password = aap.password.getText();
        if (dbc.createAccount(username, firstName, lastName, password) == true) {
            c.show(card, "4");
        } else {
            aap.userName.setText("");
            aap.firstName.setText("");
            aap.lastName.setText("");
            aap.password.setText("");
            c.show(card, "5");
        }
    }

    public void SortAvailableTrips() {
        // go to available trips panel
        clearTable(triptable);
        i = 0;
        j = 0;
        String dest = stp.destination.getText();
        String dep = stp.departure.getText();
        String date = stp.date.getText();
        tripList = dbc.getDestinations(dest, dep, date);
        if (tripList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Try Again", "No trips available", JOptionPane.INFORMATION_MESSAGE);
            c.show(card, "2");
        }
        while (!tripList.isEmpty()) {
            triptable.getModel().setValueAt(tripList.get(0), i, j);
            System.out.println(tripList.get(0));
            tripList.remove(0);
            j++;
            if (j == 4) {
                i++;
                j = 0;
            }
            //triptable.setBounds(30, i, width, height);
            bookedtrippanel.add(triptable);
            dap.add(bookedtrippanel,BorderLayout.CENTER);
            c.show(card, "6");
        }
    }

    public void showBookedTrips() {  // add connection to the database to check which bookings I have made
        k = 0;
        j = 0;
        clearTable(bookedTripTable);
        bookedTrips = dbc.checkMyBookings(uName);
        if (bookedTrips.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Book a trip", "No Booked Trips", JOptionPane.INFORMATION_MESSAGE);
            c.show(card, "3");
        }
        while (!bookedTrips.isEmpty()) {
            bookedTripTable.getModel().setValueAt(bookedTrips.get(0), k, l);
            bookedTrips.remove(0);
            l++;
            if (l == 4) {
                k++;
                l = 0;
                
            }
            bookedTripTable.setBounds(35, 50, 300, 240);
            btp.add(bookedTripTable);
            c.show(card, "3");
        }
    }

    public static void clearTable(final JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
        }
    }

    public void BookTrip() {
        String des = (String) triptable.getModel().getValueAt(0, 0);
        String dep = (String) triptable.getModel().getValueAt(0, 1);
        String price = (String) triptable.getModel().getValueAt(0, 2);
        String date = (String) triptable.getModel().getValueAt(0, 3);
        dbc.makeABooking(uName, des, dep, date, 2, price);
        JOptionPane.showMessageDialog(null, "Booked your trip", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
