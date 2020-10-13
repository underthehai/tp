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
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.commons.TravelPlanObject;
import seedu.address.model.travelplanner.ReadOnlyTravelPlanner;
import seedu.address.model.travelplanner.TravelPlanner;
import seedu.address.testutil.builders.AccommodationBuilder;
import seedu.address.testutil.builders.ActivityBuilder;


public class AddAccommodationCommandTest {

    @Test
    public void constructor_nullAccommodation_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddAccommodationCommand(null));
    }

    @Test
    public void execute_activityAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingAccommodationAdded modelStub = new ModelStubAcceptingAccommodationAdded();
        Accommodation validAccommodation = new AccommodationBuilder().build();

        CommandResult commandResult = new AddAccommodationCommand(validAccommodation).execute(modelStub);

        assertEquals(String.format(AddAccommodationCommand.MESSAGE_SUCCESS, validAccommodation),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validAccommodation), modelStub.accommodationsAdded);
    }

    @Test
    public void execute_duplicateActivity_throwsCommandException() {
        Activity validActivity = new ActivityBuilder().build();
        AddActivityCommand addActivityCommand = new AddActivityCommand(validActivity);
        ModelStub modelStub = new ModelStubWithAccommodation(validActivity);

        assertThrows(CommandException.class, AddActivityCommand.MESSAGE_DUPLICATE_ACTIVITY,
                () -> addActivityCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Accommodation hotelAlice = new AccommodationBuilder()
                .withName("Hotel Alice")
                .withStartDate("2020-10-11")
                .withEndDate("2020-10-16")
                .withLocation("Alice Road")
                .withCost("300")
                .build();
        Accommodation hotelBob = new AccommodationBuilder()
                .withName("Hotel Alice")
                .withStartDate("2020-10-17")
                .withEndDate("2020-10-23")
                .withLocation("Bob Road")
                .withCost("200")
                .build();
        AddAccommodationCommand addAliceCommand = new AddAccommodationCommand(hotelAlice);
        AddAccommodationCommand addBobCommand = new AddAccommodationCommand(hotelBob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddAccommodationCommand addAliceCommandCopy = new AddAccommodationCommand(hotelAlice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different accommodation -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithAccommodation extends ModelStub {
        private final Accommodation accommodation;

        ModelStubWithAccommodation(Accommodation accommodation) {
            requireNonNull(accommodation);
            this.accommodation = accommodation;
        }

        @Override
        public boolean hasActivity(Activity activity) {
            requireNonNull(activity);
            return this.accommodation.isSameAccommodation(accommodation);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingAccommodationAdded extends ModelStub {
        final ArrayList<Accommodation> accommodationsAdded = new ArrayList<>();

        @Override
        public boolean hasTravelPlanObject(TravelPlanObject travelPlanObject) {
            requireNonNull(travelPlanObject);
            Accommodation accommodation = (Accommodation) travelPlanObject;
            return accommodationsAdded.stream().anyMatch(accommodation::isSameAccommodation);
        }

        @Override
        public void addTravelPlanObject(TravelPlanObject travelPlanObject) {
            requireNonNull(travelPlanObject);
            Accommodation accommodation = (Accommodation) travelPlanObject;
            accommodationsAdded.add(accommodation);
        }

        @Override
        public ReadOnlyTravelPlanner getTravelPlanner() {
            return new TravelPlanner();
        }
    }
}
