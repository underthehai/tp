package seedu.address.logic.wanderlustlogic.wanderlustcommands.delete;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.showTravelPlanAtIndex;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST_TRAVELPLAN;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_SECOND_TRAVELPLAN;
import static seedu.address.testutil.typicals.TypicalTravelPlans.getTypicalTravelPlanner;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.travelplanner.ModelManager;
import seedu.address.model.travelplanner.UserPrefs;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteActivityCommand}.
 */
public class DeleteActivityCommandTest {

    private Model model = new ModelManager(getTypicalTravelPlanner(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Activity activityToDelete = model.getFilteredActivityList().get(INDEX_FIRST_TRAVELPLAN.getZeroBased());
        DeleteActivityCommand deleteActivityCommand = new DeleteActivityCommand(INDEX_FIRST_TRAVELPLAN);

        String expectedMessage = String.format(DeleteActivityCommand.MESSAGE_DELETE_ACTIVITY_SUCCESS,
                activityToDelete);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.deleteTravelPlanObject(activityToDelete);

        assertCommandSuccess(deleteActivityCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredActivityList().size() + 1);
        DeleteActivityCommand deleteActivityCommand = new DeleteActivityCommand(outOfBoundIndex);

        assertCommandFailure(deleteActivityCommand, model, Messages.MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showTravelPlanAtIndex(model, INDEX_FIRST_TRAVELPLAN);

        Activity activityToDelete = model.getFilteredActivityList().get(INDEX_FIRST_TRAVELPLAN.getZeroBased());
        DeleteActivityCommand deleteActivityCommand = new DeleteActivityCommand(INDEX_FIRST_TRAVELPLAN);

        String expectedMessage = String.format(DeleteActivityCommand.MESSAGE_DELETE_ACTIVITY_SUCCESS,
                activityToDelete);

        Model expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.deleteTravelPlanObject(activityToDelete);
        showNoActivityList(expectedModel);

        assertCommandSuccess(deleteActivityCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showTravelPlanAtIndex(model, INDEX_FIRST_TRAVELPLAN);

        Index outOfBoundIndex = INDEX_SECOND_TRAVELPLAN;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getTravelPlanner().getTravelPlanList().size());

        DeleteActivityCommand deleteActivityCommand = new DeleteActivityCommand(outOfBoundIndex);

        assertCommandFailure(deleteActivityCommand, model, Messages.MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DeleteActivityCommand deleteFirstCommand = new DeleteActivityCommand(INDEX_FIRST_TRAVELPLAN);
        DeleteActivityCommand deleteSecondCommand = new DeleteActivityCommand(INDEX_SECOND_TRAVELPLAN);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteActivityCommand deleteFirstCommandCopy = new DeleteActivityCommand(INDEX_FIRST_TRAVELPLAN);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different travelPlan -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoActivityList(Model model) {
        model.updateFilteredActivityList(p -> false);

        assertTrue(model.getFilteredActivityList().isEmpty());
    }
}
