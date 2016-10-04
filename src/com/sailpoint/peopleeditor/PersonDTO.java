package com.sailpoint.peopleeditor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.sailpoint.peopleeditor.Person;



/**
 * Created by david.lee on 9/28/16.
 */
public class PersonDTO {

    public PersonDTO(Person newPerson) {
        setThisGuy(newPerson);
    }

    public void savePerson()
    {

           DataService ds = new DataService();
           ds.insertPerson(getThisGuy());

    }

    public com.sailpoint.peopleeditor.Person getThisGuy() {
        return thisGuy;
    }

    public void setThisGuy(com.sailpoint.peopleeditor.Person thisGuy) {
        this.thisGuy = thisGuy;
    }

    private Person thisGuy;


}
