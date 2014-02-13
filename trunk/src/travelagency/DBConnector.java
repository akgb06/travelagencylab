/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

/**
 * Handles the connections to the database different methods for different
 * actions.
 *
 * @author Joel
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBConnector {

    private String url = "jdbc:mysql://localhost:3306/"; // url to database
    private String dbName = "travelagency"; // database name
    private String driver = "com.mysql.jdbc.Driver"; // driver to connect to server
    private String userName = "root"; // username to database
    private String password = "nijosv"; // password to database
    int Usercounter = 1; // for incrementing the userID in the database.
    boolean canAdd = true; // true if it is possible to add a new user, two usernames alike usernames cant exists. 
    ArrayList<String> availableDestinations = new ArrayList(); // arraylist that collects available destinations from database.
    int idOfUser; // for incrementing idOfUsers.
    ArrayList bookedTrips = new ArrayList(); // collects from database the booked trips
    int travelIdCounter; // for incrementing the travel id in database.

    /*
     * constructor for the database connection
     */
    public DBConnector() {
    }

    /*
     * this method lets a user log in to the travel agency.
     * if username and password dosnt match the user cant log in.
     */
    public boolean LogIn(String username, String word) {
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  Users");
            while (res.next()) {
                String user = res.getString("userName");
                String password = res.getString("password");
                if (username.equals(user) && word.equals(password)) { // username and password match = user can log in, return true.
                    return true;
                }
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database", "Connection Error", JOptionPane.INFORMATION_MESSAGE);
            //e.printStackTrace();
        }
        return false; // if method returns false user cant log in.
    }
    /*
     * This method adds a account to the database, also gives error message if username is already taken.
     */

    public boolean createAccount(String user, String firstName, String lastName, String word) {
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  Users");
            while (res.next()) {

                int id = res.getInt("idUsers");
                Usercounter = id + 1;
                if (res.getString("userName").equals(user)) { // those lines check if a username is already taken.
                    canAdd = false;
                    JOptionPane.showMessageDialog(null, "Username already taken", "Error Creating Account", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                } else {
                    canAdd = true;
                }
            }
            if (canAdd == true) { // if a username is free we can add a new user.
                String sql = "INSERT INTO users (idUsers, firstName, lastName, userName, password)" // insert new user
                        + "VALUES (?, ?, ?, ?, ?)"; // values from prepared statement.
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, Usercounter);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, user);
                preparedStatement.setString(5, word);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "You created a new account", "New Account", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database", "Connection Error", JOptionPane.INFORMATION_MESSAGE);
            //e.printStackTrace();
        }
        return true;
    }

    /*
     * This method get a destination departure and date trip available after a user searched for it.
     */
    public ArrayList getDestinations(String destination, String departure, String date) {
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM availabetrips WHERE destination = '" + destination + "' AND departure = '" + departure + "' AND date = '" + date + "'");

            while (res.next()) {
                availableDestinations.add(res.getString("destination"));
                availableDestinations.add(res.getString("departure"));
                availableDestinations.add(res.getString("price"));
                availableDestinations.add(res.getString("date"));
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database", "Connection Error", JOptionPane.INFORMATION_MESSAGE);
            //e.printStackTrace();
        }
        return availableDestinations;
    }

    /*
     * this method inserts a booking into bookedtravels into the database.
     */
    public void makeABooking(String username, String destination, String departure, String date, int travelId, String price) {
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT idUsers FROM users WHERE userName = '" + username + "'");
            while (res.next()) {
                idOfUser = res.getInt("idUsers");
            }
            ResultSet res1 = st.executeQuery("SELECT MAX(tripID) FROM bookedtravels");
            while (res1.next()) {
                travelId = res1.getInt("MAX(tripID)");
                travelIdCounter = travelId + 1;
            }
            String sql = "INSERT INTO bookedtravels (tripID, idUsers, destination, departure, price, date)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, travelIdCounter);
            preparedStatement.setInt(2, idOfUser);
            preparedStatement.setString(3, destination);
            preparedStatement.setString(4, departure);
            preparedStatement.setString(5, price);
            preparedStatement.setString(6, date);
            preparedStatement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database", "Connection Error", JOptionPane.INFORMATION_MESSAGE);
            //e.printStackTrace();
        }
    }

    /*
     * this method collects data from database about a users booked travels.
     */
    public ArrayList checkMyBookings(String username) {
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res1 = st.executeQuery("SELECT idUsers FROM users WHERE userName = '" + username + "'");
            while (res1.next()) {
                idOfUser = res1.getInt("idUsers");
            }
            ResultSet res = st.executeQuery("SELECT * FROM bookedtravels WHERE idUsers = '" + idOfUser + "'");
            while (res.next()) {
                bookedTrips.add(res.getString("destination"));
                bookedTrips.add(res.getString("departure"));
                bookedTrips.add(res.getString("price"));
                bookedTrips.add(res.getString("date"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookedTrips;
    }
}
