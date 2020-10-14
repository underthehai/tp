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
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.ReadOnlyTravelPlanner;
import seedu.address.model.travelplanner.TravelPlanner;
import seedu.address.testutil.builders.TravelPlanBuilder;
import seedu.address.testutil.typicals.TypicalTravelPlans;


public class AddTravelPlanCommandTest {

    @Test
    public void constructor_nullTravelPlan_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddTravelPlanCommand(null));
    }

    @Test
    public void execute_travelPlanAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingTravelPlanAdded modelStub = new ModelStubAcceptingTravelPlanAdded();
        TravelPlan validTravelPlan = new TravelPlanBuilder().build();

        CommandResult commandResult = new AddTravelPlanCommand(validTravelPlan).execute(modelStub);

        assertEquals(String.format(AddTravelPlanCommand.MESSAGE_SUCCESS, validTravelPlan),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validTravelPlan), modelStub.travelPlansAdded);
    }

    @Test
    public void execute_duplicateTravelPlan_throwsCommandException() {
        TravelPlan validTravelPlan = new TravelPlanBuilder().build();
        AddTravelPlanCommand addTravelPlanCommand = new AddTravelPlanCommand(validTravelPlan);
        ModelStub modelStub = new ModelStubWithTravelPlan(validTravelPlan);

        assertThrows(CommandException.class, AddTravelPlanCommand.MESSAGE_DUPLICATE_TRAVEL_PLAN, () ->
                addTravelPlanCommand.execute(modelStub));
    }

    @Test
    public void equals() {

        AddTravelPlanCommand addAustraliaCommand = new AddTravelPlanCommand(TypicalTravelPlans.AUSTRALIA_TRIP);
        AddTravelPlanCommand addBostonCommand = new AddTravelPlanCommand(TypicalTravelPlans.BOSTON_TRIP);

        // same object -> returns true
        assertTrue(addAustraliaCommand.equals(addAustraliaCommand));

        // same values -> returns true
        AddTravelPlanCommand addAustraliaCommandCopy = new AddTravelPlanCommand(TypicalTravelPlans.AUSTRALIA_TRIP);
        assertTrue(addAustraliaCommand.equals(addAustraliaCommandCopy));

        // different types -> returns false
        assertFalse(addAustraliaCommand.equals(1));

        // null -> returns false
        assertFalse(addAustraliaCommand.equals(null));

        // different activity -> returns false
        assertFalse(addAustraliaCommand.equals(addBostonCommand));
    }

    /**
     * A Model stub that contains a single activity.
     */
    private class ModelStubWithTravelPlan extends ModelStub {
        private final TravelPlan travelPlan;

        ModelStubWithTravelPlan(TravelPlan travelPlan) {
            requireNonNull(travelPlan);
            this.travelPlan = travelPlan;
        }

        @Override
        public boolean hasTravelPlan(TravelPlan travelPlan) {
            requireNonNull(travelPlan);
            return this.travelPlan.isSameTravelPlan(travelPlan);
        }
    }

    /**
     * A Model stub that always accept the travel plan being added.
     */
    private class ModelStubAcceptingTravelPlanAdded extends ModelStub {
        final ArrayList<TravelPlan> travelPlansAdded = new ArrayList<>();

        @Override
        public boolean hasTravelPlan(TravelPlan travelPlan) {
            requireNonNull(travelPlan);
            return travelPlansAdded.stream().anyMatch(travelPlan::isSameTravelPlan);
        }

        @Override
        public void addTravelPlan(TravelPlan travelPlan) {
            requireNonNull(travelPlan);
            travelPlansAdded.add(travelPlan);
        }

        @Override
        public ReadOnlyTravelPlanner getTravelPlanner() {
            return new TravelPlanner();
        }
    }

}