/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }


  @Test(timeout = 4000)
  public void test01() throws Throwable {
      Appt appt1 = new Appt(12, 12, -1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string1 = appt1.toString();
      assertEquals("\t12/12/-1 at -1:-1am ,Birthday Party, This is my birthday party\n", string1);
      String email = appt1.getEmailAddress();
      assertEquals("xyz@gmail.com",email);
      appt1.setValid();
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable {
      Appt appt2 = new Appt(0, 77, 12, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string2 = appt2.toString();
      assertEquals("\t12/12/2018 at 12:77am ,Birthday Party, This is my birthday party\n", string2);
      appt2.setValid();
  }


  @Test(timeout = 4000)
	public void test03() throws Throwable{
	   Appt appt5 = new Appt(0, -1, 12, 12, 2018, null, null, null);
	   appt5.setValid();
	}

}
