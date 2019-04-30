package agenda.test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryActivityFile;
import agenda.model.repository.classes.RepositoryActivityMock;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.classes.RepositoryUserFile;
import agenda.model.repository.interfaces.RepositoryActivity;
import agenda.model.repository.interfaces.RepositoryContact;
import agenda.model.repository.interfaces.RepositoryUser;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test_Big_Bang {

    private Contact con;
    private RepositoryContact rep;
    private Activity act;
    private RepositoryActivity rep2;
    RepositoryActivity activityRep;

    @Before
    public void setUp() throws Exception {
        rep = new RepositoryContactFile();
        rep2 = new RepositoryActivityMock();

        RepositoryContact contactRep = new RepositoryContactFile();
        RepositoryUser userRep = new RepositoryUserFile();
        activityRep = new RepositoryActivityFile(
                contactRep);
    }



    @Test
    public void testCase1() {
        try {
            con = new Contact("Ed", "strada Panselutei", "12345", "a@yahoo.com");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertFalse(false);
        }
    }

    @Test
    public void testCase2() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : activityRep.getActivities())
                activityRep.removeActivity(a);

            act = new Activity("Activity",
                    df.parse("03/04/2002 15:50"),
                    df.parse("03/04/2002 14:50"),
                    null,
                    "Lunch break");
            activityRep.addActivity(act);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(0 == activityRep.count());
    }


    @Test
    public void testCase3() {
        for (Activity act : activityRep.getActivities())
            activityRep.removeActivity(act);

        Calendar c = Calendar.getInstance();
        c.set(2013, 3 - 1, 20, 12, 00);
        Date start = c.getTime();

        c.set(2013, 3 - 1, 20, 12, 30);
        Date end = c.getTime();

        Activity act = new Activity("name1", start, end,
                new LinkedList<Contact>(), "description2");

        activityRep.addActivity(act);

        c.set(2013, 3 - 1, 20);

        List<Activity> result = activityRep.activitiesOnDate("name2", c.getTime());
        TestCase.assertTrue(result.size() == 0);
    }


    @Test
    public void testCase4()
    {
        try {
            con = new Contact("Ed", "strada Panselutei", "12345", "a@yahoo.com");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertFalse(false);
        }

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : activityRep.getActivities())
                activityRep.removeActivity(a);

            act = new Activity("Activity",
                    df.parse("03/04/2002 15:50"),
                    df.parse("03/04/2002 14:50"),
                    null,
                    "Lunch break");
            activityRep.addActivity(act);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(0 == activityRep.count());

        for (Activity act : activityRep.getActivities())
            activityRep.removeActivity(act);

        Calendar c = Calendar.getInstance();
        c.set(2013, 3 - 1, 20, 12, 00);
        Date start = c.getTime();

        c.set(2013, 3 - 1, 20, 12, 30);
        Date end = c.getTime();

        Activity act = new Activity("name1", start, end,
                new LinkedList<Contact>(), "description2");

        activityRep.addActivity(act);

        c.set(2013, 3 - 1, 20);

        List<Activity> result = activityRep.activitiesOnDate("name2", c.getTime());
        TestCase.assertTrue(result.size() == 0);
    }

}
