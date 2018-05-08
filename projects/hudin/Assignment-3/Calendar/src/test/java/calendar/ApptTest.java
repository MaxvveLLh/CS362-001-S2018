/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.Console;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(appt0.getEmailAddress(), "xyz@gmail.com");
      assertEquals(appt0.getXmlElement(), null);
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	   Appt appt0 = new Appt(1, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	   String string0 = appt0.toString();
	   assertFalse(appt0.isRecurring());
	   assertEquals(0, appt0.getRecurIncrement());
	   assertFalse(appt0.hasTimeSet());
    }

    @Test(timeout = 4000)
      public void test02()  throws Throwable
      {
        Appt appt0 = new Appt(12, 30, 15, 1, 2018, "Test", "Testcontent", "xyz@gmail.com");
        int[] recurringDays = new int[1];
        recurringDays[0] = 1;
        appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 10, 10);
        assertEquals(appt0.getRecurIncrement(), 10);
        assertEquals(appt0.getRecurNumber(), 10);
      }

    @Test(timeout = 4000)
    public void test03() throws Throwable
      {
        Appt appt0 = new Appt(12, 30, 15, 1, 2018, "Test", "Testcontent", "xyz@gmail.com");
        assertNotNull(appt0.getRecurDays());
      }

  @Test(timeout = 4000)
    public void test04()  throws Throwable  {
	      Appt appt = new Appt(1, 1, 1, 1, 1, null, null, null);
	      assertFalse(appt.isOn(1, 1, 0));
	      assertFalse(appt.isOn(1, 0, 1));
	      assertFalse(appt.isOn(0, 1, 1));
	      assertFalse(appt.isOn(1, 0, 0));
	      assertFalse(appt.isOn(0, 0, 1));
        assertFalse(appt.isOn(0, 0, 0));
        assertTrue(appt.hasTimeSet());
    }



  @Test(timeout = 4000)
    public void test05()  throws Throwable  {
	     Appt badMonth = new Appt(15, 30, 2, 10, 2018, "Testtitle", "Testcontent", "xyz@gmail.com");
       badMonth.setValid();
    }



  @Test(timeout = 4000)
    public void test06()  throws Throwable
    {
	                        // Appt(hour, mins, day, month, year, title, content, email)
	     Appt appt0 = new Appt(23, 30, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt1 = new Appt(15, 59, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
       Appt appt2 = new Appt(15, 30, 31, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt3 = new Appt(15, 30, 9, 12, 2018, "Test", "Testcontent", "xyz@gmail.com");
       appt0.setValid();
	     appt1.setValid();
	     appt2.setValid();
	     appt3.setValid();
	     assertTrue(appt0.getValid());
	     assertTrue(appt1.getValid());
	     assertTrue(appt2.getValid());
	     assertTrue(appt3.getValid());
     }


   @Test(timeout = 4000)
    public void test07()  throws Throwable
    {
                          // Appt(hour, mins, day, month, year, title, content, email)
	     Appt appt0 = new Appt(15, 30, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt1 = new Appt(15, 0, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt2 = new Appt(15, 30, 9, 1, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt3 = new Appt(15, 30, 1, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     appt0.setValid();
       appt1.setValid();
       appt2.setValid();
       appt3.setValid();
	     assertTrue(appt0.getValid());
       assertTrue(appt1.getValid());
       assertTrue(appt2.getValid());
       assertTrue(appt3.getValid());
     }

  @Test(timeout = 4000)
    public void test08()  throws Throwable
    {
	                        // Appt(hour, mins, day, month, year, title, content, email)
	     Appt appt0 = new Appt(25, 30, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt1 = new Appt(15, 61, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt2 = new Appt(15, 30, 9, 13, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt3 = new Appt(15, 30, 32, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     appt0.setValid();
       appt1.setValid();
       appt2.setValid();
       appt3.setValid();
	     assertFalse(appt0.getValid());
       assertFalse(appt1.getValid());
       assertFalse(appt2.getValid());
       assertFalse(appt3.getValid());
     }


  @Test(timeout = 4000)
    public void test09()  throws Throwable
    {
	                        // Appt(hour, mins, day, month, year, title, content, email)
	     Appt appt0 = new Appt(-1, 30, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt1 = new Appt(15, -1, 9, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt2 = new Appt(15, 30, 9, -1, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt3 = new Appt(15, 30, -1, 10, 2018, "Test", "Testcontent", "xyz@gmail.com");
	     Appt appt4 = new Appt(15, 30, 9, 10, -1, "Test", "Testcontent", "xyz@gmail.com");
	     appt0.setValid();
       appt1.setValid();
       appt2.setValid();
       appt3.setValid();
       appt4.setValid();
	     assertFalse(appt0.getValid());
       assertFalse(appt1.getValid());
       assertFalse(appt2.getValid());
       assertFalse(appt3.getValid());
       assertFalse(appt4.getValid());
    }

    @Test(timeout = 4000)
  	public void test010() throws Throwable{
  	   Appt appt5 = new Appt(0, -1, 12, 12, 2018, null, null, null);
  	   appt5.setValid();
  	}

    @Test(timeout = 4000)
    public void test011()  throws Throwable  {
       Appt nullInfo = new Appt(10, 30, 9, 10, 2018, null, null, null);
       nullInfo.setRecurrence(null, 0, 0, 0);
       assertEquals(nullInfo.getRecurNumber(), Appt.RECUR_NUMBER_NEVER);
       nullInfo.setRecurrence(new int[2], 2, 2, 2);
       assertEquals(nullInfo.isRecurring(), true);
       assertEquals(nullInfo.getRecurDays().length, 2);
       nullInfo.setValid();
      }

}
