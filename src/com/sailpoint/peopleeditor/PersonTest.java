package com.sailpoint.peopleeditor;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by david.lee on 9/28/16.
 */
public class PersonTest {


    public static void main(String[] args) {

        System.out.println("Creating Person Object..");
        Person p = new Person("David", "Schwimmer");
        p.setLocation("cali");
        p.setPhoneNumber("123456789");
        System.out.println("Saving Person..");
        PersonDTO pd = new PersonDTO(p);
        pd.savePerson();
        System.out.println("Check database...");

    }
}
