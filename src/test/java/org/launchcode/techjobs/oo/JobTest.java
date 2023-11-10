package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {    // test the empty constructor
        Job test_job1 = new Job();
        Job test_job2 = new Job();
        assertNotEquals("Job IDs are not distinct!", test_job1.getId(), test_job2.getId());
    }

    // test the full constructor
    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job3 =
            new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
        // test that the constructor assigned the class and value to each field
        assertTrue(test_job3.getName() instanceof String);      // class check
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", test_job3.getName());     // value check
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());
    }

    // test the equals method
    @Test
    public void testJobsForEquality() {
        Job test_job4 =
            new Job("Analyst",
            new Employer("Evergy"),
            new Location("Kansas City"),
            new PositionType("Business Analyst"),
            new CoreCompetency("Analysis"));
        Job test_job5 =
            new Job("Analyst",
            new Employer("Evergy"),
            new Location("Kansas City"),
            new PositionType("Business Analyst"),
            new CoreCompetency("Analysis"));

        // test that the two jobs have different IDs
        assertFalse(test_job4.equals(test_job5));
    }

    // test toString
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        //
        Job test_job6 =
                new Job("Teaching Assistant (TA)",
                        new Employer("LaunchCode"),
                        new Location("Kansas City"),
                        new PositionType("Mentor"),
                        new CoreCompetency("Trainer"));

        String firstChar = String.valueOf(test_job6.toString().charAt(0));
        String lastChar = String.valueOf(test_job6.toString().charAt(test_job6.toString().length() - 1));

        assertEquals("lineSeparator is NOT the first character of the job listing.",
                firstChar, "\r");
        assertEquals("lineSeparator is NOT the last character of the job listing.",
                lastChar, "\n");
        assertEquals("lineSeparator is NOT the first character of the job listing.",
            lineSeparator(), String.valueOf(test_job6.toString().charAt(0)));
        assertEquals("lineSeparator is NOT the last character of the job listing.",
            lineSeparator(), String.valueOf(test_job6.toString().charAt(test_job6.toString().length() - 1)));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job test_job7 =
            new Job("Teaching Assistant (TA)",
            new Employer("LaunchCode"),
            new Location("Kansas City"),
            new PositionType("Mentor"),
            new CoreCompetency("Trainer"));

        String job_listing = lineSeparator() + "ID: " + test_job7.getId()
            + lineSeparator() + "Name: Teaching Assistant (TA)"
            + lineSeparator() + "Employer: LaunchCode"
            + lineSeparator() + "Location: Kansas City"
            + lineSeparator() + "Position Type: Mentor"
            + lineSeparator() + "Core Competency: Trainer"
            + lineSeparator();

        assertEquals(job_listing, test_job7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job test_job8 = new Job();

        String job_listing = lineSeparator() + "ID: " + test_job8.getId()
            + lineSeparator() + "Name: Data not available"
            + lineSeparator() + "Employer: Data not available"
            + lineSeparator() + "Location: Data not available"
            + lineSeparator() + "Position Type: Data not available"
            + lineSeparator() + "Core Competency: Data not available"
            + lineSeparator();

        System.out.println(test_job8.toString());
        assertEquals("Empty fields not handled.", job_listing, test_job8.toString());

    }

}
