package seedu.address.logic.wanderlustlogic.wanderlustcommands.add;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandResult;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplanner.ReadOnlyTravelPlanner;
import seedu.address.model.travelplanner.TravelPlanner;
import seedu.address.testutil.builders.ActivityBuilder;


public class AddActivityCommandTest {

    @Test
    public void constructor_nullActivity_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddActivityCommand(null));
    }

    @Test
    public void execute_activityAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingActivityAdded modelStub = new ModelStubAcceptingActivityAdded();
        Activity validActivity = new ActivityBuilder().build();

        CommandResult commandResult = new AddActivityCommand(validActivity).execute(modelStub);

        assertEquals(String.format(AddActivityCommand.MESSAGE_SUCCESS, validActivity), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validActivity), modelStub.activitiesAdded);
    }

    @Test
    public void execute_duplicateActivity_throwsCommandException() {
        Activity validActivity = new ActivityBuilder().build();
        AddActivityCommand addActivityCommand = new AddActivityCommand(validActivity);
        ModelStub modelStub = new ModelStubWithActivity(validActivity);

        assertThrows(CommandException.class, AddActivityCommand.MESSAGE_DUPLICATE_ACTIVITY,
                () -> addActivityCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Activity univStudios = new ActivityBuilder()
                .withName("Universal Studios Singapore")
                .withLocation("Sentosa")
                .withCost("88")
                .withLevelOfImportance("5")
                .withDateTime("2020-10-11 12:00")
                .build();
        Activity natureReserve = new ActivityBuilder()
                .withName("Bukit Timah Nature Reserve")
                .withLocation("Bukit Timah")
                .withCost("0")
                .withLevelOfImportance("4")
                .withDateTime("2020-11-10 12:00")
                .build();
        AddActivityCommand addUnivStudiosCommand = new AddActivityCommand(univStudios);
        AddActivityCommand addNatureReserveCommand = new AddActivityCommand(natureReserve);

        // same object -> returns true
        assertTrue(addUnivStudiosCommand.equals(addUnivStudiosCommand));

        // same values -> returns true
        AddActivityCommand addUnivStudiosCommandCopy = new AddActivityCommand(univStudios);
        assertTrue(addUnivStudiosCommand.equals(addUnivStudiosCommandCopy));

        // different types -> returns false
        assertFalse(addUnivStudiosCommand.equals(1));

        // null -> returns false
        assertFalse(addUnivStudiosCommand.equals(null));

        // different activity -> returns false
        assertFalse(addUnivStudiosCommand.equals(addNatureReserveCommand));
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithActivity extends ModelStub {
        private final Activity activity;

        ModelStubWithActivity(Activity activity) {
            requireNonNull(activity);
            this.activity = activity;
        }

        @Override
        public boolean hasActivity(Activity activity) {
            requireNonNull(activity);
            return this.activity.isSameActivity(activity);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingActivityAdded extends ModelStub {
        final ArrayList<Activity> activitiesAdded = new ArrayList<>();

        @Override
        public boolean hasActivity(Activity activity) {
            requireNonNull(activity);
            return activitiesAdded.stream().anyMatch(activity::isSameActivity);
        }

        @Override
        public void addActivity(Activity activity) {
            requireNonNull(activity);
            activitiesAdded.add(activity);
        }

        @Override
        public ReadOnlyTravelPlanner getTravelPlanner() {
            return new TravelPlanner();
        }
    }

}
