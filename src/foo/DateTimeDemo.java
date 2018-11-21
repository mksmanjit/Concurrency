package foo;

import java.time.LocalDateTime;

public class DateTimeDemo {

    public static void main(String[] args) {
       System.out.println(DateUtil.converToTimeStamp(LocalDateTime.now()));
    }

}
