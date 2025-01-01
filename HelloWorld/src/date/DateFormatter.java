package date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateFormatter {
    public static void main(String[] args) {
       Date now =  new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy--MM---mm ");
        System.out.println(now);
        String format1 = format.format(now);
        System.out.println(format1);
    }
}
