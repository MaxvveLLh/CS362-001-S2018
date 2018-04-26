/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;

public class CalDayTest{


  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
     CalDay calday0 = new CalDay();
     assertFalse(calday0.isValid());
     assertNull(calday0.iterator());
     String str0 = calday0.toString();
     assertEquals(0, str0.length());
  }



  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
     GregorianCalendar day = new GregorianCalendar(2018, 2, 15);
     CalDay calday0 = new CalDay(day);
     Appt appt0 = new Appt( 0, 30, 12, 12, 2018, null, null, null);
     Appt appt1 = new Appt( 5,  1, 12, 12, 2018, null, null, null);
     Appt appt2 = new Appt(10, 30, 12, 12, 2018, null, null, null);
     Appt appt3 = new Appt(11, 30, 12, 12, 2018, null, null, null);
     calday0.addAppt(appt0);
     calday0.addAppt(appt1);
     calday0.addAppt(appt2);
     calday0.addAppt(appt3);
     String expectedStr = "12-12-2018 \n\t12:30AM \n\t05:01AM \n\t10:30AM \n\t11:30PM \n\t ";
     String calStr = calday0.getFullInfomrationApp(calday0);
     System.out.println(expectedStr);
     System.out.println(calStr);
  }


}
