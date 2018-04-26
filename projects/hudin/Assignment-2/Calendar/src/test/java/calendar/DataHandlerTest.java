/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;



public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
  	 DataHandler dh0 = new DataHandler("calendar_test.xml",false);
  	 GregorianCalendar firstDay = new GregorianCalendar(2018,1,1);
  	 GregorianCalendar lastDay = new GregorianCalendar(2018,12,31);
  	 Appt appt0 = new Appt(11,30,12,12,2018,"Date with GF","Date with GF","xyz@gmail.com");
  	 Appt appt1 = new Appt( 7,30,12,12,2018,"Date with GF","Date with GF","xyz@gmail.com");
     dh0.getApptRange(firstDay,lastDay);
  	 dh0.saveAppt(appt0);

  	 assertTrue(dh0.save());
  	 assertTrue(dh0.deleteAppt(appt0));
    }

  @Test(timeout = 4000) //Appointment (autosave)
  public void test01()  throws Throwable  {
      GregorianCalendar someday = new GregorianCalendar(2018, 12, 12);
      CalDay day0 = new CalDay(someday);
      Appt appt0 = new Appt(0, 30, 12, 12, 2018, "Date with GF", "Date with GF", "xyz@gmail.com");
      day0.addAppt(appt0);
      DataHandler dh0 = new DataHandler("calendar_test.xml");
      assertTrue(dh0.saveAppt(appt0));
  }

  @Test(timeout = 4000)//delete appointment (autosave)
  public void test02()  throws Throwable  {
      GregorianCalendar someday = new GregorianCalendar(2018, 12, 12);
      CalDay day0 = new CalDay(someday);
      Appt appt0 = new Appt(0, 30, 12, 12, 2018, "Date with GF", "Date with GF", "xyz@gmail.com");
      day0.addAppt(appt0);
      DataHandler dh0 = new DataHandler("calendar_test.xml");
      dh0.saveAppt(appt0);
      assertTrue(dh0.deleteAppt(appt0));
  }

}
