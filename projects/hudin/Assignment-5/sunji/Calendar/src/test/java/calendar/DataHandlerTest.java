/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.*;



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


  @Test(timeout = 4000)
  public void test03()  throws Throwable
      {
        DataHandler handle0 = new DataHandler();
        GregorianCalendar day1 = new GregorianCalendar();
        GregorianCalendar day2 = new GregorianCalendar();
        day1.set(GregorianCalendar.MONTH,-1);
        assertNotNull(handle0.getApptRange(day1, day2));
      }


      @Test(timeout = 4000)//delete appointment (autosave)
      public void test04()  throws Throwable  {
          GregorianCalendar someday = new GregorianCalendar(2018, 12, 12);
          CalDay day0 = new CalDay(someday);
          Appt appt0 = new Appt(0, 30, -1, -1, 2018, "Date with GF", "Date with GF", "xyz@gmail.com");
          day0.addAppt(appt0);
          DataHandler dh0 = new DataHandler("calendar_test.xml");
          dh0.saveAppt(appt0);
          assertTrue(dh0.deleteAppt(appt0));
      }


  @Test(timeout = 4000)
  public void test05() throws Throwable
      {
        Appt newappt = new Appt(-1,-1,-1,"New Appt","test appt","xyz@gmail.com");
        DataHandler handle2 = new DataHandler("file2.xml", false);
        DataHandler handle3 = new DataHandler("file3.xml", true);
        assertTrue(handle2.save());
        assertTrue(handle2.saveAppt(newappt));
        assertTrue(handle2.saveAppt(newappt));
        assertTrue(handle2.deleteAppt(newappt));
        assertFalse(handle3.deleteAppt(newappt));
        newappt.setValid();
        assertFalse(handle2.saveAppt(newappt));
        assertFalse(handle3.saveAppt(newappt));
      }

    @Test
    public void test06()    throws Throwable
      {
        DataHandler handle = new DataHandler();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(new Appt(5, 30, 1, 5, 2018, "Birthday", "Birthday Party","email"));
        appts.add(new Appt(4, 30, 1, 4, 2018, "Work", "My Shift","email"));

        List<CalDay> calDayTest;
        calDayTest = handle.getApptRange(new GregorianCalendar(2017, 4, 28, 14, 30, 0),new GregorianCalendar(2017, 4, 31, 19, 30, 0));

        assertTrue(calDayTest.get(0).getSizeAppts() == 0);
    }


}
