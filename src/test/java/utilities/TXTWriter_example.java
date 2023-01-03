package utilities;

import pojos.*;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TXTWriter_example {

    public static void saveUiRegistrantsData(Registrant registrant) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("applicant_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(registrant.toString() + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUiRegistrantsData(Registrant[] registrants) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("applicants_api_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < registrants.length; i++) {
                bw.append(registrants[i].toString() + "\n");
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void savePhysiciansData(Physician[] physiciansApi) {
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("physicians_api_data"), false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < physiciansApi.length; i++) {
                bw.append(physiciansApi[i].toString() + "\n");
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveAllUsersData(Registrant[] usersApi) {
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("usersall_infos_api"), false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < usersApi.length; i++) {
                bw.append(usersApi[i].toString() + "\n");
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void savePojoToFile(String filePath, Object pojoObj) {
        try {
            FileWriter fw2 = new FileWriter(filePath, false);
            BufferedWriter bw = new BufferedWriter(fw2);
            bw.append(pojoObj + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   /*
    public static void savePasswordData(PasswordChange passwordChange) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("password_data"), false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(passwordChange.toString() + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUiAppointmentData(Appointment appointment) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("appointment_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(appointment.toString() + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveApiMessagesData(Message[] message) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("messages_data"), false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < message.length; i++) {
                bw.append(message[i].toString() + "\n");
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveTheMessageData(Message data) {
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("save_message"), false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(data.toString() + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUiMessageData(Message message) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("messages_data_ui"), false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(message.toString() + "\n");
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveApiTestItemsData(CtestItem[] cTestItemUS007) {
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("testitem_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(cTestItemUS007.toString() + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveApiCreatedTestItemsData(Response response) {
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("testitem_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(response.asPrettyString() + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */




}
