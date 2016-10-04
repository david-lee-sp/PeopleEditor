package com.sailpoint.peopleeditor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by david.lee on 9/30/16.
 */
public class DataService {

    private  Connection con;
    private  final String driver ="com.mysql.jdbc.Driver";
    private  final String connectionString = "jdbc:mysql://localhost/peopleEditor";
    private  final String user = "root";
    private  final String password = "IBEr00t!";
    private String insertSQL = "INSERT INTO PERSON (firstName, lastName, location, phoneNumber) VALUES (?,?,?,?)";
    private String updateSQl = "UPDATE Person SET";
    private String deleteSQL = "DELETE FROM Person WHERE id=";
    public DataService(){

    }

    private void loadDriver() throws SQLException{
        try{
            Class.forName(this.driver);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Connection string is " + connectionString);
        this.con = DriverManager.getConnection(this.connectionString,this.user,this.password);

    }

    public void insertPerson(Person person)
    {
        PreparedStatement ps = null;
        if(con == null)
            try {
                loadDriver();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        try {
             ps = con.prepareCall(insertSQL);
            ps.setString(1,person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3,person.getLocation());
            ps.setString(4,person.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con !=null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }







}
