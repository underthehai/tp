package seedu.address.logic.wanderlustlogic.wanderlustcommands.edit;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.travelplanner.ModelManager;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.builder.EditTravelPlanDescriptorBuilder;
import seedu.address.model.travelplanner.UserPrefs;
import seedu.address.testutil.builders.TravelPlanBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.DESC_EUROPE;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.*;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditTravelPlanCommand.*;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.typicals.TypicalTravelPlans.getTypicalTravelPlanner;

public class EditTravelPlanCommandTest {

    private Model model = new ModelManager(getTypicalTravelPlanner(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        TravelPlan editedTravelPlan = new TravelPlanBuilder().build();
        EditDescriptor descriptor = new EditTravelPlanDescriptorBuilder(editedTravelPlan).build();
        EditTravelPlanCommand EditTravelPlanCommand = new EditTravelPlanCommand(INDEX_FIRST, descriptor);

        String expectedMessage = String.format(MESSAGE_EDIT_TRAVELPLAN_SUCCESS, editedTravelPlan);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.setTravelPlan(model.getFilteredTravelPlanList().get(0), editedTravelPlan);


        assertCommandSuccess(EditTravelPlanCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        EditTravelPlanCommand EditTravelPlanCommand = new EditTravelPlanCommand(INDEX_FIRST, new EditDescriptor());
        TravelPlan editedTravelPlan = model.getFilteredTravelPlanList().get(INDEX_FIRST.getZeroBased());

        String expectedMessage = String.format(MESSAGE_EDIT_TRAVELPLAN_SUCCESS, editedTravelPlan);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());

        assertCommandSuccess(EditTravelPlanCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {

        TravelPlan TravelPlanInFilteredList = model.getFilteredTravelPlanList().get(INDEX_FIRST.getZeroBased());
        TravelPlan editedTravelPlan = new TravelPlanBuilder(TravelPlanInFilteredList).withName(VALID_NAME_BOB).build();
        EditTravelPlanCommand EditTravelPlanCommand = new EditTravelPlanCommand(INDEX_FIRST,
                new EditTravelPlanDescriptorBuilder().withName(VALID_NAME_BOB).build());

        String expectedMessage = String.format(MESSAGE_EDIT_TRAVELPLAN_SUCCESS, editedTravelPlan);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.setTravelPlan(model.getFilteredTravelPlanList().get(0), editedTravelPlan);

        assertCommandSuccess(EditTravelPlanCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_duplicateTravelPlanUnfilteredList_failure() {
        TravelPlan firstTravelPlan = model.getFilteredTravelPlanList().get(INDEX_FIRST.getZeroBased());
        EditDescriptor descriptor = new EditTravelPlanDescriptorBuilder(firstTravelPlan).build();
        EditTravelPlanCommand EditTravelPlanCommand = new EditTravelPlanCommand(INDEX_SECOND, descriptor);

        assertCommandFailure(EditTravelPlanCommand, model, MESSAGE_DUPLICATE_TRAVELPLAN);
    }

    @Test
    public void execute_duplicateTravelPlanFilteredList_failure() {

        // edit TravelPlan in filtered list into a duplicate in address book
        TravelPlan TravelPlanInList = model.getFilteredTravelPlanList().get(INDEX_SECOND.getZeroBased());
        EditTravelPlanCommand EditTravelPlanCommand = new EditTravelPlanCommand(INDEX_FIRST,
                new EditTravelPlanDescriptorBuilder(TravelPlanInList).build());

        assertCommandFailure(EditTravelPlanCommand, model, MESSAGE_DUPLICATE_TRAVELPLAN);
    }

    @Test
    public void execute_invalidTravelPlanIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTravelPlanList().size() + 1);
        EditDescriptor descriptor = new EditTravelPlanDescriptorBuilder().withName(VALID_NAME_BOB).build();
        EditTravelPlanCommand EditTravelPlanCommand = new EditTravelPlanCommand(outOfBoundIndex, descriptor);

        assertCommandFailure(EditTravelPlanCommand, model, Messages.MESSAGE_INVALID_TRAVELPLAN_DISPLAYED_INDEX);
    }


    @Test
    public void equals() {
        final EditTravelPlanCommand standardCommand = new EditTravelPlanCommand(INDEX_FIRST, DESC_EUROPE);

        // same values -> returns true
        EditDescriptor copyDescriptor = new EditDescriptor(DESC_EUROPE);
        EditTravelPlanCommand commandWithSameValues = new EditTravelPlanCommand(INDEX_FIRST, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditTravelPlanCommand(INDEX_SECOND, DESC_EUROPE)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditTravelPlanCommand(INDEX_FIRST, DESC_NYC)));
    }
}
