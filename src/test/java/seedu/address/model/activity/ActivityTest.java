package seedu.address.model.activity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalActivities.ZOO;
import static seedu.address.testutil.TypicalActivities.THEMEPARK;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ActivityBuilder;


public class ActivityTest {


    @Test
    public void isSameActivity() {
        // same object -> returns true
        assertTrue(ZOO.isSameActivity(ZOO));

        // null -> returns false
        assertFalse(ZOO.isSameActivity(null));

        // different Cost and Location -> returns true
        Activity editedZOO = new ActivityBuilder(ZOO).withCost("10").withLocation("123 Pasir Ris Road").build();
        assertTrue(ZOO.isSameActivity(editedZOO));

        // different name -> returns false
        editedZOO = new ActivityBuilder(ZOO).withName("Singapore Mandai Bird Park").build();
        assertFalse(ZOO.isSameActivity(editedZOO));

    }

    @Test
    public void equals() {
        // same values -> returns true
        Activity ZOOCopy = new ActivityBuilder(ZOO).build();
        assertTrue(ZOO.equals(ZOOCopy));

        // same object -> returns true
        assertTrue(ZOO.equals(ZOO));

        // null -> returns false
        assertFalse(ZOO.equals(null));

        // different type -> returns false
        assertFalse(ZOO.equals(5));

        // different Activity -> returns false
        assertFalse(ZOO.equals(THEMEPARK));

        // different name -> returns false
        Activity editedZOO = new ActivityBuilder(ZOO).withName("Park").build();
        assertFalse(ZOO.equals(editedZOO));

        // different Cost -> returns false
        editedZOO = new ActivityBuilder(ZOO).withCost("10").build();
        assertFalse(ZOO.equals(editedZOO));

        // different Location -> returns false
        editedZOO = new ActivityBuilder(ZOO).withLocation("123 Pasir Ris Park").build();
        assertFalse(ZOO.equals(editedZOO));

        // different level of importance -> returns false
        editedZOO = new ActivityBuilder(ZOO).withLevelOfImportance("1").build();
        assertFalse(ZOO.equals(editedZOO));

        // different date and time -> returns false
        editedZOO = new ActivityBuilder(ZOO).withDateTime("2020-12-31 12:00").build();
        assertFalse(ZOO.equals(editedZOO));
    }
}
