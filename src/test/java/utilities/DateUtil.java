package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtil {
    // MMMM dd, yyy  --> February 17, 2019
    public static String todaysDate(){
        String today = new SimpleDateFormat("MMMM dd, yyyy").format(new Date());
        return today;
    }
    // MM-dd-yy     --> 02-17-19
    public static String todaysDate2(){
        String today = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
        return today;
    }
    // dd-MM-yy    --> 17-02-19
    public static String todaysDate3(){
        String today = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return today;
    }
    // yyyy-MM-dd hh:mm:ss   --> 2019-02-17 03:45:11
    public static String todaysDate4(){
        String today = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss").format(new Date());
        return today;
    }

 public static String todaysDate5(){
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return today;
    }


    public static String tomorrowDate() {

        LocalDate date = LocalDate.now();
        //System.out.println(date.minusDays(1));
        String yarin = String.valueOf(date.plusDays(1));
        System.out.println(yarin);
        int gun = (date.getDayOfMonth() + 1);
        int yil = date.getYear();
        int ay = date.getMonthValue();

        if (ay==2&&gun>28){
            gun=1;
            ay=ay+1;
        }

        if (gun>30){
            gun=1;
            ay=ay+1;
        }

        if (ay>12){
            ay=1;
            yil=yil+1;
        }

        String day = String.valueOf(gun);
        String month = String.valueOf(ay);
        String year = String.valueOf(yil);

        if (day.length()<2){
            day="0"+day;
        }

        if (month.length()<2){
            month="0"+month;
        }


        yarin = month +"/"+ day +"/" + year;
        System.out.println("yarin = " + yarin);
        return yarin;
    }


}
