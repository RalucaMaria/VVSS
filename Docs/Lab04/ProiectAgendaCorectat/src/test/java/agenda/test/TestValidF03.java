package agenda.test;

import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryActivityFile;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.interfaces.RepositoryActivity;
import agenda.model.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class TestValidF03 {

    RepositoryActivity rep;

    @Before
    public void setUp() throws Exception {
        RepositoryContact repcon = new RepositoryContactFile();
        rep = new RepositoryActivityFile(repcon);
    }

    @Test
    public void testCase1() {
        for (Activity act : rep.getActivities())
            rep.removeActivity(act);

        Calendar c = Calendar.getInstance();
        c.set(2013, 3 - 1, 20, 12, 00);
        Date start = c.getTime();

        c.set(2013, 3 - 1, 20, 12, 30);
        Date end = c.getTime();

        Activity act = new Activity("name1", start, end,
                new LinkedList<Contact>(), "description2");

        rep.addActivity(act);

        c.set(2013, 3 - 1, 20);

        List<Activity> result = rep.activitiesOnDate("name1", c.getTime());
        assertTrue(result.size() == 1);
    }
}
