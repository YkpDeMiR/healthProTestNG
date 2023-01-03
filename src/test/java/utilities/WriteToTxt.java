package utilities;


import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToTxt {



    public static void savePhysicianIds(String fileName, List<Object> id){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }

    public static void savePhysicianFirstName(String fileName, List<Object> firstname){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< firstname.size(); i++)
                writer.append(firstname.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }

    public static void savePhysicianLastName(String fileName, List<Object> lastname){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< lastname.size(); i++)
                writer.append(lastname.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }

    public static void saveAllIds(String fileName, List<Object> id){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }

    public static void saveAllObjectList(String fileName, List<Object> objects){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< objects.size(); i++)
                writer.append(objects.get(i).toString()+"  ** ,  \n **");

            writer.close();
        } catch (IOException e){
        }
    }

    public static void saveSSNData(String fileName, Registrant[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i = 0; i < customers.length; i++) {
                writer.append(customers[i].getSsn() + ",\n");
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void saveEmailData(String fileName, Registrant[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i = 0; i < customers.length; i++) {
                writer.append(customers[i].getEmail() + ",\n");
            }
            writer.close();
        } catch (Exception e) {
        }
    }


        /*
        First Name,
        Last Name,
        email,
        mobilePhone,
        Adres
        city
         */

    public static void saveCustomersData(String fileName, Registrant[] customers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i = 0; i < customers.length; i++) {

                writer.append(customers[i].getFirstName() + ",\n");
                writer.append(customers[i].getLastName() + ",\n");
                writer.append(customers[i].getEmail() + ",\n");
                //writer.append(customers[i].getMobilePhoneNumber() + ",\n");
               // writer.append(customers[i].getAddress() + ",\n");
              //  writer.append(customers[i].getCity() + ",\n");
                writer.append("-----------------------------------------------" + ",\n");


            }
            writer.close();
        } catch (Exception e) {
        }
    }

}