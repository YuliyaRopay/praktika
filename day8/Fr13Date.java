package day8;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fr13Date {
    public static void main(String[] args) throws ParseException {
        Date today=new Date();
        System.out.println(today);

        SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat sdf2=new SimpleDateFormat("dd.MM.YY");
        System.out.println(sdf.format(today));
        System.out.println(sdf2.format(today));

        //Date dat=sdf.parse("12 Oct 2000");
        //System.out.println(dat);

        System.out.println();
        System.out.println();

        Calendar c=new GregorianCalendar();
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);


        System.out.println(c.getTime());
        System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));

        System.out.println(c.getWeeksInWeekYear());

        System.out.println(sdf2.format(c.getTime()));


        // GregorianCalendar
        GregorianCalendar calendar = new GregorianCalendar(2015, 03, 01);
        System.out.println(sdf2.format(calendar.getTime()));

        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.DATE, 20);
        calendar.set(Calendar.YEAR, 2010);
        calendar.set(Calendar.HOUR, 14);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 59);
        System.out.println(sdf2.format(calendar.getTime()));


        calendar.add(Calendar.DATE, -4);
        calendar.add(Calendar.MONTH, -4);
        System.out.println(sdf2.format(calendar.getTime()));

        calendar.roll(Calendar.DATE, +4);
        calendar.roll(Calendar.MONTH, +4);
        System.out.println(sdf2.format(calendar.getTime()));








    }
}
