package util;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
public class dateParse
{


    public static LocalDate getTodaysDate()
    {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        return date;
    }


    public static String dateFormat(Timestamp ts)
    {
        String s = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(ts);
        System.out.println("TS Test " + s);

        return s;

    }

}
