package foo;

import java.io.Console;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {

    public static void main(String[] args) {
        /*GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DATE, -60);
        System.out.println(gc.getTime());*/
        Console c = System.console();
        
        char[] pwd = c.readPassword("Enter password for sagar");
        System.out.println(pwd);
    }

}
