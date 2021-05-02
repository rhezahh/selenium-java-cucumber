package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class JavaHelpers {

    public static Properties accessPropertiesFile(String propertyfile)
    {
        Properties prop = new Properties();
        // try retrieve data from file
        try
        {
            prop.load(new FileInputStream(propertyfile));
        }
        // catch exception in case properties file does not exist
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getPropertyValue(String propertyfile, String propertyname)
    {
        Properties prop = accessPropertiesFile(propertyfile);
        return prop.getProperty(propertyname);
    }

    public String updateTime(	String actualTimeFormat,
                                 String time,
                                 String expectedTimeFormat,
                                 int increamentDate,
                                 int increamentHour,
                                 int increamentMinute,
                                 int increamentSeconds
    ) throws ParseException
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        DateFormat resultDateFormat = new SimpleDateFormat(expectedTimeFormat);
        Date date = new SimpleDateFormat(actualTimeFormat).parse(time + " " + year); // we're parsing current year
        // incase year not passed
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, increamentDate);
        calendar.add(Calendar.HOUR, increamentHour);
        calendar.add(Calendar.MINUTE, increamentMinute);
        calendar.add(Calendar.SECOND, increamentSeconds);
        return resultDateFormat.format(calendar.getTime());
    }

    public String getTimeStamp(String format)
    {
        /*
         * Example format are :
         *
         * "yyyy MMM dd" for "2013 Nov 28"
         *
         * "yyyyMMdd_HHmmss" for "20130131000000"
         *
         * "yyyy MMM dd HH:mm:ss" for "2013 Jan 31 00:00:00"
         *
         * "dd MMM yyyy" for "28 Nov 2017"
         */
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
